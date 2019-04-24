package cot4400;

public enum Direction {

    NORTH, SOUTH, EAST, WEST;

    public char symbol(){
        return name().charAt(0);
    }

}
