package quotes;

import org.junit.*;

import java.io.*;

import static org.junit.Assert.*;

public class QuoteTest {

    @Test
    public void testToString() throws FileNotFoundException {
        String testResponse = App.findRandomQuote("src/main/resources/recentquotes.json");
        boolean test = testResponse != null;
        assertTrue("find random quote returns quote", test);
    }
}