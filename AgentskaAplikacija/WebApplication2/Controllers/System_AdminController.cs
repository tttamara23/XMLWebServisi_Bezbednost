using Isa2017Cinema.Models;
using Microsoft.AspNet.Identity;
using Microsoft.AspNet.Identity.EntityFramework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Mail;
using System.Threading.Tasks;
using System.Web.Mvc;
using WebApplication2.Models;

namespace WebApplication2.Controllers
{
    public class System_AdminController : Controller
    {
        // GET: System_Admin/AddNewAdmin
        public ActionResult AddNewAdmin()
        {
            if (!Request.IsAuthenticated)
                return RedirectToAction("Login", "Account");
            else
            {
                if (!User.IsInRole("System_Admin"))
                    return RedirectToAction("Index", "Home");
                else
                {
                    List<SelectListItem> items = new List<SelectListItem>();
                    items.Add(new SelectListItem { Text = "Agent", Value = "0" });
                   // items.Add(new SelectListItem { Text = "Location admin", Value = "1" });

                    List<Location> locations = new List<Location>();

                    using (var ctx = new ApplicationDbContext())
                    { 
                        var resUsr = ctx.Database.SqlQuery<SystemAdmin>("select * from AspNetUsers where id = '" + User.Identity.GetUserId() + "'").FirstOrDefault();
                        if (resUsr != null)
                        {
                            if (resUsr.IsMainAdmin)
                            {
                             //   items.Add(new SelectListItem { Text = "System admin", Value = "2" });
                            }
                        }

                        var resLocs = ctx.Locations.Where(x => x.MyAdminId == null);
                        if(resLocs != null)
                        {
                            foreach(var resLoc in resLocs)
                            {
                                locations.Add(resLoc);
                            }
                        }
                    }

                    ViewBag.items = items;
                    ViewBag.locations = locations;

                    ModelState.Merge((ModelStateDictionary)TempData["ModelState"]);

                    return View();
                }                    
            }
        }

        // GET: System_Admin/RegisterNewLocation
        public ActionResult RegisterNewLocation()
        {
            if (!Request.IsAuthenticated)
                return RedirectToAction("Login", "Account");
            else
            {
                if (!User.IsInRole("System_Admin"))
                    return RedirectToAction("Index", "Home");
                else
                    return View();
            }
        }

        // GET: System_Admin/ChangePointsScale
        public ActionResult ChangePointsScale()
        {
            if (!Request.IsAuthenticated)
                return RedirectToAction("Login", "Account");
            else
            {
                if (!User.IsInRole("System_Admin"))
                    return RedirectToAction("Index", "Home");
                else
                {
                    int[] pointsArr = new int[3];
                    using (var ctx = new ApplicationDbContext())
                    {
                        var pointsList = ctx.Database.SqlQuery<Points>("select * from Points");
                        int cnt = 0;
                        foreach (var point in pointsList)
                        {
                            pointsArr[cnt] = point.PointsCount;
                            cnt++;
                        }
                    }

                    ViewBag.pointsArr = pointsArr;

                    return View();
                }
            }
        }

