//Program Header
//Class Name: Employee
//Programmer: Arron Thornton
//CIS247
//Class Description: This class provides the blueprint for the Employee
//class.  Includes a contructor, deconstructor and functions

using System;
using System.IO;

namespace Employee
{
    abstract class Employee
    {
        #region Class Constants

        //all of our constants
        private const int MIN_DEPENDENTS = 0;
        private const int MAX_DEPENDENTS = 10;
        private const double MIN_SALARY = 20000;
        private const double MAX_SALARY = 200000;
        private const string DEFAULT_NAME = "not given";
        private const char DEFAULT_GENDER = 'U';
        //private const string DEFAULT_TYPE = "Hourly";

        #endregion

        #region Protected Variables

        // all of our necessary protected variables for the employee class
        protected string _firstName;
        protected string _lastName;
        protected char _gender;
        protected int _dependents;
        protected double _annualSalary;
        protected double weeklySalary;
        protected static int numOfEmployees = 0;
        protected Benefits benefits;
        protected string employeeType;

        #endregion

        #region Getters and Setters

        //all of the necessary getters and setters for our private variables
        public string EmployeeType
        {
            get { return employeeType; }
        }

        public Benefits Benefits
        {
            get { return benefits; }
            set
            {
                if (value == null)
                {
                    benefits = new Benefits();
                }
                benefits = value;
            }
        }
        public static int NumOfEmployees
        {
            get { return numOfEmployees; }
        }

        public string FirstName
        {
            get { return _firstName; }
            set
            {
                if (String.IsNullOrEmpty(value))
                {
                    value = DEFAULT_NAME;
                }
                _firstName = value;
            }
        }
        public string LastName
        {
            get { return _lastName; }
            set
            {
                if (String.IsNullOrEmpty(value))
                {
                    value = DEFAULT_NAME;
                }
                _lastName = value;
            }
        }
        public char Gender
        {
            get { return _gender; }
            set
            {
                if (!(value == 'm' || value == 'M' || value == 'f' || value == 'F'))
                {
                    value = DEFAULT_GENDER;
                }
                _gender = value;
            }
        }
        public int Dependents
        {
            get { return _dependents; }
            set
            {
                if (value < MIN_DEPENDENTS)
                {
                    value = MIN_DEPENDENTS;
                }
                else if (value > MAX_DEPENDENTS)
                {
                    value = MAX_DEPENDENTS;
                }

                _dependents = value;
            }
        }
        public double AnnualSalary
        {
            get { return _annualSalary; }
            set
            {
                if (value < MIN_SALARY)
                {
                    value = MIN_SALARY;
                }
                else if (value > MAX_SALARY)
                {
                    value = MAX_SALARY;
                }

                _annualSalary = value;
            }
        }
        public string EmployeeName
        {
            get { return FirstName + " " + LastName; }
        }

        #endregion

        #region Constructors

        //The default contructor
        public Employee()
        {
            benefits = new Benefits();
            numOfEmployees++;
            FirstName = DEFAULT_NAME;
            LastName = DEFAULT_NAME;
            Gender = DEFAULT_GENDER;
            Dependents = MIN_DEPENDENTS;
            AnnualSalary = MIN_SALARY;
        }

        public Employee(string type)
        {
            benefits = new Benefits();
            numOfEmployees++;
            FirstName = DEFAULT_NAME;
            LastName = DEFAULT_NAME;
            Gender = DEFAULT_GENDER;
            Dependents = MIN_DEPENDENTS;
            AnnualSalary = MIN_SALARY;
            employeeType = type;
        }

        //This constructor accepts the values from the user to create the object
        public Employee(string type, string first, string last, char gend, int depend, double sal, Benefits benefits)
        {
            this.Benefits = benefits;
            numOfEmployees++;
            FirstName = first;
            LastName = last;
            Gender = gend;
            Dependents = depend;
            AnnualSalary = sal;
            employeeType = type;
        }

        #endregion

        #region Non-Static Methods

        // this method calculates our weekly pay
        public virtual double CalculateWeeklyPay()
        {
            return weeklySalary = AnnualSalary/52;
        }

        //the overloaded method to recalculate the modified salary
        public double CalculateWeeklyPay(double modifiedSalary)
        {
            AnnualSalary = modifiedSalary;
            return weeklySalary = modifiedSalary/52;
        }

        //the ToString method compiles all of the object's data into one, formatted, string
        public virtual string ToString()
        {
            string output = "";
            output = "\n_-_-_-_-_-_-_-_-_-_- Employee Information -_-_-__-_-_-_-_-_-_\n";
            output += "\t\t         Type:  " + EmployeeType + "\n";
            output += "\t\t         Name:  " + EmployeeName + "\n";
            output += "\t\t       Gender:  " + Gender + "\n";
            output += "\t\t   Dependents:  " + Dependents + "\n";
            output += "\t\tAnnual Salary:  " + AnnualSalary.ToString("C") + "\n";
            output += "\t\tWeekly Salary:  " + weeklySalary.ToString("C") + "\n";
            output += "\t\t      Net Pay:  " + CalculateNetPay().ToString("C") + "\n";
            output += benefits.ToString();
            return output;
        }

        //Finally created a function to write the information to a file
        public virtual void WriteToFile()
        {
            using (StreamWriter writer = new StreamWriter("EmployeeInfo.txt", true))
            {
                writer.WriteLine("\n_-_-_-_-_-_-_-_-_-_-_-_-_-_-" + EmployeeName + "-_-_-_-_-_-_-_-_-_-_-_-_\n");
                writer.WriteLine("\t                 Type:  " + EmployeeType + "\n");
                writer.WriteLine("\t                 Name:  " + EmployeeName + "\n");
                writer.WriteLine("\t               Gender:  " + Gender + "\n");
                writer.WriteLine("\t           Dependents:  " + Dependents + "\n");
                writer.WriteLine();
            }
            benefits.WriteBenefitsToFile();
        }

        public abstract double CalculateNetPay();

        #endregion
        //deconstuctor
        ~Employee(){}
    }

    
}
