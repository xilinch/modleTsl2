package cn.leancloud.llls.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.leancloud.llls.R;
import cn.leancloud.llls.adapter.MainAdapter;
import cn.leancloud.llls.bean.RecomBean;

/**
 * describe 该类主要完成以下功能
 */

public class MainFragment extends Fragment {

    private RecyclerView recyclerView;

    private View view;

    private MainAdapter adapter;

    String[] icons = new String[]{
            "https://pic.nfapp.southcn.com/nfplus/ossfs/pic/xy/201809/09/t2_(98X0X461X440)5b94f1e63a8b050474bf4a98_watermark_batchwm.jpg",
            "https://pic.nfapp.southcn.com/nfplus/ossfs/pic/xy/201809/09/t2_(98X0X461X440)5b94f1e63a8b050474bf4a98_watermark_batchwm.jpg",
            "https://pic.nfapp.southcn.com/nfplus/ossfs/pic/xy/201809/09/t2_(98X0X461X440)5b94f1e63a8b050474bf4a98_watermark_batchwm.jpg",
            "http://img5.imgtn.bdimg.com/it/u=420216615,387325622&fm=26&gp=0.jpg",
            "http://cdn.duitang.com/uploads/item/201408/07/20140807210445_N2kSm.jpeg",
            "http://img5.duitang.com/uploads/item/201408/07/20140807205756_wBYNA.jpeg",
            "http://www.pptbz.com/d/file/p/201708/5f02b5fb092cc2c3773b893f69158532.jpg",
            "http://img.zcool.cn/community/01a96055af3e216ac72581786e03ce.jpg@1280w_1l_2o_100sh.jpg",
            "http://img.zcool.cn/community/01c61356415a3532f87512f62f2fc6.jpg@1280w_1l_2o_100sh.jpg",
            "http://pic.pptbz.com/201506/2015070579126777.JPG"
    };

    String[] titles = new String[]{
            "推荐彩票",
            "新浪",
            "百度",
            "好123",
            "新华社",
            "腾讯",
            "万维网",
            "CNN",
            "中华军事网",
            "网易新闻",
            "广告",
    };

    String[] urls = new String[]{
            "http://103.17.119.82/tg15.html",
            "http://103.17.119.82/tg15.html",
            "http://www.sina.com",
            "http://www.baidu.com",
            "http://www.hao123.com",
            "http://www.126.com",
            "http://www.qq.com",
            "http://wwww.163.com",
            "http://www.cnn.com",
            "https://military.china.com/",
            "https://news.163.com/"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view == null){
            view = inflater.inflate(R.layout.fragment_main, container,false);
            recyclerView = (RecyclerView) view.findViewById(R.id.list_main);

            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            List<RecomBean> list = new ArrayList<>();
            for(int i = 0;i < 10; i ++){
                RecomBean recomBean = new RecomBean();
                recomBean.setId(i);
                recomBean.setIcon(icons[i % icons.length]);
                recomBean.setText(titles[i%titles.length]);
                recomBean.setUrl(urls[i%urls.length]);
                list.add(recomBean);
            }
            Log.e("my","onCreateView:" + list.toString());
            adapter = new MainAdapter(list, getContext());
            recyclerView.setAdapter(adapter);

        }
        return view;
    }
}
