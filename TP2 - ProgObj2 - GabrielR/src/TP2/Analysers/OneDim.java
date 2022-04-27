package TP2.Analysers;

import java.util.ArrayList;
import java.lang.StringBuilder;

public class OneDim extends AnalyserFormat{



    public boolean Sequence(String chain, String sequence) {
        String reversedChain = reverseChain(chain);
        return chain.contains(sequence) || reversedChain.contains(sequence);
    }


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


    public boolean AllSequencesCount(String chain, ArrayList<String> sequenceList, int objective) {

        String reversedValue = reverseChain(chain);

        int[] counter = new int[3];

        String originalValue = chain;
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

    private String reverseChain (String chain){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(chain);
        return stringBuilder.reverse().toString();
    }
}
