package Links;

public class LinkSameProperties<T extends Property<?>> extends LinkProperties<T> {


    public LinkSameProperties() {
        super();
    }

    public LinkSameProperties(T property) {
        super();
        add(property);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
