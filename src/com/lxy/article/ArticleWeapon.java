package com.lxy.article;

import com.lxy.creature.Creature;

/**
 * @description:
 * @author: lxy
 * @date: Created in 2020/5/13 13:28
 * @version: 1.0
 * @modified By:
 */
public abstract class ArticleWeapon extends Article {

    public  void useArticle(Creature enemyCreature){
        enemyCreature.setHp(enemyCreature.getHp()+this.getEffectValue());
    }

    public ArticleWeapon() {
    }

    public ArticleWeapon(String id, String description, int effectValue) {
        super(id, description, effectValue);
    }
}
