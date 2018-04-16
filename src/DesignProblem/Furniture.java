package DesignProblem;

public class Furniture {

    private int width;
    private int depth;
    private int[] position;
    private String name;
    private boolean canBeOnCarpet;

    public Furniture(int width, int depth, String name, boolean canBeOnCarpet) {
        this.width = width;
        this.depth = depth;
        this.name = name;
        this.canBeOnCarpet = canBeOnCarpet;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCanBeOnCarpet() {
        return canBeOnCarpet;
    }

    public void setCanBeOnCarpet(boolean canBeOnCarpet) {
        this.canBeOnCarpet = canBeOnCarpet;
    }
}
