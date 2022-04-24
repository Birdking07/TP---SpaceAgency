
/**
  Classe main du TP2 : Space agency
  @author : Gabriel R
  @handIn : 5/1/2022
  @description : Va obtenir une chain de caractères sous forme hexadécimale et va ensuite la convertir dans une
                 des convertisseurs par la methode convertir() et ensuite va faire l'appel à une des convertisseurs.
 */

package TP2;

import TP2.Analysers.OneDim;
import TP2.Analysers.TwoDim;
import TP2.Converters.*;


import java.util.ArrayList;

public class SystemController {


    public static void main(String[] Args){

        BigGenerator generator = new BigGenerator();

        int seed = 80;
        String sequence = generator.obtenirChaineControle(seed);


        int loopCounter = 1;
        String[] allConverters = {"LPF"}; //changer avec la liste de convertisseurs
        for(int i = 0 ; i < allConverters.length ; i++){
            convert( allConverters[i], sequence , loopCounter);
            loopCounter++;
        }

    }

    /**
     *
     * @param converterType type de convertisseur utilisé
     *  Options : HPF INV LPF POI ROT
     * @param sequence série de chiffres de la méthode obtenirChaineControle
     */

    private static void convert(String converterType , String sequence , int loopCounter){

            switch (converterType){

                case "HPF" -> {
                    HPF instanceHPF = new HPF();
                   instanceHPF.convert(sequence , 8); //changer avec la limite voulue

                }
                case "INV" -> {
                    INV instanceINV = new INV();
                    instanceINV.convert(sequence);
                }
                case "LPF" -> {
                    LPF instanceLPV = new LPF();
                    instanceLPV.convert(sequence , 8); //changer avec la limite voulue


                }
                case "POI" -> {
                    POI instancePOI = new POI();
                   instancePOI.convert(sequence , true); //changer pour false si on souhaite filtrer les nombres impairs
                }
                case "ROT" -> {
                    ROT instanceROT = new ROT(13); //changer avec la variation voulue pour la classe ROT
                    instanceROT.convert(sequence);
                }
                default -> {
                    System.out.println("Classe " + loopCounter + " Invalide");
                    System.out.println("Entrez une classe valide Gilles :(");
                }
            }
    }

