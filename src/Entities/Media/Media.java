package Entities.Media;

import Entities.Abstract.Purchasable;

import java.util.ArrayList;

public class Media implements Purchasable {

    private String name;
    public static enum MediaType {
        TELEVISION,
        SITE,
        RADIO,
        PRESS,
    }
    private MediaType mediaType;
    public static enum MediaPeriodicity {
        DAILY,
        WEEKLY,
        MONTHLY,
    }
    private MediaPeriodicity mediaPeriodicity;
    private String scale;
    private boolean free;
    private boolean available = true;

    private ArrayList<Publication> publications = new ArrayList<Publication>();

    public void addPublication(Publication publication) {
        publications.add(publication);
    }

    public Media(String name, MediaType mediaType, MediaPeriodicity mediaPeriodicity, String scale, boolean free) {
        this.name = name;
        this.mediaType = mediaType;
        this.mediaPeriodicity = mediaPeriodicity;
        this.scale = scale;
        this.free = free;

    }
    public Media(String name, MediaType mediaType, MediaPeriodicity mediaPeriodicity, String scale, boolean free, boolean available) {
        this.name = name;
        this.mediaType = mediaType;
        this.mediaPeriodicity = mediaPeriodicity;
        this.scale = scale;
        this.free = free;
        this.available = available;
    }

    public String getName() {
        return name;
    }
    public MediaType getMediaType() {
        return mediaType;
    }
    public MediaPeriodicity getMediaPeriodicity() {
        return mediaPeriodicity;
    }
    public String getScale() {
        return scale;
    }
    public boolean isFree() {
        return free;
    }
    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return (name + " :\n" +
                "\tMedia Type: " + mediaType + "\n" +
                "\tMedia Periodicity: " + mediaPeriodicity + "\n" +
                "\tScale: " + scale + "\n" +
                "\tFree: " + (free?("Yes"):("No")) + "\n" +
                "\tAvailable: " + (available?("Yes"):("No")) + "\n" +
                "\tPublications: " + publications.toString());
    }
}
