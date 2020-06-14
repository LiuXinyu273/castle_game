package com.lxy;

import com.lxy.article.Aenemy;
import com.lxy.article.Attackweapeon;
import com.lxy.article.BaseAttack;
import com.lxy.creature.*;
import com.lxy.handler.*;

import java.util.HashMap;
import java.util.Scanner;


/**
 * @description:
 * @author: lxy
 * @date: Created in 2020/5/12 15:25
 * @version: 1.0
 * @modified By:
 */
public class Sense {
    Person person = new Person();

    Monsterchonglou monsterchonglou = new Monsterchonglou();
    Monsterqianye monsterqianye = new Monsterqianye();
    Monsterxuanxiao monsterxuanxiao = new Monsterxuanxiao();
    Monsterkumu monsterkumu = new Monsterkumu();
    Monsterbaiyue Monsterbaiyue = new Monsterbaiyue();

    MonsterSet monsterSet = new MonsterSet();
    RoomSet roomSet = new RoomSet();

    private HashMap<String, Handler> handlders =new HashMap<String, Handler>();



    public Sense(){
        handlders.put("go", new HandlerGo(this));
        handlders.put("bye", new HandlerBye(this));
        handlders.put("help",new HandlerHelp(this));
        handlders.put(("chop"),new HandlerChop(this));

        initRoom();
    }



    public void initSence(){
        initPerson();
        initMonster();
        initRoom();
    }

    public void initRoom(){
        Room room1,room2,room3,room4,room5,room6;
        room1 = new Room("r1","江都");
        room2 = new Room("r2","九顶山");
        room3 = new Room("r3","古藤林");
        room4 = new Room("r4","蜀山古道");
        room5 = new Room("r5","灵儿仙人洞");
        room6 = new Room("r6","成功逃出");

        room1.setExits("r2",room2);
        room2.setExits("r3",room3);
        room3.setExits("r4",room4);
        room4.setExits("r5",room5);
        room5.setExits("r6",room6);

        roomSet.getRooms().add(room1);
        roomSet.getRooms().add(room2);
        roomSet.getRooms().add(room3);
        roomSet.getRooms().add(room4);
        roomSet.getRooms().add(room5);
        roomSet.getRooms().add(room6);

        person.setCurrentRoom(room1);
    }

    public void goRoom(String direction)
    {
        Room nextRoom = person.getCurrentRoom().getExit(direction);

        if (nextRoom == null) {
            System.out.println("没有这个房间，请重新输入！");
        }
        else {
            person.setCurrentRoom(nextRoom);
        }
        showPromptAndProcess();
    }

    public void initPerson(){
        //
        person.setId("p1");
        person.setDescription("穿越者");
        person.setHp(200);
        person.setMaxhp(200);
        person.setLv(1);
        person.setExp(0);
        person.setExpVR(100);
        //防具
        person.setCurrentWeapon(new Aenemy("A1","布衣",10));
        person.getArticleWeapons().add(0,person.getCurrentWeapon());
        //武器
        person.setCurrentWeapon(new Attackweapeon("k1","拳头",-30));
        person.getArticleWeapons().add(1,person.getCurrentWeapon());

    }

    public void initMonster(){

        monsterchonglou.setId("chonglou");
        monsterchonglou.setDescription("重楼");
        monsterchonglou.setHp(50);
        monsterchonglou.setLeftExp(60);
        monsterchonglou.setCurrentRoom(roomSet.getRooms().get(0));
        monsterchonglou.setCurrentWeapon(new BaseAttack("shoes","布鞋",-10));

        monsterqianye.setId("qianye");
        monsterqianye.setDescription("千叶");
        monsterqianye.setHp(80);
        monsterqianye.setLeftExp(80);
        monsterqianye.setCurrentRoom(roomSet.getRooms().get(1));
        monsterqianye.setCurrentWeapon(new BaseAttack("strap","蛇鞭",-20));


        monsterxuanxiao.setId("xuanxiao");
        monsterxuanxiao.setDescription("玄霄");
        monsterxuanxiao.setHp(100);
        monsterxuanxiao.setLeftExp(100);
        monsterxuanxiao.setCurrentRoom(roomSet.getRooms().get(2));
        monsterxuanxiao.setCurrentWeapon(new BaseAttack("knife","大刀",-50));

        monsterkumu.setId("kumu");
        monsterkumu.setDescription("枯木");
        monsterkumu.setHp(120);
        monsterkumu.setLeftExp(90);
        monsterkumu.setCurrentRoom(roomSet.getRooms().get(3));
        monsterkumu.setCurrentWeapon(new BaseAttack("spear","长矛",-40));

        Monsterbaiyue.setId("baiyue");
        Monsterbaiyue.setDescription("拜月");
        Monsterbaiyue.setHp(200);
        Monsterbaiyue.setCurrentRoom(roomSet.getRooms().get(4));
        Monsterbaiyue.setCurrentWeapon(new BaseAttack("heart","阴霾",-50));


        monsterSet.getMonsters().add(0, monsterchonglou);
        monsterSet.getMonsters().add(1, monsterqianye);
        monsterSet.getMonsters().add(2, monsterxuanxiao);
        monsterSet.getMonsters().add(3, monsterkumu);
        monsterSet.getMonsters().add(4, Monsterbaiyue);

    }

