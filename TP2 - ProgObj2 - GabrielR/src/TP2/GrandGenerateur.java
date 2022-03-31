package TP2;

import java.util.Random;
/**
 * GrandGenerateur
 * Génère aléatoirement une chaîne de contrôle de 1024 caractères.
 *
 * @author Gilles-Philippe Grégoire et Eric Drouin
 * @version 0.1
 * @since 2022-03-28
 */
public class GrandGenerateur {
    public static final int LONGUEUR_CHAINE_CONTROLE = 1024;

    /**
     * Génère une chaîne de contrôle en utilisant des structures de données et
     * des objets de niveau 2CP.
     *
     * @param germe pour la génération aléatoire
     * @return la chaîne de contrôle de LONGUEUR_CHAINE_CONTROLE caractères
     */
    public static String obtenirChaineControle(int germe) {
        final char[] CARACTERES = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B',
                'C', 'D', 'E', 'F'};
        char[] chaine = new char[LONGUEUR_CHAINE_CONTROLE];
        Random aleatoire = new Random(germe);
        for (int i = 0; i < chaine.length; i++) {
            chaine[i] = CARACTERES[aleatoire.nextInt(16)];
        }
        return new String(chaine);
    }
}
