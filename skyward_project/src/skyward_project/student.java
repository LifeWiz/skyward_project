package skyward_project;
import java.util.Scanner;
import java.io.*;

public class student{
static String studentname;
static File student_list = new File("all_students");
static Scanner sc = new Scanner(System.in);
int choice, total = 0;
public void signup() throws IOException  {
	Scanner list = new Scanner(student_list);
	FileWriter fw = new FileWriter(student_list,true);
	System.out.println("What is your Name: ");
	studentname = sc.next();
	while(list.hasNext()) {
		if(studentname == list.nextLine()) {
			//continue
		} 
		else {
			File file = new File(studentname);
	        if(file.createNewFile()){
	        System.out.println("You are enrolled at our school");
	        fw.write(studentname);
	        fw.close();
	        }
	        else {
	        System.out.println("You are already enrolled");
	        }
		}	
	}
}
public void classsignup() throws IOException {
	
File s = new File(studentname);
FileWriter fw = new FileWriter(s,true);
BufferedWriter bw = new BufferedWriter(fw);
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
fw.write("Classes\n\n");
while(total !=5) {
choice = sc.nextInt();
if(choice == 1) {
	bw.write("Algebra\n\n");
	choice = sc.nextInt();
}
if(choice == 2) {
	bw.write("US History\n\n");
	choice = sc.nextInt();

}
if(choice == 3) {
	bw.write("European History\n\n");
	choice = sc.nextInt();

}
if(choice == 4) {
	bw.write("Calculus\n\n");
	choice = sc.nextInt();

}
if(choice == 5) {
	bw.write("Physics\n\n");
	choice = sc.nextInt();

}
if(choice == 6) {
	bw.write("Biology\n\n");
	choice = sc.nextInt();

}
if(choice == 7) {
	bw.write("Chemistry\n\n");
	choice = sc.nextInt();

}
if(choice == 8) {
	bw.write("Advanced English 12\n\n");
	choice = sc.nextInt();

}
if(choice == 9) {
	bw.write("English 12\n\n");
	choice = sc.nextInt();

}
if(choice == 10) {
	bw.write("Mythology\n\n");
	choice = sc.nextInt();

}
if(choice == 11) {
	bw.write("American Literature\n\n");
	choice = sc.nextInt();

}
if(choice == 12) {
	bw.write("Laws and Civics\n\n");
	choice = sc.nextInt();

}
if(choice == 13) {
	bw.write("Health\n\n");
	choice = sc.nextInt();

}
if(choice == 14) {
	bw.write("Japanese\n\n");
	choice = sc.nextInt();

}
if(choice == 15) {
	bw.write("French\n\n");
	choice = sc.nextInt();

}
if(choice == 16) {
	bw.write("German\n\n");
	choice = sc.nextInt();

}
if(choice == 17) {
	bw.write("Computer Science\n\n");
	choice = sc.nextInt();

}
if(choice == 18) {
	bw.write("Internet Security\n\n");
	choice = sc.nextInt();

}
if(choice == 19) {
	bw.write("Gym\n\n");
	choice = sc.nextInt();

}
if(choice == 20) {
	bw.write("Wind Symphony\n\n");
	choice = sc.nextInt();
}
total = total + 1;
}
if(choice > 20) {
	System.out.println("Not a class");
}
bw.close();
}


}

