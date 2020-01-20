package quotes;

import com.google.gson.*;

import java.io.*;

public class Quote {
    String[] tags;
    String author;
    String likes;
    String text;

    public Quote(String[] tags, String author, String likes, String text) {

        this.tags = tags;
        this.author = author;
        this.likes = likes;
        this.text = text;
    }

    public String toString() {
        return this.text + "\n-" + this.author;
    }

    public void stashQuote(){
        Quote[] quotey;
        try {
            quotey = App.getAllQuotes();
        } catch (IOException e){
            e.printStackTrace();
            return;
        }
        Quote[] quoteyJr = new Quote[quotey.length + 1];
        for(int i = 0; i < quotey.length;i++){
            quoteyJr[i] = quotey[i];
        }
        quoteyJr[quoteyJr.length - 1] = this;

        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileWriter myWriter = new FileWriter("src/main/resources/recentquotes.json");
            gson.toJson(quoteyJr,myWriter);
            myWriter.close();
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("File not found");
        }
    }
}