    public void printWelcome() {
        System.out.println();
        System.out.println("恭喜你成为一名侠客！");
        System.out.println("这里是仙剑奇侠传模式！");
        System.out.println("你需要打败每个房间的怪物以获得胜利！");
        System.out.println("当你通关后，便可进击蓬莱仙岛了！");
        System.out.println("不知道怎么玩？输入 help试试看！");
        System.out.println();
        showPromptAndProcess();
    }

    public void showPromptAndProcess(){
        boolean flag = false;
        System.out.println("==============================================================================");
        System.out.print("此处的敌人有:  ");//敌人属性
        for (Monster monsters: monsterSet.getMonsters()
             ) {
            if (monsters.getCurrentRoom().getId().equals(person.getCurrentRoom().getId())){
                if (monsters.getHp() <= 0) {//记录敌人死亡
                    monsters.setHp(0);
                    flag = true;
                    person.getEnemyExp(monsters);//人获取经验值
                    person.upGrade();
                }
                System.out.println(monsters.getId()+"  "+monsters.getDescription()+"  血量: "+monsters.getHp()+
                        "  攻击力: "+-monsters.getCurrentWeapon().getEffectValue());
                break;
            }
        }
        System.out.print(person.getDescription()+" 你目前在  " + person.getCurrentRoom());//你的状态
        System.out.println("  你的状态: 血量: "+person.getHp()+"  等级: "+person.getLv()+"  当前经验值: "+person.getExp()+
                "  武器: "+person.getCurrentWeapon().getDescription()+
                "  攻击力: "+-person.getCurrentWeapon().getEffectValue()+
                "  防具: " +person.getArticleWeapons().get(0).getDescription()+"  防御力: "
                +person.getArticleWeapons().get(0).getEffectValue());

        if (flag)
            ProcessOptimization();
        System.out.println("==============================================================================");
    }

    public void ProcessOptimization(){
            System.out.println("当前房间敌人已死亡，可前往下一关！");
            System.out.print("你可以前往 ");
            System.out.print(person.getCurrentRoom().getExitDesc());
            System.out.println(roomSet.getRooms().get(roomSet.getRooms().indexOf(person.getCurrentRoom())+1));
    }

    public void play(){
        Scanner in = new Scanner(System.in);
        while (true) {
            String line = in.nextLine();
            String[] words = line.split(" ");
            Handler handler = handlders.get(words[0]);
            String value = "";
            if (words.length > 1){
                value = words[1];
            }

            if (monsterSet.getMonsters().get(4).getHp() == 0 ){
                //结束语句
                System.out.println("恭喜您已经通关完成！");
                System.out.println("现在您可以进击蓬莱仙岛了！");
                break;
            }
            else if (handler != null) {
                handler.doCmd(value);
                if (handler.isBye())
                    break;
            }
            else {
                System.out.println("输入错误命令，重新输入。");
            }
        }
        System.out.println("感谢您的游玩！");
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Monsterchonglou getMonsterchonglou() {
        return monsterchonglou;
    }

    public void setMonsterchonglou(Monsterchonglou monsterchonglou) {
        this.monsterchonglou = monsterchonglou;
    }

    public Monsterqianye getMonsterqianye() {
        return monsterqianye;
    }

    public void setMonsterqianye(Monsterqianye monsterqianye) {
        this.monsterqianye = monsterqianye;
    }

    public Monsterxuanxiao getMonsterxuanxiao() {
        return monsterxuanxiao;
    }

    public void setMonsterxuanxiao(Monsterxuanxiao monsterxuanxiao) {
        this.monsterxuanxiao = monsterxuanxiao;
    }

    public Monsterkumu getMonsterkumu() {
        return monsterkumu;
    }

    public void setMonsterkumu(Monsterkumu monsterkumu) {
        this.monsterkumu = monsterkumu;
    }

    public Monsterbaiyue getMonsterbaiyue() {
        return Monsterbaiyue;
    }

    public void setMonsterbaiyue(Monsterbaiyue monsterbaiyue) {
        this.Monsterbaiyue = monsterbaiyue;
    }

    public MonsterSet getMonsterSet() {
        return monsterSet;
    }

    public void setMonsterSet(MonsterSet monsterSet) {
        this.monsterSet = monsterSet;
    }

    public RoomSet getRoomSet() {
        return roomSet;
    }

    public void setRoomSet(RoomSet roomSet) {
        this.roomSet = roomSet;
    }

    public HashMap<String, Handler> getHandlders() {
        return handlders;
    }

    public void setHandlders(HashMap<String, Handler> handlders) {
        this.handlders = handlders;
    }
}
