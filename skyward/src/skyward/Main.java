package skyward;

import java.util.Scanner;
import java.io.*;
import java.io.File;
public class Main {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		Main m = new Main();
		m.MainMethod();
		
	}
	public void MainMethod() throws IOException{
		
		student s = new student();
		teacher t = new teacher();
		Scanner input = new Scanner(System.in);
		String choice = "";
		int option = 0, runtime = 0;
		boolean validInput = false, endLoop = false;
		
		System.out.println("-=Mock Skyward Project=-");
		
		while (endLoop == false) {
			if (runtime == 0) {
				s.signup();
				runtime = runtime + 1;
			}
			else {
				validInput = false;
				while (validInput == false) {
					
					System.out.println(" [1] Student \n [2] Teacher\n [3] Quit");
					choice = input.nextLine(); 
					
						try { //converts inputted string to int and checks if it throws an exception. 
							option = Integer.parseInt(choice);
							validInput = true;
						}
						catch (Exception e) {
							System.out.println("Your input was not valid. Please try again.");
						}
				}
			
				switch (choice) {
				case "1":
					s.signup();
					break;
				case "2":
					t.chooseStudent();
					break;
				case "3":
					endLoop = true;
					break;
				}
			}
		}
	}

}