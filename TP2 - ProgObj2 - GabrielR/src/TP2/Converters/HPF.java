package TP2.Converters;

public class HPF {


    private static int defaultLimit = 8;

    /**
     * @return une valeur qui est soit plus grand ou égal au limite défini
     */


    public String convert(String receivedValue, int limit) {

        String newValue = "";
        for (int i = 0; i < receivedValue.length() ; i++) {
            newValue += seperate(receivedValue.charAt(i), limit);
        }

        return newValue;

    }


    private char seperate(char currentCharacter, int limit) {
        if (limit < 0) {
            limit = defaultLimit;
        }

        int value = 0;
        try {
            value = Integer.parseInt(String.valueOf(currentCharacter));
        } catch (NumberFormatException e) {
            switch (currentCharacter) {
                case 'A' -> value = 10;
                case 'B' -> value = 11;
                case 'C' -> value = 12;
                case 'D' -> value = 13;
                case 'E' -> value = 14;
                case 'F' -> value = 15;
            }

        }
        if (value >= limit) {
            return currentCharacter;
        } else {
            return '0';
        }
    }

}
