package DesignProblem;

import java.util.List;

public class Room {

    private int[][] area;
    private int[] window;
    private int[] door;
    private List<Furniture> furnitures;
    private Carpet carpet;

    public int[][] getArea() {
        return area;
    }

    public void setArea(int[][] area) {
        this.area = area;
    }

    public int[] getWindow() {
        return window;
    }

    public void setWindow(int[] window) {
        this.window = window;
    }

    public int[] getDoor() {
        return door;
    }

    public void setDoor(int[] door) {
        this.door = door;
    }

    public List<Furniture> getFurnitures() {
        return furnitures;
    }

    public void setFurnitures(List<Furniture> furnitures) {
        this.furnitures = furnitures;
    }

    public Carpet getCarpet() {
        return carpet;
    }

    public void setCarpet(Carpet carpet) {
        this.carpet = carpet;
    }
}
