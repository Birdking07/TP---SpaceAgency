package TP2.Analysers;

import java.util.ArrayList;
import java.lang.StringBuilder;

/**
 * @author Gabriel
 * Analyseur 1D qui la lire la chaine en question horizontallement de droite à gauche et de gauche à droite
 * afin de répondre aux besoins spécifiques de chaque méthode
 */
public class OneDim extends AnalyserFormat{


   // on vérifie la chaine en le lisant des deux directions
    public boolean Sequence(String chain, String sequence) {
        String reversedChain = reverseChain(chain);
        return chain.contains(sequence) || reversedChain.contains(sequence);
    }

    // si la séquence en un des deux directions est retrouvé parmi la liste on retourne vrai.
    public boolean AllSequences(String chain, ArrayList<String> sequenceList) {

        String reversedChain = reverseChain(chain);

        boolean normal = false , reversed = false;
        for (int i = 0 ; i < sequenceList.size() ; i++) {
            if (chain.contains(sequenceList.get(i))) {
                normal = true;
                break;
            }
        }

        for (int i = 0 ; i < sequenceList.size() ; i++){
            if (reversedChain.contains(sequenceList.get(i))){
                reversed = true;
                break;
            }
        }
        return normal || reversed;
    }

    // on remplace toutes les séquences recherchées dans la chaine par 'X' et ensuite on les compte
    public boolean OneSequenceCount(String chain, String sequence, int objective) {
        int counter = 0;

        String reversedValue = reverseChain(chain);

             chain = chain.replaceAll(sequence , "X");
               for (int i = 0 ; i < chain.length() ; i++){
                   if (chain.charAt(i) == 'X'){
                       counter++;
                   }
               }
            reversedValue = reversedValue.replaceAll(sequence , "X");
               for (int i = 0 ; i < reversedValue.length(); i++){
                   if (reversedValue.charAt(i) == 'X'){
                       counter++;
                   }
               }
            return counter == objective;
    }

    // on lit les séquences dans la liste une à la fois en recherchant la séquence qui se retrouve
    // en utilisant la methode de la methode précédant.
    public boolean AllSequencesCount(String chain, ArrayList<String> sequenceList, int objective) {

        String reversedValue = reverseChain(chain);

        int[] counter = new int[3];

        String originalValue = chain;

        //afin que l'apparition des "X" ne transporte pas d'une boucle a l'autre
        String originalReversedValue = reversedValue;

        int objectiveCounter = 0;

     for (int i = 0 ; i < sequenceList.size() ; i++){
         chain = originalValue;
         reversedValue = originalReversedValue;
         chain = chain.replaceAll(sequenceList.get(i) , "X");
         for (int a = 0 ; a < chain.length() ; a++){
             if (chain.charAt(a) == 'X'){
                 counter[i]++;
             }
         }
         reversedValue = reversedValue.replaceAll(sequenceList.get(i) , "X");
         for (int a = 0 ; a < reversedValue.length() ; a++){
             if (reversedValue.charAt(a) == 'X'){
                 counter[i]++;
             }
         }
     }
     for (int i = 0 ; i < sequenceList.size() ; i++){
         if (counter[i] >= objective){
             objectiveCounter++;
         }
     }
     return objectiveCounter >= sequenceList.size();
    }
    // methode qui va inverser la chaine afin de le lire de l'autre direction
    private String reverseChain (String chain){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(chain);
        return stringBuilder.reverse().toString();
    }
}
