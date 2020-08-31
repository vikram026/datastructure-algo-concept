
public class StringMatch {
  public static void compare(String str, String regex)
  {
      if (str.matches(regex))
      {
          System.out.println(str + " matches");
      }
      else
      {
          System.out.println(str + " does not match");
      }
  }

}
