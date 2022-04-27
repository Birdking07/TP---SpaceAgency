package TP2.Analysers;

import java.util.ArrayList;
import java.lang.StringBuilder;

public class OneDim extends AnalyserFormat{



    public boolean Sequence(String chain, String sequence) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(chain);
        String reversedChain = stringBuilder.reverse().toString();
        return chain.contains(sequence) || reversedChain.contains(sequence);
    }


    public boolean AllSequences(String chain, ArrayList<String> sequenceList) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean normal = false , reversed = false;
        for (int i = 0 ; i < sequenceList.size() ; i++) {
            if (chain.contains(sequenceList.get(i))) {
                normal = true;
                break;
            }
        }

        stringBuilder.append(chain);
        String reversedChain = stringBuilder.reverse().toString();
        for (int i = 0 ; i < sequenceList.size() ; i++){
            if (reversedChain.contains(sequenceList.get(i))){
                reversed = true;
                break;
            }
        }
        return normal || reversed;
    }


    public boolean OneSequenceCount(String chain, String sequence, int objective) {
        StringBuilder reversedChain = new StringBuilder();
        int counter = 0;

        reversedChain.append(chain);
        String reversedValue = reversedChain.reverse().toString();

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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(chain);
        String reversedValue = stringBuilder.reverse().toString();
        String originalReversedValue = reversedValue;

        int[] counter = new int[3];

        String originalValue = chain;

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
         System.out.println(counter[i] + " " + objective);
         if (counter[i] >= objective){
             objectiveCounter++;
         }
     }
     return objectiveCounter >= sequenceList.size();
    }
}
