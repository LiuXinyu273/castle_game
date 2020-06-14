package com.lxy.article;

import com.lxy.creature.Creature;

/**
 * @description:
 * @author: lxy
 * @date: Created in 2020/5/13 14:20
 * @version: 1.0
 * @modified By:
 */
public class ArticleAttack extends ArticleWeapon{
    @Override
    public void useArticle(Creature enemyCreature) {
        enemyCreature.setHp(enemyCreature.getHp()+this.getEffectValue());
    }

    public ArticleAttack() {
    }

    public ArticleAttack(String id, String description, int effectValue) {
        super(id, description, effectValue);
    }
}
