package com.lxy.handler;

import com.lxy.Sense;

/**
 * @description:
 * @author: lxy
 * @date: Created in 2020/5/7 15:21
 * @version: 1.0
 * @modified By:
 */
public class HandlerHelp extends Handler {

    public HandlerHelp(Sense sense) {
        super(sense);
    }

    @Override
    public void doCmd(String word) {
        System.out.println("新手玩家必看攻略如下:");
        System.out.println("你可以做的命令有: bye help chop");
        System.out.println("如：\tchop zom(enemy)");
        System.out.println("当你斩杀当前场景的敌人后，可前往下一场景！并且可以使用 'go' 命令");
        System.out.println("如：\tgo room(房间id)");
        System.out.println("玩家可进行升级,每100经验值升一级,每级所需经验值上升20点,升级后最大攻击力上升10点,最大生命值上升20点,且生命值回满");
        System.out.println("当然,你可以使用 'bye' 命令，退出游戏，记得下次再来噢！");
    }
}
