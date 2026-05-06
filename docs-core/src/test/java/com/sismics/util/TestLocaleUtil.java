package com.sismics.util;

import com.sismics.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

/**
 * Test of the locale utilities.
 * 
 * @author jtremeaux
 */
public class TestLocaleUtil extends BaseTest {
    
    @Test
    public void getLocaleWithNullTest() {
        Locale result = LocaleUtil.getLocale(null);
        Assert.assertEquals(Locale.ENGLISH, result);
    }
    
    @Test
    public void getLocaleWithEmptyStringTest() {
        Locale result = LocaleUtil.getLocale("");
        Assert.assertEquals(Locale.ENGLISH, result);
    }
    
    @Test
    public void getLocaleWithSimpleLanguageCodeTest() {
        Locale result = LocaleUtil.getLocale("fr");
        Assert.assertNotNull(result);
        Assert.assertEquals("fr", result.getLanguage());
        Assert.assertEquals("", result.getCountry());
        Assert.assertEquals("", result.getVariant());
    }
    
    @Test
    public void getLocaleWithLanguageAndCountryTest() {
        Locale result = LocaleUtil.getLocale("en_US");
        Assert.assertNotNull(result);
        Assert.assertEquals("en", result.getLanguage());
        Assert.assertEquals("US", result.getCountry());
        Assert.assertEquals("", result.getVariant());
    }
    
    @Test
    public void getLocaleWithFranceFrenchTest() {
        Locale result = LocaleUtil.getLocale("fr_FR");
        Assert.assertNotNull(result);
        Assert.assertEquals("fr", result.getLanguage());
        Assert.assertEquals("FR", result.getCountry());
        Assert.assertEquals("", result.getVariant());
    }
    
    @Test
    public void getLocaleWithLanguageCountryAndVariantTest() {
        Locale result = LocaleUtil.getLocale("en_US_variant");
        Assert.assertNotNull(result);
        Assert.assertEquals("en", result.getLanguage());
        Assert.assertEquals("US", result.getCountry());
        Assert.assertEquals("variant", result.getVariant());
    }
    
    @Test
    public void getLocaleWithComplexVariantTest() {
        Locale result = LocaleUtil.getLocale("de_DE_schinese");
        Assert.assertNotNull(result);
        Assert.assertEquals("de", result.getLanguage());
        Assert.assertEquals("DE", result.getCountry());
        Assert.assertEquals("schinese", result.getVariant());
    }
    
    @Test
    public void getLocaleWithOnlyCountryTest() {
        Locale result = LocaleUtil.getLocale("zh");
        Assert.assertNotNull(result);
        Assert.assertEquals("zh", result.getLanguage());
    }
    
    @Test
    public void getLocaleWithMultipleUnderscoresTest() {
        Locale result = LocaleUtil.getLocale("pt_BR_variant");
        Assert.assertNotNull(result);
        Assert.assertEquals("pt", result.getLanguage());
        Assert.assertEquals("BR", result.getCountry());
        Assert.assertEquals("variant", result.getVariant());
    }
    
    @Test
    public void getLocaleWithLowercaseLanguageTest() {
        Locale result = LocaleUtil.getLocale("en_gb");
        Assert.assertNotNull(result);
        Assert.assertEquals("en", result.getLanguage());
        Assert.assertEquals("GB", result.getCountry());
    }
    
    @Test
    public void getLocaleWithUppercaseLanguageTest() {
        Locale result = LocaleUtil.getLocale("EN_US");
        Assert.assertNotNull(result);
        Assert.assertEquals("en", result.getLanguage());
        Assert.assertEquals("US", result.getCountry());
    }
}
