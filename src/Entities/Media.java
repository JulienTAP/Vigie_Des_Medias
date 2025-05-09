package Entities;

import Entities.Abstract.Purchasable;

public class Media implements Purchasable {

    private String name;
    enum MediaType {
        TELEVISION,
        SITE,
        RADIO,
        PRESS,
    }
    private MediaType mediaType;
    enum MediaPeriodicity {
        DAILY,
        WEEKLY,
        MONTHLY,
    }
    private MediaPeriodicity mediaPeriodicity;
    private String scale;
    private boolean free;
    private boolean available = true;
}
