package com.tms.geq.myapplication.utils;



import com.tms.geq.myapplication.vo.GetAllSense;
import com.tms.geq.myapplication.vo.GetLightSenseValve;
import com.tms.geq.myapplication.vo.GetParkRate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class AnalysisJSONUtils {

    //  {
    //    "serverinfo": "{\"pm2.5\":251,\"co2\":1916,\"LightIntensity\":1883,\"humidity\":29,\"temperature\":4}\n"
    //  }
    //1.解析传感器数据
    public static GetAllSense getGetAllSense(String json){
        //json数据转换编码
        String tokener = JSONTokener(json);
        JSONObject jsonObject;
        GetAllSense getAllSense =null;
        try {
            jsonObject = new JSONObject(tokener);
            String jsonObjectString = jsonObject.getString("serverinfo");
            JSONObject serverinfo = new JSONObject(jsonObjectString);
            int pm25 = serverinfo.getInt("pm2.5");
            int co2 = serverinfo.getInt("co2");
            int lightIntensity = serverinfo.getInt("LightIntensity");
            int humidity = serverinfo.getInt("humidity");
            int temperature = serverinfo.getInt("temperature");
            getAllSense = new GetAllSense(pm25,co2,lightIntensity,humidity,temperature);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return getAllSense;
    }


    //2.解析光照传感器阈值
    public static GetLightSenseValve getGetLightSenseValve(String json){
        //json数据转换编码
        String tokener = JSONTokener(json);
        JSONObject jsonObject;
        GetLightSenseValve getLightSenseValve =null;
        try {
            jsonObject = new JSONObject(tokener);
            String jsonObjectString = jsonObject.getString("serverinfo");
            JSONObject serverinfo = new JSONObject(jsonObjectString);
            String down = serverinfo.getString("Down");
            String up = serverinfo.getString("Up");
            getLightSenseValve = new GetLightSenseValve(down,up);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return getLightSenseValve;
    }

    //3.查询当前小车速度
    public static int getGetCarSpeed(String json){
        //json数据转换编码
        String tokener = JSONTokener(json);
        JSONObject jsonObject;
        int carSpeed = -1;
        GetLightSenseValve getLightSenseValve =null;
        try {
            jsonObject = new JSONObject(tokener);
            String jsonObjectString = jsonObject.getString("serverinfo");
            JSONObject serverinfo = new JSONObject(jsonObjectString);
            carSpeed = serverinfo.getInt("CarSpeed");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return carSpeed;
    }

    //4.设置小车动作是否成功
    public static boolean getSetCarMove(String json){
        //json数据转换编码
        String tokener = JSONTokener(json);
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(tokener);
            String jsonObjectString = jsonObject.getString("serverinfo");
            JSONObject serverinfo = new JSONObject(jsonObjectString);
            String result = serverinfo.getString("result");
            if (result.equals("ok")){
                return true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }



    //5.查询小车账户余额
    public static int getGetCarAccountBalance(String json){
        //json数据转换编码
        String tokener = JSONTokener(json);
        int banlance = -1;
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(tokener);
            String jsonObjectString = jsonObject.getString("serverinfo");
            JSONObject serverinfo = new JSONObject(jsonObjectString);
            banlance = serverinfo.getInt("Banlance");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return banlance;
    }

    //6.小车账充值是否成功
    public static boolean getSetCarAccountRecharge(String json){
        //json数据转换编码
        String tokener = JSONTokener(json);
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(tokener);
            String jsonObjectString = jsonObject.getString("serverinfo");
            JSONObject serverinfo = new JSONObject(jsonObjectString);
            String result = serverinfo.getString("result");
            if (result.equals("ok")){
                return true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }



    //7.查询道路状态
    public static int getGetRoadStatus(String json){
        //json数据转换编码
        String tokener = JSONTokener(json);
        JSONObject jsonObject;
        int status = -1;
        GetLightSenseValve getLightSenseValve =null;
        try {
            jsonObject = new JSONObject(tokener);
            String serverinfo = jsonObject.getString("serverinfo");
            JSONObject object = new JSONObject(serverinfo);
            status = object.getInt("Status");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return status;
    }

    //8.设置费率是否成功
    public static boolean getSetParkRate(String json){
        //json数据转换编码
        String tokener = JSONTokener(json);
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(tokener);
            String serverinfo = jsonObject.getString("serverinfo");
            JSONObject object = new JSONObject(serverinfo);
            String result = object.getString("result");
            if (result.equals("ok")){
                return true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }


    //9 查询当前费率信息
    public static GetParkRate getGetParkRate(String json){
        //json数据转换编码
        String tokener = JSONTokener(json);
        JSONObject jsonObject;
        GetParkRate getParkRate = null;
        try {
            jsonObject = new JSONObject(tokener);
            String rateType = jsonObject.getString("RateType");
            int money = jsonObject.getInt("Money");
            getParkRate = new GetParkRate(rateType,money);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return getParkRate;
    }


    //{
    //    "serverinfo": "[{\"ParkFreeId\":2},{\"ParkFreeId\":2}]\n"
    //}
    //10 查询当前空闲车位
    public static List<Integer> getGetParkFree(String json){
        //json数据转换编码
        String tokener = JSONTokener(json);
        JSONObject jsonObject;
        List<Integer> list = new ArrayList<Integer>();
        try {
            jsonObject = new JSONObject(tokener);
            String jsonObjectString = jsonObject.getString("serverinfo");
            JSONArray jsonArray = new JSONArray(jsonObjectString);
            for (int i =0;i<jsonArray.length();i++){
                JSONObject arrayJSONObject = jsonArray.getJSONObject(i);
                int parkFreeId = arrayJSONObject.getInt("ParkFreeId");
                list.add(parkFreeId);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }



    //json数据转换编码
    public static String JSONTokener(String in) {
        // consume an optional byte order mark (BOM) if it exists
        if (in != null && in.startsWith("\ufeff")) {
            in = in.substring(1);
        }
        return in;
    }




}
