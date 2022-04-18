
/**
  Classe main du TP2 : Space agency
  @author : Gabriel R
  @handIn : 5/1/2022
  @description : Va obtenir une chaine de caractères sous forme hexadécimale et va ensuite la convertir dans une
                 des convertisseurs par la methode convertir() et ensuite va faire l'appel à une des convertisseurs.
 */

package TP2;

public class SystemController {

    private static String sequence;

    public static void main(String[] Args){

        BigGenerator gg = new BigGenerator();

        int seed = 3113;
        sequence = gg.obtenirChaineControle(seed);


    }

}
