package skyward_project;
import java.util.Scanner;
import java.io.*;

public class student{
static String studentname;
static File student_list = new File("all_students.txt");
static Scanner sc = new Scanner(System.in);
int choice, total = 0;
public void signup() throws IOException  {
	Scanner list = new Scanner(student_list);
	FileWriter fw = new FileWriter(student_list,true);
	System.out.println("What is your First Name: ");
	studentname = sc.next();
	studentname = studentname +".txt";

	while(list.hasNext()) {
		if(studentname == list.nextLine()) {
			askuser();
			} 
		else {
			File file = new File(studentname);
	        if(file.createNewFile()){
	        System.out.println("You are enrolled at our school");
	    	studentname = studentname.replace(".txt", "");
	        fw.write(studentname);
	        classsignup();
	        fw.close();
	        }
	        else {
	        System.out.println("You are already enrolled");
			askuser();
	        }
		}	
	}
}
public void classsignup() throws IOException {
studentname = studentname + ".txt";
File s = new File(studentname);
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
case 1: 
	bw.write("Economics");
	bw.newLine();
	break;
case 2:
	bw.write("European History");
	bw.newLine();
	break;
case 3:
	bw.write("US History");
	bw.newLine();
	break;
case 4:
	bw.write("Calculus");
	bw.newLine();
	break;
case 5:
	bw.write("Physics");
	bw.newLine();
	break;

case 6: 
	bw.write("Biology");
	bw.newLine();
	break;

case 7:
	bw.write("Chemistry\n\n");
	bw.newLine();
	break;

case 8:
	bw.write("Advanced English 12");
	bw.newLine();
	break;

case 9:
	bw.write("English 12");
	bw.newLine();
	break;

case 10:
	bw.write("Mythology");
	bw.newLine();
	break;

case 11:
	bw.write("American Literature");
	bw.newLine();
	break;

case 12:
	bw.write("Laws and Civics");
	bw.newLine();
	break;
case 13:
	bw.write("Health");
	bw.newLine();
	break;

case 14:
	bw.write("Japanese");
	bw.newLine();
	break;

case 15:
	bw.write("French");
	bw.newLine();

	break;
case 16:
	bw.write("German");
	bw.newLine();
	break;
case 17:
	bw.write("Computer Science");
	bw.newLine();
	break;
case 18:
	bw.write("Internet Security\n\n");
	bw.newLine();
	break;

case 19:
	bw.write("Gym\n\n");
	bw.newLine();
	break;

case 20:
	bw.write("Wind Symphony\n\n");
	bw.newLine();
	break;

default:
	System.out.println("Not a class");
	break;
}
}
bw.close();
}
public void viewattendence() throws IOException {
	File s = new File(studentname);
	Scanner list = new Scanner(s);
	String [] attendance = new String [364];
	int attendanceline = 0;
	if(s.length() == 0) {
System.out.println("Your Teacher hasnt entered anything");
	}
	else {
if("Attendance" == list.nextLine()) {
	while(list.hasNext()) {
		attendance[attendanceline] = list.nextLine();
		System.out.println(attendance[attendanceline]);
		attendanceline = attendanceline + 1;
			}
		}
	}
}
public void viewgrades() throws IOException {
	File s = new File(studentname);
	Scanner list = new Scanner(s);
	String [] grades = new String [1000000];
	int gradeline = 0;
	boolean check = true;
	if(s.length() == 0) {
System.out.println("Your Teacher hasnt entered anything");
	}
	else {
if("Grades" == list.nextLine()) {
	while(check == true) {
		grades[gradeline] = list.nextLine();
		System.out.println(grades[gradeline]);
		gradeline = gradeline + 1;
		if(list.nextLine() == "Attendance") {
			check = false;
		}
	}
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