        public async Task<ActionResult> AddAdmin(AddNewAdminViewModel adminVM)
        {
            if (!Request.IsAuthenticated)
                return RedirectToAction("Login", "Account");
            else
            {
                if (!User.IsInRole("System_Admin"))
                    return RedirectToAction("Index", "Home");
                else
                {
                    if (adminVM.Name != null && adminVM.LastName != null && adminVM.Email != null && adminVM.UserName != null)
                    {
                        Admin newAdmin = null;
                        if (adminVM.Admin_Type == AdminType.SYSTEM_ADMIN)
                        {
                            newAdmin = new SystemAdmin
                            {
                                Admin_Type = adminVM.Admin_Type,
                                Name = adminVM.Name,
                                LastName = adminVM.LastName,
                                Email = adminVM.Email,
                                UserName = adminVM.UserName,
                                IsMainAdmin = false                                
                            };
                        }
                        else if (adminVM.Admin_Type == AdminType.FANZONE_ADMIN)
                        {
                            newAdmin = new FanZoneAdmin
                            {
                                Admin_Type = adminVM.Admin_Type,
                                Name = adminVM.Name,
                                LastName = adminVM.LastName,
                                Email = adminVM.Email,
                                UserName = adminVM.UserName,
                                HasSetPassword = false                                
                            };
                        }
                        else if (adminVM.Admin_Type == AdminType.LOCATION_ADMIN)
                        {
                            if(adminVM.MyLocationId != null)
                            {
                                newAdmin = new LocationAdmin
                                {
                                    Admin_Type = adminVM.Admin_Type,
                                    Name = adminVM.Name,
                                    LastName = adminVM.LastName,
                                    Email = adminVM.Email,
                                    UserName = adminVM.UserName,
                                    MyLocationId = "123"
                                };
                            }
                            else
                            {
                                ModelState.AddModelError("", "Error: Admin location is null.");
                                TempData["ModelState"] = ModelState;
                                return RedirectToAction("AddNewAdmin", "System_Admin");
                            }
                        }

                        if (newAdmin != null)
                        {
                            using (var um = new UserManager<ApplicationUser>(new UserStore<ApplicationUser>(new ApplicationDbContext())))
                            {
                                IdentityResult result;
                                if (um.Users.FirstOrDefault(usr => usr.Email == newAdmin.Email) == null)
                                {
                                    //RandomString()
                                    string newPassword = "ARFSAWEFSA!0934gfY";
                                    result = await um.CreateAsync(newAdmin, newPassword);
                                    if (result.Succeeded)
                                    {
                                        if (adminVM.Admin_Type == AdminType.SYSTEM_ADMIN)
                                        {
                                            if (!um.IsInRole(newAdmin.Id, "System_Admin"))
                                            {
                                                var userResult = um.AddToRole(newAdmin.Id, "System_Admin");
                                                if (!userResult.Succeeded)
                                                {
                                                    ModelState.AddModelError("", "Adding user '" + newAdmin.UserName + "' to '" + "System_Admin" + "' role failed with error(s): " + userResult.Errors);
                                                    TempData["ModelState"] = ModelState;
                                                    return RedirectToAction("AddNewAdmin", "System_Admin");
                                                }
                                            }
                                        }
                                        else if (adminVM.Admin_Type == AdminType.FANZONE_ADMIN)
                                        {
                                            if (!um.IsInRole(newAdmin.Id, "Fanzone_Admin"))
                                            {
                                                var userResult = um.AddToRole(newAdmin.Id, "Fanzone_Admin");
                                                if (!userResult.Succeeded)
                                                {
                                                    ModelState.AddModelError("", "Adding user '" + newAdmin.UserName + "' to '" + "Fanzone_Admin" + "' role failed with error(s): " + userResult.Errors);
                                                    TempData["ModelState"] = ModelState;
                                                    return RedirectToAction("AddNewAdmin", "System_Admin");
                                                }
                                                else
                                                {
                                                    //email to isaNS2017@gmail.com from the same address
                                                    var fromAddress = new MailAddress("isaNS2017@gmail.com", "ISA NS");
                                                    var toAddress = new MailAddress(adminVM.Email, "ISA NS");
                                                    string fromPassword = "isa2017_123";
                                                    string subject = "Welcome to ISA2017 Cinemas";
                                                    string body = "Hello new Fanzone admin!" + System.Environment.NewLine + "Your sign-in credentials are:" + System.Environment.NewLine + "Email: " + adminVM.Email + System.Environment.NewLine + "Password: " + newPassword;

                                                    var smtp = new SmtpClient
                                                    {
                                                        Host = "smtp.gmail.com",
                                                        Port = 587,
                                                        EnableSsl = true,
                                                        DeliveryMethod = SmtpDeliveryMethod.Network,
                                                        UseDefaultCredentials = false,
                                                        Credentials = new NetworkCredential(fromAddress.Address, fromPassword)
                                                    };
                                                    using (var message = new MailMessage(fromAddress, toAddress)
                                                    {
                                                        Subject = subject,
                                                        Body = body
                                                    })
                                                    {
                                                        smtp.Send(message);
                                                    }
                                                }                                                
                                            }
                                        }
                                        else if (adminVM.Admin_Type == AdminType.LOCATION_ADMIN)
                                        {
                                            if (!um.IsInRole(newAdmin.Id, "Location_Admin"))
                                            {
                                                var userResult = um.AddToRole(newAdmin.Id, "Location_Admin");
                                                if (!userResult.Succeeded)
                                                {
                                                    ModelState.AddModelError("", "Adding user '" + newAdmin.UserName + "' to '" + "Location_Admin" + "' role failed with error(s): " + userResult.Errors);
                                                    TempData["ModelState"] = ModelState;
                                                    return RedirectToAction("AddNewAdmin", "System_Admin");
                                                }
                                                else
                                                {
                                                    ApplicationDbContext ctx = new ApplicationDbContext();
                                                    var resLoc = ctx.Locations.FirstOrDefault(x => x.Id.ToString() == adminVM.MyLocationId);

                                                    if(resLoc != null)
                                                    {
                                                        resLoc.MyAdminId = newAdmin.Id;
                                                        ctx.SaveChanges();
                                                    }
                                                    else
                                                    {
                                                        um.RemoveFromRole(newAdmin.Id, "Location_Admin");
                                                        ModelState.AddModelError("", "Error: Given admin location is not found! Please try again.");
                                                        TempData["ModelState"] = ModelState;
                                                        return RedirectToAction("AddNewAdmin", "System_Admin");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    else
                                    {
                                        ModelState.AddModelError("", "Error while trying to create new admin");
                                        TempData["ModelState"] = ModelState;
                                        return RedirectToAction("AddNewAdmin", "System_Admin");
                                    }
                                }
                                else
                                {
                                    ModelState.AddModelError("", "User with this email adress already exists");
                                    TempData["ModelState"] = ModelState;
                                    return RedirectToAction("AddNewAdmin", "System_Admin");
                                }
                            }
                        }
                        else
                        {
                            ModelState.AddModelError("", "Error while trying to add new admin (newAdmin is null)");
                            TempData["ModelState"] = ModelState;
                            return RedirectToAction("AddNewAdmin", "System_Admin");
                        }
                    }
                    else
                    {
                        ModelState.AddModelError("", "Error while trying to add new admin (some fields are null)");
                        TempData["ModelState"] = ModelState;
                        return RedirectToAction("AddNewAdmin", "System_Admin");
                    }

                    TempData["success"] = "Succesfully added a new: " + adminVM.Admin_Type.ToString();
                    return RedirectToAction("Index", "Home");
                }
            }            
        }

       

        private string RandomString()
        {
            var chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            var numbers = "0123456789";
            var stringChars = new char[8];
            var random = new Random();

            for (int i = 0; i < 2; i++)
            {
                stringChars[i] = chars[random.Next(chars.Length)];
            }
            for (int i = 2; i < 6; i++)
            {
                stringChars[i] = numbers[random.Next(numbers.Length)];
            }
            for (int i = 6; i < 8; i++)
            {
                stringChars[i] = chars[random.Next(chars.Length)];
            }

            var finalString = new String(stringChars);
            return finalString;
        }
    }
}