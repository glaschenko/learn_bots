package utils;

import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/*
 * Author: glaschenko
 * Created: 13.03.2018
 */
public class BotsUtils {
    public static StringEntity wrapToStringEntity(JSONObject obj) {
        StringEntity entity;
        try {
            entity = new StringEntity(obj.toString());
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
        return entity;
    }

    public static StringBuilder readHttpEntity(HttpEntity entity) throws IOException {
        InputStreamReader in = new InputStreamReader(entity.getContent());
        BufferedReader rd = new BufferedReader(in);
        StringBuilder sb = new StringBuilder();
        String s = rd.readLine();
        while (s != null){
            sb.append(s);
            s = rd.readLine();
        }
        return sb;
    }


}
