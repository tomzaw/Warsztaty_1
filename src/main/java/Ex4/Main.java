package Ex4;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Tomek
 */
public class Main {

    public static void main(String[] args) {

        String sThrow = "2D2+1";

        System.out.println(throwDices(sThrow));
    }

    public static int throwDices(String sThrow) {

        Pattern p1 = Pattern.compile("\\d+");
        Matcher finder = p1.matcher(sThrow);

        int throwsNumber = 0;
        int diceType = 1;
        int modifier = 0;
        if (finder.find()) {
            throwsNumber = Integer.valueOf(finder.group());
        }

        Pattern p2 = Pattern.compile("D(\\d+)");
        finder = p2.matcher(sThrow);

        if (finder.find()) {
            diceType = Integer.valueOf(finder.group(1));
        }

        Pattern p3 = Pattern.compile("(\\+|\\-)(\\d+)");
        finder = p3.matcher(sThrow);

        if (finder.find()) {
            modifier = Integer.valueOf(finder.group(2));
        }

        Random rand = new Random();

        int dice = rand.nextInt(diceType) + 1;

        return throwsNumber * dice + modifier;
    }
}
