package Entities;

import Entities.Abstract.Being;
import Links.LinkSameProperties;
import Links.Property;

import java.util.ArrayList;

public class Rich extends Being {

    private String name;
    private ArrayList<Integer> ranks;

    private LinkSameProperties<Property<Organisation>> organisationProperties;
    private LinkSameProperties<Property<Media>> mediaProperties;
}
