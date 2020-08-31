
public class NowTest {
  
  public static void main(String[] args) throws TwitterException {
    ConfigurationBuilder configurationBuider = new ConfigurationBuilder();
    configurationBuider.setDebugEnabled(true)
            .setOAuthConsumerKey("")
            .setOAuthConsumerSecret("")
            .setOAuthAccessToken("")
            .setOAuthAccessTokenSecret("");

    TwitterFactory tf=new TwitterFactory(configurationBuider.build());
    twitter4j.Twitter twitter=tf.getInstance();

    // You can pull this in from user input, etc.
    String hashTagToSearchFor = "testme";

    List<Status> status=twitter.getHomeTimeline();
    for(Status s:status){
        HashtagEntity[] hashTags = s.getHashtagEntities();
        for (HashtagEntity hashtag : hashTags) {
            if (hashtag.equals(hashTagToSearchFor)) {
                System.out.println(s.getUser().getName() + ": " + s.getText());

                // Assuming all hashtags are unique...
                continue;
            }
        }
    }
    }

}
