package com.hanrui.android.puzzle;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.hanrui.android.puzzle.adapter.GridPicListAdapter;
import com.hanrui.android.puzzle.util.ScreenUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //GridView显示图片
    private GridView mGridView;
    private List<Bitmap>mPicList;

    //显示Type
    private PopupWindow mPopupWindow;
    private View mPopupView;
    private TextView mTvPuzzleMainTypeSelected;
    private LayoutInflater mLayoutInflater;
    private TextView mTvType2;
    private TextView mTvType3;
    private TextView mTvType4;

    //游戏类型N*N
    private int mType=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPicList=new ArrayList<Bitmap>();
        //初始化Views
        initViews();
        //数据适配器
        mGridView.setAdapter(new GridPicListAdapter(MainActivity.this,mPicList));

        //显示难度Type
        mTvPuzzleMainTypeSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupShow(v);
            }
        });

    }




    //显示popup window
    private void popupShow(View view){
        int density=(int) ScreenUtil.getDeviceDensity(this);//获取设备屏幕density
        //显示popup window
        mPopupWindow=new PopupWindow(mPopupView,50*density,200*density);//大小
        mPopupWindow.setFocusable(true);//获得焦点
        mPopupWindow.setOutsideTouchable(true);

        //透明背景
        Drawable transpent=new ColorDrawable(Color.TRANSPARENT);
        mPopupWindow.setBackgroundDrawable(transpent);

        //获取位置
        int[]location=new int[2];
        view.getLocationOnScreen(location);
        mPopupWindow.showAtLocation(view,
                Gravity.NO_GRAVITY,
                location[0]-40*density,
                location[1]+30*density
        );
    }

    //初始化Views
    private void initViews(){
        mGridView=(GridView)findViewById(R.id.gv_puzzle_main_pic_list);
        int[]imageId=new int[]{R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,
                R.drawable.pic5,R.drawable.pic6,R.drawable.pic7,R.drawable.pic8,R.drawable.pic8,R.drawable.pic9,
                R.drawable.pic10,R.drawable.pic11,R.drawable.pic11,R.drawable.pic12,R.drawable.pic13,R.drawable.pic14,
                R.drawable.pic15,R.mipmap.ic_launcher};
        Bitmap[]bitmaps=new Bitmap[imageId.length];
        for(int i=0;i<bitmaps.length;i++){
            bitmaps[i]= BitmapFactory.decodeResource(getResources(),imageId[i]);//加载图片
            mPicList.add(bitmaps[i]);
        }

        //显示type
        mTvPuzzleMainTypeSelected=(TextView)findViewById(
            R.id.tv_puzzle_main_type_selected);
        mLayoutInflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        //mType view
        mPopupView=mLayoutInflater.inflate(R.layout.puzzle_main_type_selected,null);
        mTvType2=(TextView)mPopupView.findViewById(R.id.tv_main_type_2);
        mTvType3=(TextView)mPopupView.findViewById(R.id.tv_main_type_3);
        mTvType4=(TextView)mPopupView.findViewById(R.id.tv_main_type_4);
        //监听事件
        mTvType2.setOnClickListener(this);
        mTvType3.setOnClickListener(this);
        mTvType4.setOnClickListener(this);

    }

    //popup window item点击事件
    public void onClick(View v){
        switch(v.getId()){
            case R.id.tv_main_type_2:
                mType=2;
                mTvPuzzleMainTypeSelected.setText("2×2");
                break;
            case R.id.tv_main_type_3:
                mType=3;
                mTvPuzzleMainTypeSelected.setText("3×3");
                break;
            case R.id.tv_main_type_4:
                mType=4;
                mTvPuzzleMainTypeSelected.setText("4×4");
                break;
            default:
                break;
        }
        mPopupWindow.dismiss();
    }
}
