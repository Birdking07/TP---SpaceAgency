package TP2.Analysers;

import java.util.ArrayList;

public class OneDim extends AnalyserFormat{



    public boolean Sequence(String chain, String sequence) {
        return chain.contains(sequence);
    }


    public boolean AllSequences(String chain, ArrayList<String> sequenceList) {
        for (int i = 0 ; i < sequenceList.size() ; i++) {
            if (chain.contains(sequenceList.get(i))){
                return true;
            }
        }
        return false;
    }


    public boolean OneSequenceCount(String chain, String sequence, int objective) {
        int counter = 0;

             chain = chain.replaceAll(sequence , "X");
               for (int i = 0 ; i < chain.length() ; i++){
                   if (chain.charAt(i) == 'X'){
                       counter++;
                   }
               }
            return counter == objective;
               //correctly does it's job but values given are incorrect?
    }


    public boolean AllSequencesCount(String chain, ArrayList<String> sequenceList, int objective) {
        int[] counter = new int[3];
        String originalValue = chain;
        int objectiveCounter = 0;
     for (int i = 0 ; i < sequenceList.size() ; i++){
         chain = originalValue;
         chain = chain.replaceAll(sequenceList.get(i) , "X");
         for (int a = 0 ; a < chain.length() ; a++){
             if (chain.charAt(a) == 'X'){
                 counter[i]++;
             }
         }
     }
     for (int i = 0 ; i < sequenceList.size() ; i++){
         if (counter[i] == objective){
             objectiveCounter++;
         } else {
             return false;
         }
     }
     return objectiveCounter == sequenceList.size();
    }
}
