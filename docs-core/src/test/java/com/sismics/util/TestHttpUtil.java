package com.sismics.util;

import com.sismics.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Test of the HTTP utilities.
 * 
 * @author jtremeaux
 */
public class TestHttpUtil extends BaseTest {
    
    private static final SimpleDateFormat EXPIRES_FORMAT = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
    
    @Test
    public void buildExpiresHeaderWithZeroTest() {
        String result = HttpUtil.buildExpiresHeader(0);
        Assert.assertNotNull(result);
        Assert.assertFalse(result.isEmpty());
        verifyExpiresHeaderFormat(result);
    }
    
    @Test
    public void buildExpiresHeaderWithOneSecondTest() {
        long futureTime = 1000;
        String result = HttpUtil.buildExpiresHeader(futureTime);
        Assert.assertNotNull(result);
        Assert.assertFalse(result.isEmpty());
        verifyExpiresHeaderFormat(result);
    }
    
    @Test
    public void buildExpiresHeaderWithOneHourTest() {
        long futureTime = 3600 * 1000;
        String result = HttpUtil.buildExpiresHeader(futureTime);
        Assert.assertNotNull(result);
        Assert.assertFalse(result.isEmpty());
        verifyExpiresHeaderFormat(result);
    }
    
    @Test
    public void buildExpiresHeaderWithOneDayTest() {
        long futureTime = 24 * 3600 * 1000;
        String result = HttpUtil.buildExpiresHeader(futureTime);
        Assert.assertNotNull(result);
        Assert.assertFalse(result.isEmpty());
        verifyExpiresHeaderFormat(result);
    }
    
    @Test
    public void buildExpiresHeaderWithOneWeekTest() {
        long futureTime = 7 * 24 * 3600 * 1000;
        String result = HttpUtil.buildExpiresHeader(futureTime);
        Assert.assertNotNull(result);
        Assert.assertFalse(result.isEmpty());
        verifyExpiresHeaderFormat(result);
    }
    
    @Test
    public void buildExpiresHeaderWithOneMonthTest() {
        long futureTime = 30 * 24 * 3600 * 1000;
        String result = HttpUtil.buildExpiresHeader(futureTime);
        Assert.assertNotNull(result);
        Assert.assertFalse(result.isEmpty());
        verifyExpiresHeaderFormat(result);
    }
    
    @Test
    public void buildExpiresHeaderWithLargeTimeTest() {
        long futureTime = 365 * 24 * 3600 * 1000;
        String result = HttpUtil.buildExpiresHeader(futureTime);
        Assert.assertNotNull(result);
        Assert.assertFalse(result.isEmpty());
        verifyExpiresHeaderFormat(result);
    }
    
    @Test
    public void buildExpiresHeaderWithNegativeTimeTest() {
        long futureTime = -3600 * 1000;
        String result = HttpUtil.buildExpiresHeader(futureTime);
        Assert.assertNotNull(result);
        Assert.assertFalse(result.isEmpty());
        verifyExpiresHeaderFormat(result);
    }
    
    @Test
    public void buildExpiresHeaderFormatTest() throws ParseException {
        long futureTime = 60 * 1000;
        long beforeCall = System.currentTimeMillis();
        String result = HttpUtil.buildExpiresHeader(futureTime);
        long afterCall = System.currentTimeMillis();
        
        Date parsedDate = EXPIRES_FORMAT.parse(result);
        Assert.assertNotNull(parsedDate);
        
        long expectedExpiration = beforeCall + futureTime;
        long timeDifference = Math.abs(parsedDate.getTime() - expectedExpiration);
        
        Assert.assertTrue("Time difference is too large: " + timeDifference, timeDifference < 5000);
    }
    
    @Test
    public void buildExpiresHeaderDayOfWeekTest() {
        String result = HttpUtil.buildExpiresHeader(1000);
        Assert.assertTrue("Result should contain a day of week", 
            result.contains("Mon") || result.contains("Tue") || result.contains("Wed") || 
            result.contains("Thu") || result.contains("Fri") || result.contains("Sat") || 
            result.contains("Sun"));
    }
    
    @Test
    public void buildExpiresHeaderMonthTest() {
        String result = HttpUtil.buildExpiresHeader(1000);
        Assert.assertTrue("Result should contain a month abbreviation",
            result.contains("Jan") || result.contains("Feb") || result.contains("Mar") || 
            result.contains("Apr") || result.contains("May") || result.contains("Jun") ||
            result.contains("Jul") || result.contains("Aug") || result.contains("Sep") ||
            result.contains("Oct") || result.contains("Nov") || result.contains("Dec"));
    }
    
    @Test
    public void buildExpiresHeaderTimezoneTest() {
        String result = HttpUtil.buildExpiresHeader(1000);
        Assert.assertTrue("Result should contain timezone offset",
            result.matches(".*[+-]\\d{4}.*"));
    }
    
    private void verifyExpiresHeaderFormat(String expiresHeader) {
        Assert.assertTrue("Header should match expected format",
            expiresHeader.matches("^[A-Z][a-z]{2}, \\d{2} [A-Z][a-z]{2} \\d{4} \\d{2}:\\d{2}:\\d{2} [+-]\\d{4}$"));
    }
}
