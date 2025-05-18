//https://www.youtube.com/watch?v=QsEg9UN0_zg

import java.time.*;

public class TimeConverter {
    public static ZonedDateTime convertTime(String source, String target, String localTime)
    {
        ZoneId sourceCountry = UserInterface.getCountry(source); //Converts userInput into ZoneId using getCounty method with parameter.
        ZoneId targetCountry = UserInterface.getCountry(target);

        LocalTime localTimeParsed;
        try{
        localTimeParsed= LocalTime.parse(localTime); //Converts the string input time (HH:mm) into LocalTime object. Which is (14:30) to LocalTime.of(14,30)
        } catch (Exception e){
            throw new IllegalArgumentException("Invalid time format, the program is only allows 24-hour clock, e.g.(23:59)");
        }

        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), localTimeParsed); //Combines the current date with the parsed time

        ZonedDateTime sourceDateTime = localDateTime.atZone(sourceCountry); //assign the source time zone to the LocalDateTime to create a ZonedDateTime
        ZonedDateTime sourceDateTime2 = sourceDateTime.withZoneSameInstant(targetCountry); // Converts the source time to the equivalent time in the target time zone (but it's the same moment in real time.)
        
        return sourceDateTime2; // Return the converted ZonedDateTime for the target country

    }
}
