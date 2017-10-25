package com.huida.kindergarten.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.huida.kindergarten.R;

import java.util.ArrayList;

/**
 * Created by 赵发
 * 2017/10/23.
 */

public class ContentFragment extends FragmentActivity {

    private RadioGroup radioGroup;
    private ViewPager vp_content;
    private RadioButton rb_class;
    private ArrayList<BaseFragment> pagerList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contentfragment);
        initView();
        initDate();
    }
    public void initView() {
        radioGroup = (RadioGroup) findViewById(R.id.rg_content);
        vp_content = (ViewPager) findViewById(R.id.vp_content);
        rb_class = (RadioButton) findViewById(R.id.rb_class);

        radioGroup.check(R.id.rb_class);
    }
    public void initDate() {
        pagerList = new ArrayList<>();
        BaseFragment fragment_class = new fragment_class();
        BaseFragment school = new fragment_school();
        BaseFragment information = new fragment_information();
        BaseFragment mine = new fragment_mine();

        pagerList.add(fragment_class);
        pagerList.add(school);
        pagerList.add(information);
        pagerList.add(mine);

        FragmentManager fm = getSupportFragmentManager();
        myFragmentPagerAdapter mfpa = new myFragmentPagerAdapter(fm,pagerList);
       vp_content.setAdapter(mfpa);

        vp_content.setCurrentItem(0);
        radioGroup.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
    }
    public class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.rb_class:
                    vp_content.setCurrentItem(0);
                    break;
                case R.id.rb_school:
                    vp_content.setCurrentItem(1);
                    break;
                case R.id.rb_add:
                    vp_content.setCurrentItem(2);
                    break;
                case R.id.rb_information:
                    vp_content.setCurrentItem(3);
                    break;
                case R.id.rb_mine:
                    vp_content.setCurrentItem(3);
                    break;
            }
        }
    }
}
