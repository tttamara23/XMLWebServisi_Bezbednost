using Isa2017Cinema.Models;
using Microsoft.AspNet.Identity;
using Microsoft.AspNet.Identity.EntityFramework;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Data.SqlClient;
using System.IO;
using System.Linq;
using System.Net;
using System.Net.Mail;
using System.Threading.Tasks;
using System.Web.Mvc;
using WebApplication2.Models;

namespace WebApplication2.Controllers
{
    public class FanZoneController : Controller
    {
        // GET: FanZone/FanZone
        public ActionResult FanZonePage()
        {
            if (!Request.IsAuthenticated)
                return RedirectToAction("Login", "Account");
            else
            {
                if (!(User.IsInRole("Fanzone_Admin") || User.IsInRole("Regular_User")))
                    return RedirectToAction("Index", "Home");
                else
                {
                    List<ThemeRequisit> themeRequisits = new List<ThemeRequisit>();
                    using (var ctx = new ApplicationDbContext())
                    {
                        string fzID = ctx.Fanzone.FirstOrDefault().Id.ToString();
                        var fzData = ctx.Fanzone.Include(x => x.RequisitsList).FirstOrDefault();
                        foreach (var req in fzData.RequisitsList)
                        {
                            if(req.ParentUserId == null)
                                themeRequisits.Add(req);
                        }
                    }

                    ViewBag.requisitsToShow = themeRequisits;

                    string uID = User.Identity.GetUserId();

                    if (User.IsInRole("Regular_User"))
                    {
                        List<ThemeRequisit> myRequisits = new List<ThemeRequisit>();
                        List<Post> allPosts = new List<Post>();
                        List<Post> myPosts = new List<Post>();
                        using (var ctx = new ApplicationDbContext())
                        {
                            string fzID = ctx.Fanzone.FirstOrDefault().Id.ToString();
                            var fzData = ctx.Fanzone.Include(x => x.PostsList).Include(y => y.RequisitsList).FirstOrDefault();

                            foreach (var p in fzData.PostsList)
                            {
                                if (p.ParentUserId != uID)
                                    allPosts.Add(p);
                                else
                                    myPosts.Add(p);
                            }

                            foreach (var req in fzData.RequisitsList)
                            {
                                if(req.ParentUserId == uID)
                                    myRequisits.Add(req);
                            }
                        }

                        ViewBag.myRequisits = myRequisits;
                        ViewBag.allPosts = allPosts;
                        ViewBag.myPosts = myPosts;
                    }
                    else if (User.IsInRole("Fanzone_Admin"))
                    {
                        List<Post> unapprovedPosts = new List<Post>();
                        List<Post> postsToManage = new List<Post>();
                        using (var ctx = new ApplicationDbContext())
                        {
                            var fzData = ctx.Fanzone.Include(y => y.PostsList).FirstOrDefault();

                            foreach (var p in fzData.PostsList)
                            {
                                if (!p.IsTakenByAdmin)
                                    unapprovedPosts.Add(p);
                                else if (uID == p.ParentAdminId)
                                    postsToManage.Add(p);
                            }                               

                            ViewBag.unapprovedPosts = unapprovedPosts;
                            ViewBag.postsToManage = postsToManage;
                        }
                    }

                    ViewBag.systemTime = DateTime.Now;

                    ModelState.Merge((ModelStateDictionary)TempData["ModelState"]);
                    return View();
                }
            }
        }

        // GET: FanZone/FirstLoginPasswordChange
        public ActionResult FirstLoginPasswordChange()
        {
            if (!Request.IsAuthenticated)
                return RedirectToAction("Login", "Account");
            else
            {
                /*if (!User.IsInRole("Fanzone_Admin"))
                    return RedirectToAction("Index", "Home");*/
                if (User.IsInRole("Fanzone_Admin") || User.IsInRole("Location_Admin"))
                    return View();
                else return RedirectToAction("Index", "Home");
            }
        }

      

        
        
        public async Task<ActionResult> ChangeFirstPassword(FirstPasswordChangeViewModel fpcVM)
        {
            if (!Request.IsAuthenticated)
                return RedirectToAction("Login", "Account");
            else
            {
                if (!User.IsInRole("Fanzone_Admin") && !User.IsInRole("Location_Admin"))
                    return RedirectToAction("Index", "Home");
                else
                {
                    if (fpcVM.NewPassword != null && fpcVM.ConfirmPassword != null)
                    {
                        if(fpcVM.NewPassword == fpcVM.ConfirmPassword)
                        {
                            using (var um = new UserManager<ApplicationUser>(new UserStore<ApplicationUser>(new ApplicationDbContext())))
                            {
                                var user = await um.FindByIdAsync(User.Identity.GetUserId());
                                if (user != null)
                                {
                                    user.PasswordHash = um.PasswordHasher.HashPassword(fpcVM.NewPassword);
                                    var result = await um.UpdateAsync(user);
                                    
                                    if (result.Succeeded)
                                    {
                                        using (var ctx = new ApplicationDbContext())
                                        {
                                            try
                                            {
                                                ctx.Database.ExecuteSqlCommand("update AspNetUsers set HasSetPassword = 1 where Id = '" + user.Id + "'");
                                            }
                                            catch (SqlException e)
                                            {
                                                ModelState.AddModelError("", "Error while trying to change password (SQL exception).");
                                                return View("FirstLoginPasswordChange");
                                            }                                           
                                        }

                                        TempData["success"] = "Succesfully updated the password.";
                                        return RedirectToAction("Index", "Home");
                                    }
                                    else
                                    {
                                        ModelState.AddModelError("", "Error while trying to change password.");
                                        return View("FirstLoginPasswordChange");
                                    }
                                }
                                else
                                {
                                    ModelState.AddModelError("", "Error while trying to change password (can't find given user).");
                                    return View("FirstLoginPasswordChange");
                                }                                
                            }                            
                        }
                        else
                        {
                            ModelState.AddModelError("", "Error: The passwords are not matching.");
                            return View("FirstLoginPasswordChange");
                        }
                    }
                    else
                    {
                        ModelState.AddModelError("", "Error: Some attributes are null.");
                        return View("FirstLoginPasswordChange");
                    }
                }
            }
        }

        

     
    }
}