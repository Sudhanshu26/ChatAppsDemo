package com.company.chatappsdemo;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private ArrayAdapter<ChatMessage> adp;

    private ListView list;
    private EditText chatText;
    private Button send;
    private boolean side =false;
    public int m=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send = (Button) findViewById(R.id.btn);
        list = (ListView) findViewById(R.id.listView1);
        List<ChatMessage> mensajes = new ArrayList<ChatMessage>();
        mensajes.add(new ChatMessage(false,"first message"));

        adp = new ArrayAdapter<ChatMessage>(getApplicationContext(),android.R.layout.simple_list_item_1,mensajes);
        //View vv= adp.getView(0,null,null);

        chatText = (EditText) findViewById(R.id.chat);

        chatText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if ((event.getAction() == KeyEvent.ACTION_DOWN) && keyCode == KeyEvent.KEYCODE_ENTER) {
                    return sendChatMessage();

                }


                return false;
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            sendChatMessage();
        }
    });
        list.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        list.setAdapter(adp);
        adp.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
            list.setSelection(adp.getCount()-1);
            }
        });
    }



    private boolean sendChatMessage() {

        adp.add(new ChatMessage(side, chatText.getText().toString()));
        chatText.setText("");
       side=!side;

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
