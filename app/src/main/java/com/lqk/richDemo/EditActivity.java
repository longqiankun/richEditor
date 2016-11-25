package com.lqk.richDemo;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lqk.richeditor.view.EditWalkView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import org.xwalk.core.XWalkPreferences;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




public class EditActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 输入内容
     */
    EditWalkView mEtEditDiaryContent;
    /**
     * 黑体
     */
    ImageButton mBtnRichBarBold;
    ImageButton pic;
    /**
     * 删除线
     */
    ImageButton mBtnRichBarStrikeThrough;
    /**
     * 无序列表
     */
    ImageButton mBtnRichBarBullet;
    /**
     * 有序列表
     */
    ImageButton mBtnRichBarListNumber;
    /**
     * 字体颜色
     */
    ImageButton mBtnRichBarTextColor;
    /**
     * 字体大小
     */
    ImageButton mBtnRichBarTextSize;
    View mLinRichBarTextSizeDivider;
    /**
     * 改变字体大小栏
     */
    LinearLayout mLinRichBarTextSize;
    /**
     * 默认字体
     */
    TextView mTvDefaultTextSize;
    /**
     * 增大字体
     */
    ImageButton mBtnRichBarTextSizeIncrease;
    /**
     * 减小字体
     */
    ImageButton mBtnRichBarTextSizeDecrease;
    private Context mContext=this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        initView();
        init();
//        XWalkPreferences.setValue("enable-javascript", true);
    }
private void initView(){
    mBtnRichBarTextSizeDecrease=(ImageButton) findViewById(R.id.btn_rich_bar_text_size_decrease);
    mBtnRichBarTextSizeIncrease=(ImageButton) findViewById(R.id.btn_rich_bar_text_size_increase);
    mTvDefaultTextSize=(TextView) findViewById(R.id.tv_default_text_size);
    mLinRichBarTextSize=(LinearLayout) findViewById(R.id.lin_rich_bar_text_size);
    mLinRichBarTextSizeDivider=findViewById(R.id.lin_rich_bar_text_size_divider);
    mBtnRichBarTextSize=(ImageButton) findViewById(R.id.btn_rich_bar_text_size);

     mEtEditDiaryContent=(EditWalkView) findViewById(R.id.et_edit_diary_content);
     mBtnRichBarBold=(ImageButton) findViewById(R.id.btn_rich_bar_bold);

     mBtnRichBarStrikeThrough=(ImageButton) findViewById(R.id.btn_rich_bar_strike_through);

     mBtnRichBarBullet=(ImageButton) findViewById(R.id.btn_rich_bar_bullet);

     mBtnRichBarListNumber=(ImageButton) findViewById(R.id.btn_rich_bar_list_number);
     mBtnRichBarTextColor=(ImageButton) findViewById(R.id.btn_rich_bar_text_color);
    pic=(ImageButton) findViewById(R.id.pic);
}
    protected void init() {
        mBtnRichBarBold.setOnClickListener(this);
        mBtnRichBarBullet.setOnClickListener(this);
        mBtnRichBarListNumber.setOnClickListener(this);
        mBtnRichBarStrikeThrough.setOnClickListener(this);
        pic.setOnClickListener(this);
        mBtnRichBarTextColor.setOnClickListener(this);
        mBtnRichBarTextSize.setOnClickListener(this);
        mBtnRichBarTextSizeDecrease.setOnClickListener(this);
        mBtnRichBarTextSizeIncrease.setOnClickListener(this);
        mTvDefaultTextSize.setOnClickListener(this);
        mEtEditDiaryContent.setEditorFontSize(10);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_rich_bar_bold://黑体
                mEtEditDiaryContent.setBold();
                break;
            case R.id.pic://黑体
//                String picPath= Environment.getExternalStorageDirectory().getAbsolutePath()+"/a20161028155926421.jpg";
                String picPath= Environment.getExternalStorageDirectory().getAbsolutePath()+"/DCIM/Camera/IMG_20161116_132810.jpg";
                mEtEditDiaryContent.insertImage(picPath,"");
               /* Picasso.with(this).load(new File(picPath)).resize(720,1280).into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        String picPath= Environment.getExternalStorageDirectory().getAbsolutePath()+"/aaaa.jpg";
                        File f=new File(picPath);
                        Log.e("TAG",bitmap.getWidth()+"="+bitmap.getHeight());
                        try {
                            if (!f.exists()) f.createNewFile();
                            saveBitmap(bitmap, picPath);
                            mEtEditDiaryContent.insertImage(picPath,"");
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable) {

                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {

                    }
                });*/

                break;
            case R.id.btn_rich_bar_strike_through://删除线
                mEtEditDiaryContent.setStrikeThrough();
             String html=   mEtEditDiaryContent.getHtml();
                Log.e("TAG","-----"+html);
                break;
            case R.id.btn_rich_bar_bullet://无序列表
                mEtEditDiaryContent.setBullets();
                break;
            case R.id.btn_rich_bar_list_number://有序列表
                mEtEditDiaryContent.setNumbers();
                break;
            case R.id.btn_rich_bar_text_color://字体颜色
                showChooseColorDialog();
                break;
            case R.id.btn_rich_bar_text_size://字体大小
                if (View.VISIBLE == mLinRichBarTextSize.getVisibility()) {
                    mLinRichBarTextSize.setVisibility(View.GONE);
                    mLinRichBarTextSizeDivider.setVisibility(View.GONE);
                } else {
                    mLinRichBarTextSize.setVisibility(View.VISIBLE);
                    mLinRichBarTextSizeDivider.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.btn_rich_bar_text_size_increase://增大字体
                mEtEditDiaryContent.setEditorFontSizeBigger();
                break;
            case R.id.btn_rich_bar_text_size_decrease://减小字体
                mEtEditDiaryContent.setEditorFontSmaller();
                break;
            case R.id.tv_default_text_size://默认字体大小
                mEtEditDiaryContent.setEditorFontDefault();
                break;

        }

    }


    private AlertDialog.Builder mDialogBuilder;

    private Dialog mDialog;

    /**
     * 选择颜色对话框
     */
    private void showChooseColorDialog() {
        mDialogBuilder = new AlertDialog.Builder(mContext);
        mDialogBuilder.setCancelable(true);
        GridView selectPanel = (GridView) LayoutInflater.from(mContext).inflate(R.layout.dialog_color_select_panel, null, false);
        final List<ColorPanel> colorPanel = new ArrayList<>();
        colorPanel.add(new ColorPanel(ColorPanel.BLACK));
        colorPanel.add(new ColorPanel(ColorPanel.RED));
        colorPanel.add(new ColorPanel(ColorPanel.ORANGE));
        colorPanel.add(new ColorPanel(ColorPanel.GREEN));
        colorPanel.add(new ColorPanel(ColorPanel.BLUE));
        colorPanel.add(new ColorPanel(ColorPanel.PURPLE));
        selectPanel.setAdapter(new CommonAdapter<ColorPanel>(mContext, colorPanel, R.layout.item_color_select_panel) {
            @Override
            public void convert(Holder holder, ColorPanel color) {
                LinearLayout panel = holder.getView(R.id.card_color_panel);
                panel.setBackgroundColor(color.getColor());
            }
        });
        selectPanel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mEtEditDiaryContent.setTextColor(colorPanel.get(position).getColor());
                mDialog.dismiss();
            }
        });

        mDialogBuilder.setView(selectPanel);
        mDialog = mDialogBuilder.show();
    }
    public void saveBitmap(Bitmap bm,String picName) {
        File f = new File(picName);
        if (f.exists()) {
            f.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(f);
            bm.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch blockØ
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }





}
