package com.lxy.article;

import com.lxy.creature.Creature;

/**
 * @description:
 * @author: lxy
 * @date: Created in 2020/5/13 15:00
 * @version: 1.0
 * @modified By:
 */
public class ArticleDefense extends ArticleWeapon{

    @Override
    public void useArticle(Creature enemyCreature) {
        super.useArticle(enemyCreature);
    }

    public ArticleDefense() {
    }

    public ArticleDefense(String id, String description, int effectValue) {
        super(id, description, effectValue);
    }
}
