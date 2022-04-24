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

            while (chain.contains(sequence) && counter < objective){
                int position = chain.indexOf(sequence);
                System.out.println(position);
               chain = chain.substring(position);
               counter++;
            }
            return objective == counter;
    }


    public boolean AllSequencesCount(String chain, ArrayList<String> sequenceList, int objective) {
        return false;
    }
}
