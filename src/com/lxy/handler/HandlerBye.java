package com.lxy.handler;

import com.lxy.Sense;

/**
 * @description:
 * @author: lxy
 * @date: Created in 2020/5/7 15:20
 * @version: 1.0
 * @modified By:
 */
public class HandlerBye extends Handler{
    public HandlerBye(Sense sense){
        super(sense);
    }

    @Override
    public void doCmd(String word) {

    }

    @Override
    public boolean isBye() {
        return true;
    }
}
