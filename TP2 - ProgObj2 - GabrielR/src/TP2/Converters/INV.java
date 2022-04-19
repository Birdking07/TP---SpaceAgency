package TP2.Converters;

public class INV {

    public String transform (String receivedValue){
        String characterSent = receivedValue.toUpperCase();
        switch (characterSent) {
            case "0" -> characterSent = "F";
            case "1" -> characterSent = "E";
            case "2" -> characterSent = "D";
            case "3" -> characterSent = "C";
            case "4" -> characterSent = "B";
            case "5" -> characterSent = "A";
            case "6" -> characterSent = "9";
            case "7" -> characterSent = "8";
            case "8" -> characterSent = "7";
            case "9" -> characterSent = "6";
            case "A" -> characterSent = "5";
            case "B" -> characterSent = "4";
            case "C" -> characterSent = "3";
            case "D" -> characterSent = "2";
            case "E" -> characterSent = "1";
            case "F" -> characterSent = "0";
        }
        return characterSent;
    }
}
