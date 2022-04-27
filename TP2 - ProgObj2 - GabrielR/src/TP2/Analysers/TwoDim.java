package TP2.Analysers;

import java.util.ArrayList;

public class TwoDim extends AnalyserFormat{




    public boolean Sequence(String chain, String sequence) {

        String[][] current2dChain = convertToSquare(chain);

        // horizontal
        if (chain.contains(sequence)){
            return true;
        }
        // reversed horizontal
        if (reverseChain(chain).contains(sequence)){
            return true;
        }
        //vertical
        for (int i = 0 ; i < 32 ; i++){
            for (int a = 0 ; a < 32 ; a++){

            }
        }
        //diagonal
        for (int i = 0 ; i < 32 ; i++){
            for (int a = 0 ; a < 32 ; a++){
                //funny here
                if (a == 31){
                    //un mauvais tp
                }
            }
        }
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
            if (i == 32){
                i = 0;
                verticalPosition++;
                if (verticalPosition == 32){
                    break;
                }
            }
            twoDimChain[verticalPosition][i] = String.valueOf(chain.charAt(i));
        }
        return twoDimChain;
    }

    private String reverseChain (String chain){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(chain);
        return stringBuilder.reverse().toString();
    }

}
