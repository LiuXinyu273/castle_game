package com.lxy.article;

import com.lxy.creature.Creature;

/**
 * @description:
 * @author: lxy
 * @date: Created in 2020/5/13 16:42
 * @version: 1.0
 * @modified By:
 */
public class Aenemy extends ArticleDefense {
    public Aenemy() {
    }

    public Aenemy(String id, String description, int effectValue) {
        super(id, description, effectValue);
    }

    @Override
    public void useArticle(Creature enemyCreature) {
        super.useArticle(enemyCreature);
    }
}
