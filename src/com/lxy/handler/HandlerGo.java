package com.lxy.handler;

import com.lxy.Sense;

/**
 * @description:
 * @author: lxy
 * @date: Created in 2020/5/7 15:21
 * @version: 1.0
 * @modified By:
 */
public class HandlerGo extends Handler {
    public HandlerGo(Sense sense) {
        super(sense);
    }

    @Override
    public void doCmd(String word) {
        sense.goRoom(word);
    }
}
