package com.lxy.creature;


import com.lxy.article.ArticleWeapon;

import java.util.HashMap;

/**
 * @description:
 * @author: lxy
 * @date: Created in 2020/5/13 15:20
 * @version: 1.0
 * @modified By:
 */
public  class Person extends Creature {
    private HashMap<String,Integer> skills = new HashMap<>();

    @Override
    public void upGrade() {
        super.upGrade();
    }

    @Override
    public void getEnemyExp(Monster enemy) {
        super.getEnemyExp(enemy);
    }

    @Override
    public void attack(ArticleWeapon articleWeapon, Creature enemy) {
        articleWeapon.useArticle(enemy);
    }

    public Person(String id, String description) {
        super(id, description);
    }

    public Person(String id, String description, int hp) {
        super(id, description, hp);
    }

    public Person() {
    }

    public HashMap<String, Integer> getSkills() {
        return skills;
    }

    public void setSkills(HashMap<String, Integer> skills) {
        this.skills = skills;
    }
}
