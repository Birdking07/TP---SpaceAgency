package TP2.Converters;

public class POI {

    public String convert (String receivedValue , boolean isEven){
        String[] evenNumbers = {"0","2","4","6","8" , "A" , "C" , "E"};
        String[] oddNumbers = {"1","3","5","7","9" , "B" , "D" , "F"};

        for (int i = 0; i < evenNumbers.length; i++) {
            if(receivedValue.equals(evenNumbers[i]) && isEven){
                return receivedValue;
            } else {
                return "0";
            }
        }
        return null;
    }

}
