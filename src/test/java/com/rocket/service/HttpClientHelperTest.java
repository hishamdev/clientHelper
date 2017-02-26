package com.rocket.service;

/**
 * Created by aadithya.hatwar on 26/02/17.
 */

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import com.rocket.science.helper.HttpClientHelper;

import java.util.HashMap;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HttpClientHelperTest {

    @Test
    void myFirstTest() {
        Optional<JSONObject> temp = new HttpClientHelper().getRequest("http://www.webservicex.com/globalweather.asmx/GetWeather?CityName=Bangalore&CountryName=India");
        System.out.println(temp);
        assertEquals(2, 1 + 1);

        HashMap<Integer,Integer> hashtest = new HashMap<Integer,Integer>();
        hashtest.put(1,1);

        JSONObject jsonObject = new JSONObject(hashtest);
        temp = new HttpClientHelper().postRequest("http://requestb.in/1b8kg471", jsonObject);
        System.out.println(temp);
        assertEquals(2, 1 + 1);
    }


}



