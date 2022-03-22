package com.day27.employeepayroll;

public class EmployeePayrollData {

	/**
	 * private variables can only be accessed within the same class (an outside
	 * class has no access to it) private = restricted access However, it is
	 * possible to access them if we provide public get and set methods.
	 */
	private int employeeId;
	private String employeeName;
	private double employeeSalary;

	/**
	 * creating parameterized constructor of EmployeePayrollData by passing
	 * parameters with no return type
	 * 
	 * @param employeeId     -passing employee Id
	 * @param employeeName   -passing name
	 * @param employeeSalary -passing employeeSalary
	 */
	public EmployeePayrollData(int employeeId, String employeeName, double employeeSalary) {
		/**
		 * this variables is used to point the current object
		 */
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
	}

	@Override
	/**
	 * The toString() method returns the String representation of the object.
	 */
	public String toString() {
		return "EmployeePayrollData [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeSalary="
				+ employeeSalary + "]";
	}

}
