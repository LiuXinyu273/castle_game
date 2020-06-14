package com.lxy.creature;

import java.util.ArrayList;

/**
 * @description:
 * @author: lxy
 * @date: Created in 2020/5/13 15:20
 * @version: 1.0
 * @modified By:
 */
public class MonsterSet {
    private ArrayList<Monster> monsters = new ArrayList<>();

    //增删改查


    public MonsterSet() {
    }

    public MonsterSet(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }

}
