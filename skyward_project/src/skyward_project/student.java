package skyward_project;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
public class student {
static File student_list = new File("all_students.txt");
static Scanner sc = new Scanner(System.in);
private void signup() throws IOException  {
	Scanner list = new Scanner(student_list);
	
	System.out.println("What is your Name: ");
	String student = sc.next();
	while(list.hasNext()) {
		if(student == list.nextLine()) {
			//continue
		} 
		else {
			File newstudent = new File(student);
			newstudent.createNewFile();
		}	
	}
	
	
	
}


}
