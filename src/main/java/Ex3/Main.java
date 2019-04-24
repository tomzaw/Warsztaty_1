package Ex3;

import java.util.Scanner;

/**
 *
 * @author Tomek
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Think of the number from range 0-1000 and I will guess it in max. 10 tries.");
        float max = 1000;
        float min = 0;
        float guess = (int) ((max - min) / 2) + min;

        try {

            int answer;
            int i=0;
            while (true) {

                System.out.println("I guess: " + guess);

                System.out.println("1.Correct.");
                System.out.println("2.Too much.");
                System.out.println("3.Too less.");

                String s = sc.next();

                if (s.matches("\\d+")) {

                    answer = Integer.valueOf(s);

                    if (answer == 1) {

                        System.out.println("I won.");
                        break;

                    } else if (answer == 2) {

                        max = guess;
                        guess = (int) ((max - min) / 2) + min;

                    } else if (answer == 3) {

                        min = guess;
                        guess = (int) ((max - min) / 2) + min;

                    } else {
                        
                        System.out.println("Input answer from range 1-3.");
                    }
                    i++;
                    
                } else {

                    System.out.println("Input answer from range 1-3.");
                }
                
                if(i==10)
                    break;
            }

            sc.close();

        } catch (NumberFormatException e) {

            System.out.println(e);
        }
    }
}
