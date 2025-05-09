package Entities;

import Entities.Abstract.Being;
import Entities.Abstract.Purchasable;
import Links.LinkSameProperties;
import Links.Property;

public class Organisation extends Being implements Purchasable {
    private String name;
    private String comment;

    private LinkSameProperties<Property<Organisation>> organisationProperties;
    private LinkSameProperties<Property<Media>> mediaProperties;
}
