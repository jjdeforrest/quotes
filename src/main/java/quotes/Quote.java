package quotes;

public class Quote {
    String[] tags;
    String author;
    String likes;
    String text;

    public Quote(String[] tags, String author, String likes, String text){

        this.tags = tags;
        this.author = author;
        this.likes = likes;
        this.text = text;
    }
    public String toString(){
        return this.text + "\n-" + this.author;
    }
}
