using Isa2017Cinema.Models;
using System;
using System.Collections.Generic;
using WebApplication2.Models;

namespace Isa2017Cinema
{
    public class Initializer : System.Data.Entity.DropCreateDatabaseIfModelChanges<ApplicationDbContext>
    {
        public Initializer()
        {
        }

        protected override void Seed(ApplicationDbContext context)
        {
           
        }
    }
}