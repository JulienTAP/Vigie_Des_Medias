package Links;

import Entities.Abstract.Purchasable;
import Utils.Percentage;

public class Property <T extends Purchasable> {

    private final T target;
    public static enum PropertyQualifier {
        OWNER,
        EQUALS,
        PARTICIPANT,
        SUPERIOR,
        INFERIOR,
    }
    private PropertyQualifier qualifier;
    private Percentage percentage;
    private String comment = "";

    public Property(T target, PropertyQualifier qualifier, Percentage percentage, String comment) {
        this.target = target;
        this.qualifier = qualifier;
        this.percentage = percentage;
        this.comment = comment;
    }

    public Property(T target, PropertyQualifier qualifier, Percentage percentage) {
        this(target, qualifier, percentage, "");
    }

    public T getTarget() {
        return target;
    }

    public PropertyQualifier getQualifier() {
        return qualifier;
    }

    public Percentage getPercentage() {
        return percentage;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return target.getName() + " : \n" +
                "   qualifier = " + qualifier + "\n" +
                "   percentage = " + percentage + "\n" +
                "   comment = " + (comment.isEmpty()?("No comment"):(comment));
    }

}
