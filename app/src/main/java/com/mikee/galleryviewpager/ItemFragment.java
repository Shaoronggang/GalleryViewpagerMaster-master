package com.mikee.galleryviewpager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemFragment extends Fragment {

    private TextView tvMastername;
    private ImageView ivMaster;
    private TextView tvNationName;
    private TextView tvMasterDes;

    private static final String PARAMS_TITLE = "title";
    private static final String NATION_NAME = "nation";
    private static final String MASTER_DES = "des";
    private static final String IMAGEVIEW = "image";
    private static final String POSITION = "pos";
    private RelativeLayout llFragment;
    private int pos;
    private String[] urls = {
            "http://www.jb51.net/",
            "http://blog.csdn.net/",
            "https://github.com/",
            "http://www.jianshu.com/",
            "http://www.jcodecraeer.com/",
    };


    /**
     * 创建并传值
     *
     * @return
     */
    public static Fragment create(String masterName, String nationName, String masterDes, int imagePath,int position) {
        ItemFragment fragment = new ItemFragment();
        Bundle bundle = new Bundle();
        bundle.putString(PARAMS_TITLE, masterName);
        bundle.putString(NATION_NAME, nationName);
        bundle.putString(MASTER_DES, masterDes);
        bundle.putInt(IMAGEVIEW, imagePath);
        bundle.putInt(POSITION, position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 在这里面进行数据的实例化
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item, container, false);
        tvMastername = (TextView) view.findViewById(R.id.tv_master_name);
        ivMaster = (ImageView) view.findViewById(R.id.iv_master);
        tvNationName = (TextView) view.findViewById(R.id.tv_nation_name);
        tvMasterDes = (TextView) view.findViewById(R.id.tv_master_des);
        llFragment = (RelativeLayout) view.findViewById(R.id.ll_fragment);

        llFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(pos == 2) {
                    Intent intent = new Intent(getActivity(),MyActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(urls[pos]));
//                getActivity().
                    startActivity(intent);
                }
            }
        });

        return view;
    }

    /**
     * 在这里进行数据的绑定，设置
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            tvMastername.setText(bundle.getString(PARAMS_TITLE));
            tvNationName.setText(bundle.getString(NATION_NAME));
            tvMasterDes.setText(bundle.getString(MASTER_DES));
            ivMaster.setImageResource(bundle.getInt(IMAGEVIEW));
            pos = bundle.getInt(POSITION);
        }
    }

    /**
     * 将base64转为bitmap
     *
     * @param string
     * @return
     */
    public Bitmap stringtoBitmap(String string) {
        // 将字符串转换成Bitmap类型
        Bitmap bitmap = null;
        try {
            byte[] bitmapArray;
            bitmapArray = Base64.decode(string, Base64.DEFAULT);
            bitmap = BitmapFactory.decodeByteArray(bitmapArray, 0,
                    bitmapArray.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    /**
     * 将Bitmap转换成字符串
     *
     * @param bitmap
     * @return
     */
    public String bitmaptoString(Bitmap bitmap) {
        // 将Bitmap转换成字符串
        String string = null;
        ByteArrayOutputStream bStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, bStream);
        byte[] bytes = bStream.toByteArray();
        string = Base64.encodeToString(bytes, Base64.DEFAULT);
        return string;
    }
}
