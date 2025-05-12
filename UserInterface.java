import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class UserInterface {

    public static void main(String[]args){
    Scanner sc = new Scanner(System.in);
    int choice;
    String source, target, country, hemisphere, season, localTime;


        do { 
            System.out.println("=== World Time & Season App ===");
            System.out.println("1. Convert Time");
            System.out.println("2. Determine Current Season");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice)
            {
                case 1:
                    System.out.print("\nEnter source country: ");
                    source = sc.nextLine();
                    System.out.print("Enter target country: ");
                    target = sc.nextLine();
                    System.out.print("Enter local time (HH:mm): ");
                    localTime = sc.nextLine();

                    try {
                        ZonedDateTime convertedTime = TimeConverter.convertTime(source, target, localTime);
                        System.out.println("Converted time in " + target + ": " + convertedTime.toLocalTime());
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    System.out.println("");
                    break;

                // case 2:
                // try{
                //     System.out.print("\nEnter country: ");
                //     country = sc.nextLine();

                //     System.out.println("Current date: " + today);

                //     System.out.println(country + " is in the " + hemisphere + " Hemisphere.");
                    
                //     System.out.println("Current season in " + country + ": " + season);
                // } catch (Exception e){
                //     System.out.println("Error " + e.getMessage());
                // }
                // break;

                case 3:
                System.out.println("Goodbye!");
                break;

                default:
                    System.out.println("Invalid choice. Please enter integer between 1 to 3.");
            }
        
        } while(choice !=3);
        sc.close();
    }
}

