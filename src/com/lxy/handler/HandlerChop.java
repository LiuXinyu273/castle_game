package com.lxy.handler;

import com.lxy.Sense;
import com.lxy.creature.Monster;


/**
 * @description:
 * @author: lxy
 * @date: Created in 2020/5/7 15:20
 * @version: 1.0
 * @modified By:
 */
public class HandlerChop extends Handler{
    public HandlerChop(Sense sense) {
        super(sense);
    }

    @Override
    public void doCmd(String word) {
        boolean flag = true;
        for (Monster monsters: sense.getMonsterSet().getMonsters()
        ){
            if (word.equals(monsters.getId())){
                sense.getPerson().attack(sense.getPerson().getCurrentWeapon(),monsters);
                monsters.attack(monsters.getCurrentWeapon(),sense.getPerson());
                sense.getPerson().Addblood(sense.getPerson().getArticleWeapons().get(0));
                flag = false;
            }
        }
        if (flag)
            System.out.println("没有此敌人，请攻击正确的敌人！否则你将会被敌人强力攻击！");
        sense.showPromptAndProcess();

    }

}
