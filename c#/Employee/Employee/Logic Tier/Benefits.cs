//Program Header
//Class Name: Benefits
//Programmer: Arron Thornton
//CIS247
//Class Description: This class provides the blueprint for the Benefits
//class.  Includes a contructor, deconstructor and functions

using System;
using System.IO;

namespace Employee
{
    class Benefits
    {
        #region Constant Variables
        private const string DEFAULT_HEALTH_INSURANCE = "Blue Cross";
        private const double MIN_LIFE_INSURANCE = 0;
        private const double MAX_LIFE_INSURANCE = 1000000;
        private const int MIN_VACATION = 0;
        private const int MAX_VACATION = 45;
        #endregion

        #region Private Variables
        private string _healthInsuranceCompany;
        private double _lifeInsuranceAmount;
        private int _vacationDays;
        #endregion

        #region Getters and Setters
        public string HealthInsuranceCompany
        {
            get { return _healthInsuranceCompany; }
            set
            {
                if (String.IsNullOrEmpty(value))
                {
                    value = DEFAULT_HEALTH_INSURANCE;
                }
                _healthInsuranceCompany = value;
            }
        }

        public double LifeInsuranceAmount
        {
            get { return _lifeInsuranceAmount; }
            set
            {
                if (value < MIN_LIFE_INSURANCE)
                {
                    value = MIN_LIFE_INSURANCE;
                }
                else if (value > MAX_LIFE_INSURANCE)
                {
                    value = MAX_LIFE_INSURANCE;
                }
                _lifeInsuranceAmount = value;
            }
        }

        public int VacationDays
        {
            get { return _vacationDays; }
            set
            {
                if (value < MIN_VACATION)
                {
                    value = MIN_VACATION;
                }
                else if (value > MAX_VACATION)
                {
                    value = MAX_VACATION;
                }
                _vacationDays = value;
            }
        }
        #endregion

        #region Constructors
        public Benefits()
        {
            HealthInsuranceCompany = DEFAULT_HEALTH_INSURANCE;
            LifeInsuranceAmount = MIN_LIFE_INSURANCE;
            VacationDays = MIN_VACATION;
        }

        public Benefits(string health, double life, int vacation)
        {
            HealthInsuranceCompany = health;
            LifeInsuranceAmount = life;
            VacationDays = vacation;
        }
        #endregion

        #region Non-Static Methods
        public override string ToString()
        {
            string output = "";
            output = "\n_-_-_-_-_-_-_-_-_-_- Benefits Information -_-_-__-_-_-_-_-_-_\n";
            output += "     Health Insurance Company:  " + HealthInsuranceCompany + "\n";
            output += "        Life Insurance Amount:  " + LifeInsuranceAmount.ToString("C") + "\n";
            output += "                Vacation Days:  " + VacationDays + "\n";
            return output;
        }

        public void WriteBenefitsToFile()
        {
            using (StreamWriter writer = new StreamWriter("EmployeeInfo.txt", true))
            {
                writer.WriteLine("\n***************** Benefits Information *****************\n"); 
                writer.WriteLine("     Health Insurance Company:  " + HealthInsuranceCompany + "\n");
                writer.WriteLine("        Life Insurance Amount:  " + LifeInsuranceAmount.ToString("C") + "\n");
                writer.WriteLine("                Vacation Days:  " + VacationDays + "\n");
            }
        }

        #endregion
        ~Benefits(){}
    }
}
