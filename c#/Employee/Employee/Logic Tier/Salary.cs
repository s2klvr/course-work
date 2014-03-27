//Program Header
//Class Name: Salary
//Programmer: Arron Thornton
//CIS247
//Class Description: This is a sub-class that provides the blueprint for the Salary subclass
//class.  Includes a contructor, deconstructor and functions

using System;
using System.IO;

namespace Employee
{
    class Salary : Employee
    {
        #region Subclass Constant Variables
        private const int MIN_MANAGEMENT_LEVEL = 0;
        private const int MAX_MANAGEMENT_LEVEL = 3;
        private const double BONUS_PERCENT = .10;
        private const double TAX_RATE = .73;
        #endregion

        #region Subclass Private Variables
        private int managementLevel;
        #endregion

        #region Subclass Properties
        public int ManagementLevel
        {
            get { return managementLevel; }
            set
            {
                if (value < 0)
                {
                    managementLevel = MIN_MANAGEMENT_LEVEL;
                }
                else if (value > 3)
                {
                    managementLevel = MAX_MANAGEMENT_LEVEL;
                }
                else
                {
                    managementLevel = value;
                }
            }
        }
        #endregion

        # region Subclass Constructors
        public Salary() : base()
        {
            ManagementLevel = MIN_MANAGEMENT_LEVEL;
        }

        public Salary(string type)
            :base(type)
        {
            ManagementLevel = MIN_MANAGEMENT_LEVEL;
        }

        public Salary(string fname, string lname, char gen, int dep, double sal, Benefits ben, int manLevel)
            : base("Salary", fname, lname, gen, dep, sal, ben)
        {
            ManagementLevel = manLevel;
        }
        #endregion

        #region Subclass Non-Static Methods
        //this method overrides the superclass method
        public override double CalculateWeeklyPay()
        {
            double actualBonusPercentage = managementLevel * BONUS_PERCENT;
            AnnualSalary += AnnualSalary * actualBonusPercentage;
            return base.weeklySalary = AnnualSalary / 52;
        }
        //this method overrides the superclass ToString method to allow the addition of extra information
        public override string ToString()
        {
            string output;

            output = base.ToString();
            output += "\t                Level:\t" + ManagementLevel + "\n";
            return output;
        }
        public override void WriteToFile()
        {
            base.WriteToFile();
            using (StreamWriter writer = new StreamWriter("EmployeeInfo.txt", true))
            {
                writer.WriteLine("\t                Level:  " + ManagementLevel + "\n");
                writer.WriteLine("\t        Annual Salary:  " + AnnualSalary.ToString("C") + "\n");
                writer.WriteLine("\t        Weekly Salary:  " + weeklySalary.ToString("C") + "\n");
                writer.WriteLine("\t              Net Pay:  " + CalculateNetPay().ToString("C") + "\n");
                writer.WriteLine();
            }
        }

        public override double CalculateNetPay()
        {
            return weeklySalary*TAX_RATE;
        }
        #endregion
    }
}
