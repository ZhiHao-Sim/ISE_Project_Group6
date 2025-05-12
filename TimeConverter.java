
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class TimeConverter {

  public static void main(String[] args) {

      LocalDateTime now = LocalDateTime.now();
      System.out.println(now);
      System.out.println("ZoneId.systemDefault(): " + ZoneId.systemDefault());

      // convert LocalDateTime to ZonedDateTime, with default system zone id
      ZonedDateTime zonedDateTime = now.atZone(ZoneId.systemDefault());

      // convert LocalDateTime to ZonedDateTime, with specified zoneId
      ZonedDateTime europeDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of("Europe/Kaliningrad"));
      System.out.println(europeDateTime);

      // convert LocalDateTime to ZonedDateTime, with specified off set
      ZonedDateTime offSetNegative5 = now.atOffset(ZoneOffset.of("-05:00")).toZonedDateTime();
      System.out.println(offSetNegative5);

      // display all zone ids
      //ZoneId.getAvailableZoneIds().forEach(System.out::println);

  }

}
