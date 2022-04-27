package TP2.Analysers;

import java.util.ArrayList;

public class TwoDim extends AnalyserFormat{




    public boolean Sequence(String chain, String sequence) {
        return false;
    }


    public boolean AllSequences(String chain, ArrayList<String> sequenceList) {
        return false;
    }


    public boolean OneSequenceCount(String chain, String sequence, int objective) {
        return false;
    }


    public boolean AllSequencesCount(String chain, ArrayList<String> sequenceList, int objective) {
        return false;
    }

    private String[][] convertToSquare (String chain){
        int verticalPosition = 0;
        String[][] twoDimChain = new String[32][32];
        for (int i = 0 ; i < chain.length() ; i++){
            twoDimChain[verticalPosition][i] = String.valueOf(chain.charAt(i));
            if (i % 31 == 0){
                verticalPosition++;
            }
        }
        return twoDimChain;
    }

    private String reverseChain (String chain){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(chain);
        return stringBuilder.reverse().toString();
    }

}
