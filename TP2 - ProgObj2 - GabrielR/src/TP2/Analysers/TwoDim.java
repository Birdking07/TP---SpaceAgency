package TP2.Analysers;

import java.util.ArrayList;

/**
 * Analyseur 2D qui lit les valuers horizontales verticales et diagonales de facon régulière et inversé et va ensuite
 * répondre aux besoins spécifiques de chaque méthode comme définit dans la classe abstraite AnalyserFormat
 */

public class TwoDim extends AnalyserFormat{



    public boolean Sequence(String chain, String sequence) {

        String[][] current2dChain = ConvertToSquare(chain);
        String[] rows = new String[32];
        String[] columns = new String[32];
        String[][] Diagonals;


        // horizontal & vertical rows being stored
        for (int i = 0 ; i < 32 ; i++) {
            for (int a = 0; a < 32; a++) {
                rows[i] += current2dChain[i][a];
                columns[i] += current2dChain[a][i];
            }
        }

        Diagonals = ReturnDiagonals(current2dChain);


        // horizontal
        for (int i = 0 ; i < 32 ; i++){
            if (rows[i].contains(sequence) || ReverseChain(rows[i]).contains(sequence)){
                return true;
            }
        }

        //vertical
        for (int i = 0 ; i < 32 ; i++){
              if( columns[i].contains(sequence) || ReverseChain(rows[i]).contains(sequence)){
                  return true;
              }
        }

        //diagonal
        for (int i = 0 ; i < 4 ; i++){
            for (int a = 0 ; a < 32 ; a++){
                if (Diagonals[i][a].contains(sequence) || ReverseChain(Diagonals[i][a]).contains(sequence)){
                    return true;
                }
            }
        }
        return false;

    }


