package cn.leancloud.llls;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 *
 * describe 该类主要完成以下功能
 * 1.显示引导页
 */

public class GuidActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private Button button;
    // 引导图片资源
    private ArrayList<View> pageview;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_guide);
        initView();
    }


    private void initView(){
        ImageView view1 = new ImageView(this);
        view1.setScaleType(ImageView.ScaleType.FIT_CENTER);
        view1.setBackgroundResource(R.mipmap.bg);
        ImageView view2 = new ImageView(this);
        view2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        view2.setBackgroundResource(R.mipmap.bg2);
        pageview = new ArrayList<View>();
        pageview.add(view1);
        pageview.add(view2);
        button = (Button) findViewById(R.id.imgbutton_help_finish);
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new SlideImageAdapter());
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int arg0) {
                Log.e("my","onPageSelected  ：" + arg0);
                if (arg0 == pageview.size() - 1) {
                    button.setVisibility(View.VISIBLE);
                } else {
                    button.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
//                if (arg0 == 0) {
//                    int Alpha = (int) (255 * arg1);
//                    button.setAlpha(Alpha);
//                }
//                if (arg0 == 2) {
//                    button.setVisibility(View.VISIBLE);
//                    button.setAlpha(1.0f);
//                }
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GuidActivity.this, MainActivity1.class);
                startActivity(intent);
                finish();
            }
        });
    }


    private class SlideImageAdapter extends PagerAdapter {
        @Override
        //获取当前窗体界面数
        public int getCount() {
            return pageview.size();
        }

        @Override
        //断是否由对象生成界面
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        //是从ViewGroup中移出当前View
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView(pageview.get(arg1));
        }

        //返回一个对象，这个对象表明了PagerAdapter适配器选择哪个对象放在当前的ViewPager中
        public Object instantiateItem(View arg0, int arg1) {
            ((ViewPager) arg0).addView(pageview.get(arg1));
            return pageview.get(arg1);
        }
    }
}
