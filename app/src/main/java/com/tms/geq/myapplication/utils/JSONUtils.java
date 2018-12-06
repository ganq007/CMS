package com.tms.geq.myapplication.utils;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils {

    public static JSONObject getJSONObject(String key,String value){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(key,value);
        } catch (JSONException e) {
            e.printStackTrace();
            LogUtils.loge("JSONUtils 出错了");
        }
        return jsonObject;
    }

    public static JSONObject getJSONObject(String key,int value){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(key,value);
        } catch (JSONException e) {
            e.printStackTrace();
            LogUtils.loge("JSONUtils 出错了");
        }
        return jsonObject;
    }


    public static JSONObject getJSONObject(String key,String value,String key2,String value2){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(key,value);
            jsonObject.put(key2,value2);
        } catch (JSONException e) {
            e.printStackTrace();
            LogUtils.loge("JSONUtils 出错了2");
        }
        return jsonObject;
    }

    public static JSONObject getJSONObject(String key,int value,String key2,String value2){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(key,value);
            jsonObject.put(key2,value2);
        } catch (JSONException e) {
            e.printStackTrace();
            LogUtils.loge("JSONUtils 出错了2");
        }
        return jsonObject;
    }


    public static JSONObject getJSONObject(String key,String value,String key2,int value2){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(key,value);
            jsonObject.put(key2,value2);
        } catch (JSONException e) {
            e.printStackTrace();
            LogUtils.loge("JSONUtils 出错了2");
        }
        return jsonObject;
    }












}
