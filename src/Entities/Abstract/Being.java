package Entities.Abstract;

import Entities.Media.Media;
import Entities.Organisation;
import Links.LinkSameProperties;
import Links.Property;

public abstract class Being {
    protected String name;
    protected boolean isMoral;

    protected LinkSameProperties<Property<Organisation>> organisationProperties = new LinkSameProperties<Property<Organisation>>();
    protected LinkSameProperties<Property<Media>> mediaProperties = new LinkSameProperties<Property<Media>>();

    public boolean isMoral() {
        return isMoral;
    }

    public String getName() {
        return name;
    }

    public LinkSameProperties<Property<Organisation>> getOrganisationProperties() {
        return organisationProperties;
    }

    public LinkSameProperties<Property<Media>> getMediaProperties() {
        return mediaProperties;
    }

    public void addProperty(Property<? extends Purchasable> property) {
        if (property.getTarget() instanceof Organisation) {
            organisationProperties.add(new Property<Organisation>(
                    (Organisation) property.getTarget(),
                    property.getQualifier(),
                    property.getPercentage(),
                    property.getComment()
            ));
        } else if (property.getTarget() instanceof Media) {
            mediaProperties.add(new Property<Media>(
                    (Media) property.getTarget(),
                    property.getQualifier(),
                    property.getPercentage(),
                    property.getComment()
            ));
        } else {
            throw new IllegalArgumentException("Unsupported property target type: " + property.getTarget().getClass().getName());
        }
    }

    public void removeProperty(Property<? extends Purchasable> property) {
        if (property.getTarget() instanceof Organisation) {
            organisationProperties.remove(new Property<Organisation>(
                    (Organisation) property.getTarget(),
                    property.getQualifier(),
                    property.getPercentage(),
                    property.getComment()
            ));
        } else if (property.getTarget() instanceof Media) {
            mediaProperties.remove(new Property<Media>(
                    (Media) property.getTarget(),
                    property.getQualifier(),
                    property.getPercentage(),
                    property.getComment()
            ));
        } else {
            throw new IllegalArgumentException("Unsupported property target type: " + property.getTarget().getClass().getName());
        }
    }

    public int getPropertyIndices(Property<? extends Purchasable> property) {
        if (property.getTarget() instanceof Organisation) {
            return organisationProperties.indexOf(new Property<Organisation>(
                    (Organisation) property.getTarget(),
                    property.getQualifier(),
                    property.getPercentage(),
                    property.getComment()
            ));
        } else if (property.getTarget() instanceof Media) {
            return mediaProperties.indexOf(new Property<Media>(
                    (Media) property.getTarget(),
                    property.getQualifier(),
                    property.getPercentage(),
                    property.getComment()
            ));
        } else {
            throw new IllegalArgumentException("Unsupported property target type: " + property.getTarget().getClass().getName());
        }
    }

    @Override
    public String toString() {
        return ("\n" + name + ":" +
                "\n\tisMoral = " + (isMoral ? ("yes") : ("no")));
    }

    public String printProperties(boolean all) {
        return "\norganisationProperties = " + (organisationProperties.isEmpty() ? ("Don't own any organisation") : (organisationProperties.printTree(all)).replace("\n", "\n\t")) +
                "\nmediaProperties = " + (mediaProperties.isEmpty() ? ("Don't own any media") : (mediaProperties.printTree(all)).replace("\n", "\n\t"));
    }
}
