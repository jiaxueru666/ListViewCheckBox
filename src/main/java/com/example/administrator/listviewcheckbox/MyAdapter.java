package com.example.administrator.listviewcheckbox;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * date:2017/6/7 0007
 * authom:贾雪茹
 * function:
 */

public class MyAdapter extends BaseAdapter{
    private Context context;
    private List<MyBean>mylist;

    public MyAdapter(Context context, List<MyBean> mylist) {
        this.context = context;
        this.mylist = mylist;
    }

    @Override
    public int getCount() {
        return mylist.size();
    }

    @Override
    public Object getItem(int i) {
        return mylist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final  int i, View view, ViewGroup viewGroup) {
        final MyHolder holder;
        if(view==null){
            holder=new MyHolder();
            view=View.inflate(context,R.layout.items,null);
            holder.text= (TextView) view.findViewById(R.id.textview);
            holder.cbox= (CheckBox) view.findViewById(R.id.cbox);

            view.setTag(holder);
        }else{
            holder= (MyHolder) view.getTag();
        }
        //赋值
        holder.text.setText(mylist.get(i).getConnect());
        holder.cbox.setChecked(mylist.get(i).isCheckbox());

        holder.cbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //当checkbox状态为选中时，再次点击将他的状态改变成false；
              if(mylist.get(i).isCheckbox()){
                 mylist.get(i).setCheckbox(false);
                  //同时将复用的控件的状态也变成false；
                  holder.cbox.setChecked(false);
              }else{
                  mylist.get(i).setCheckbox(true);
                  holder.cbox.setChecked(true);
              }
                //刷新；
                notifyDataSetChanged();
            }
        });
        return view;
    }
    class MyHolder{
        TextView text;
        CheckBox cbox;
    }
}
