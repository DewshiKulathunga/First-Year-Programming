package arrays;

import java.util.*;
import java.io.File; 
import java.io.FileWriter;   
import java.io.PrintWriter;
import java.io.IOException;  //IOException class to control errors
import java.io.FileNotFoundException;  //FileNotFoundException class to control errors 

public class Task1 {
	
	private static boolean Menu = true;
	
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	String roomName;
	int roomNum = 0;
	String[] hotel = new String[9];
	
	//for (int x = 0; x < 9; x++ ) hotel[x] = ""; //initialise
	Initialise(hotel);
	
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
						Customer_Adding(hotel);
					break;
					
					case "E":
						Empty_Rooms_Display(hotel);
					break;
						
					case "V":
						Rooms_View(hotel);
					break;
						
					case "D":
						Customer_Deleting(hotel);
					break;
						
					case "F":
						Find_Customer(hotel);
					break;
						
					case "S":
						Store_Data_To_File(hotel);
					break;
						
					case "L":
						Load_Data_From_File(hotel);
					break;
						
					case "O":
						Rooms_View_Alphabetically_ByName(hotel);
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
	private static void Initialise( String hotelRef[] ) {
	 for (int x = 1; x < 9; x++ ) hotelRef[x] = "no one";
	 System.out.println( "Initialise");
	
	}
	
	//Add customer to room
	private static void Customer_Adding(String hotel[]) {
        String roomName;
		int roomNum;
		
        Scanner input = new Scanner(System.in);

		System.out.print("Enter Room Number (1-8): ");
		roomNum = input.nextInt();
			
		if(hotel[roomNum].equals("no one")){
			System.out.print("Enter Name For Room " + (roomNum) + " : ");
			roomName = input.next();
			hotel[roomNum] = roomName.toLowerCase();
		}
		
		else{
			System.out.println("Room " + (roomNum) + " is already booked");
			System.out.println("Please pick another room");
		}
    }
	
	//Display Empty Rooms
	private static void Empty_Rooms_Display(String hotel[]) {
        for (int x = 1; x < 9; x++ )
        {
			if(hotel[x].equals("no one")){
				System.out.println("Room " + x + " is Empty");
			}
			
			else{
				System.out.println("Room " + x + " is not Empty");
			}
        }
    }
	
	//View All Rooms
	private static void Rooms_View(String hotel[]) {
        for (int x = 1; x < 9; x++ )
        {
            System.out.println("room is " + x + " occupied by " + hotel[x]);
        }
        
    }


	//Delete Customer From Room
	private static void Customer_Deleting(String hotel[]){
		int roomNum;
		
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Room Number To Delete(1 - 8): ");
        roomNum = input.nextInt();
		
        hotel[roomNum] = "no one";
        System.out.println("Record Deleted");
    }
	
	
	//Find Customer From Name
	private static void Find_Customer(String hotel[]){
		String roomName;
		int x;
		
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Name To Find Customer: ");
        roomName = input.next();
		roomName = roomName.toLowerCase();
		
		boolean Checker = false;

        for (x = 1; x < 9; x++){
            if(roomName.equals(hotel[x])){
                System.out.println("Room that holds the name entered is room: " + x );
				Checker = true;
            }
		}
		
		if (Checker == false) {
            System.out.println("There Are No Rooms Booked With That Name");
        }
	}
	
	
	//Store Program Data to File
	private static void Store_Data_To_File(String hotel[]){
		try {  
			File fileName = new File("Task1.txt");  
			
			if (fileName.createNewFile()) {  
				System.out.println("File created: " + fileName.getName());  
				System.out.println("Absolute path: " + fileName.getAbsolutePath());  
			} 
			
			else {  
				System.out.println("File already exists.");  
			} 
			
			FileWriter fileWriter = new FileWriter("Task1.txt");
			PrintWriter printWriter = new PrintWriter(fileWriter);
			int x;
				for (x = 1; x < 9; x++) {
					printWriter.print("Room Number is: " + x + "   ");
					printWriter.println("");
					printWriter.printf("Room Name is: " + hotel[x] + "   ");
					printWriter.println("");
					printWriter.println("");
					
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
	private static void Load_Data_From_File(String hotel[]){
		try {
			File fileName = new File("Task1.txt");
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
	private static void Rooms_View_Alphabetically_ByName(String hotel[]) {
		String temp;
		
		String alph_Order[] = hotel.clone();
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