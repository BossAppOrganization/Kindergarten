package com.huida.kindergarten.activity.fragment;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.huida.kindergarten.R;
import com.huida.kindergarten.activity.activity.recopeActivity;

import java.util.ArrayList;

/**
 * Created by 赵发
 * 2017/10/23.
 */

public class fragment_class extends BaseFragment {


    private ListView lv_class_teacher;
    private MyAdapter adapter;
    private ArrayList<String> list;
    private String text[]={"小赵","小钱","小孙","小李","小赵"};
    private Button recope;

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.activity_class, null);
        lv_class_teacher = (ListView) view.findViewById(R.id.lv_class_teacher);
        recope = (Button) view.findViewById(R.id.bt_class_recope);

        return view;
    }

    @Override
    protected void initListener() {
           recope.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(mActivity, recopeActivity.class);
               }
           });
    }

    @Override
    protected void initData() {
        list = new ArrayList<>();
        for (int i = 0; i <text.length-1 ; i++) {

            list.add(text[i]);


        }
        adapter = new MyAdapter();
        lv_class_teacher.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {

    }

     class MyAdapter extends BaseAdapter{
         @Override
         public int getCount() {
             return list.size();
         }

         @Override
         public Object getItem(int position) {
             return position;
         }

         @Override
         public long getItemId(int position) {
             return 0;
         }

         @Override
         public View getView(int position, View convertView, ViewGroup parent) {
             ViewHolder holder;
          if(convertView==null){
              convertView = View.inflate(mActivity, R.layout.activity_class_listview_item, null);

               holder = new ViewHolder();
              holder.tv_class_text = (TextView) convertView.findViewById(R.id.tv_class_text);

              convertView.setTag(holder);

          }else {

              holder= (ViewHolder) convertView.getTag();

          }
              holder.tv_class_text.setText(list.get(position));

             return convertView;
         }
         class ViewHolder{
             public TextView tv_class_text;
         }
     }


}
