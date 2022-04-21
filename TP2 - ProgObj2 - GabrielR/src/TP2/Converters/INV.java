package TP2.Converters;

public class INV {

    public String convert (String receivedValue){

        String newValue = "";
        String UPPER = receivedValue.toUpperCase();

        for (int i = 0 ; i < receivedValue.length() ; i++){
            char individualCharacter = UPPER.charAt(i);
            newValue += seperate(individualCharacter);
        }

        return newValue;
    }

    private static char seperate(char inversedChar){
        switch (inversedChar) {
            case '0' -> inversedChar = 'F';
            case '1' -> inversedChar = 'E';
            case '2' -> inversedChar = 'D';
            case '3' -> inversedChar = 'C';
            case '4' -> inversedChar = 'B';
            case '5' -> inversedChar = 'A';
            case '6' -> inversedChar = '9';
            case '7' -> inversedChar = '8';
            case '8' -> inversedChar = '7';
            case '9' -> inversedChar = '6';
            case 'A' -> inversedChar = '5';
            case 'B' -> inversedChar = '4';
            case 'C' -> inversedChar = '3';
            case 'D' -> inversedChar = '2';
            case 'E' -> inversedChar = '1';
            case 'F' -> inversedChar = '0';
        }
        return inversedChar;
    }
}
