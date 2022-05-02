package TP2.Converters;



public class LPF {

    /**
     *
     * @param receivedValue valeur recue à être transformée
     * @param limit valeur maximale qui peut être renvoyé
     * @return la chaine transformée ou chaque char est soit plus petit que la limite ou égal à 0
     */
    public String convert (String receivedValue , int limit){

        String newValue = "";
        for (int i = 0 ; i < receivedValue.length() ; i++){
            newValue += seperate(receivedValue.charAt(i) , limit);
        }
        return newValue;
    }
    //changement de chaque valeur individuelle
    private char seperate(char currentCharacter , int limit){
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
        if (value <= limit) {
            return currentCharacter;
        } else {
            return '0';
        }
    }
}