    public boolean AllSequences(String chain, ArrayList<String> sequenceList) {
        String[][] current2dChain = ConvertToSquare(chain);
        String[] rows = new String[32];
        String[] columns = new String[32];
        String[][] Diagonals;


        // horizontal & vertical rows being stored
        for (int i = 0 ; i < 32 ; i++) {
            for (int a = 0; a < 32; a++) {
                rows[i] += current2dChain[i][a];
                columns[i] += current2dChain[a][i];
            }
        }
        Diagonals = ReturnDiagonals(current2dChain);


        // Vérification de l'horizontal
        for (int i = 0 ; i < sequenceList.size() ; i++){
            for (int a = 0 ; a < 32 ; a++){
                if (rows[a].contains(sequenceList.get(i)) || ReverseChain(rows[a]).contains(sequenceList.get(i))){
                    return true;
                }
            }
        }


        // Vérification du vertical
        for (int i = 0 ; i < sequenceList.size() ; i++){
            for (int a = 0 ; a < 32 ; a++){
                if( columns[a].contains(sequenceList.get(i)) || ReverseChain(rows[a]).contains(sequenceList.get(i))){
                    return true;
                }
            }
        }


        //Verification du diagonal
        for (int i = 0 ; i < sequenceList.size() ; i++){
            for (int j = 0 ; j < 4 ; j++){
                for (int a = 0 ; a < 32 ; a++){
                    if (Diagonals[j][a].contains(sequenceList.get(i)) || ReverseChain(Diagonals[j][a]).contains(sequenceList.get(i))){
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public boolean OneSequenceCount(String chain, String sequence, int objective) {

        String[][] current2dChain = ConvertToSquare(chain);
        String[] originalRows = new String[32];
        String[] originalColumns = new String[32];
        String[] rows = new String[32];
        String[] columns = new String[32];
        String[][] Diagonals;
        String[][] originalDiagonals = new String[4][32];
        int objectiveCounter = 0;


        // stockage des valeurs horizontales et verticales de la table 2D.
        for (int i = 0 ; i < 32 ; i++) {
            for (int a = 0; a < 32; a++) {
                rows[i] += current2dChain[i][a];
                columns[i] += current2dChain[a][i];
            }
        }
        // recherche des valeurs diagonales
        Diagonals = ReturnDiagonals(current2dChain);

        // Stockage des valeurs horizontales verticales et diagonaux afin que l'on puisse remplacer les séquences
        // par une valeur X et quand même préservé la chaine dans sa forme originale.
        System.arraycopy(rows, 0, originalRows, 0, rows.length);
        System.arraycopy(columns, 0, originalColumns, 0, rows.length);

        for (int i = 0 ; i < 4 ; i++){
            System.arraycopy(Diagonals[i] , 0 , originalDiagonals[i] , 0 , 32);
        }

        // Vérification de l'horizontal
        for (int i = 0 ; i < 32 ; i++){
            rows[i] = rows[i].replaceAll(sequence , "X");
            for (int a = 0 ; a < rows[i].length() ; a++){
                if (rows[i].charAt(a) == 'X'){
                    objectiveCounter++;

                }
            }
            if (rows[i].contains("X")){
                rows[i] = originalRows[i];
            }
            rows[i] = ReverseChain(rows[i]);
            rows[i] = rows[i].replaceAll(sequence , "X");
            for (int a = 0 ; a < rows[i].length() ; a++){
                if (rows[i].charAt(a) == 'X'){
                    objectiveCounter++;
                }
            }
        }

        // Vérification de l'horizontal
        for (int i = 0 ; i < 32 ; i++){
            columns[i] = columns[i].replaceAll(sequence , "X");
            for (int a = 0 ; a < columns[i].length() ; a++){
                if (columns[i].charAt(a) == 'X'){
                    objectiveCounter++;
                }
            }
            if (columns[i].contains("X")){
                columns[i] = originalColumns[i];
            }
            columns[i] = ReverseChain(columns[i]);
            columns[i] = columns[i].replaceAll(sequence , "X");
            for (int a = 0 ; a < columns[i].length() ; a++){
                if (columns[i].charAt(a) == 'X'){
                    objectiveCounter++;
                }
            }
        }

        //Verification du diagonal
        for (int i = 0 ; i < 4 ; i++){
            for (int a = 0 ; a < 32 ; a++){
                Diagonals[i][a] = Diagonals[i][a].replaceAll(sequence , "X");
               for (int j = 0 ; j < Diagonals[i][a].length() ; j++){
                   if (Diagonals[i][a].charAt(j) == 'X'){
                       objectiveCounter++;
                   }
               }

               if (Diagonals[i][a].contains("X")){
                Diagonals[i][a] = originalDiagonals[i][a];
               }

               Diagonals[i][a] = ReverseChain(Diagonals[i][a]);
               Diagonals[i][a] = Diagonals[i][a].replaceAll(sequence , "X");
                for (int j = 0 ; j < Diagonals[i][a].length() ; j++){
                    if (Diagonals[i][a].charAt(j) == 'X'){
                        objectiveCounter++;
                    }
                }
            }
        }
        return objectiveCounter >= objective;
    }


    public boolean AllSequencesCount(String chain, ArrayList<String> sequenceList, int objective) {

        String[][] current2dChain = ConvertToSquare(chain);
        String[] originalRows = new String[32];
        String[] originalColumns = new String[32];
        String[] rows = new String[32];
        String[] columns = new String[32];
        String[][] Diagonals;
        String[][] originalDiagonals = new String[4][32];
        int[] objectiveCounter = new int[sequenceList.size()];

        // stockage des valeurs horizontal et vertical
        for (int i = 0 ; i < 32 ; i++) {
            for (int a = 0; a < 32; a++) {
                rows[i] += current2dChain[i][a];
                columns[i] += current2dChain[a][i];
            }
        }
        //stockage des valeurs diagonales
        Diagonals = ReturnDiagonals(current2dChain);

        // Stockage des valeurs horizontales verticales et diagonaux afin que l'on puisse remplacer les séquences
        // par une valeur X et quand même préservé la chaine dans sa forme originale.
        System.arraycopy(rows, 0, originalRows, 0, rows.length);
        System.arraycopy(columns, 0, originalColumns, 0, rows.length);

        for (int i = 0 ; i < 4 ; i++){
            System.arraycopy(Diagonals[i] , 0 , originalDiagonals[i] , 0 , 32);
        }

        // Vérification de l'horizontal
        for (int i = 0 ; i < sequenceList.size() ; i++){
            for (int a = 0 ; a < 32 ; a++){
                rows[a] = rows[a].replaceAll(sequenceList.get(i) , "X");
                for (int j = 0 ; j < rows[a].length() ; j++){
                    if (rows[a].charAt(j) == 'X'){
                        objectiveCounter[i]++;
                    }
                }
                if (rows[a].contains("X")){
                    rows[a] = originalRows[a];
                }
                rows[a] = ReverseChain(rows[a]);
                rows[a] = rows[a].replaceAll(sequenceList.get(i) , "X");
                for (int j = 0 ; j < rows[a].length() ; j++){
                    if (rows[a].charAt(j) == 'X'){
                        objectiveCounter[i]++;
                    }
                }
            }
        }


        // Vérification du vertical
        for (int i = 0 ; i < sequenceList.size() ; i++){
            for (int a = 0 ; a < 32 ; a++){
                columns[a] = columns[a].replaceAll(sequenceList.get(i) , "X");
                for (int j = 0 ; j < columns[a].length() ; j++){
                    if (columns[a].charAt(j) == 'X'){
                        objectiveCounter[i]++;
                    }
                }
                if (columns[a].contains("X")){
                    columns[a] = originalColumns[a];
                }
                columns[a] = ReverseChain(columns[a]);
                columns[a] = columns[a].replaceAll(sequenceList.get(i) , "X");
                for (int j = 0 ; j < columns[a].length() ; j++){
                    if (columns[a].charAt(j) == 'X'){
                        objectiveCounter[i]++;
                    }
                }
            }
        }


        //Verification du diagonal
        for (int i = 0 ; i < sequenceList.size() ; i++){
            for (int a = 0 ; a < 4 ; a++){
                for (int j = 0 ; j < 32 ; j++){
                    Diagonals[a][j] = Diagonals[a][j].replaceAll(sequenceList.get(i) , "X");
                    for (int f = 0 ; f < Diagonals[a][j].length() ; f++){
                        if (Diagonals[a][j].charAt(f) == 'X'){
                            objectiveCounter[i]++;
                        }
                    }
                    Diagonals[a][j] = ReverseChain(Diagonals[a][j]);
                    Diagonals[a][j] = Diagonals[a][j].replaceAll(sequenceList.get(i) , "X");
                    for (int f = 0 ; f < Diagonals[a][j].length() ; f++){
                        if (Diagonals[a][j].charAt(f) == 'X'){
                            objectiveCounter[i]++;
                        }
                    }
                }
            }
        }
        boolean isObjective = false;
        for (int i = 0 ; i < sequenceList.size() ; i++){
            if (objectiveCounter[i] >= objective){
                isObjective = true;
            } else {
                isObjective = false;
                break;
            }
        }
        return isObjective;
    }

    /**
     *
     * @param chain la chaine string recue
     * @return la chaine convertie en une table 2D
     */
    private String[][] ConvertToSquare(String chain){

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

    /**
     * inverse la chaine en question
     * @param chain chaine string recue
     * @return la chaine inversé
     */
    private String ReverseChain(String chain){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(chain);
        return stringBuilder.reverse().toString();
    }

    /**
     *
     * @param current2dChain
     * Va rechercher toutes les valeurs en diagonal par chaque coin individuellement.
     * La lecture s'arrête lorsque chaque coin ait lu en forme de triangle jusqu'a l'intersection au centre
     * puisque la boucle va incrémenter le nombre d'objets à rechercher ainsi que sa position horizontale, mais ne vas
     * pas réduire le nombre d'objets ensuite. Chaque coin est défini comme si elle était sur une boussole ex: NW, SE.
     * Un coin se lit ex: a, ab, abc, etc.
     * @return une table 2D contenant chaque coin ainsi que toutes leurs 32 lignes de valeurs.
     */
    private String[][] ReturnDiagonals (String[][] current2dChain){

        String[] diagonalsNW = new String[32];
        String[] diagonalsSE = new String[32];
        String[] diagonalsSW = new String[32];
        String[] diagonalsNE = new String[32];

        String[][] Diagonals = new String[4][32];

        // coin NW de la chaine 2D
        for (int i = 0 ; i < 32 ; i++){
            diagonalsNW[i] = "";
            for (int a = 0 ; a < i  ; a++){

                int currentDiagonalPos = (i - a) - 1;
                if (i == 31){
                    diagonalsNW[i] += current2dChain[currentDiagonalPos + 1][a];
                } else {
                    diagonalsNW[i] += current2dChain[currentDiagonalPos][a];
                }
            }
        }


        //coin SE de la chaine 2D
        for (int i = 0 ; i < 32 ; i++){
            diagonalsSE[i] = "";
            int e = 32;
            for (int a = 0 ; a < i ; a++){
                e--;
            }
            for (int a = 0 ; a < i  ; a++){

                int currentDiagonalPos = (32 - a) - 1;
                if (a % e >= 1 || (i == 31 && a != 0)){
                    e++;
                }
                diagonalsSE[i] += current2dChain[currentDiagonalPos][e];
            }
        }

        //coin NE de la chaine 2D
        for (int i = 0 ; i < 32 ; i++){
            diagonalsNE[i] = "";
            int e = 32;
            for (int a = 0 ; a < i ; a++){
                e--;
            }
            for (int a = 0 ; a < i  ; a++){
                if (a % e >= 1 || (i == 31 && a != 0)){
                    e++;
                }
                diagonalsNE[i] += current2dChain[a][e];
            }
        }

        //coin SW de la chaine 2D
        for (int i = 0 ; i < 32 ; i++){
            diagonalsSW[i] = "";
            int e = 32;
            for (int a = 0 ; a < i ; a++){
                e--;
            }
            for (int a = 0 ; a < i  ; a++){

                if (a % e >= 1 || (i == 31 && a != 0)){
                    e++;
                }
                diagonalsSW[i] += current2dChain[e][a];
            }
        }

        // on copie tous les coins dans une table 2D afin de l'envoyer tout d'un coup vers les autres méthodes
        System.arraycopy(diagonalsNW, 0, Diagonals[0], 0, 32);
        System.arraycopy(diagonalsSE, 0, Diagonals[1], 0, 32);
        System.arraycopy(diagonalsNE, 0, Diagonals[2], 0, 32);
        System.arraycopy(diagonalsSW, 0, Diagonals[3], 0, 32);

        return Diagonals;
    }
}
