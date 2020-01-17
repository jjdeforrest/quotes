package quotes;

import org.junit.*;

import java.io.*;

import static org.junit.Assert.*;

public class QuoteTest {

    @Test
    public void testToString() throws FileNotFoundException {
        Quote quote = App.findRandomQuote("src/main/resources/recentquotes.json");
        boolean test = quote.tags != null;
        assertTrue("find random quote returns quote", test);
    }
}