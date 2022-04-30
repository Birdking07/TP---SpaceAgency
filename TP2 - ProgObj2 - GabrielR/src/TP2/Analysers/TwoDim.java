package TP2.Analysers;

import java.util.ArrayList;

public class TwoDim extends AnalyserFormat{




    public boolean Sequence(String chain, String sequence) {

        String[][] current2dChain = convertToSquare(chain);
        String[] rows = new String[32];
        String[] columns = new String[32];
        String[] diagonals = new String[63]; // look at nazim dm for example

        String[] reversedDiagonals = new String[32];
        // horizontal & vertical rows being stored
        for (int i = 0 ; i < 32 ; i++) {
            for (int a = 0; a < 32; a++) {
                rows[i] = current2dChain[i][a];
                columns[i] = current2dChain[a][i];
                System.out.print(current2dChain[i][a]);
                if (a == 31){
                    System.out.println("");
                }
            }
        }
        //storing diagonals (set to downwards by default)
        // reading from top downwards
        for (int i = 0 ; i <= 32 ; i++){
                diagonals[i] = "";
                for (int a = 0 ; a < i  ; a++){

                    int currentDiagonalPos = (i - a) - 1;
                    diagonals[i - 1] += current2dChain[currentDiagonalPos][a];
                }
        }


        for (int i = 0 ; i < 62 ; i++){
            System.out.println(diagonals[i]);
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
        for (int i = 1 ; i < 32 ; i++){
            if (diagonals[i].contains(sequence)){
                return true;
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

        String[][] twoDimChain = new String[32][32];
        int currentChar = 0;
        for (int i = 0 ; i < 32 ; i++){
           for (int a = 0 ; a < 32 ; a++){
               twoDimChain[i][a] = String.valueOf(chain.charAt(currentChar));
               currentChar++;
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
