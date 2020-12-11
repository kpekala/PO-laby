package utils;

import javafx.scene.paint.Color;

public class Colors {

    public static String PRIMARY = "#88304e";
    public static String LIGHT = "#e23e57";
    public static String DARK = "#522546";
    public static String ACCENT = "#311d3f";

    public static String getGrey(double grey){
        return Color.gray(grey).toString().replace("0x","#");
    }
}