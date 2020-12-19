package utils;

import javafx.scene.paint.Color;

public class Colors {

    public static String PRIMARY = "#88304e";
    public static String LIGHT = "#e23e57";
    public static String DARK = "#522546";
    public static String ACCENT = "#311d3f";
    public static String GREEN = "#7CFC00";

    public static String getGrey(double grey){
        return Color.gray(grey).toString().replace("0x","#");
    }

    public static String getMapColor(int index){
        return index == 0 ? GREEN : "#32CD32";
    }

    public static String getGrassColor(){
        return "#808000";
    }
}