package TP2.Analysers;

import java.util.ArrayList;

public class TwoDim extends AnalyserFormat{




    public boolean Sequence(String chain, String sequence) {

        String[][] current2dChain = convertToSquare(chain);
        String[] rows = new String[32];
        String[] columns = new String[32];
        String[] diagonals = new String[32]; // look at nazim dm for example
        String[] reversedDiagonals = new String[32];
        // horizontal & vertical rows being stored
        for (int i = 0 ; i < 32 ; i++) {
            for (int a = 0; a < 32; a++) {
                rows[i] = current2dChain[i][a];
                columns[i] = current2dChain[a][i];
            }
        }
        //storing diagonals (set to downwards by default)

        int totalValuesInside = 0;
        boolean correctSide = true;
        for (int i = 0 ; i < 32 ; i++){
            diagonals[i] = "";
            if (i < 16 && correctSide){
                totalValuesInside++;
                for (int a = 0 ; a < totalValuesInside ; a++){
                    int currentColumn = (i - a);
                    diagonals[i] += current2dChain[currentColumn][i];
                }
            } else {
                correctSide = false;
                totalValuesInside--;
                for (int a = 0 ; a < totalValuesInside ; a++){
                    int currentColumn = (i - a);
                    diagonals[i] += current2dChain[currentColumn][i];
                }
            }
        }

        // horizontal
        for (int i = 0 ; i < 32 ; i++){
            if (rows[i].contains(sequence)){
                return true;
            }
        }
        // reversed horizontal
        for (int i = 0 ; i < 32 ; i++){
            if (reverseChain(rows[i]).contains(sequence)){
                return true;
            }
        }

        //vertical
        for (int i = 0 ; i < 32 ; i++){
            for (int a = 0 ; a < 32 ; a++){

            }
        }
        //diagonal
        for (int i = 0 ; i < 32 ; i++){
            if (diagonals[i].contains(sequence)){
                return true;
            }

        }
        for (int i = 0 ; i < 32 ; i++){

        }
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
