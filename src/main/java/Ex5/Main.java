package Ex5;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Tomek
 */
public class Main {

    public static void main(String[] args) {

        Connection connect = Jsoup.connect("http://www.onet.pl");
        String[] excluded = new String[5];
        excluded[0] = "oraz";
        excluded[1] = "ponieważ";
        excluded[2] = "żeby";
        excluded[3] = "jakby";
        excluded[4] = "chciałby";
        
        Path path = Paths.get("popular_words.txt");
        Path path2 = Paths.get("filtered_popular_words.txt");

        try {

            Document document = connect.get();
            Elements links = document.select("span.title");
            Files.deleteIfExists(path);
            Files.createFile(path);
            String title;
            for (Element link : links) {

                title = link.text();
                title = title.replaceAll("(\\.|,|!|\\?|\"|:|;)", "");
                String[] words = title.split(" ");

                for (String word : words) {

                    if (word.length() > 3) {

                        Files.write(path, (word + System.lineSeparator()).getBytes(Charset.forName("UTF-8")), StandardOpenOption.APPEND);
                    }
                }
            }

            Files.deleteIfExists(path2);
            Files.createFile(path2);
            ArrayList<String> words = new ArrayList<>(Files.readAllLines(path, Charset.forName("UTF-8")));

            //save to file filtered_pupular_words.txt from pupular_words.txt
            for (String excludedWord : excluded) {

                for (int i = 0; i < words.size(); i++) {

                    if (words.get(i).equals(excludedWord)) {
                        words.remove(i);
                    }
                }
            }

            Files.write(path2, words);

        } catch (IOException e) {

            System.out.println(e);
        }
    }
}
