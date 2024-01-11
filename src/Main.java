import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

class Main {
    public static void main(String[] args) throws IOException {

        Writer output;
        output = new BufferedWriter(new FileWriter("src/Working Seeds", true));
        System.out.println("can write now");
        
        int[] arr1 = new int[20];
        int[] arr2 = new int[20];

        Random rand = new Random();

        // Long.MIN_VALUE = -9223372036854775808L
        // Long.MAX_VALUE = 9223372036854775807L

//        output.append("\n\nTimestamp: ").append(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date()));

        for (long seed = -1975339189L; seed > Long.MIN_VALUE; seed--) {
            int counter = 0;
            rand.setSeed(seed);
            for (int j = 0; j < 20; j++) {
                arr1[j] = rand.nextInt(5) + 1;
                arr2[j] = rand.nextInt(5) + 1;
            }

            for (int index =   0; index < 20; index++) {
                if (arr1[index] % 2 == 1 && arr2[index] % 2 == 1)
                    counter++;
                else
                    break;
            }
            if (counter == 20) {
                output.append("\n\nTimestamp: ").append(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date()));
                output.append("\nArray 1: ").append(Arrays.toString(arr1));
                output.append("\nArray 2: ").append(Arrays.toString(arr2));
                output.append("\nSeed: ").append(String.valueOf(seed));
                System.out.println("\n\nArray 1: " + Arrays.toString(arr1) + "\nArray 2: " + Arrays.toString(arr2) + "\nSeed: " + seed);
                break;
            }
            System.out.println("Seed: " + seed);

            /*
            * ---------------------------------
            *   List of current working seeds
            * ---------------------------------

            * Array 1: [1, 5, 3, 5, 5, 1, 1, 3, 3, 5, 5, 3, 3, 5, 1, 3, 5, 5, 1, 3]
            * Array 2: [5, 5, 3, 5, 3, 1, 5, 5, 1, 1, 1, 3, 5, 5, 3, 3, 5, 3, 1, 3]
            * Seed: -9223372035417550248

            * Array 1: [3, 3, 5, 5, 5, 1, 5, 3, 1, 3, 1, 5, 1, 1, 5, 3, 1, 3, 1, 1]
            * Array 2: [1, 3, 5, 1, 3, 1, 1, 1, 5, 5, 3, 1, 5, 3, 3, 3, 5, 1, 5, 3]
            * Seed: -9223372033292148033

            * Array 1: [1, 1, 5, 1, 5, 1, 1, 3, 5, 3, 5, 1, 1, 1, 1, 1, 5, 3, 3, 5]
            * Array 2: [3, 3, 1, 3, 3, 1, 1, 5, 5, 3, 3, 5, 1, 5, 5, 3, 5, 3, 3, 1]
            * Seed: -9223372033243552541

            * Array 1: [5, 1, 3, 5, 3, 3, 1, 3, 1, 3, 1, 5, 5, 5, 3, 3, 5, 3, 3, 1]
            * Array 2: [5, 1, 3, 1, 5, 1, 3, 1, 5, 3, 5, 1, 3, 1, 1, 1, 5, 5, 5, 5]
            * Seed: -9223372033136347478
            * */
        }

        output.close();
    }
}