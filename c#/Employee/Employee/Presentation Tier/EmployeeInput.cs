//Program Header
//Class Name: EmployeeInput
//Programmer: Arron Thornton
//CIS247
//Class Description: This class provides input functionality for
//gathering information from the user

using System;

namespace Employee
{
    class EmployeeInput
    {
        //this class gathers all necessary information for the base class object
        public static void CollectEmployeeInformation(Employee theEmployee)
        {
            theEmployee.FirstName = InputUtilities.UppercaseFirst(InputUtilities.getStringInputValue("first name"));
            theEmployee.LastName = InputUtilities.UppercaseFirst(InputUtilities.getStringInputValue("last name"));
            theEmployee.Gender = Char.ToUpper(InputUtilities.getCharInputValue("gender (M or F)"));
            theEmployee.Dependents = InputUtilities.getIntegerInputValue("number of dependents");
            theEmployee.Benefits.HealthInsuranceCompany = InputUtilities.UppercaseFirst(InputUtilities.getStringInputValue("health insurance company"));
            theEmployee.Benefits.LifeInsuranceAmount = InputUtilities.getDoubleInputValue("life insurance amount");
            theEmployee.Benefits.VacationDays = InputUtilities.getIntegerInputValue("vacation days");

        }
        //this method collects the information for an Hourly employee by accepting only a hourly object as a parameter
        public static void CollectHourlyInformation(Hourly theEmployee)
        {
            theEmployee.Hours = InputUtilities.getDoubleInputValue("hours worked");
            theEmployee.Wage = InputUtilities.getDoubleInputValue("hourly wage");
            theEmployee.Category = InputUtilities.UppercaseFirst(InputUtilities.getStringInputValue("category"));
        }
        //this method collects the information for an Salary employee by accepting only a salary object as a parameter
        public static void CollectSalaryInformation(Salary theEmployee)
        {
            theEmployee.AnnualSalary = InputUtilities.getDoubleInputValue("annual salary");
            theEmployee.ManagementLevel = InputUtilities.getIntegerInputValue("management level");

        }
    }
}
