package bftsqd;

import bftsqd.tools.ConsoleColor;
import bftsqd.tools.ConsoleUtilities;

import java.lang.management.ManagementFactory;
import java.net.http.HttpClient;
import java.util.Scanner;

public class Main {
   public static final Scanner sc = new Scanner(System.in);
   public static boolean colorSupported = true;

   public static void main(String[] args) {
      String osName = System.getProperty("os.name");
      if (osName.equalsIgnoreCase("windows 10")) {
         System.out.println("Your commander is not supporting color formatting! Disabling colors..");
         colorSupported = false;
      }

      System.out.println(ConsoleColor.RED + "[PizdaLoader] " + ConsoleColor.WHITE_BOLD + "Initializing..");
      try {
         ConsoleUtilities.changeConsoleTitle("Pizda - Loader");
      } catch(Exception e) {System.out.println("Вызвано исключение при изменении названия окна консоли. ExCode: " + e.getMessage());}

      System.out.println(ConsoleColor.RED + "[PizdaLoader] " + ConsoleColor.WHITE_BOLD + "Started on: " + osName);

      System.out.println(ConsoleColor.RED +  "[PizdaLoader] " + ConsoleColor.WHITE + "Проверка доступности сети..");

      if (!ConsoleUtilities.isInternetAvailable()) {
         System.out.println(ConsoleColor.RED + "[PizdaLoader] (ERROR) " + ConsoleColor.WHITE + "Подключения к сети нет, запуск не возможен");
         sc.next();
         System.exit(-1);
      }

      System.out.println(ConsoleColor.GREEN + "Ethernet connection is establish! Starting..");
      sc.next();
   }
}