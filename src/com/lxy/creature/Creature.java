package com.lxy.creature;

import com.lxy.Room;
import com.lxy.article.ArticleWeapon;

import java.util.ArrayList;

/**
 * @description:
 * @author: lxy
 * @date: Created in 2020/5/13 15:20
 * @version: 1.0
 * @modified By:
 */
public class Creature {
    private String id;
    private String description;//name
    private Room currentRoom;//当前位置
    private int Maxhp;//最大生命值
    private int hp;//生命值
    private int Exp;//经验值
    private int ExpVR;//升级所需要的经验值

    private int lv;//等级
    private ArticleWeapon currentWeapon;//当前武器
    private ArrayList<ArticleWeapon> articleWeapons = new ArrayList<>();//技能


    //攻击函数
    public void attack(ArticleWeapon articleWeapon, Creature enemy){
        articleWeapon.useArticle(enemy);
    }

    //获取敌人的经验值函数
    public void getEnemyExp(Monster enemy){
        int value = enemy.getLeftExp();
        enemy.setLeftExp(0);
        this.Exp +=value;
    }

    //升级函数
    public void upGrade(){
        if(this.Exp >= this.ExpVR){
            this.lv++;
            setExp(this.Exp-this.ExpVR);
            this.ExpVR+=20;
            this.Maxhp+=20;
            this.currentWeapon.setEffectValue(this.currentWeapon.getEffectValue()-10);
            setHp(this.Maxhp);
            System.out.println("您已升级，生命上限获得提升！");
        }
    }

    //防御函数，变相加血函数
    public void Addblood(ArticleWeapon articleWeapon){
        this.hp+=articleWeapon.getEffectValue();
    }


    public Creature() {
    }

    public Creature(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getExp() {
        return Exp;
    }

    public void setExp(int exp) {
        Exp = exp;
    }

    public Creature(String id, String description, int hp) {
        this.id = id;
        this.description = description;
        this.hp = hp;
    }

    public String getId() {
        return id;
    }

    public int getMaxhp() {
        return Maxhp;
    }

    public void setMaxhp(int maxhp) {
        Maxhp = maxhp;
    }

    public int getLv() {
        return lv;
    }

    public void setLv(int lv) {
        this.lv = lv;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getExpVR() {
        return ExpVR;
    }

    public void setExpVR(int expVR) {
        ExpVR = expVR;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public ArticleWeapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(ArticleWeapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    public ArrayList<ArticleWeapon> getArticleWeapons() {
        return articleWeapons;
    }

    public void setArticleWeapons(ArrayList<ArticleWeapon> articleWeapons) {
        this.articleWeapons = articleWeapons;
    }
}
