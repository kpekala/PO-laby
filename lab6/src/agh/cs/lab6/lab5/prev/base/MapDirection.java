package agh.cs.lab6.lab5.prev.base;

public enum MapDirection{
    NORTH, SOUTH, WEST, EAST;

    public String toString(){
        return switch (this){
            case NORTH -> "Północ";
            case SOUTH -> "Południe";
            case WEST -> "Zachód";
            case EAST ->  "Wschód";
        };
    }
    public String code(){
        return switch (this){
            case NORTH -> "N";
            case SOUTH -> "S";
            case WEST -> "W";
            case EAST ->  "E";
        };
    }
    public MapDirection next(){
        return switch (this){
            case NORTH -> EAST;
            case SOUTH -> WEST;
            case WEST -> NORTH;
            case EAST ->  SOUTH;
        };
    }
    public MapDirection previous(){
        return switch (this){
            case NORTH -> WEST;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
            case EAST ->  NORTH;
        };
    }
    public Vector2d toUnitVector(){
        return switch (this){
            case NORTH -> new Vector2d(0,1);
            case SOUTH -> new Vector2d(0,-1);
            case WEST -> new Vector2d(-1,0);
            case EAST -> new Vector2d(1,0);
        };
    }
}