package DesignProblem;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ProblemSolving {



    Random generator = new Random();
    Room room = new Room();
    //furnitures
    List<Furniture> furnitureList = new ArrayList<>();
    List<Furniture> settedFurnitures = new ArrayList<>();
    int[][] area = new int[600][400];

    public ProblemSolving() {
        prepare();
        designRoom();
    }

    public double countCarpetSize() {
        double size = 0;
        double r = 0;


        size = Math.PI * r * r;
        return size;
    }

    public void designRoom() {
        prepare();
        //najpierw telewizor i kanapa
        putRandom(furnitureList.get(4));
        settedFurnitures.add(furnitureList.get(4));
        furnitureList.remove(4);

        //telewizor
        putRandom(furnitureList.get(0));
        settedFurnitures.add( furnitureList.get(0));
        furnitureList.remove(0);

        //szafki które nie moga stac na dywanie
        putRandom(furnitureList.get(6));
        settedFurnitures.add(furnitureList.get(6));
        furnitureList.remove(6);

        putRandom(furnitureList.get(7));
        settedFurnitures.add(furnitureList.get(7));
        furnitureList.remove(7);

        putRandom(furnitureList.get(8));
        settedFurnitures.add(furnitureList.get(8));
        furnitureList.remove(8);

        putRandom(furnitureList.get(9));
        settedFurnitures.add(furnitureList.get(9));
        furnitureList.remove(9);

        //mogace stac na dywanie
        putRandom(furnitureList.get(1));
        settedFurnitures.add(furnitureList.get(1));
        furnitureList.remove(1);

        putRandom(furnitureList.get(2));
        settedFurnitures.add(furnitureList.get(2));
        furnitureList.remove(2);

        putRandom(furnitureList.get(3));
        settedFurnitures.add(furnitureList.get(3));
        furnitureList.remove(3);

        putRandom(furnitureList.get(5));
        settedFurnitures.add(furnitureList.get(5));
        furnitureList.remove(5);

    }

    private void putSofa() {

    }

    private void putRandom(Furniture f) {
        if(!isOverlapping(f) || f.getPosition() == null) {
            int p1 = generator.nextInt(600);
            int p2;
            int p3 = generator.nextInt(400);
            int p4;
            if (p1 > 600 - f.getWidth()) {
                p2 = p1;
                p1 = p1 - f.getWidth();
            } else {
                p2 = p1 + f.getWidth();
            }

            if (p3 > 400 - f.getDepth()) {
                p4 = p3;
                p3 = p3 - f.getDepth();
            } else {
                p4 = p3 + f.getDepth();
            }

            int[] pos = new int[]{p1, p2, p3, p4};
            f.setPosition((pos));
        }
        else
            putRandom(f);

    }

//    private void findFreeSpaceAtTheWall(int width, int depth) {
//        for (int i = 0; i < area.length; i++) {
//            for (int j = 0; j <area[i].length; j++) {
//
//            }
//        }
//    }

    private void prepare() {
        //x, y
        freeArea(area);
        room.setArea(area);
        //x, delta x, y, delta y
        room.setDoor(new int[]{600,0,100,90});
        //zajmij miejsce
        //TODO: reafctor this
        for(int i =0; i < 90; i++)
            area[100+i][400-1] = 1;
        room.setWindow(new int[]{230,140,400,0});
        for(int i =0; i < 140; i++)
            area[600-1][230+i] = 1;

        //telewizor
        furnitureList.add(new Furniture(150,35, "telewzior", false));
        //lawa
        furnitureList.add(new Furniture(100,50,"lawa",true));
        //pufy dwie
        furnitureList.add(new Furniture(50,50,"pufa1",true));
        furnitureList.add(new Furniture(50,50,"pufa2",true));
        //kanapa
        furnitureList.add(new Furniture(140, 80, "kanapa", false));
        //fotel
        furnitureList.add(new Furniture(90,80,"fotel",true));
        //4 jakies szafki kredensy itp
        furnitureList.add(new Furniture(60,35,"szafka1",false));
        furnitureList.add(new Furniture(135,43,"szafka2",false));
        furnitureList.add(new Furniture(45,35,"szafka3",false));
        furnitureList.add(new Furniture(90,43,"szafka4",false));

        room.setFurnitures(furnitureList);
    }

    private void freeArea(int[][] area) {
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {
                area[i][j] = 0;
            }
        }
    }


    private boolean isOverlapping(Furniture f) {
        if (f.getPosition() != null) {
            int[] pos = f.getPosition();
            for (int i = 0; i < settedFurnitures.size(); i++) {
                if ((pos[0] <= settedFurnitures.get(i).getPosition()[0] && pos[1] >= settedFurnitures.get(i).getPosition()[0])
                     || (pos[0] >= settedFurnitures.get(i).getPosition()[0] && pos[0] <= settedFurnitures.get(i).getPosition()[1])
                        ) {
                    return true;
                }
            }
            return false;
        }
        else
            return false;
    }

    private boolean isWindowOrDoorCovered() {

        return false;
    }

    private boolean isMax30Degree() {

        return false;
    }

    private boolean canClosetBeOpen() {

        return false;
    }

    public Random getGenerator() {
        return generator;
    }

    public void setGenerator(Random generator) {
        this.generator = generator;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Furniture> getFurnitureList() {
        return furnitureList;
    }

    public void setFurnitureList(List<Furniture> furnitureList) {
        this.furnitureList = furnitureList;
    }

    public List<Furniture> getSettedFurnitures() {
        return settedFurnitures;
    }

    public void setSettedFurnitures(List<Furniture> settedFurnitures) {
        this.settedFurnitures = settedFurnitures;
    }

    public int[][] getArea() {
        return area;
    }

    public void setArea(int[][] area) {
        this.area = area;
    }


}
