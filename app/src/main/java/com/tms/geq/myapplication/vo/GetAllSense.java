package com.tms.geq.myapplication.vo;

public class GetAllSense {
    //  {
    //    "serverinfo": "{\"pm2.5\":251,\"co2\":1916,\"LightIntensity\":1883,\"humidity\":29,\"temperature\":4}\n"
    //  }
    //传感器对象
    public int pm25 ;
    public int co2 ;
    public int LightIntensity ;
    public int humidity ;
    public int temperature ;

    public GetAllSense(int pm25, int co2, int lightIntensity, int humidity, int temperature) {
        this.pm25 = pm25;
        this.co2 = co2;
        LightIntensity = lightIntensity;
        this.humidity = humidity;
        this.temperature = temperature;
    }
}
