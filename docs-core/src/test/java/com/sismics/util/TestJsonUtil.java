package com.sismics.util;

import com.sismics.BaseTest;
import jakarta.json.JsonValue;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test of the JSON utilities.
 * 
 * @author bgamard
 */
public class TestJsonUtil extends BaseTest {
    
    @Test
    public void nullableStringWithNullValueTest() {
        JsonValue result = JsonUtil.nullable((String) null);
        Assert.assertEquals(JsonValue.NULL, result);
    }
    
    @Test
    public void nullableStringWithValidValueTest() {
        JsonValue result = JsonUtil.nullable("test_value");
        Assert.assertNotNull(result);
        Assert.assertNotEquals(JsonValue.NULL, result);
        Assert.assertEquals("test_value", result.toString().replace("\"", ""));
    }
    
    @Test
    public void nullableStringWithEmptyStringTest() {
        JsonValue result = JsonUtil.nullable("");
        Assert.assertNotNull(result);
        Assert.assertNotEquals(JsonValue.NULL, result);
    }
    
    @Test
    public void nullableStringWithSpecialCharactersTest() {
        String specialValue = "value with {\"quotes\": true} and special chars!@#$%";
        JsonValue result = JsonUtil.nullable(specialValue);
        Assert.assertNotNull(result);
        Assert.assertNotEquals(JsonValue.NULL, result);
    }
    
    @Test
    public void nullableIntegerWithNullValueTest() {
        JsonValue result = JsonUtil.nullable((Integer) null);
        Assert.assertEquals(JsonValue.NULL, result);
    }
    
    @Test
    public void nullableIntegerWithZeroTest() {
        JsonValue result = JsonUtil.nullable(0);
        Assert.assertNotNull(result);
        Assert.assertNotEquals(JsonValue.NULL, result);
    }
    
    @Test
    public void nullableIntegerWithPositiveValueTest() {
        JsonValue result = JsonUtil.nullable(12345);
        Assert.assertNotNull(result);
        Assert.assertNotEquals(JsonValue.NULL, result);
    }
    
    @Test
    public void nullableIntegerWithNegativeValueTest() {
        JsonValue result = JsonUtil.nullable(-9876);
        Assert.assertNotNull(result);
        Assert.assertNotEquals(JsonValue.NULL, result);
    }
    
    @Test
    public void nullableIntegerWithMaxValueTest() {
        JsonValue result = JsonUtil.nullable(Integer.MAX_VALUE);
        Assert.assertNotNull(result);
        Assert.assertNotEquals(JsonValue.NULL, result);
    }
    
    @Test
    public void nullableIntegerWithMinValueTest() {
        JsonValue result = JsonUtil.nullable(Integer.MIN_VALUE);
        Assert.assertNotNull(result);
        Assert.assertNotEquals(JsonValue.NULL, result);
    }
    
    @Test
    public void nullableLongWithNullValueTest() {
        JsonValue result = JsonUtil.nullable((Long) null);
        Assert.assertEquals(JsonValue.NULL, result);
    }
    
    @Test
    public void nullableLongWithZeroTest() {
        JsonValue result = JsonUtil.nullable(0L);
        Assert.assertNotNull(result);
        Assert.assertNotEquals(JsonValue.NULL, result);
    }
    
    @Test
    public void nullableLongWithPositiveValueTest() {
        JsonValue result = JsonUtil.nullable(9223372036854775L);
        Assert.assertNotNull(result);
        Assert.assertNotEquals(JsonValue.NULL, result);
    }
    
    @Test
    public void nullableLongWithNegativeValueTest() {
        JsonValue result = JsonUtil.nullable(-9223372036854775L);
        Assert.assertNotNull(result);
        Assert.assertNotEquals(JsonValue.NULL, result);
    }
    
    @Test
    public void nullableLongWithMaxValueTest() {
        JsonValue result = JsonUtil.nullable(Long.MAX_VALUE);
        Assert.assertNotNull(result);
        Assert.assertNotEquals(JsonValue.NULL, result);
    }
    
    @Test
    public void nullableLongWithMinValueTest() {
        JsonValue result = JsonUtil.nullable(Long.MIN_VALUE);
        Assert.assertNotNull(result);
        Assert.assertNotEquals(JsonValue.NULL, result);
    }
}
