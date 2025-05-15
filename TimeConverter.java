//https://www.youtube.com/watch?v=QsEg9UN0_zg

import java.time.*;

public class TimeConverter {
    public static ZonedDateTime convertTime(String source, String target, String localTime)
    {
        ZoneId sourceCountry = UserInterface.getCountry(source);
        ZoneId targetCountry = UserInterface.getCountry(target);

        LocalTime localTimeParsed = LocalTime.parse(localTime);
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), localTimeParsed);

        ZonedDateTime sourceDateTime = localDateTime.atZone(sourceCountry);
        ZonedDateTime sourceDateTime2 = sourceDateTime.withZoneSameInstant(targetCountry);
        
        return sourceDateTime2;
    }
}
