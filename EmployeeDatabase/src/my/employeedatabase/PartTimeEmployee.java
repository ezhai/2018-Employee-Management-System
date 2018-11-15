/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.employeedatabase;

/**
 *
 * @author shawnzhang12
 */
public class PartTimeEmployee extends EmployeeInfo {

    private double hourlyWage;
    private double hoursPerWeek;
    private double weeksPerYear;
    private double deductionsRate;

    public PartTimeEmployee(int eN, String fN, String lN, int s, int wL, double hW, double hPW, double wPY, double dR) {
        super(eN, fN, lN, s, wL);
        hourlyWage = hW;
        hoursPerWeek = hPW;
        weeksPerYear = wPY;
        deductionsRate = dR;
    }

    public PartTimeEmployee() {
        super(-1, "", "", -1, -1);
        hourlyWage = -1;
        hoursPerWeek = -1;
        weeksPerYear = -1;
        deductionsRate = -1;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public double getHoursPerWeek() {
        return hoursPerWeek;
    }

    public double getWeeksPerYear() {
        return weeksPerYear;
    }

    public void setHourlyWage(double hW) {
        hourlyWage = hW;
    }

    public void setHoursPerWeek(double hPW) {
        hoursPerWeek = hPW;
    }

    public void setWeeksPerYear(double wPY) {
        weeksPerYear = wPY;
    }

    public void setDeductionsRate(double dR) {
        if (dR < 0 || dR >= 1) {
            deductionsRate = -1;
        } else {
            deductionsRate = dR;
        }
    }

    public double getDeductionsRate() {
        return deductionsRate;
    }

    public double calcAnnualGrossIncome() {
        return (hourlyWage * hoursPerWeek * weeksPerYear);
    }

    public double calcAnnualNetIncome() {
        return (hourlyWage * hoursPerWeek * weeksPerYear * (1 - getDeductionsRate()));
    }
}
