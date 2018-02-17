package com.santiago.bertha;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jason on 2/17/2018.
 */

public class Plant {

    String name;
    Device device;

    int minTemp;
    int maxTemp;

    SunLevel exposure;
    WaterLevel moisture;

    List<State> states;

    Plant(String initName, Device initDevice,
          int initMinTemp, int initMaxTemp,
          SunLevel initExposure, WaterLevel initMoisture) {
        name = initName;
        device = initDevice;
        minTemp = initMinTemp;
        maxTemp = initMaxTemp;
        exposure = initExposure;
        moisture = initMoisture;
        states = new ArrayList<>();
    }



}
