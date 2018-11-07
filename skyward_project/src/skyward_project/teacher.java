package skyward_project;
import java.util.Scanner;
import java.io.*;
public class teacher {
	
	private String UserInputName = "", studentName = ""; //Variables and Arrays
	private String[] StudentListArray, ClassListArray = new String[8], ClassAttendanceArray = new String[8], ClassGradeArray = new String[8];
	private boolean ValidStudent, ValidChoice, ValidClass, ValidInput;
	private int StudentID, fileLength;
	Scanner input = new Scanner(System.in);
	
	public void chooseStudent() throws IOException {
		
		Scanner StudentList = new Scanner(new File("all_students.txt")); //Opens list of students
		int studentNum = 0; //Variables
		int l = 0;
		String options = "", skip, classname;
		ValidStudent = false;
		
		while (StudentList.hasNextLine() == true) { //Finds the number of registered students
			studentNum = studentNum + 1;
		}
		
		StudentListArray = new String[studentNum]; //Creates a student array based on number^
		
		System.out.println("-=Student List=-");
		
		while (StudentList.hasNext()) { //Enters student names into array^ and outputs a list to user
			studentName = StudentList.nextLine();
			StudentListArray[l] = studentName;
			System.out.println("\t" + studentName);
			l++;
		}
		
		while (ValidStudent == false) { //User chooses student
			System.out.println("Please choose a student by entering their name:");
			UserInputName = input.nextLine();
			
			for (int i = 0; i < studentNum; i++) { //Validates input
				if (UserInputName == StudentListArray[i]) {
					ValidStudent = true;
					StudentID = i;
				}
			}
			if (ValidStudent == false) {
				System.out.println("Student not found. Please try again.");
			}
		}
		
		String StudentName = StudentListArray[StudentID];
		
		PrintWriter writer = new PrintWriter(StudentName);
		Scanner reader = new Scanner(StudentName);
		
		if (reader.nextLine() == "Classes") { //Outputs class list from File 
			for (int i = 0; i < 8; i++) { //Enters all classes into ClassList Array
				skip = reader.nextLine();
				classname = reader.nextLine();
				ClassListArray[i] = classname;
			}
		}
		if (reader.nextLine() == "Grades") { //Outputs class list from File 
			for (int i = 0; i < 8; i++) { //Enters all grades into ClassGrades Array
				skip = reader.nextLine();
				classname = reader.nextLine();
				ClassGradeArray[i] = classname;
			}
		}
		if (reader.nextLine() == "Attendance") { //Outputs class list from File 
			for (int i = 0; i < 8; i++) { //Enters all Attendance into ClassAttendanceArray
				skip = reader.nextLine();
				classname = reader.nextLine();
				ClassAttendanceArray[i] = classname;
			}
		}
		
		reader.close(); //closes files
		writer.close();
		
		ChoosingOptions(); //Calls next method
	}
	
	public void ChoosingOptions() throws IOException{
		
		ValidChoice = false; //Variables
		int choice = 0;
		String options = "";
		
		Main m = new Main(); //Converter for Main Class
		
		while (ValidChoice == false) { //Loop that continues until user enters a valid option
			System.out.println("What would you like to do with " + StudentListArray[StudentID] + "?");
			System.out.println("\t[1] Assign Grades\n\t[2] Take Attendance\n\t[3] Back");
			
			options = input.nextLine(); 
			try { //converts inputted string to int and checks if it throws an exception. 
				choice = Integer.parseInt(options);
				ValidChoice = true;
			}
			catch (Exception e) {
				System.out.println("Your input was not valid. Please try again.");
			}
		}
		
		if (choice == 1) { //Calls different methods based on user choice
			assignGrade();
		}
		else if (choice == 2) {
			takeAttendance();
		}
		else if (choice == 3) {
			m.MainMethod();
		}
		else {//Recalls options method if the user didn't enter a valid choice
			System.out.println("That is not an option. Try again");
			ChoosingOptions();
		}
	}
	
