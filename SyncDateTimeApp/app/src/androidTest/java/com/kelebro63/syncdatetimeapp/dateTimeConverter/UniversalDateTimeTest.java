package com.kelebro63.syncdatetimeapp.dateTimeConverter;

import org.joda.time.DateTime;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by Bistrov Alexey on 30.09.2015.
 */
public class UniversalDateTimeTest {

    @Test
    public void testUniversalDateTime() {
        DateTime dateTime = new DateTime(new Date(1443547200000L));
        UniversalDateTime universalDateTime = UniversalDateTime.universalDateTimeGetterFromServer(dateTime);
        universalDateTime.CalculateDisplacementTime(new DateTime(new Date()));
        assertEquals("comparison failed", universalDateTime.getServerTime().getMillis(),
                UniversalDateTime.universalDateTimeGetterFromDevice(new DateTime(new Date())).getServerTime().getMillis(), 0.001);
    }
}
