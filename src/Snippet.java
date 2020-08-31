import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateTime {
  public static void main(String[] args) {
    
  }
   private Timestamp geTimestamp(String stringDate) {
      try {
     // log.debug("Converting string Date to Timestamp");
      
      stringDate = stringDate.substring(0, stringDate.lastIndexOf('-'));
      String pattern = "yyyy-MM-ddTHH:mm:ss.SSSSSSS";
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
      LocalDateTime localDateTime = LocalDateTime.from(formatter.parse(stringDate));
  
      return Timestamp.valueOf(localDateTime);
      
     // stringDate = stringDate.substring(0, stringDate.lastIndexOf('-'));
      }catch(DateTimeParseException  | StringIndexOutOfBoundsException exception) {
       // log.warn("Error while  parsing string to timestamp ",exception);
        return new Timestamp(new Date().getTime()); //TODO need to be changed
       
      }
      return Timestamp.valueOf();
    }
}