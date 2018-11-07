package skyward;
import java.util.Scanner;
import java.io.*;
public class teacher {
	
	private String UserInputName = "", studentName = "";
	private String[] StudentListArray, ClassListArray = new String[8], ClassAttendanceArray = new String[8], ClassGradeArray = new String[8];
	private boolean ValidStudent, ValidChoice, ValidClass, ValidInput;
	private int StudentID, fileLength;
	Scanner input = new Scanner(System.in);
	student s = new student();
	public void chooseStudent() throws IOException {
		
		Scanner StudentList = new Scanner(new File("all_students.txt")); //Variables and stuff
		FileInputStream fis = new FileInputStream("all_students.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		int studentNum = 0;
		int l = 0;
		String options = "", skip, classname;
		ValidStudent = false;
		String line = br.readLine();
		while (line != null) { //Finds the number of registered students
			studentNum = studentNum + 1;
			line = br.readLine(); 
		}
		
		StudentListArray = new String[studentNum]; //Creates a student array based on number^
		
		System.out.println("-=Student List=-");
		
		while (StudentList.hasNext()) { //Enters student names into array^
			studentName = StudentList.nextLine();
			StudentListArray[l] = studentName;
			System.out.println("\t" + studentName);
			l++;
		}
		
			//User chooses student
			System.out.println("\nPlease choose a student by entering their name:");
			UserInputName = input.nextLine();
			System.out.println(UserInputName);
			for (int i = 0; i < studentNum; i++) { //Validates input
				if (StudentListArray[i] == UserInputName) {
					StudentID = i;
				}
			}
		
		String StudentName = StudentListArray[StudentID] + "";
		
		PrintWriter writer = new PrintWriter(UserInputName);
		UserInputName = UserInputName +".txt";
		Scanner reader = new Scanner(UserInputName);
		Scanner Student = new Scanner(new File(UserInputName));
		
		while(reader.hasNext()){
			String list2 = reader.nextLine();
			if(list2.equals("Classes")){
				String skip1 = reader.nextLine();
			for (int i = 0; i < 8; i++) {
				classname = reader.nextLine();
				skip1 = reader.nextLine();
				ClassListArray[i] = classname;
			System.out.println(ClassListArray[i]);
			}
		}
		}

				
		if (Student.nextLine().equals("Grades")) { //Outputs class list from File 
			skip = reader.nextLine();
			for (int i = 0; i < 8; i++) {
				skip = reader.nextLine();
				classname = reader.nextLine();
				System.out.println(classname);

				ClassGradeArray[i] = classname;
			}
		}
			int attendencespot = 0;
		while(reader.hasNext()){
		String list1 = reader.nextLine();
		if(list1.equals("Attendance")) { //Outputs class list from File
			while(reader.hasNext()){
				skip = reader.nextLine();
				ClassAttendanceArray[attendencespot] = br.readLine();
				System.out.println(ClassAttendanceArray[attendencespot]);
				attendencespot = attendencespot + 1;
			}
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
		String percent = "";
		int perc = 0;
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
		
		while (ValidInput == false) { //Loop that continues until user enters a valid option
			System.out.println("Please enter the student's class grade as a integer percentage");
			percent = input.next();
			
			try { //converts inputted string to int and checks if it throws an exception. 
				per = Integer.parseInt(percent);
				Validinput = true;
			}
			catch (Exception e) {
				System.out.println("Your input was not valid. Please try again.");
			}
		}
		
		percentage = per;
		
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
				writer.println(Grade + " " + percentage);
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
					ValidMonth = true;
					break;
				case "Feb":
					dayNum = 28;
					ValidMonth = true;
					break;
				case "Mar":
					dayNum = 31;
					ValidMonth = true;
					break;
				case "Apr":
					dayNum = 30;
					ValidMonth = true;
					break;
				case "May":
					dayNum = 31;
					ValidMonth = true;
					break;
				case "Jun":
					dayNum = 30;
					ValidMonth = true;
					break;
				case "Jul":
					dayNum = 31;
					ValidMonth = true;
					break;
				case "Aug":
					dayNum = 31;
					ValidMonth = true;
					break;
				case "Sep":
					dayNum = 30;
					ValidMonth = true;
					break;
				case "Oct":
					dayNum = 31;
					ValidMonth = true;
					break;
				case "Nov":
					dayNum = 30;
					ValidMonth = true;
					break;
				case "Dec":
					dayNum = 31;
					ValidMonth = true;
					break;
				default:
					ValidMonth = false;
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
				ValidChoice = true;
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
				writer.print(month + " " + day + " Absent**");
				break;
			case 2:
				writer.print(month + " " + day + " Tardy**");
				break;
			case 3:
				writer.print(month + " " + day + " Present**");
				break;
			}
		}
		
		writer.close();
		reader.close();
		
		ChoosingOptions(); //Calls next method
		
	}
}
