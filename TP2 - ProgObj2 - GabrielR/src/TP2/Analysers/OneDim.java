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
        int counter = 0;
        String originalValue = chain;

             chain = chain.replaceAll(sequence , "X");
               for (int i = 0 ; i < chain.length() ; i++){
                   if (chain.charAt(i) == 'X'){
                       counter++;
                   }
               }

               sequence = "21";
               chain = originalValue;
               int maxPos = chain.length();
               for (int i = 0 ; i < chain.length() ; i++){
                   char minPos = chain.charAt(i);
                   minPos = chain.charAt(maxPos);
                   maxPos--;
               }
            return counter == objective;
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
