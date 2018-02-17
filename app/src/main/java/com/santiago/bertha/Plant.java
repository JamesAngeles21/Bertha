package com.santiago.bertha;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jason on 2/17/2018.
 */

public class Plant {

    String name;
    String idealWater;
    String idealSun;
    String minTemp;
    String maxTemp;

    List<State> states;

    JSONParser parser = new JSONParser();

    Plant(String initName) {
        try{
            //Parse the JSON file
            Object obj = parser.parse(new FileReader("app\\flowers.json"));
            JSONObject jsonObject = (JSONObject)obj;

            //Retrieve the JSON flower object
            JSONObject flower = (JSONObject) jsonObject.get(initName);

            // Initialize fields from flower objects values
            name = initName;
            idealWater = (String) flower.get("water");
            idealSun = (String) flower.get("sun");
            minTemp = (String) flower.get("min_temp");
            maxTemp = (String) flower.get("max_temp");
            states = new ArrayList<>();

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String getName() {
        return name;
    }

    String getIdealWater() {
        return idealWater;
    }

    String getIdealSun() {
        return idealSun;
    }

    String getMinTemp() {
        return minTemp;
    }

    String getMaxTemp() {
        return maxTemp;
    }
}