	public void assignGrade() throws IOException{
		
		String choice = ""; //Variables
		String numer = "", slash = "", denom = "";
		int numerator = 0, denominator = 0;
		float percentage = 0;
		char Grade = ' ';
		String StudentName = StudentListArray[StudentID];
		StudentName = StudentName + ".txt";
		ValidClass = false;
		ValidInput = false;
		
		PrintWriter writer = new PrintWriter(StudentName); //FileIO
		Scanner reader = new Scanner(StudentName);
		
		for (int i = 0; i < 8; i++) { //Prints a list of student's classes
			System.out.println(ClassListArray[i]);
		}
	
		while (ValidClass = false) { //User chooses a class to edit
			System.out.println("\n\t Please select a class to grade (Case Sensitive)");
			choice = input.nextLine();
			
			for (int i = 0; i < 8; i++) { //Validates input
				if (choice == ClassListArray[i]) {
					ValidClass = true;
				}
			}
			if (ValidClass == false) {
				System.out.println("Class not found. Please try again.");
			}
		}
		
		System.out.println("Please enter the student's class grade as a fraction [X / Y]"); //Input Prompt
		numer = input.next();
		slash = input.next();
		denom = input.next();
		
		while (ValidInput == false) { //Loop that continues until user enters a valid option
			System.out.println("Please enter the student's class grade as a fraction [X / Y]");
			numer = input.next();
			slash = input.next();
			denom = input.next();
			
			try { //converts inputted string to int and checks if it throws an exception. 
				numerator = Integer.parseInt(numer);
				denominator = Integer.parseInt(denom);
				ValidInput = true;
			}
			catch (Exception e) {
				System.out.println("Your input was not valid. Please try again.");
			}
		}
		
		percentage = numerator / denominator; //Determines Percentage grade and letter grade
		
		if (percentage <= 100 && percentage > 90) {
			Grade = 'A';
		}
		else if (percentage <= 90 && percentage > 80) {
			Grade = 'B';
		}
		else if (percentage <= 80 && percentage > 70) {
			Grade = 'C';
		}
		else if (percentage <= 70 && percentage > 60) {
			Grade = 'D';
		}
		else if (percentage <= 60 && percentage > 0) {
			Grade = 'F';
		}
		
		writer.println("Classes"); //Rewrites Classes to the file
		for (int i = 0; i < 8; i++) {
			writer.println(ClassListArray[i]);
		}
		
		writer.println("Grades"); //Rewrites Grades to the file
		for (int i = 0; i < 8; i++) {
			writer.println(ClassListArray[i]);
			if (ClassListArray[i] == choice) {
				writer.println(Grade + " " + numerator + "/" + denominator);
			}
			else {
				writer.println(ClassGradeArray[i]);
			}
		}
		
		writer.println("Attendance"); //Rewrites Attendance to the file
		for (int i = 0; i < 8; i++) {
			writer.println(ClassListArray[i]);
			writer.println(ClassAttendanceArray[i]);
		}
		
		writer.close();
		reader.close();
		
		ChoosingOptions(); //Calls next method
		
	}
	public void takeAttendance() throws IOException{
		
		String choice = "", status = "", month = "", day = ""; //Variables
		int options = 0, date = 0, dayNum = 0;
		String StudentName = StudentListArray[StudentID];
		StudentName = StudentName + ".txt";
		ValidClass = false;
		ValidInput = false;
		Boolean ValidMonth = false, ValidDay = false;
		
		PrintWriter writer = new PrintWriter(StudentName); //FileIO
		Scanner reader = new Scanner(StudentName);
		
		for (int i = 0; i < 8; i++) { //Outputs a list of classes
			System.out.println(ClassListArray[i]);
		}
	
		while (ValidClass = false) { //User chooses a class to edit
			System.out.println("\n\t Please select a class to edit (Case Sensitive)");
			choice = input.nextLine();
			
			for (int i = 0; i < 8; i++) { //Validates input
				if (choice == ClassListArray[i]) {
					ValidClass = true;
				}
			}
			if (ValidClass == false) {
				System.out.println("Class not found. Please try again.");
			}
		}
		
		while (ValidMonth == false && ValidDay == false) { //User inputs date. Checks for valid date.
			System.out.println("Please enter a date in the following format - [Jul 08]");
			month = input.next();
			day = input.next();
			
			try { //Checks if day is a number
				date = Integer.parseInt(day);
			}
			catch (Exception e) {
				System.out.println("Your input was not valid. Please try again.");
				continue;
			}
			
			switch (month) { //Checks if user entered valid month
				case "Jan": 
					dayNum = 31;
					ValidMonth == true;
					break;
				case "Feb":
					dayNum = 28;
					ValidMonth == true;
					break;
				case "Mar":
					dayNum = 31;
					ValidMonth == true;
					break;
				case "Apr":
					dayNum = 30;
					ValidMonth == true;
					break;
				case "May":
					dayNum = 31;
					ValidMonth == true;
					break;
				case "Jun":
					dayNum = 30;
					ValidMonth == true;
					break;
				case "Jul":
					dayNum = 31;
					ValidMonth == true;
					break;
				case "Aug":
					dayNum = 31;
					ValidMonth == true;
					break;
				case "Sep":
					dayNum = 30;
					ValidMonth == true;
					break;
				case "Oct":
					dayNum = 31;
					ValidMonth == true;
					break;
				case "Nov":
					dayNum = 30;
					ValidMonth == true;
					break;
				case "Dec":
					dayNum = 31;
					ValidMonth == true;
					break;
				default:
					ValidMonth == false;
					System.out.println("That is not a month. Please try again.");
					continue;
			}
			
			if (date < 0 && date > dayNum) { //checks if user entered a valid date according to the month
				System.out.println("That is not a valid date. Please try again.");
				continue;
			}
			else {
				ValidDay = true;
			}
		}
		
		while (ValidChoice == false) { //Loop that continues until user enters a valid option
			System.out.println("Please enter an integer according to the following:");
			System.out.println("\t[1] Absent\n\t[2] Tardy\n\t[3] Present");
			
			status = input.nextLine();
			try { //converts inputted string to int and checks if it throws an exception. 
				options = Integer.parseInt(status);
			}
			catch (Exception e) {
				System.out.println("Your input was not valid. Please try again.");
				continue;
			}
			
			if (options < 1 && options > 3) { //checks if user entered a valid option
				System.out.println("That is not an option. Please try again.");
			}
			else {
				ValidChoice = true
			}
		}
		
		writer.println("Classes"); //Rewrites classes section to file
		for (int i = 0; i < 8; i++) {
			writer.println(ClassListArray[i]);
		}
		
		writer.println("Grades"); //Rewrites grades section to file
		for (int i = 0; i < 8; i++) {
			writer.println(ClassListArray[i]);
			writer.println(ClassGradeArray[i]);
		}
		
		writer.println("Attendance"); //Rewrites attendance section to file
		for (int i = 0; i < 8; i++) {
			writer.println(ClassListArray[i]);
			writer.println(ClassAttendanceArray[i]);
			switch(options) {
			case 1: 
				writer.println(month + " " + day + " Absent");
				break;
			case 2:
				writer.println(month + " " + day + " Tardy");
				break;
			case 3:
				writer.println(month + " " + day + " Present");
				break;
			}
		}
		
		writer.close();
		reader.close();
		
		ChoosingOptions(); //Calls next method
		
	}
}
