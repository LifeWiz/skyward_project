package skyward_project;
import java.util.Scanner;
import java.io.*;

public class student {
static File student_list = new File("all_students");
static Scanner sc = new Scanner(System.in);
public void signup() throws IOException  {
	Scanner list = new Scanner(student_list);
	System.out.println("What is your Name: ");
	String student = sc.next();
	while(list.hasNext()) {
		if(student == list.nextLine()) {
			//continue
		} 
		else {
			File file = new File(student);
	        if(file.createNewFile()){
	        System.out.println("You are enrolled at our school");
	        }
	        else {
	        System.out.println("You are already enrolled");
	        }
		}	
	}
}
public void classsignup(String student) throws IOException {
File s = new File(student);
FileWriter fw = new FileWriter(s,true);
BufferedWriter bw = new BufferedWriter(fw);
int choice, total = 0;
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
fw.write("Classes");
while(total < 5) {
choice = sc.nextInt();
if(choice == 1) {
	bw.write("Algebra");
	total = total + 1;
}
if(choice == 2) {
	bw.write("US History");
	total = total + 1;
}
if(choice == 3) {
	bw.write("European History");
	total = total + 1;
}
if(choice == 4) {
	bw.write("Calculus");
	total = total + 1;
}
if(choice == 5) {
	bw.write("Physics");
	total = total + 1;
}
if(choice == 6) {
	bw.write("Biology");
	total = total + 1;
}
if(choice == 7) {
	bw.write("Chemistry");
	total = total + 1;
}
if(choice == 8) {
	bw.write("Advanced English 12");
	total = total + 1;
}
if(choice == 9) {
	bw.write("English 12");
	total = total + 1;
}
if(choice == 10) {
	bw.write("Mythology");
	total = total + 1;
}
if(choice == 11) {
	bw.write("American Literature");
	total = total + 1;
}
if(choice == 12) {
	bw.write("Laws and Civics");
	total = total + 1;
}
if(choice == 13) {
	bw.write("Health");
	total = total + 1;
}
if(choice == 14) {
	bw.write("Japanese");
	total = total + 1;
}
if(choice == 15) {
	bw.write("French");
	total = total + 1;
}
if(choice == 16) {
	bw.write("German");
	total = total + 1;
}
if(choice == 17) {
	bw.write("Computer Science");
	total = total + 1;
}
if(choice == 18) {
	bw.write("Internet Security");
	total = total + 1;
}
if(choice == 19) {
	bw.write("Gym");
	total = total + 1;
}
if(choice == 20) {
	bw.write("Wind Symphony");
	total = total + 1;
}

}
}


}
