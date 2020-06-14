package com.lxy.article;

import com.lxy.creature.Creature;

/**
 * @description:
 * @author: lxy
 * @date: Created in 2020/5/13 13:56
 * @version: 1.0
 * @modified By:
 */
public class BaseAttack extends ArticleAttack {

    @Override
    public void useArticle(Creature enemyCreature) {
        enemyCreature.setHp(enemyCreature.getHp()+this.getEffectValue());
    }

    public BaseAttack() {
    }

    public BaseAttack(String id, String description, int effectValue) {
        super(id, description, effectValue);
    }
}
