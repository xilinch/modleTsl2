package cn.leancloud.llls.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.List;

import cn.leancloud.llls.R;
import cn.leancloud.llls.WebviewActivity;
import cn.leancloud.llls.bean.RecomBean;

/**
 * Created by BinaryHB on 11/24/15.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
  private Context mContext;
  private List<RecomBean> mList;

  public MainAdapter(List<RecomBean> list, Context context) {
    this.mContext = context;
    this.mList = list;
  }

  @Override
  public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new MainViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_list_main, parent, false));
  }

  @Override
  public void onBindViewHolder(final MainViewHolder holder, final int position) {
    Log.e("my","onBindViewHolder:position" + " position " + mList.get(position).toString());
    holder.mTitle.setText( mList.get(position).getText());
    holder.mPrice.setText("5颗星");
    holder.mName.setText(mList.get(position).getText());
    Glide.with(mContext).load(mList.get(position).getUrl()).into(new SimpleTarget<GlideDrawable>() {
      @Override
      public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
        Log.e("my","onResourceReady: "+ mList.get(position).getUrl());
        holder.mPicture.setImageDrawable(resource);
      }
    });
    holder.mItem.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(mContext, WebviewActivity.class);
        intent.putExtra("url", mList.get(position).getUrl());
        mContext.startActivity(intent);
      }
    });
  }

  @Override
  public int getItemCount() {
    return mList.size();
  }

  class MainViewHolder extends RecyclerView.ViewHolder {
    private TextView mName;
    private TextView mPrice;
    private TextView mTitle;
    private CardView mItem;
    private ImageView mPicture;

    public MainViewHolder(View itemView) {
      super(itemView);
      mName = (TextView) itemView.findViewById(R.id.name_item_main);
      mTitle = (TextView) itemView.findViewById(R.id.title_item_main);
      mPrice = (TextView) itemView.findViewById(R.id.price_item_main);
      mPicture = (ImageView) itemView.findViewById(R.id.picture_item_main);
      mItem = (CardView) itemView.findViewById(R.id.item_main);
    }
  }
}
