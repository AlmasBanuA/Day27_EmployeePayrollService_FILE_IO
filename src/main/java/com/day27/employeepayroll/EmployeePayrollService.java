package com.day27.employeepayroll;

/**
 * UC1:- Creating an Employee Payroll Service to Read and Write Employee Payroll to a Console 
 * 		 - Create Employee Payroll Class of id, name and Salary 
 * 		 - Read the information from the Console - Finally write the Employee Payroll to the Console
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {

	/**
	 * Java Enums can be thought of as classes which have a fixed set of constants
	 * (a variable that does not change) we can define an enum either inside the
	 * class or outside the class
	 * 
	 * @author user -Almas
	 *
	 */
	public enum IOService {
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	}

	/**
	 * creating List of Type EmployeePayrollData using ArrayList to store all the
	 * employeePayrolldata
	 */
	private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();;

	/**
	 * creating constructor of EmployeePayrollService() which is default type
	 */
	public EmployeePayrollService() {
		employeePayrollList = new ArrayList<>();
	}

	/**
	 * Main method for manipulation Of JavaFILE_IO
	 * 
	 * @param args - Default Java param (Not used)
	 */
	public static void main(String[] args) {
		/**
		 * creating instance of EmployeePayrollService class
		 */
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();

		/**
		 * using scanner to read input from console
		 */
		Scanner consoleInputReader = new Scanner(System.in);

		/**
		 * Calling method readEmployeePayrollData to read data from console
		 */
		employeePayrollService.readEmployeePayrollData(consoleInputReader);

		/**
		 * Calling method writeEmployeePayrollData to write the data
		 */
		employeePayrollService.writeEmployeePayrollData();

	}

	/**
	 * created method readEmployeePayrollData which reads the data of the employee
	 * from the console
	 */
	private void readEmployeePayrollData(Scanner consoleInputReader) {
		System.out.println("Enter Employee ID: ");
		int id = consoleInputReader.nextInt();
		System.out.println("Enter Employee Name: ");
		String name = consoleInputReader.next();
		System.out.println("Enter Employee Salary: ");
		double salary = consoleInputReader.nextDouble();
		employeePayrollList.add(new EmployeePayrollData(id, name, salary));
	}

	/**
	 * created method writeEmployeePayrollData which writes the data of the employee
	 * in the console
	 */
	private void writeEmployeePayrollData() {
		System.out.println("\nWriting Employee Payroll to console\n" + employeePayrollList);
	}

}
