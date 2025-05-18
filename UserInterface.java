// timeZoneID https://docs.oracle.com/cd/E84527_01/wcs/tag-ref/MISC/TimeZones.html
//https://www.youtube.com/watch?v=FlMZhN9vzSI  Input Validation for Integer only

import java.time.*; // imports classes for handling dates, times and time zones
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    public static ZoneId getCountry(String country) 
    {
        String lowerCase = country.toLowerCase(); // Convert Country to LowerCase to ensure case insensitive like China, CHINA and china

        //ZoneId.of(Continent/City) Continent: Asia, Europe, America, Australia and Africa
        if (lowerCase.equals("china")){
            return ZoneId.of("Asia/Shanghai"); //return timeZone of Asia ShangHai
        } else if (lowerCase.equals("taiwan")) {
            return ZoneId.of("Asia/Taipei");
        } else if (lowerCase.equals("korea")) {
            return ZoneId.of("Asia/Seoul");
        } else if (lowerCase.equals("pakistan")) {
            return ZoneId.of("Asia/Karachi");
        } else if (lowerCase.equals("japan")) {
            return ZoneId.of("Asia/Tokyo");
        } else if (lowerCase.equals("spain")) {
            return ZoneId.of("Europe/Madrid");
        } else if (lowerCase.equals("russia")) {
            return ZoneId.of("Europe/Moscow");
        } else if (lowerCase.equals("france")) {
            return ZoneId.of("Europe/Paris");
        } else if (lowerCase.equals("germany")) {
            return ZoneId.of("Europe/Berlin");
        } else if (lowerCase.equals("usa")) {
            return ZoneId.of("America/New_York");
        } else if (lowerCase.equals("canada")) {
            return ZoneId.of("America/Toronto");
        } else if (lowerCase.equals("brazil")) {
            return ZoneId.of("America/Sao_Paulo");
        } else if (lowerCase.equals("australia")) {
            return ZoneId.of("Australia/Sydney");
        } else {
            throw new IllegalArgumentException("Invalid country name: " + country + "Please try again");
        }
    } 

    public static void main(String[]args){
    Scanner sc = new Scanner(System.in);
    int choice;
    String source, target, country, hemisphere, season, localTime; 
    LocalDate today;


        do { 
            System.out.println("=== World Time & Season App ===");
            System.out.println("1. Convert Time");
            System.out.println("2. Determine Current Season");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            
            while(true){
                try {
                    choice = sc.nextInt();
                    break;
                } catch (InputMismatchException e){
                    System.out.println("Invalid input. Please enter integer only!!!!");
                    sc.nextLine();
                    System.out.print("Enter choice: ");
                }
            }

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
                        ZonedDateTime convertedTime = TimeConverter.convertTime(source, target, localTime); //Convert time between two different zones
                        System.out.println("Converted time in " + target + ": " + convertedTime.toLocalTime());
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    System.out.println("");
                    break;

                case 2:
                try{
                    System.out.print("\nEnter country: ");
                    country = sc.nextLine();

                    today = LocalDate.now();

                    System.out.println("Current date: " + today);

                    /* This part is on the other branch: */
                    // MatchHemisphere matchHemisphere = new MatchHemisphere();
                    // hemisphere = matchHemisphere.getHemisphere();

                    // here is manualy give hemisphere a string "Northern" for temporary show case
                    hemisphere = "Northern";

                    System.out.println(country + " is in the " + hemisphere + " Hemisphere.");
                    
                    // System.out.println("Current season in " + country + ": " + season);
                } catch (Exception e){
                    System.out.println("Error " + e.getMessage());
                }
                break;

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

