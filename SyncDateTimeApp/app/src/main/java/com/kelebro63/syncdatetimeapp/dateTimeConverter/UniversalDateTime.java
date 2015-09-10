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

    public UniversalDateTime universalDateTimeGetterFromServer(DateTime serverTime) {
        return new UniversalDateTime(serverTime);
    }

    public UniversalDateTime universalDateTimeGetterFromDevice(DateTime deviceTime) {
        return new UniversalDateTime(new DateTime(deviceTime.getMillis() - displacementTime));
    }

    public void CalculateDisplacementTime(DateTime deviceTime) {
        displacementTime = deviceTime.getMillis() - serverTime.getMillis();
    }

}
