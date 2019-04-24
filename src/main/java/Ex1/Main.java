package Ex1;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Tomek
 */
public class Main {

    public static void main(String[] args) {

        Random rand = new Random();

        int number = rand.nextInt(100) + 1;

        Scanner sc = new Scanner(System.in);

        Integer guessedNumber;
        System.out.println("Guess the number: ");

        try {

            while (true) {

                String s = sc.next();

                if (s.matches("\\d+")) {

                    guessedNumber = Integer.valueOf(s);

                    if (guessedNumber < number) {

                        System.out.println("Too less.");

                    } else if (guessedNumber > number) {

                        System.out.println("Too much.");

                    } else if (guessedNumber == number) {

                        System.out.println("That's right.");
                        break;
                    }
                } else {

                    System.out.println("It is not a number.");
                }
            }

            sc.close();

        } catch (NumberFormatException e) {

            System.out.println(e);
        }
    }
}
