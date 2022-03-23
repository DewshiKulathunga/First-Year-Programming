package arrays;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;   
import java.io.PrintWriter;
import java.io.IOException;  //IOException class to control errors
import java.io.FileNotFoundException;  //FileNotFoundException class to control errors 

public class Task2 {
    private static boolean Menu = true;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String roomName;
        int roomNum = 0;

        hotel hotelManage = new hotel();

        //for (int x = 0; x < 9; x++ ) hotel[x] = ""; //initialise
        hotelManage.Initialise();

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
                    hotelManage.Customer_Adding();
                    break;

                case "E":
                    hotelManage.Empty_Rooms_Display();
                    break;

                case "V":
                    hotelManage.Rooms_view();
                    break;

                case "D":
                    hotelManage.Customer_Deleting();
                    break;

                case "F":
                    hotelManage.Find_Customer();
                    break;

                case "S":
                    hotelManage.Store_Data_To_File();
                    break;

                case "L":
                    hotelManage.Load_Data_From_File();
                    break;

                case "O":
                    hotelManage.Rooms_View_Alphabetically_ByName();
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


	public static class hotel {

        private static final Room_Task2[] roomObj = new Room_Task2[9];

        //Initialise
        public void Initialise() {
            for (int x = 0; x < roomObj.length - 1; x++) {
                roomObj [x] = new Room_Task2(x + 1, "no one");
            }
        }

		//Add customer to room
        public void Customer_Adding() {

            Scanner input = new Scanner(System.in);

            System.out.print("Enter Room Number (1-8): ");
            int noOfRooms = input.nextInt();
            int numberOfRooms = noOfRooms - 1;

            if(roomObj[numberOfRooms].roomName.equals("no one")){
                System.out.print("Enter Name For Room " + (noOfRooms) + " : ");
                String customerName = input.next();
                roomObj[numberOfRooms].roomName = customerName.toLowerCase();
            }

            else{
                System.out.println("Room " + (noOfRooms) + " is already booked");
                System.out.println("Please pick another room");
            }
        }

        //Display Empty Rooms
        public void Empty_Rooms_Display() {
            for (int x = 0; x < roomObj.length - 1; x++)
            {
                if(roomObj[x].roomName.equals("no one")){
                    System.out.println("Room " + (x + 1) + " is Empty");
                }

                else{
                    System.out.println("Room " + (x + 1) + " is not Empty");
                }
            }
        }
		
        //View All Rooms
        public void Rooms_view() {
            for (int x = 0; x < roomObj.length - 1; x++ )
            {
                System.out.println("room " + roomObj[x].roomNum + " occupied by " + roomObj[x].roomName);
            }

        }

        //Delete Customer From Room
        public void Customer_Deleting(){

            Scanner input = new Scanner(System.in);
            System.out.print("Enter Room Number To Delete(1 - 8): ");
            int numberOfRooms = input.nextInt();
            int noOfRooms = numberOfRooms - 1 ;

            roomObj[noOfRooms].roomName = "no one";
            System.out.println("Record Deleted");
        }

        //Find Customer From Name
        public void Find_Customer() {

            Scanner input = new Scanner(System.in);
            System.out.print("Enter Name To Find Customer: ");
            String customerName = input.next();
            customerName = customerName.toLowerCase();

            boolean Checker = false;

            for (int x = 0; x < roomObj.length - 1; x++) {
                if (customerName.equals(roomObj[x].roomName)) {
                    System.out.println("The Room That Matches That name is Room number " + (x + 1));
                    Checker = true;
                }

                if (Checker == false) {
                    System.out.println("There Are No Rooms Booked With That Name");
                }
            }
        }

        //Store Program Data to File
        public void Store_Data_To_File(){
            try {
                File fileName = new File("Task2.txt");

                if (fileName.createNewFile()) {
                    System.out.println("File created: " + fileName.getName());
                    System.out.println("Absolute path: " + fileName.getAbsolutePath());
                }

                else {
                    System.out.println("File already exists.");
                }

                FileWriter fileWriter = new FileWriter("Task2.txt");
                PrintWriter printWriter = new PrintWriter(fileWriter);

                for (int x = 0; x < roomObj.length - 1; x++) {
                    printWriter.print("Room Number is: " + (x + 1));
                    printWriter.println(" ");
                    printWriter.printf("Room Name is: " + roomObj[x].roomName);
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
        public void Load_Data_From_File(){
            try {
                File fileName = new File("Task2.txt");
                Scanner fileReader = new Scanner(fileName);

                while (fileReader.hasNextLine()) {
                    String data = fileReader.nextLine();
                    System.out.println(data);
                }

                fileReader.close();

            }

            catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        //View guests Ordered alphabetically by name
        public void Rooms_View_Alphabetically_ByName() {
            Room_Task2[] alph_Order = roomObj.clone();

            Room_Task2 temp;

            for (int i = 0; i < alph_Order.length - 1; i++) {

                for (int j = i + 1; j < alph_Order.length - 1; j++) {

                    if ((alph_Order[i].roomName).compareTo(alph_Order[j].roomName)>0) {
                        temp = alph_Order[i];
                        alph_Order[i] = alph_Order[j];
                        alph_Order[j] = temp;
                    }
                }
            }

            System.out.println("View Guests Alphabetically by Name");

            for (int i = 0; i < alph_Order.length - 1; i++) {
                System.out.println(alph_Order[i].roomName);
            }

        }
    }
	
	public static class Room_Task2 {
		public Integer roomNum;
		public String roomName;

	public Room_Task2(int roomNum, String roomName){
		this.roomNum = roomNum;
		this.roomName = roomName;
	}
	}
	
}