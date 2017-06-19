package com.example.administrator.listviewcheckbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private boolean boo=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview= (ListView) findViewById(R.id.listview);
        Button button= (Button) findViewById(R.id.btn);
        Button button2= (Button) findViewById(R.id.btn2);

        final List<MyBean> beanlist=new ArrayList<>();
        for (int i = 0; i <100 ; i++) {
            MyBean bean=new MyBean();
            bean.setConnect(i+"");
            bean.setCheckbox(false);
            beanlist.add(bean);
        }
        final MyAdapter adapter = new MyAdapter(MainActivity.this, beanlist);
        listview.setAdapter(adapter);
//反选按钮的监听；
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i <beanlist.size() ; i++) {
                    boolean b = beanlist.get(i).isCheckbox();
                    if(b){
                        beanlist.get(i).setCheckbox(false);

                    }else{
                        beanlist.get(i).setCheckbox(true);

                    }
                    adapter.notifyDataSetChanged();
                }
            }
        });
//全选按钮的监听；
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(boo){
                    for (int i = 0; i <beanlist.size() ; i++) {
                        beanlist.get(i).setCheckbox(true);
                        boo=false;
                    }
                }else{
                    for (int i = 0; i <beanlist.size() ; i++) {
                        beanlist.get(i).setCheckbox(false);
                        boo=true;
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });
    }
}
