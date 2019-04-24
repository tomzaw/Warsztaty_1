package Ex2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Tomek
 */
public class Main {

    public static void main(String[] args) {

        Random rand = new Random();

        int[] numbers = new int[6];
        numbers[0] = rand.nextInt(48) + 1;

        for (int i = 1; i < numbers.length; i++) {

            numbers[i] = rand.nextInt(48) + 1;
            
            for (int j = 0; j < i; j++) {

                if (numbers[j] == numbers[i]) {

                    i--;
                    break;
                }
            }
        }

        Scanner sc = new Scanner(System.in);

        Integer[] guessedNumbers = new Integer[6];

        int hits = 0;
        boolean uniqueNumber;
        try {

            int i = 0;
            while (true) {

                System.out.print("Guess the number: ");
                uniqueNumber = true;

                String s = sc.next();

                if (s.matches("\\d+")) {

                    guessedNumbers[i] = Integer.valueOf(s);

                    if (guessedNumbers[i] < 1 || guessedNumbers[i] > 49) {

                        System.out.println("The number should be in range of 1-49.");
                        continue;

                    } else if (i > 0) {

                        for (int j = 0; j < i; j++) {

                            if (guessedNumbers[j].equals(guessedNumbers[i])) {

                                System.out.println("The number was typed before.");
                                uniqueNumber = false;
                                break;
                            }
                        }
                    }

                    if (uniqueNumber == true) {

                        for (int j = 0; j < guessedNumbers.length; j++) {

                            if (guessedNumbers[i].equals(numbers[j])) {

                                hits++;
                            }
                        }

                        i++;
                    }
                } else {

                    System.out.println("It is not a positive integer number.");
                }

                if (i == 6) {
                    break;
                }
            }

            sc.close();

            Arrays.sort(guessedNumbers);
            System.out.print("Your guess: ");
            for (Integer guessedNumber : guessedNumbers) {

                System.out.print(guessedNumber + " ");
            }
            System.out.println();

            Arrays.sort(numbers);
            System.out.print("Numbers generated: ");
            for (Integer number : numbers) {

                System.out.print(number + " ");
            }
            System.out.println();

            System.out.println("Correct hits: " + hits);

        } catch (NumberFormatException e) {

            System.out.println(e);
        }
    }
}
