package TP2.Analysers;

import java.util.ArrayList;

/**
 * @author Gabriel
 * Classe qui sert à formatter les quatres méthodes qui analysent la chaine en utilisant divers techniques ces methodes
 * sont présentes dans l'analyseur 1D et 2D.
 */
public abstract class AnalyserFormat {
    /**
     *
     * @param chain la chaine à être analysé
     * @param sequence la séquence recherchée dans la chaine
     * @return Vrai si la séquence est présente faux sinon
     */
    public abstract boolean Sequence(String chain , String sequence);

    /**
     *
     * @param chain la chaine à être analysé
     * @param sequenceList liste de plusieurs séquences a recherché
     * @return Vrai si une des séquences est présente faux sinon
     */
    public abstract boolean AllSequences(String chain , ArrayList<String> sequenceList);

    /**
     *
     * @param chain la chaine à être analysé
     * @param sequence la séquence recherchée dans la chaine
     * @param objective un objectif numérique à atteindre qui correspond au nombre de fois la séquence est trouvé
     * @return Vrai si la séquence est présente le nombre de fois recherchée faux sinon
     */
    public abstract boolean OneSequenceCount(String chain , String sequence , int objective);

    /***
     *
     * @param chain la chaine à être analysé
     * @param sequenceList liste de plusieurs séquences a recherché
     * @param objective un objectif numérique à atteindre qui correspond au nombre de fois les séquences sont retrouvés
     * @return Vrai si toutes les séquences sont présentes le nombre de fois demandé dans le paramètre objectif faux sinon
     */
    public abstract boolean AllSequencesCount(String chain , ArrayList<String> sequenceList , int objective);
}
