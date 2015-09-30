package com.kelebro63.syncdatetimeapp.dateTimeConverter;

import org.joda.time.DateTime;

/**
 * Created by Bistrov Alexey on 09.09.2015.
 */
public class UniversalDateTime {


    public static Long displacementTime;
    private DateTime serverTime;


    private UniversalDateTime(DateTime serverTime) {
        this.serverTime = serverTime;
    }

    public static UniversalDateTime universalDateTimeGetterFromServer(DateTime serverTime) {
        return new UniversalDateTime(serverTime);
    }

    public static UniversalDateTime universalDateTimeGetterFromDevice(DateTime deviceTime) {
        return displacementTime != null ? new UniversalDateTime(new DateTime(deviceTime.getMillis() - displacementTime)) : null;
    }

    public void CalculateDisplacementTime(DateTime deviceTime) {
        displacementTime = deviceTime.getMillis() - serverTime.getMillis();
    }

    public DateTime getServerTime() {
        return serverTime;
    }
}
