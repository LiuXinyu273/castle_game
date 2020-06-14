package com.lxy.handler;

import com.lxy.Sense;


/**
 * @description:
 * @author: lxy
 * @date: Created in 2020/5/7 15:20
 * @version: 1.0
 * @modified By:
 */
public class Handler {
    protected Sense sense;

    public Handler(Sense sense){
        this.sense = sense;
    }

    public void doCmd(String word){

    }

    public boolean isBye(){
        return false;
    }
}
