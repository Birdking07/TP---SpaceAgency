package TP2.Converters;

public class ROT {

    private int variation;

    public ROT (int storedInt){
        storeROT(storedInt);
    }

    public String convert (String receivedValue){
        String newValue = "";

        for (int i = 0 ; i < receivedValue.length() ; i++){
            newValue += seperate(receivedValue.charAt(i));
        }
        return newValue;
    }
    private char seperate(char currentCharacter){
        char[] hexadecimals = {'A' , 'B' , 'C' , 'D' , 'E'};
        int preCalc = 0;
        try{
            preCalc = Integer.parseInt(String.valueOf(currentCharacter));
        } catch (NumberFormatException InvalidNumber){
            switch (currentCharacter) {
                case 'A' -> preCalc = 10;
                case 'B' -> preCalc = 11;
                case 'C' -> preCalc = 12;
                case 'D' -> preCalc = 13;
                case 'E' -> preCalc = 14;
                case 'F' -> preCalc = 15;
            }
        }

        int addValue = preCalc + variation;
        if (addValue >= 0 && addValue < 16) {

            if (addValue < 10){
                return String.valueOf(addValue).charAt(0);
            } else {
                switch (addValue){
                    case 10 -> {return 'A';}
                    case 11 -> {return 'B';}
                    case 12 -> {return 'C';}
                    case 13 -> {return 'D';}
                    case 14 -> {return 'E';}
                    case 15 -> {return 'F';}
                    default -> throw new ArithmeticException("Non hexadecimal value returned");
                }
            }

        } else {

            int rotatedValue = addValue % 16;

            if (rotatedValue < 10){

                return String.valueOf(rotatedValue).charAt(0);
            } else {

                return hexadecimals[rotatedValue - 10];
            }
        }
    }

    private void storeROT(int variation){
        this.variation = variation;
    }
}
