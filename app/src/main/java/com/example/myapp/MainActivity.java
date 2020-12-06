package com.example.myapp;


import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import  java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
private ViewGroup mViewPager;
private PagerAdapter mAdapter;
private List<View>mViews=new ArrayList<>();

private LinearLayout mTab1;
    private LinearLayout mTab2;
    private LinearLayout mTab3;

    private Button mBnt1;
    private Button mBnt2;
    private Button mBnt3;

    @Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);

    initView();
    initEvents();

}

private  void initEvents(){
        mTab1.setOnClickListener(this);
    mTab2.setOnClickListener(this);
    mTab3.setOnClickListener(this);


    mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){
        @Override
        public void onPageScrolled(int position,float positionOffset,int positionOffsetPixels) {
            int currentItem = mViewPager.getCurrentItem();
            resetImg();

            switch (currentItem) {
                case 0:
                    mBnt1.setImagerResource(R.drawable.tab2);
                    break;
                case 1:
                    mBnt2.setImagerResource(R.drawable.tab2);
                    break;
                case 2:
                    mBnt3.setImagerResource(R.drawable.tab3);
                    break;
                default:
                    break;
            }
        }
            @Override
            public void onPageScrollStateChanged ( int state){

            }

        });

    }
    public void initView(){
        mViewPager=(ViewPager)findViewById(R.id.viewpager);

        mTab1=(LinearLayout)findViewById(R.id.tab1);
        mTab1=(LinearLayout)findViewById(R.id.tab2);
        mTab1=(LinearLayout)findViewById(R.id.tab3);
        mBnt1=(Button)findeViewById(R.id.but1);
        mBnt1=(Button)findeViewById(R.id.but2);
        mBnt1=(Button)findeViewById(R.id.but3);

        LayoutInflater mInflater = LayoutInflater.from(this);

        View tab01=mInflater.inflate(R.layout.tab01,null);
        View tab02=mInflater.inflate(R.layout.tab02,null);
        View tab03=mInflater.inflate(R.layout.tab03,null);

        mViews.add(tab01);
        mViews.add(tab02);
        mViews.add(tab03);

        mAdapter=new PagerAdapter() {
            @Override
            public void destroyItem(ViewGroup container,int position){
                container.removeView(mViews.get(position));}

                @Override
                        public Object instantiareItem(ViewGroup container,int position){
                View view=mViews.get(position);
                container.addView(view);
                return view;
            }
            @Override
            public int getCount() {
                return mViews.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view==object;
            }

        };
        mViewPager.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View v){
        restImg();

        switch (v.getId()) {
            case R.id.tab1:
                mViewPager.setCurrentItem(0);
                mBnt1.setImageResource(R.drawable.tab1);
                break;
            case R.id.tab2:
                mViewPager.setCurrentItem(1);
                mBnt1.setImageResource(R.drawable.tab2);
                break;
            case R.id.tab3:
                mViewPager.setCurrentItem(2);
                mBnt1.setImageResource(R.drawable.tab3);
                break;
            default:
                break;
        }
        }
        private  void resetImg(){
        mBnt1.setImageResource(R.drawable.ic_launcher_background);
            mBnt2.setImageResource(R.drawable.ic_launcher_background);
            mBnt3.setImageResource(R.drawable.ic_launcher_background);

    }
}

