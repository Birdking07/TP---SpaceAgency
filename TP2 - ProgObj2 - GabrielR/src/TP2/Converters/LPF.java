package TP2.Converters;

public class LPF {

    public String LPF (String receivedValue , int limit){
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
        if (value <= limit) {
            return "0";
        } else {
            return String.valueOf(value);
        }
    }
}
