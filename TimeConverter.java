import java.time.*;
import java.util.*;

public class TimeConverter {

    public static void main(String[] args) {
    
        String source, target, country, hemisphere, season, localTime;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter source country: ");
        source = sc.nextLine();

        System.out.print("Enter target country: ");
        target = sc.nextLine();

        System.out.print("Enter local time (HH:mm): ");
        localTime = sc.nextLine();

        try {
            ZonedDateTime convertedTime = convertTime(source, target, localTime);
            System.out.println("Converted time in " + target + ": " + convertedTime);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
  
    public static ZonedDateTime convertTime(String source, String target, String localTime)
    {
      
    }
  
}
