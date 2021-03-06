/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.gson.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class App {

    public static void main(String[] args) throws IOException {
        getRonSwanson();
    }
    public static Quote findRandomQuote(String path) throws FileNotFoundException {
        Gson gson = new Gson();
        FileReader reader = new FileReader(path);

        Quote[] quotey = gson.fromJson(reader,Quote[].class);

        Random rand = new Random();
        int random = rand.nextInt(quotey.length);
        return quotey[random];
    }
    public static Quote[] getAllQuotes() throws FileNotFoundException {

        Gson gson = new Gson();
        FileReader reader = new FileReader("src/main/resources/recentquotes.json");

        return gson.fromJson(reader,Quote[].class);
    }
    public static Quote getRonSwanson() throws IOException {
        try {
            URL url = new URL("https://ron-swanson-quotes.herokuapp.com/v2/quotes");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader input = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String quote = input.readLine();
            quote = quote.substring(1, quote.length() - 1);
            String[] placeholder = new String[]{};
            Quote ronSwansonQuote = new Quote(placeholder, "Ron Swanson", "", quote);
            ronSwansonQuote.stashQuote();
            System.out.println(ronSwansonQuote);
            return ronSwansonQuote;
        } catch (IOException e){
            Quote result = findRandomQuote("src/main/resources/recentquotes.json");
            System.out.println(result);
            return result;
        }
    }
}
