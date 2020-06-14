package com.lxy;

import java.util.ArrayList;

/**
 * @description:
 * @author: lxy
 * @date: Created in 2020/5/12 15:25
 * @version: 1.0
 * @modified By:
 */
public class RoomSet {
    private ArrayList<Room> rooms = new ArrayList<>();

    public RoomSet() {
    }

    public RoomSet(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }
}
