import java.util.ArrayList;
import java.util.Scanner;

public class ActivityPlanner {

    // Activity class to hold activity name and completion status
    public static class Activity{
        String name;
        boolean isCompleted;

        // Constuctor to initialize activity name with incomplete status
        public Activity(String name){
            this.name=name;
            this.isCompleted= false;
        }

        // Override method to display activity name with completion status
        @Override
        public String toString(){
            if(isCompleted){
                return name + " Completed";
            }
            else{
                return name + " Not Completed";
            }
            
        }
    }
    
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        
        // ArrayList to store activity objeccts
        ArrayList<Activity> activities = new ArrayList<>(); 
        
        // Flag for the while loop below
        boolean exit = false; 
        
        // Display welcome message
        System.out.println("\nWelcome to the Activity Planner!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Please enter a choice from the menu below:");

        // Main loop to display menu and process user choices
        while(!exit){

            //Display menu options
            System.out.println("\n///////MENU////////");
            System.out.println("\n1. Add activity");
            System.out.println("2. View activities");
            System.out.println("3. Complete an activity");
            System.out.println("4. Exit");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            
            // Initialize user choice variable
            int choice = 0;

            // Get user choice until valid Integer between 1 and 4 is entered
            while(true) {
                System.out.println("Enter your choice (1-4):");

                // Check if the next input is an integer
                if (scnr.hasNextInt()) {
                    
                    // Read the integer input
                    choice = scnr.nextInt();
                    scnr.nextLine(); // Clear the newline character

                    // Check if the input is within valid range
                    if(choice >= 1 && choice <= 4){

                        // Break the loop if valid input is received
                        break;

                    }

                    // Loop again if input is out of range
                    else{
                        System.out.println("Invalid input. Please enter a number between 1 and 4.");
                        
                        // Clear the invalid input
                        scnr.nextLine();
                        
                    
                    }
                }

                // Loop again if input is not an integer
                else{
                    System.out.println("Invalid input. Please enter a number");
                    
                    // Clear the invalid input
                    scnr.nextLine();
                    
                }
            }
    
            // Add a new activity if the user selected 1
            if (choice == 1) {
                
                // Prompt user to enter activity name
                System.out.println("\nEnter new activity:");
                
                // Read the activity name
                String activity = scnr.nextLine();
                

                // Store it in the activites list as an Activity object
                activities.add(new Activity(activity));

                // Display addition to the user
                System.out.println("\n[Activity '"+ activity+ "' is added.]");
            }

            else if (choice == 2) {

                // Display all activities with their completion status
                System.out.println("\nActivities:");
                
                // Get the size of the activities list
                int size= activities.size();

                // If no activities added yet, inform the user, and main loop again
                if(size== 0){
                    System.out.println("No activities added yet.");
                    continue;
                }

                // Loop through the activities list and display each activity
                for (int i=0; i< size; i++) {

                    // Display activity number and its details overridden toString() method
                    System.out.println((i+1)+ ". " + activities.get(i));
                }
            }

            // Mark an activity as completed if user selected 3
            else if(choice == 3){

                // Display all activities with their completion status
                System.out.println("\nActivities:");
                int size= activities.size();
                if(size == 0){
                    System.out.println("No activities added yet.\n");
                    continue;
                }
                for (int i=0; i<size; i++) {
                    System.out.println((i+1)+ ". " + activities.get(i));
                }

                // Ask user to enter activity number to mark as completed
                System.out.println("\nEnter the number of the activity to complete:");

                // Read the activity number
                int activityNum= scnr.nextInt();
                scnr.nextLine(); // Clear the newline character
                
                // Validate the activity number and main loop again if invalid
                if(activityNum <=0 || activityNum > activities.size()){
                    System.out.println("Invalid activity number.\n");
                    continue;
                }
                // Mark the selected activity as completed
                activities.get(activityNum-1).isCompleted = true;

                // Inform the user about the completion
                System.out.println("\nActivity '"+ activities.get(activityNum-1).name+"' marked as completed.");

            }

            // Exit the program if user selected 4
            else if(choice == 4){

                // Set exit flag to true to break the main loop
                exit = true;

                // Display exit message
                System.out.println("\nExiting the program. \nGoodbye!!!!!!!");

            }
            
            
        }

    // Close the scanner
    scnr.close();    
    }
    
}
