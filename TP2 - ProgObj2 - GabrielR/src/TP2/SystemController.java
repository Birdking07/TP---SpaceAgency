
/**
  Classe main du TP2 : Space agency
  @author : Gabriel R
  @handIn : 5/1/2022
  @description : Va obtenir une chaine de caractères sous forme hexadécimale et va ensuite la convertir dans une
                 des convertisseurs par la methode convertir() et ensuite va faire l'appel à une des convertisseurs.
 */

package TP2;

import TP2.Converters.*;

import java.lang.reflect.Method;

public class SystemController {


    public static void main(String[] Args){

        BigGenerator generator = new BigGenerator();

        int seed = 3113;
        String sequence = generator.obtenirChaineControle(seed);



        String[] allConverters = {"HPF" , "LPF"};
        for(int i = 0 ; i < allConverters.length ; i++){
            convert( allConverters[i], sequence);
        }


    }

    /**
     *
     * @param converterType type de convertisseur utilisé
     *  Options : HPF INV LPV POI ROT
     * @param sequence série de chiffres de la méthode obtenirChaineControle
     */

    private static void convert(String converterType , String sequence){

       //just make the fucking switch i cba




    }

}
