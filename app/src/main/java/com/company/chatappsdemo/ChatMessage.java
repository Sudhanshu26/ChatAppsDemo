package com.company.chatappsdemo;

/**
 * Created by sudhanshu on 30/9/15.
 */
public class ChatMessage {
   public boolean left;
    private  String message;

    public ChatMessage(boolean left, String message) {
        super();
        this.left = left;
        this.message = message;

    }

    @Override
    public String toString() {
        return message;
        //return super.toString();
    }
}
