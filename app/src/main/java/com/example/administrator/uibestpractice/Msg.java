package com.example.administrator.uibestpractice;

import java.lang.ref.PhantomReference;

/**
 * Created by Administrator on 2015/8/29.
 */
public class Msg {
    public static final int TYPE_RECEIVE=0;
    public static final int TYPE_SEND=1;
    private String content;
    private int type;
    public Msg(String content,int type){
        this.content=content;
        this.type=type;

    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
}
