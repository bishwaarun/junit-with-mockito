package com.mrcoder.junit.mockito.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse ="{\"id\":1,\"name\":\"Tea\"}";

    @Test
    public void jsonAssert_strictTrue_ExactMatchExceptSpaces() throws JSONException {
        String expectedResponse ="{\"id\":1,\"name\":\"Tea\"}";
        JSONAssert.assertEquals(expectedResponse,actualResponse,true);
        // test pass if exact json in expect and actual
    }

    @Test
    public void jsonAssert_strictFalse_ExactMatchExceptSpaces() throws JSONException {
        String expectedResponse ="{\"id\":1}";
        JSONAssert.assertEquals(expectedResponse,actualResponse,false);
        // test pass if json format is correct
    }

    @Test
    public void jsonAssert_WithoutEscapeCharacter() throws JSONException {
        String expectedResponse ="{id:1,name:Tea}";
        JSONAssert.assertEquals(expectedResponse,actualResponse,false);
    }
}