    static private void testTP() {

        //remove comments and refractor to undergo different tests

        boolean result;
        String conversion;
        String chain;
        ArrayList<String> sequences;

        INV convINV = new INV();
        ROT convROT = new ROT(13);
        HPF convHPF = new HPF();
        LPF convLPF = new LPF();
        POI convPOI = new POI();

        chain = BigGenerator.obtenirChaineControle(50);
        conversion = convINV.convert(chain);
        result = conversion.startsWith("4662687433328BA0281704C8C03E79C2");
        System.out.println("TEST INV : " + (result ? "BON TP!" : "MAUVAIS TP??"));

        chain = BigGenerator.obtenirChaineControle(60);
        conversion = convROT.convert(chain);
        result = conversion.startsWith("82CD6741C9F46B8C9BAB8F15115F4A5F");
        System.out.println("TEST ROT : " + (result ? "BON TP!" : "MAUVAIS TP??"));

        chain = BigGenerator.obtenirChaineControle(70);
        conversion = convHPF.convert(chain , 8);
        result = conversion.startsWith("B900000E00BA9A0A09AB0F89E8EF0F0E");
        System.out.println("TEST HPF : " + (result ? "BON TP!" : "MAUVAIS TP??"));

        chain = BigGenerator.obtenirChaineControle(80);
        conversion = convLPF.convert(chain , 7);
        result = conversion.startsWith("00600312560720062001220530360700"); //should the last digit not be an 8 in this case?
        System.out.println("TEST LPF : " + (result ? "BON TP!" : "MAUVAIS TP??"));

        chain = BigGenerator.obtenirChaineControle(90);
        conversion = convPOI.convert(chain , true);
        result = conversion.startsWith("006060C600A0A28080000CE008004A0A");
        System.out.println("TEST POI : " + (result ? "BON TP!" : "MAUVAIS TP??"));


        OneDim analyseur1D = new OneDim();
        TwoDim TwoDim = new TwoDim();
        chain = BigGenerator.obtenirChaineControle(100);

        // sequence contains
        result = analyseur1D.Sequence(chain, "77B7B9DA5AE45C2EF2AC4F2FD59DF235");
        System.out.println("TEST 1D.1 : " + (result ? "BON TP!" : "MAUVAIS TP??"));

        // absent within sequence
        result = analyseur1D.Sequence(chain, "77B7B9DA5AE45C2EF2AC4F2FD59DF230");
        System.out.println("TEST 1D.2 : " + (!result ? "BON TP!" : "MAUVAIS TP??"));

         // returns true if two or more sequences are present
        sequences = new ArrayList<>();
        sequences.add("BCBAB105397C688E28CC5E8D9478FE40");  // true
        sequences.add("26CF16DD67598821B6B216BB196CF42E");  // true
        result = analyseur1D.AllSequences(chain, sequences);
        System.out.println("TEST 1D.3 : " + (result ? "BON TP!" : "MAUVAIS TP??"));



        // two sequences present and one absent -> returns true
        sequences.add("668BA6724590940523E66D0938EBD275");  // false
        result = analyseur1D.AllSequences(chain, sequences);
        System.out.println("TEST 1D.4 : " + (result ? "BON TP!" : "MAUVAIS TP??"));

        // two absent sequences -> returns false
        sequences.clear();
        sequences.add("668BA6724590940523E66D0938EBD275");  // false
        sequences.add("69764F7AFB4FE0F99A4C0DE8A5049354");  // false
        result = analyseur1D.AllSequences(chain, sequences);
        System.out.println("TEST 1D.5 : " + (!result ? "BON TP!" : "MAUVAIS TP??"));

        // if the sequence is present 8 times -> returns true since the int given is 8
        result = analyseur1D.OneSequenceCount(chain, "12", 8);
        System.out.println("TEST 1D.6 : " + (result ? "BON TP!" : "MAUVAIS TP??"));

        // if the sequence is present 8 times -> returns false since the int given is 9
        result = analyseur1D.OneSequenceCount(chain, "12", 9);
        System.out.println("TEST 1D.7 : " + (!result ? "BON TP!" : "MAUVAIS TP??"));

        // if the sequence is present 8 and 10 times -> returns true if int is 8
        sequences.clear();
        sequences.add("12");  // present 8 times
        sequences.add("31");  // present 10 times
        result = analyseur1D.AllSequencesCount(chain, sequences, 8);
        System.out.println("TEST 1D.8 : " + (result ? "BON TP!" : "MAUVAIS TP??"));

        // if the sequences are present 8 and 10 times -> returns false for int 9
        result = analyseur1D.AllSequencesCount(chain, sequences, 9);
        System.out.println("TEST 1D.9 : " + (!result ? "BON TP!" : "MAUVAIS TP??"));



        chain = BigGenerator.obtenirChaineControle(110);
        /*  B5381678D4AAB83812723044C137E36B
            FEFBF94AA736257A06FDCC451EF85FBA
            0B0D4EC6B6633FD3C8C20541F9B8A97B
            561A86E91278033E4D1E1E34679EE48A
            D6C9A62C25E70BB37D6A142D5910A4B9
            76D39B3DC891B131E58AD20C920C21B0
            178E8D2B95871C2E44DAB32F35002A28
            F724E04B6960BAEDCC2AAD44846575F0
            E715753585CD8A1167D5C0F4DED0EE76
            C04DA12C0E675FF167349491B867214F
            850114760D0969738E3E61EB6466079E
            0FC0A265137C0C2B213605D2CD9FAA16
            0B1C73395BF0AC3D92929F3695D3B8AB
            14245E5DD9C70E0A2A92AF727ADC7AA6
            B5CEAC2B155D9D181FB13E64C8D0E3C0
            1379F785C858302803755C0C875DC8AC
            79F14A2A6A890EFC9087B02423E7C3C9
            1B52DBB4B8CF6660259FE841DD5B2882
            8C24805864F772618523155580546B4B
            8E08D8B5CBFE836D0DA9836B32BA74E2
            80E3790A0F41CC1E5C97256B16A727D5
            BC16A12C1E4F7EEDC2CACC152F73E8DF
            8E14AC711EEAC13F9BC75B9D4B40B3CF
            99D4769DCD36CF566B68DC576C3CD3FB
            90E6887F4EF96878713122E15695D5A4
            2E509DA7A9ADFE93A51ECC9BE79427BD
            B009A438F48FB8C70C607E5FB4C828D2
            64DADA1475BDB34D96CB6488FA87761D
            5DB1D0B2C6A8D19D6DB5ABB803A42221
            41EBDBFF26B2DF010E7D1D89DD630CD1
            F186EC2C815E507EEBBB5373F3ECA90C
            18566776A76ED925BBF7D49A3F439D34 */

        // sequence present
        result = TwoDim.Sequence(chain, "9C63FF92");
        System.out.println("TEST 2D.1 : " + (result ? "BON TP!" : "MAUVAIS TP??"));;

        // sequence absente
        result = TwoDim.Sequence(chain, "9C63FF93");
        System.out.println("TEST 2D.2 : " + (!result ? "BON TP!" : "MAUVAIS TP??"));


        // two sequences present -> has to return TRUE
        sequences.clear();
        sequences.add("25FFB4D2");  // present
        sequences.add("CF666025");  // present
        result = TwoDim.AllSequences(chain, sequences);
        System.out.println("TEST 2D.3 : " + (result ? "BON TP!" : "MAUVAIS TP??"));

        // two sequences present, une absente -> has to return TRUE
        sequences.add("FFFFFFFF");  // absente
        result = TwoDim.AllSequences(chain, sequences);
        System.out.println("TEST 2D.4 : " + (result ? "BON TP!" : "MAUVAIS TP??"));

        // two sequences absent -> has to return FALSE
        sequences.clear();
        sequences.add("FFFFFFFF");  // absent
        sequences.add("DEADBEEF");  // absent
        result = TwoDim.AllSequences(chain, sequences);
        System.out.println("TEST 2D.5 : " + (!result ? "BON TP!" : "MAUVAIS TP??"));



        // sequence present 28 times -> has to return TRUE with a value of = 28
        result = TwoDim.OneSequenceCount(chain, "60", 28);
        System.out.println("TEST 2D.6 : " + (result ? "BON TP!" : "MAUVAIS TP??"));

        // sequence present 28 times -> has to return FALSE with a value of = 29
        result = TwoDim.OneSequenceCount(chain, "60", 29);
        System.out.println("TEST 2D.7 : " + (!result ? "BON TP!" : "MAUVAIS TP??"));

        // sequences present 2 et 3 times -> has to return TRUE with a value of 2
        sequences.clear();
        sequences.add("79F");  // present 2 times
        sequences.add("E42");  // present 3 times
        result = TwoDim.AllSequencesCount(chain, sequences, 2);
        System.out.println("TEST 2D.8 : " + (result ? "BON TP!" : "MAUVAIS TP??"));

        // sequences present 2 et 3 times -> has to return FALSE with a value of = 3
        result = TwoDim.AllSequencesCount(chain, sequences, 3);
        System.out.println("TEST 2D.9 : " + (!result ? "BON TP!" : "MAUVAIS TP??"));


        /* ************************* CONFIGURATION DES SYSTÃˆMES *************************
         *
         * Le systÃ¨me de poussÃ©e aura un germe de 50 et les composants suivants:
         *   CONVERTISSEURS: INV, POI
         *   ANALYSEUR: 1D
         *
         * Le systÃ¨me de pilotage aura un germe de 60 et les composants suivants:
         *   CONVERTISSEURS: ROT (13), HPF (value 4)
         *   ANALYSEUR: 1D
         *
         * Le systÃ¨me de communication aura un germe de 70 et les composants suivants:
         *   CONVERTISSEURS: INV, ROT (-5), INV, POI (interrupteur ouvert)
         *   ANALYSEUR: 2D
         *
         * Le systÃ¨me d'oxygÃ©nation aura un germe de 80 et les composants suivants:
         *   CONVERTISSEURS: POI (interrupteur fermÃ©), LPF (value B)
         *   ANALYSEUR: 2D
         *
         * Le systÃ¨me de recyclage des dÃ©chets organiques aura un germe de 90 et les
         * composants suivants:
         *   CONVERTISSEURS: INV, ROT (2), INV, ROT (-2), INV
         *   ANALYSEUR: 1D
         */
    }

}
