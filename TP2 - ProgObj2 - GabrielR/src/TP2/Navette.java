package TP2;

/**
 Classe main du TP2 : Space agency
 @author : Gabriel R
 @handIn : 5/1/2022
 @description : Va obtenir une chain de caractères sous forme hexadécimale et va ensuite la convertir dans une
 des convertisseurs par la methode convert() et ensuite va faire l'appel aux analyseurs pour vérifier la chaine
 et si tous les analyseurs retournent vrai le décollage est authorisé.
 */

public class Navette {
    public static void main(String[] Args){

        BigGenerator generator = new BigGenerator();
        SystemController systemController = new SystemController();

        int seed = 100;
        String sequence = generator.obtenirChaineControle(seed);

        String[] allConverters = {""}; //changer avec la liste de convertisseurs
        for(int i = 0 ; i < allConverters.length ; i++){
            sequence = SystemController.convert(allConverters[i], sequence);
        }
        boolean liftoff = SystemController.analyse(sequence);

        if (liftoff){
            System.out.println("Merci pour le bon tp Gilles!!");
            System.out.println("Décollage authorisé!");
        } else {
            System.out.println("Décollage non authorisé");
            System.out.println("Une ou plusieurs analyseurs ont échoué...");
        }

    }
}
