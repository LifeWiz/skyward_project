import java.util.Scanner;
import java.io.*;

public class teacher {
	
	private String UserInputName = "", studentName = "";
	private String[] StudentListArray, ClassListArray = new String[8], ClassAttendanceArray = new String[8], ClassGradeArray = new String[8];
	private boolean ValidStudent, ValidChoice, ValidClass, ValidInput;
	private int StudentID, fileLength;
	Scanner input = new Scanner(System.in);
	
	public void chooseStudent() throws IOException {
		
		Scanner StudentList = new Scanner(new File("all_stundents")); //Variables and stuff
		int studentNum = 0;
		int l = 0;
		String options = "", skip, classname;
		ValidStudent = false;
		
		while (StudentList.hasNextLine()) { //Finds the number of registered students
			studentNum = studentNum + 1;
		}
		
		StudentListArray = new String[studentNum]; //Creates a student array based on number^
		
		System.out.println("-=Student List=-");
		
		while (StudentList.hasNext()) { //Enters student names into array^
			studentName = StudentList.nextLine();
			StudentListArray[l] = studentName;
			System.out.println("\t" + studentName);
			l++;
		}
		
		while (ValidStudent == false) { //User chooses student
			System.out.println("\nPlease choose a student by entering their name:");
			UserInputName = input.nextLine();
			
			for (int i = 0; i < studentNum; i++) { //Validates input
				if (UserInputName == StudentListArray[i]) {
					ValidStudent = true;
					StudentID = i;
				}
			}
		}
		
		String StudentName = StudentListArray[StudentID] + "";
		
		PrintWriter writer = new PrintWriter(StudentName);
		Scanner reader = new Scanner(StudentName);
		
		if (reader.nextLine() == "Classes") { //Outputs class list from File 
			for (int i = 0; i < 8; i++) {
				skip = reader.nextLine();
				classname = reader.nextLine();
				ClassListArray[i] = classname;
			}
		}
		if (reader.nextLine() == "Grades") { //Outputs class list from File 
			for (int i = 0; i < 8; i++) {
				skip = reader.nextLine();
				classname = reader.nextLine();
				ClassGradeArray[i] = classname;
			}
		}
		if (reader.nextLine() == "Attendance") { //Outputs class list from File 
			for (int i = 0; i < 8; i++) {
				skip = reader.nextLine();
				classname = reader.nextLine();
				ClassAttendanceArray[i] = classname;
			}
		}
		
		reader.close();
		writer.close();
		
		ChoosingOptions(); //Calls next method
	}
	
	public void ChoosingOptions() throws IOException{
		
		ValidChoice = false; //Variables
		int choice = 0;
		String options = "";
		
		Main m = new Main();
		
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
		
		String choice = "";
		String numer = "", slash = "", denom = "";
		int numerator = 0, denominator = 0;
		float percentage = 0;
		char Grade = ' ';
		String StudentName = StudentListArray[StudentID];
		StudentName = StudentName + ".txt";
		ValidClass = false;
		ValidInput = false;
		
		PrintWriter writer = new PrintWriter(StudentName);
		Scanner reader = new Scanner(StudentName);
		
		for (int i = 0; i < 8; i++) {
			System.out.println(ClassListArray[i]);
		}
	
		while (ValidClass = false) { //User chooses a class to edit
			System.out.println("\n\t Please select a class to edit");
			choice = input.nextLine();
			
			for (int i = 0; i < 8; i++) { //Validates input
				if (choice == ClassListArray[i]) {
					ValidClass = true;
				}
			}
		}
		
		System.out.println("Please enter the student's class grade as a fraction [X / Y]");
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
		
		writer.println("Classes");
		for (int i = 0; i < 8; i++) {
			writer.println(ClassListArray[i]);
		}
		
		writer.println("Grades");
		for (int i = 0; i < 8; i++) {
			writer.println(ClassListArray[i]);
			if (ClassListArray[i] == choice) {
				writer.println(Grade + " " + numerator + "/" + denominator);
			}
			else {
				writer.println(ClassGradeArray[i]);
			}
		}
		
		writer.println("Attendance");
		for (int i = 0; i < 8; i++) {
			writer.println(ClassListArray[i]);
			writer.println(ClassAttendanceArray[i]);
		}
		
		writer.close();
		reader.close();
		
		ChoosingOptions(); //Calls next method
		
	}
	public void takeAttendance() throws IOException{
		
		String choice = "", status = "";
		int options = 0;
		String StudentName = StudentListArray[StudentID];
		StudentName = StudentName + ".txt";
		ValidClass = false;
		ValidInput = false;
		
		PrintWriter writer = new PrintWriter(StudentName);
		Scanner reader = new Scanner(StudentName);
		
		for (int i = 0; i < 8; i++) {
			System.out.println(ClassListArray[i]);
		}
	
		while (ValidClass = false) { //User chooses a class to edit
			System.out.println("\n\t Please select a class to edit");
			choice = input.nextLine();
			
			for (int i = 0; i < 8; i++) { //Validates input
				if (choice == ClassListArray[i]) {
					ValidClass = true;
				}
			}
		}
		
		while (ValidChoice == false) { //Loop that continues until user enters a valid option
			System.out.println("Please enter an integer according to the following:");
			System.out.println("\t[1] Absent\n\t[2] Tardy\n\t[3] Present");
			
			status = input.nextLine();
			try { //converts inputted string to int and checks if it throws an exception. 
				options = Integer.parseInt(status);
				ValidChoice = true;
			}
			catch (Exception e) {
				System.out.println("Your input was not valid. Please try again.");
			}
		}
		
		writer.println("Classes");
		for (int i = 0; i < 8; i++) {
			writer.println(ClassListArray[i]);
		}
		
		writer.println("Grades");
		for (int i = 0; i < 8; i++) {
			writer.println(ClassListArray[i]);
			writer.println(ClassGradeArray[i]);
		}
		
		writer.println("Attendance");
		for (int i = 0; i < 8; i++) {
			writer.println(ClassListArray[i]);
			if (ClassListArray[i] == choice) {
				switch(options) {
				case 1: 
					writer.println("Absent");
					break;
				case 2:
					writer.println("Tardy");
					break;
				case 3:
					writer.println("Present");
					break;
				}
			}
			else {
			writer.println(ClassAttendanceArray[i]);
			}
		}
		
		writer.close();
		reader.close();
		
		ChoosingOptions(); //Calls next method
		
	}
}
