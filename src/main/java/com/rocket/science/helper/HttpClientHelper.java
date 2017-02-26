package com.rocket.science.helper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Optional;



public class HttpClientHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientHelper.class);


    public Optional<JSONObject> getRequest(String urlString){


        try{

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet getRequest = new HttpGet(urlString);
            getRequest.addHeader("accept", "application/json");

            HttpResponse response = httpClient.execute(getRequest);

            if (response.getStatusLine().getStatusCode() != 200) {

                LOGGER.error("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());

                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            String output;

            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            JSONObject res = new JSONObject(output);

            httpClient.getConnectionManager().shutdown();

            return Optional.of(res);

        }
        catch(Exception e){

            return Optional.empty();
        }

    }


    public Optional<JSONObject> postRequest(String url, JSONObject jsonobject){

        try{
            HttpClient client = new DefaultHttpClient();//HttpClientBuilder.create().build();
            HttpPost request = new HttpPost(url);
            StringEntity params =new StringEntity(jsonobject.toString());
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            HttpResponse response = client.execute(request);

            if(response.getStatusLine().getStatusCode()!=200){
                LOGGER.error("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            String output;

            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            JSONObject res = new JSONObject(output);

            client.getConnectionManager().shutdown();

            return Optional.of(res);


        }
        catch(Exception e){


            return Optional.empty();

        }


    }

}
