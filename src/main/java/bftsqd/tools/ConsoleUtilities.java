package bftsqd.tools;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConsoleUtilities {
   public static void changeConsoleTitle(String title) throws Exception {
      if (System.getProperty("os.name").startsWith("Windows")) new ProcessBuilder("cmd", "/c", "title " + title).inheritIO().start().waitFor();
   }

   public static boolean isInternetAvailable() {
      try {
         HttpURLConnection connection = (HttpURLConnection) new URL("https://www.google.com").openConnection();
         connection.setRequestMethod("HEAD");
         connection.setConnectTimeout(3000);
         connection.setReadTimeout(3000);
         int responseCode = connection.getResponseCode();
         return (responseCode == HttpURLConnection.HTTP_OK);
      } catch (IOException e) {
         return false;
      }
   }
}
