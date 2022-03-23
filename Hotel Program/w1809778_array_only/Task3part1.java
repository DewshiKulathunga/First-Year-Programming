package arrays;

import java.util.*;
import java.io.File; 
import java.io.FileWriter;   
import java.io.PrintWriter;
import java.io.IOException;  //IOException class to control errors
import java.io.FileNotFoundException;  //FileNotFoundException class to control errors 

public class Task3part1 {
	
	private static boolean Menu = true;
	
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	int roomNum = 0;
	String[] firstName = new String[9];
	String[] secondName = new String[9];
	int[] numOfGuests = new int[9];
	long[] creditCardNum = new long[9];
	
	//for (int x = 0; x < 9; x++ ) hotel[x] = ""; //initialise
	Initialise(firstName, secondName);
	
	Menu = true;
	
		while (Menu) {	
			System.out.println("");
			System.out.println("");
			System.out.println("-----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*");
			System.out.println("Please select one of the options.");
			System.out.println("-----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*");
			System.out.println("");
			System.out.println("");
			System.out.println("-----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*");
			System.out.println("A: Add customer to Room.");
			System.out.println("-----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*");
			System.out.println("V: View all Rooms.");
			System.out.println("-----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*");
			System.out.println("E: Display Empty Rooms.");
            System.out.println("-----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*");
			System.out.println("D: Delete customer from Room.");
            System.out.println("-----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*");
			System.out.println("F: Find room from customer name.");
            System.out.println("-----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*");
			System.out.println("S: Store program data into a file.");
            System.out.println("-----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*");
			System.out.println("L: Load program data from file.");
            System.out.println("-----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*");
			System.out.println("O: View guests Ordered alphabetically by name");
            System.out.println("-----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*");
			System.out.println("");
			System.out.println("Thank You!");
			System.out.println("-----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*");
			System.out.println("");
			System.out.println("");
			System.out.print("Please pick the option you want: ");
					
			String Selection = input.next();
			Selection = Selection.toUpperCase();
			System.out.println("");
			System.out.println("");
			System.out.println("-----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*");
			System.out.println("");
			System.out.println("");
					
					switch (Selection) {
						
						case "A":
							Customer_Adding(firstName, secondName, numOfGuests, creditCardNum);
						break;
						
						case "E":
							Empty_Rooms_Display(firstName, secondName);
						break;
						
						case "V":
							Rooms_view(firstName, secondName);
						break;
						
						case "D":
							Customer_Deleting(firstName, secondName, numOfGuests, creditCardNum);
						break;
						
						case "F":
							Find_Customer(firstName, secondName);
						break;
						
						case "S":
							Store_Data_To_File(firstName, secondName, numOfGuests, creditCardNum);
						break;
						
						case "L":
							Load_Data_From_File();
						break;
						
						case "O":
							Rooms_view_alphabetically_byName(firstName);
						break;
				
						default:
							System.out.println("Invalid Selection");
						break;
					}
					
					System.out.println("");
					System.out.println("");
					System.out.println("-----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*");
					System.out.println("Do you want to pick another Option\n1 : Yes\n2 : No");
					System.out.println("-----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*");
					System.out.println("");
					System.out.println("");
					System.out.print("Please pick the option you want: ");		
					
					if (input.nextInt() == 1) {
					System.out.println("");
					System.out.println("");
					System.out.println("-----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*");
					System.out.println("");
					System.out.println("");
					Menu = true;
					} 
					
					else {
						Menu = false;
						System.out.println("");
						System.out.println("");
						System.out.println("-----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*");
						System.out.println("Thank You for Choosing Our Hotel");		
						System.out.println("Please Come Again");
						System.out.println("-----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*----*");
					}
					
		
		}
	
	}
	
	//Initialise
	private static void Initialise(String[] firstName, String[] secondName) {
	 for (int x = 1; x < 9; x++ ) {
		 firstName[x] = "no";
		 secondName[x] = "one";
	 }
	 System.out.println( "Initialise");
	
	}
	
	//Add customer to room
	private static void Customer_Adding(String[] firstName, String[] secondName, int[] numOfGuests, long[] creditCardNum) {
		int roomNum;
		
        Scanner input = new Scanner(System.in);

		System.out.print("Enter Room Number (1-8): ");
		roomNum = input.nextInt();
			
		if(firstName[roomNum].equals("no") && secondName[roomNum].equals("one")){
			System.out.print("Enter First Name For Room " + (roomNum) + " : ");
			String customerFirstName = input.next();
			firstName[roomNum] = customerFirstName.toLowerCase();
			
			System.out.print("Enter Second Name For Room " + (roomNum) + " : ");
			String customerSecondName = input.next();
			secondName[roomNum] = customerSecondName.toLowerCase();
			
			System.out.print("Enter Number of Guests For Room " + (roomNum) + " : ");
			int guests = input.nextInt();
			numOfGuests[roomNum] = guests;
			
			System.out.print("Enter Credit Card Number For Room " + (roomNum) + " : ");
			long creditCard = input.nextLong();
			creditCardNum[roomNum] = creditCard;
		}
		
		else{
			System.out.println("Room " + (roomNum) + " is already booked");
			System.out.println("Please pick another room");
		}
    }
	
	//Display Empty Rooms
	private static void Empty_Rooms_Display(String[] firstName, String[] secondName) {
        for (int x = 1; x < 9; x++ )
        {
			if(firstName[x].equals("no") && secondName[x].equals("one")){
				System.out.println("Room " + x + " is Empty");
			}
			
			else{
				System.out.println("Room " + x + " is not Empty");
			}
        }
    }
	
	//View All Rooms
	private static void Rooms_view(String[] firstName, String[] secondName) {
        for (int x = 1; x < 9; x++ )
        {
            System.out.println("room is " + x + " occupied by " + firstName[x] + " " + secondName[x]);
        }
        
    }


	//Delete Customer From Room
	private static void Customer_Deleting(String[] firstName, String[] secondName, int[] numOfGuests, long[] creditCardNum){
		int roomNum;
		
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Room Number To Delete(1 - 8): ");
        roomNum = input.nextInt();
		
        firstName[roomNum] = "no";
		secondName[roomNum] = "no";
		numOfGuests[roomNum] = 0;
		creditCardNum[roomNum] = 0;
		
        System.out.println("Record Deleted");
    }
	
	
	//Find Customer From Name
	private static void Find_Customer(String[] firstName, String[] secondName){
		int x;
		
        Scanner input = new Scanner(System.in);
        System.out.print("Enter First Name To Find Customer: ");
        String customerFirstName = input.next();
		customerFirstName = customerFirstName.toLowerCase();
		
		System.out.print("Enter Second Name To Find Customer: ");
        String customerSecondName = input.next();
		customerSecondName = customerSecondName.toLowerCase();
		
		boolean Checker = false;

        for (x = 1; x < 9; x++){
            if(customerFirstName.equals(firstName[x]) && customerSecondName.equals(secondName[x])){
                System.out.println("Room that holds the name entered is room: " + x );
				Checker = true;
            }
		}
		
		if (Checker == false) {
            System.out.println("There Are No Rooms Booked With That Name");
        }
	}
	
	
	//Store Program Data to File
	private static void Store_Data_To_File(String[] firstName, String[] secondName, int[] numOfGuests, long[] creditCardNum){
		try {  
			File fileName = new File("Task3part1.txt");  
			
			if (fileName.createNewFile()) {  
				System.out.println("File created: " + fileName.getName());  
				System.out.println("Absolute path: " + fileName.getAbsolutePath());  
			} 
			
			else {  
				System.out.println("File already exists.");  
			} 
			
			FileWriter fileWriter = new FileWriter("Task3part1.txt");
			PrintWriter printWriter = new PrintWriter(fileWriter);
			int x;
				for (x = 1; x < 9; x++) {
					printWriter.print("Room Number is: " + x);
                    printWriter.println(" ");
                    printWriter.printf("Customer First Name for Room " + (x + 1) + " is : " + firstName[x]);
                    printWriter.println(" ");
					printWriter.printf("Customer Second Name for Room " + (x + 1) + " is : " + secondName[x]);
                    printWriter.println(" ");
					printWriter.printf("Number of Guests for Room " + (x + 1) + " is : " + numOfGuests[x]);
                    printWriter.println(" ");
					printWriter.printf("Customer Credit Card Number for Room " + (x + 1) + " is : " + creditCardNum[x]);
                    printWriter.println(" ");
                    printWriter.println(" ");
					
				}
				
				printWriter.close();
				System.out.println("All recorded saved.");
			
		} 
		
		catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();  
		} 
	}
	
	
	//Load Program Data From File
	private static void Load_Data_From_File(){
		try {
			File fileName = new File("Task3part1.txt");
			Scanner fileReader = new Scanner(fileName);
				
			while (fileReader.hasNextLine()) {
				String records = fileReader.nextLine();
				System.out.println(records);
			}
			
			fileReader.close();
	  
		} 
		
		catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	
	//View guests Ordered alphabetically by name
	private static void Rooms_view_alphabetically_byName(String[] firstName) {
		String temp;
		
		String alph_Order[] = firstName.clone();
		for (int i = 1; i < alph_Order.length - 1; i++) {
			
            for (int j = i + 1; j < alph_Order.length; j++) { 
			
                if (alph_Order[i].compareTo(alph_Order[j])>0) {
                    temp = alph_Order[i];
                    alph_Order[i] = alph_Order[j];
                    alph_Order[j] = temp;
                }
            }
        }

        System.out.println("View Guests Alphabetically by Name");
			
		for (int i = 1; i < 9; i++) {
			System.out.println(alph_Order[i]);
        }
		
    }
}		