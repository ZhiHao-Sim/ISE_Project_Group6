//https://www.youtube.com/watch?v=QsEg9UN0_zg
import java.time.*;

public class TimeConverter {
    public static ZonedDateTime convertTime(String source, String target, String localTime)
    {
        ZoneId sourceCountry = getCountry(source);
        ZoneId targetCountry = getCountry(target);

        LocalTime localTimeParsed = LocalTime.parse(localTime);
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), localTimeParsed);

        ZonedDateTime sourceDateTime = localDateTime.atZone(sourceCountry);
        ZonedDateTime sourceDateTime2 = sourceDateTime.withZoneSameInstant(targetCountry);
        
        return sourceDateTime2;
    }

    public static ZoneId getCountry(String country) 
    {
            String lowerCase = country.toLowerCase();

            if (lowerCase.equals("china")){
                return ZoneId.of("Asia/Shanghai");
            } else if (lowerCase.equals("spain")) {
                return ZoneId.of("Europe/Madrid");
            } else if (lowerCase.equals("usa")) {
                return ZoneId.of("America/New_York");
            } else if (lowerCase.equals("japan")) {
                return ZoneId.of("Asia/Tokyo");
            } else if (lowerCase.equals("australia")) {
                return ZoneId.of("Australia/Sydney");
            } else {
                throw new IllegalArgumentException("Invalid country name: " + country);
            }
    } 
}
