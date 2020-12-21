package utils;

import logic.model.GameConfig;
import logic.model.Vector2d;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ui.model.StatisticsModel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public  class FileUtils {
    public static GameConfig loadConfig(){
        Object obj = null;
        try {
            obj = new JSONParser().parse(new FileReader("resources/parameters.json"));
        } catch (IOException | ParseException exception) {
            exception.printStackTrace();
        }

        JSONObject jo = (JSONObject) obj;

        long animalsNumber = (long) jo.get("animalsNumber");
        long width = (long) jo.get("width");
        long height = (long) jo.get("height");
        boolean singleSimulation = (boolean) jo.get("singleSimulation");
        long startEnergy = (long) jo.get("startEnergy");
        long moveEnergy = (long) jo.get("moveEnergy");
        long plantEnergy = (long) jo.get("plantEnergy");
        long jungleWidth = (long) jo.get("jungleWidth");
        long jungleHeight = (long) jo.get("jungleHeight");

        return new GameConfig((int)animalsNumber,(int)width,(int)height,singleSimulation,(int)startEnergy,(int)moveEnergy,(int)plantEnergy,
                new Vector2d((int)jungleWidth, (int)jungleHeight));
    }

    public static void saveStatistics(StatisticsModel model){
        JSONObject jo = new JSONObject();
        jo.put("animalsNumber", model.getAnimalsNumber());
        jo.put("grassNumber", model.getGrassNumber());
        jo.put("mostPopularGen", model.getMostPopularGen());
        jo.put("avgEnergy", model.getAvgEnergy());
        jo.put("avgLifeSpan", model.getAvgLifeSpan());
        jo.put("avgChildNumber", model.getAvgChildNumber());

        PrintWriter pw = null;
        try {
            pw = new PrintWriter("resources/simulation.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        pw.write(jo.toJSONString());

        pw.flush();
        pw.close();
    }
}
