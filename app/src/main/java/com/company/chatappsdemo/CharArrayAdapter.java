package com.company.chatappsdemo;

import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.view.Gravity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
//import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sudhanshu on 30/9/15.
 */
public class CharArrayAdapter extends ArrayAdapter<ChatMessage>{
    //private TextView charText;
    private List<ChatMessage> messageList = new ArrayList<ChatMessage>();
    private LinearLayout layout;

    public CharArrayAdapter(Context applicationContext, int textViewResourceId,List<ChatMessage>objects) {
        super(applicationContext, textViewResourceId, objects);
    }

    public void add(ChatMessage objects) {

        messageList.add(objects);
        super.add(objects);
        //View vv=getView(0,null,);
        //vv.setText(objects.toString());
    }
    public int getCount(){
        return this.messageList.size();
    }

    public ChatMessage getItem(int index){
        return this.messageList.get(index);
    }

    public View getView(int position,View convertView,ViewGroup parent){

        ChatMessage message =messageList.get(position);
        View v = convertView;
        if(v==null){

            LayoutInflater inflator = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);


            if(getItemViewType(position)==0){
                v = inflator.inflate(R.layout.msg_he,parent,false);}
            else{
                v=inflator.inflate(R.layout.msg_she,parent,false);}//v = inflator.inflate(R.layout.chat,parent,false);

        }
        layout = (LinearLayout)v.findViewById(R.id.message1);
        ChatMessage messageobj = getItem(position);
        TextView charText = (TextView)v.findViewById(R.id.SingleMessage);
        charText.setText(messageobj.toString());

        layout.setGravity(messageobj.left? Gravity.LEFT:Gravity.RIGHT);

        return  v;
    }

//    public Bitmap decodeToBitMap(byte[] decodedByte){
//        return BitmapFactory.decodeByteArray(decodedByte,0,decodedByte.length);
//    }


}
