package fasttrackit.lottogame;

import java.util.Random;

/**
 * Created by Bogdan on 2/21/2015.
 */
public class numbers {

    public int[] generatenr(int numbersCount, int bound) {
        // 2 prepare the lotto machine and init it
        Random lottoMachine = new Random();
        lottoMachine.setSeed(System.currentTimeMillis());

        // 2 generate the numbers
        int[] sixGeneratedNumbers = new int[numbersCount];
        for (int i = 0; i < numbersCount; i++) {

            int nr = lottoMachine.nextInt(bound) + 1;

            //check if nr is not already in the array, if it is generate a new one
            for (int j = 0; j < i; j++)
                if (sixGeneratedNumbers[j] == nr)
                    nr = lottoMachine.nextInt(bound) + 1;

            sixGeneratedNumbers[i] = nr;

            // wait , not necessary anyway
            try {
                Thread.currentThread().sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println(sixGeneratedNumbers);
        return sixGeneratedNumbers;

    }
}
