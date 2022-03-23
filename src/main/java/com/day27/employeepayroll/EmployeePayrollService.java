package com.day27.employeepayroll;

/**
 *  UC1 :- Create an Employee Payroll Service to Read and Write Employee Payroll to a Console
 *         - Create Employee Payroll Class of id, name and Salary
 *         - Read the information from the console
 *         - Finally write the employee payroll to the console
 *  UC2 :- Write a program to demonstrate File Operations like
 *         - Check File Exists
 *         - Delete File and Check File Not Exist
 *         - Create Directory
 *         - Create Empty File
 *         - List Files, Directories as well as Files with Extension
 *  UC3:-  Create a Watch Service to watch particular directory along with all Files and
 *         Sub Directories - Using File IO Count Number of Entries in the File    
 *  UC4:-  Create an Employee Payroll Service to store Employee Payroll into a File 
 *  	   - Create Employee Payroll Class of id,   
 *  UC5:-  Ability for Employee Payroll Service to print the Employee Payrolls       
 *
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
	 * creating List of EmployeePayrollData
	 */
	public List<EmployeePayrollData> employeePayrollList;

	/**
	 * creating constructor of EmployeePayrollService() which is default type
	 */
	public EmployeePayrollService() {
	}

	/**
	 * creating parameterized constructor of EmployeePayrollService with no return
	 * type
	 * 
	 * @param employeePayrollList -passing parameter
	 */
	public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
		this.employeePayrollList = employeePayrollList;
	}

	/**
	 * Main method for manipulation Of JavaFILE_IO
	 * 
	 * @param args - Default Java param (Not used)
	 */
	public static void main(String[] args) {

		/**
		 * creating List of Type EmployeePayrollData using ArrayList to store all the
		 * employeePayrolldata
		 */
		List<EmployeePayrollData> employeePayrollList = new ArrayList<EmployeePayrollData>();

		/**
		 * creating instance of EmployeePayrollService class
		 */
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);

		/**
		 * using scanner to read input from console
		 */
		Scanner consoleInputReader = new Scanner(System.in);

		/**
		 * Calling method readEmployeeData to read data from console
		 */
		employeePayrollService.readEmployeeData(consoleInputReader);

		/**
		 * Calling method writeEmployeePayrollData to write the data
		 */
		employeePayrollService.writeEmployeeData(IOService.CONSOLE_IO);
	}

	/**
	 * @param consoleInputReader Read employee data
	 */
	public void readEmployeeData(Scanner consoleInputReader) {
		System.out.println("Enter employee ID : ");
		int id = Integer.parseInt(consoleInputReader.nextLine());
		System.out.println("Enter employee name : ");
		String name = consoleInputReader.nextLine();
		System.out.println("Enter employee salary : ");
		double salary = Double.parseDouble(consoleInputReader.nextLine());

		/**
		 * Adding EmployeePayrollData to the employeepayrollList
		 */
		employeePayrollList.add(new EmployeePayrollData(id, name, salary));
	}

	/**
	 * created method writeEmployeeData which writes the data of the employee in the
	 * console
	 */
	public void writeEmployeeData(IOService ioService) {
		if (ioService.equals(IOService.CONSOLE_IO))
			System.out.println("Writing Employee Payroll Data to Console\n" + employeePayrollList);
		else if (ioService.equals(IOService.FILE_IO))
			new EmployeePayrollFileIOService().writeData(employeePayrollList);
	}

	/**
	 * created method printData to print the employee payroll data Using FileIO
	 * prints lines in the payroll file
	 * 
	 * @param ioService Print Data
	 */
	public void printData(IOService ioService) {
		new EmployeePayrollFileIOService().printData();
	}

	/**
	 * create method countEntries -Using File IO Count Number of Entries in the File
	 * 
	 * @param ioService
	 * @return number of entries
	 */
	public long countEntries(IOService ioService) {
		if (ioService.equals(IOService.FILE_IO))
			return new EmployeePayrollFileIOService().countEntries();
		return 0;
	}
}
