package TP2.Converters;

public class HPF {


    private static int defaultLimit = 8;

    /**
     * @return une valeur qui est soit plus grand ou égal au limite défini
     */

    public static String convert (String receivedValue, int limit) {

        if (limit < 0) {
            limit = defaultLimit;
        }

        int value = 0;
      try {
         value = Integer.parseInt(receivedValue);
      } catch (NumberFormatException e) {
          switch (receivedValue) {
              case "A" -> value = 10;
              case "B" -> value = 11;
              case "C" -> value = 12;
              case "D" -> value = 13;
              case "E" -> value = 14;
              case "F" -> value = 15;
          }

      }
      if (value >= limit) {
           return "0";
      } else {
          return String.valueOf(value);
      }
    }
}
