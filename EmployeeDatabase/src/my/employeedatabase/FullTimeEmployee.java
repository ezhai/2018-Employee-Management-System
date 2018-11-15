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
public class FullTimeEmployee extends EmployeeInfo {

	private double yearlySalary;
	private double deductionsRate;

	public FullTimeEmployee(int eN, String fN, String lN, int s, int wL, double yS, double dR) {
		super(eN, fN, lN, s, wL);
		yearlySalary = yS;
		deductionsRate = dR;
	}
        
        public FullTimeEmployee() {
		super(-1,"", "", -1, -1);
		yearlySalary = -1;
		deductionsRate = -1;
        }

	public void setDeductionsRate(double dR) {
		if (dR < 0 || dR >= 1) {
			deductionsRate = -1;
		} else {
			deductionsRate = dR;
		}
	}
        
        public void setYearlySalary (double s) {
		if (s < 0) {
			yearlySalary = -1;
		} else {
			yearlySalary = s;
		}
	}
	public double getDeductionsRate() {
		return deductionsRate;
	}
        
        public double getYearlySalary() {
		return yearlySalary;
	}

	public double calcAnnualGrossIncome() {
		return yearlySalary;
	}

	public double calcAnnualNetIncome() {
		return (yearlySalary * (1 - getDeductionsRate()));
	}
}

