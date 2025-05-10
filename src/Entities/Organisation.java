package Entities;

import Entities.Abstract.Being;
import Entities.Abstract.Purchasable;
import Links.LinkSameProperties;
import Links.Property;

public class Organisation extends Being implements Purchasable {
    private String comment;


    public Organisation(String name, String comment) {
        this.name = name;
        this.comment = comment;
        this.isMoral = false;
    }
    public Organisation(String name) {
        this(name, "");
    }
    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "   comment = " + (comment.isEmpty()?("No comment"):(comment)) + "\n" + printProperties(false);
    }

    public String printAll(){
        return super.toString() + "\n" +
                "   comment = " + (comment.isEmpty()?("No comment"):(comment)) + "\n" + printProperties(true);
    }
}
