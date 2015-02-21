package fasttrackit.lottogame;

import javax.xml.bind.SchemaOutputResolver;
import java.util.*;

public class LottoV1 {

    public static final int NUMBERS_COUNT = 5;
    public static final int BOUND = 40;




    public static void main(String[] args) {

        //  read users' numbers and store them
        //  prepare the lotto machine and init it
        //  generate the lotto numbers
        // compare the user numbers with the lotto numbers and tell if won something (4,5,6)

        // all in one or in different classes
        // all in one and a single method or in different methods


        // here is the simple and the most dummy idea

        // comment
        // ...
        double startTime = System.currentTimeMillis();
        System.out.println("");
        numbers obiect = new numbers();
        int[] sixGeneratedNumbers = obiect.generatenr(NUMBERS_COUNT, BOUND);
        // 3 print the extraction
        System.out.println("here is the extraction today:");
        for (int i = 0; i < NUMBERS_COUNT; i++)
            System.out.print(sixGeneratedNumbers[i] + " |");

        System.out.println("");

        int howManyWons;
        int deCateori = 0;
        do {
            howManyWons = 0;
            deCateori++;
            // 1 read
            int[] myNumbers = new int[NUMBERS_COUNT];
            Random myNumbersMachine = new Random();

            for (int i = 0; i < NUMBERS_COUNT; i++) {
                int nr = myNumbersMachine.nextInt(BOUND) + 1;
                //check if nr is not already in the array, if it is generate a new one
                for (int j = 0; j < i; j++)
                    if (myNumbers[j] == nr) nr = myNumbersMachine.nextInt(BOUND) + 1;
                myNumbers[i] = nr;
            }
            // here are my numbers
            System.out.println("here are my numbers:");
            for (int i = 0; i < NUMBERS_COUNT; i++)
                System.out.print(myNumbers[i] + " |");


            //compare and tell if won

            int[] wonNumbers = new int[NUMBERS_COUNT];

            for (int i = 0; i < NUMBERS_COUNT; i++)
                for (int j = 0; j < NUMBERS_COUNT; j++) {

                    if (myNumbers[i] == sixGeneratedNumbers[j]) {
                        howManyWons++;
                        wonNumbers[howManyWons - 1] = sixGeneratedNumbers[j];
                    }
                }

            switch (howManyWons) {

                case 3: // that is 4 numbers
                    System.out.println("congrat, you won at 3rd category");
                    break;
                case 4: // that is 5 numbers
                    System.out.println("congrat, you won at 2rd category");
                    break;

                default:
                    System.out.println("you are a looser, but keep trying, you guessed " + howManyWons + " numbers");
                    break;
            }

            System.out.println("here is what you won: ");
            for (int i = 0; i < NUMBERS_COUNT; i++)
                if (wonNumbers[i] != 0)
                    System.out.print(wonNumbers[i] + " |");

        } while (howManyWons <= 4);
        double endTime   = System.currentTimeMillis();
        double totalTime =( endTime - startTime)/1000;

        System.out.println();
        System.out.println("Ai incercat de :" + deCateori);
        System.out.println(totalTime);
    }
}
