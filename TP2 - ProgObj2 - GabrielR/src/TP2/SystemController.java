package TP2;

public class SystemController {

    private static String sequence;

    public static void main(String[] Args){

        BigGenerator gg = new BigGenerator();

        int seed = 3113;
        sequence = gg.obtenirChaineControle(seed);

    }

}
