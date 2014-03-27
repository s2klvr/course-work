//Program Header
//Class Name: Hourly
//Programmer: Arron Thornton
//CIS247
//Class Description: This is a sub-class that provides the blueprint for the Hourly subclass
//class.  Includes a contructor, deconstructor and functions

using System;
using System.IO;

namespace Employee
{
    class Hourly : Employee
    {
        #region Subclass Constant Variables
        private const double MIN_WAGE = 10;
        private const double MAX_WAGE = 75;
        private const double MIN_HOURS = 0;
        private const double MAX_HOURS = 50;
        private const double TAX_RATE = .82;
        #endregion

        #region Subclass Private Variables
        private double _wage;
        private double _hours;
        private string _category;
        #endregion

        #region Getters and Setters
        public double Wage
        {
            get { return _wage; }
            set
            {
                if (value > MIN_WAGE && value < MAX_WAGE)
                {
                    _wage = value;    
                }
                else if (value < MIN_WAGE)
                {
                    _wage = MIN_WAGE;
                }
                else
                {
                    _wage = MAX_WAGE;
                }
                base.AnnualSalary = CalculateWeeklyPay()*48;

            }
        }
        public double Hours
        {
            get { return _hours; }
            set
            {
                if (value > MIN_HOURS && value < MAX_HOURS)
                {
                    _hours = value;
                }
                else if (value < MIN_HOURS)
                {
                    _hours = MIN_HOURS;
                }
                else
                {
                    _hours = MAX_HOURS;
                }
                base.AnnualSalary = CalculateWeeklyPay() * 48; 
            }
        }
        public string Category
        {
            get { return _category; }
            set { _category = value; }
        }
        #endregion

        #region Subclass Constructors
        public Hourly() : base()
        {
            Hours = MIN_HOURS;
            Wage = MIN_WAGE;        
        }

        public Hourly(string type)
            : base(type)
        {
            Hours = MIN_HOURS;
            Wage = MIN_WAGE;          
        }

        public Hourly(string fname, string lname, char gen, int dep, double wage, double hours, Benefits ben, string category)
            : base("Hourly", fname, lname, gen, dep, 0, ben)
        {
            Category = category;
            Hours = hours;
            Wage = wage;
        }
        #endregion

        #region Non-Static Methods
        //this method overrides the superclass method
        public override double CalculateWeeklyPay()
        {
            return weeklySalary = Wage * Hours ;
        }
        //this method overrides the superclass ToString method to allow the addition of extra information
        public override string ToString()
        {
            string output;

            output = base.ToString();
            output += "\t             Category:  " + Category + "\n";
            output += "\t                Hours:  " + Hours + "\n";
            output += "\t                Wages:  " + Wage.ToString("C") + "\n";
            return output;
        }
        public override void WriteToFile()
        {
            base.WriteToFile();
            using (StreamWriter writer = new StreamWriter("EmployeeInfo.txt", true))
            {
                writer.WriteLine("\t             Category:  " + Category + "\n");
                writer.WriteLine("\t                Hours:  " + Hours + "\n");
                writer.WriteLine("\t                Wages:  " + Wage.ToString("C") + "\n");
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
