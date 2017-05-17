package com.hanrui.android.puzzle.adapter;

import android.R.color;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.hanrui.android.puzzle.util.ScreenUtil;

import java.util.List;

/**
 * Created by Administrator on 2017/5/17 0017.
 */

public class GridPicListAdapter extends BaseAdapter{
    //映射List
    private List<Bitmap>picList;
    private Context mContext;
    public GridPicListAdapter(Context context,List<Bitmap> picList){
        this.mContext=context;
        this.picList=picList;
    }
    public int getCount(){
        return picList.size();
    }

    public Object getItem(int position){
        return picList.get(position);
    }

    public long getItemId(int position){
        return position;
    }

    public View getView(int position,View convertView,ViewGroup arg2){
        ImageView iv_pic_item=null;
        int density=(int) ScreenUtil.getDeviceDensity(mContext);//获取设备屏幕density
        if(convertView==null){
            iv_pic_item=new ImageView(mContext);
            //设置布局图片
            iv_pic_item.setLayoutParams(new GridView.LayoutParams(80*density,100*density));
            //设置显示比例
            iv_pic_item.setScaleType(ImageView.ScaleType.FIT_XY);
        }else{
            iv_pic_item=(ImageView)convertView;
        }
        iv_pic_item.setBackgroundColor(color.black);
        iv_pic_item.setImageBitmap(picList.get(position));
        return iv_pic_item;
    }
}
