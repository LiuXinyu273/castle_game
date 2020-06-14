package com.lxy.creature;

import com.lxy.article.ArticleWeapon;

/**
 * @description:
 * @author: lxy
 * @date: Created in 2020/5/13 15:20
 * @version: 1.0
 * @modified By:
 */
public class Monsterqianye extends Monster{
    @Override
    public void attack(ArticleWeapon articleWeapon, Creature enemy) {
        articleWeapon.useArticle(enemy);
    }

}
