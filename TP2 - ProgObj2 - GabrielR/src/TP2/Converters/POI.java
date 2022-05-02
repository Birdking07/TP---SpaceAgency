package TP2.Converters;

public class POI {

    /**
     *
     * @param receivedValue la chaine recue à être transformée
     * @param isEven s'il est vrai les chiffres renvoyés peuvent seulement être pair sinon impair
     * @return la chaine transformée ou chaque char est soit pair ou impair s'il est l'inverse d'isEven il retournera 0
     */
    public String convert (String receivedValue , boolean isEven){
        String newValue = "";
        for (int i = 0 ; i < receivedValue.length() ; i++){
            newValue += seperate(receivedValue.charAt(i) , isEven);
        }
        return newValue;
     }
    //changement de chaque valeur individuelle
     private static char seperate(char currentCharacter , boolean isEven){
         char[] evenNumbers = {'0','2','4','6','8' , 'A' , 'C' , 'E'};
         char[] oddNumbers = {'1','3','5','7','9' , 'B' , 'D' , 'F'};
         if (isEven){
             for (int i = 0; i < evenNumbers.length; i++) {
                 if(currentCharacter == (evenNumbers[i])){
                     return currentCharacter;
                 }
             }
         } else {
             for (int i = 0; i < oddNumbers.length; i++) {
                 if(currentCharacter == (oddNumbers[i])){
                     return currentCharacter;
                 }
             }
         }
         return '0';
     }


}
