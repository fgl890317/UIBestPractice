package com.example.administrator.uibestpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView msgListView;
    private EditText inputText;
    private MsgAdapter adapter;
    private List<Msg> msgList=new ArrayList < Msg> ();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMegs();
        adapter=new MsgAdapter(MainActivity.this,R.layout.msg_item,msgList);
        inputText= (EditText) findViewById(R.id.input_text);
        msgListView= (ListView) findViewById(R.id.msg_list_view);
        msgListView.setAdapter(adapter);
        findViewById(R.id.send).setOnClickListener(this);
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
    private void initMegs(){
        Msg msg1=new Msg("hello guy",Msg.TYPE_RECEIVE);
        msgList.add(msg1);
        Msg msg2=new Msg("hello who is that",Msg.TYPE_SEND);
        msgList.add(msg2);
        Msg msg3=new Msg("This is tom,.nice to you",Msg.TYPE_RECEIVE);
        msgList.add(msg3);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.send:
                String content=inputText.getText().toString();
                if(!"".equals(content)){
                    Msg msg=new Msg(content,Msg.TYPE_SEND);
                    msgList.add(msg);
                    adapter.notifyDataSetChanged();
                    msgListView.setSelection(msgList.size());
                    inputText.setText("");
                }
                break;
        }
    }
}
