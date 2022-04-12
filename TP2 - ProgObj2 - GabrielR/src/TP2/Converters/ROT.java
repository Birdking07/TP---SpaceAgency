package TP2.Converters;

public class ROT {

    public String ROT (String receivedValue , int valueVariation){
        char[] hexadecimals = {'A' , 'B' , 'C' , 'D' , 'E'};
        int preCalc = Integer.parseInt(receivedValue);
        int addValue = preCalc + valueVariation;
        if (addValue >= 0 && addValue <= 15){
            if (addValue < 10){
                return String.valueOf(addValue);
            }
        } else {
            int rotatedValue = addValue % 15;
            if (rotatedValue < 10){
                return String.valueOf(rotatedValue);
            } else {
                return String.valueOf(hexadecimals[rotatedValue - 10]);
            }
        }
        return "";
    }
}
