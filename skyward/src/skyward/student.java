package skyward;

import java.util.Scanner;
import java.io.*;

public class student{
static String studentname;
static String studentnamefile;
static File student_list = new File("all_students.txt");
static Scanner sc = new Scanner(System.in);
int choice, total = 0;
String [] classlist = new String [8]; 
static boolean checkname = false;
public void signup() throws IOException  {
	//Signup for classes 
	Scanner list = new Scanner(student_list);
	FileWriter fw = new FileWriter(student_list,true);
	BufferedWriter bw = new BufferedWriter(fw);
	System.out.println("What is your First Name: ");
	studentname = sc.next();
	BufferedReader reader;
	try {
		reader = new BufferedReader(new FileReader(student_list)); //creates object for studentlist(our student database)
		String line = reader.readLine();
		while (line != null) {
			if(line.equals(studentname)){ //Checks if student is in the file
				checkname = true;
				break;
			}
			else{
			line = reader.readLine();
		}
		}
		reader.close();
		} catch (IOException e) {
		e.printStackTrace();
	}
	if(checkname == false){
		studentnamefile = studentname +".txt";
		File file = new File(studentnamefile);
		file.createNewFile();
	    System.out.println("You are enrolled at our school");
	    bw.newLine();
	    bw.write(studentname);
	    bw.newLine();
	    classsignup();
		}
else{
	askuser();
}
    bw.close();
	}
public void classsignup() throws IOException {
//which classs you want to signup for
File s = new File(studentnamefile);
FileOutputStream fw = new FileOutputStream(s);

BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fw));
//FileWriter fw = new FileWriter(s,true);
//BufferedWriter bw = new BufferedWriter(fw);
System.out.println("What Clases would you like to signup for: ");
System.out.println("1: Economics");
System.out.println("2: US History");
System.out.println("3: European History");
System.out.println("4: Calculus");
System.out.println("5: Physics");
System.out.println("6: Biology");
System.out.println("7: Chemistry");
System.out.println("8: Advanced English 12");
System.out.println("9: English 12");
System.out.println("10: Mythology");
System.out.println("11: American Literature");
System.out.println("12: Laws and Civics");
System.out.println("13: Health");
System.out.println("14: Japanese");
System.out.println("15: French");
System.out.println("16: German");
System.out.println("17: Computer Science");
System.out.println("18: Internet Security");
System.out.println("19: Gym");
System.out.println("20: Wind Symphony");
bw.write("Classes\n");
bw.newLine();
for(int value = 0; value <8; value++) {
choice = sc.nextInt();
switch(choice) {
case 1: //chose your class and its written to the array and written to your file
	bw.write("Economics");
	bw.newLine();
	classlist[value] = "Economics";
	break;
case 2:
	bw.write("European History");
	bw.newLine();
	classlist[value] = "European History";
	break;
case 3:
	bw.write("US History");
	bw.newLine();
	classlist[value] = "US History";
	break;
case 4:
	bw.write("Calculus");
	bw.newLine();
	classlist[value] = "Calculus";
	break;
case 5:
	bw.write("Physics");
	bw.newLine();
	classlist[value] = "Physics";
	break;

case 6: 
	bw.write("Biology");
	bw.newLine();
	classlist[value] = "Biology";
	break;

case 7:
	bw.write("Chemistry\n\n");
	bw.newLine();
	classlist[value] = "Chemistry";
	break;

case 8:
	bw.write("Advanced English 12");
	bw.newLine();
	classlist[value] = "Advanced English 12";
	break;

case 9:
	bw.write("English 12");
	bw.newLine();
	classlist[value] = "English 12";
	break;

case 10:
	bw.write("Mythology");
	bw.newLine();
	classlist[value] = "Mythology";
	break;

case 11:
	bw.write("American Literature");
	bw.newLine();
	classlist[value] = "American Literature";
	break;

case 12:
	bw.write("Laws and Civics");
	bw.newLine();
	classlist[value] = "Laws and Civics";
	break;
case 13:
	bw.write("Health");
	bw.newLine();
	classlist[value] = "Health";
	break;

case 14:
	bw.write("Japanese");
	bw.newLine();
	classlist[value] = "Japanese";
	break;

case 15:
	bw.write("French");
	bw.newLine();
	classlist[value] = "French";
	break;
case 16:
	bw.write("German");
	bw.newLine();
	classlist[value] = "German";
	break;
case 17:
	bw.write("Computer Science");
	bw.newLine();
	classlist[value] = "Computer Science";

	break;
case 18:
	bw.write("Internet Security");
	bw.newLine();
	classlist[value] = "Internet Security";
	break;

case 19:
	bw.write("Gym");
	bw.newLine();
	classlist[value] = "Gym";
	break;
case 20:
	bw.write("Wind Symphony");
	bw.newLine();
	classlist[value] = "Wind Symphony";
	break;
default:
	System.out.println("Not a class");
	break;
}
}
bw.newLine();
bw.write("Grades");
bw.newLine();
for(int value = 0; value <8; value++){
	bw.newLine();
	bw.write(classlist[value]);
	bw.newLine();
}
bw.newLine();
bw.write("Attendance");
bw.newLine();
for(int value = 0; value <8; value++){
	bw.newLine();
	bw.write(classlist[value]);
	bw.newLine();
}
bw.close();
}
public void viewattendence() throws IOException {
	studentnamefile = studentname +".txt";
	File s = new File(studentnamefile);
	FileInputStream fis = new FileInputStream(studentnamefile);
	BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	Scanner list = new Scanner(s);
	String [] attendance = new String [364];
	int attendanceline = 0;
	boolean checkatten = true;
	while(list.hasNext()){ // reads from file and prints to monitor your attendance for each class together
		String list1 = list.nextLine();
		if(list1.equals("Attendance")) {
			while(list.hasNext()){
			attendance[attendanceline] = list.nextLine();
			System.out.println(attendance[attendanceline]);
			attendanceline = attendanceline + 1;
			}
	}
	}

}

public void viewgrades() throws IOException {
	studentnamefile = studentname.trim() + ".txt";
	File s = new File(studentnamefile);
	Scanner list = new Scanner(s);
	FileInputStream fis = new FileInputStream(studentnamefile);
	BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	String [] grades = new String [1000000];
	int gradeline = 0;
	boolean check = true;
	boolean check2 = true;
	while(list.hasNext()){
	String list1 = list.nextLine();
	if(list1.equals("Grades")) { // Prints your grade that we have on file from the teacher
	while(check == true) {
		grades[gradeline] = list.nextLine();
		System.out.println(grades[gradeline]);
		gradeline = gradeline + 1;
		if(br.readLine().equals("Attendance")) {
			check = false;
			break;
		}
		}
	}
	if(br.readLine().equals("Attendance")) {
		check = false;
		break;
	}
	}
	}

	



public void askuser() throws IOException {
	Main menu = new Main();
	System.out.println("As a Student would you like:");
	System.out.println("1: View Grades\n2: View Attendance\n3: Go Back to Main menu");
	int userchoice = sc.nextInt();
	switch(userchoice) {
	case 1:
		viewgrades();
		break;
	case 2:
		viewattendence();
		break;
	case 3:
		menu.MainMethod();
		break;
	}
}


}
