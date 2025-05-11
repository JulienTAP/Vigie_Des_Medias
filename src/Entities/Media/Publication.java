package Entities.Media;

import java.util.Date;

public class Publication {
    private String author;
    private String name;
    private Date date;
    private String content;

    public Publication(String author,String name, String content) {
        this.author = author;
        this.name = name;
        this.date = new Date();
        this.content = content;
    }
    public String getAuthor() {
        return author;
    }
    public String getName() {
        return name;
    }
    public Date getDate() {
        return date;
    }
    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "\n\t" + name
                + "\n\t" + date.toString()
                + "\n\t" + content;
    }
}
