import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;
//import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DaysCalculator {

  public static void main(String[] args) throws ParseException {
//    SimpleDateFormat sdf=new SimpleDateFormat("dd MM yyyy");
//    Date input1=sdf.parse("23 01 2018");
//    Date input2=sdf.parse("23 01 2019");
//    long diff=input2.getTime()-input1.getTime();
//    
//    long days=TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
//    System.out.println(days);
    
    

  DateTimeFormatter sdf=DateTimeFormatter.ofPattern("dd MM yyyy");
  LocalDate input1=LocalDate.parse("23 01 2018",sdf);
  LocalDate input2=LocalDate.parse("23 01 2020",sdf);
  
  long days=ChronoUnit.DAYS.between(input1, input2);
  System.out.println(days);
  
  
  /**
   * self method ******************************************
   */
  Date date1=new Date(23, 01, 2018);
  Date date2=new Date(23, 01, 2019);
  int noOfDays=calculateDays(date1,date2);
  System.out.println("self Calculator :: "+noOfDays);
  
  
    
  }
  private static int getLeapDays(Date date) {
    int y=date.year;
    if(date.month<=2)
      y--; 
    return y/4-y/100+y/400;  
  }

  private static int calculateDays(Date date1, Date date2) {
  
    int inputDays1=countDays(date1);
    int inputDays2=countDays(date2);

    return inputDays2-inputDays1;
  }
  private static int countDays(Date date) {
    int[] months= {31,28,31,30,31,30,31,31,30,31,30,31};
    int noOfDays=date.year*365+date.day;
    
    for(int i=0;i<date.month-1;i++) {
      noOfDays+=months[i];
    }
    noOfDays+=getLeapDays(date);
    return noOfDays;
  }

}
