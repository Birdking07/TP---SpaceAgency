package TP2;

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
        }

    }
}
