package Entities;

import Entities.Abstract.Purchasable;

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
                "   Media Type: " + mediaType + "\n" +
                "   Media Periodicity: " + mediaPeriodicity + "\n" +
                "   Scale: " + scale + "\n" +
                "   Free: " + (free?("Yes"):("No")) + "\n" +
                "   Available: " + (available?("Yes"):("No")));
    }
}
