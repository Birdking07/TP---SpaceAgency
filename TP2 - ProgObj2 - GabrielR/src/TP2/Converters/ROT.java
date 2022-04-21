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
        if (addValue >= 0 && addValue <= 15){
            if (addValue < 10){
                return currentCharacter;
            }
        } else {
            int rotatedValue = addValue % 15;
            if (rotatedValue < 10){
                return currentCharacter;
            } else {
                return hexadecimals[rotatedValue - 10];
            }
        }
        return '0';
    }

    private void storeROT(int variation){
        this.variation = variation;
    }
}
