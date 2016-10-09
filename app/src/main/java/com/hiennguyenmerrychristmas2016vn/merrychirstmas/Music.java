package com.hiennguyenmerrychristmas2016vn.merrychirstmas;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Music extends AppCompatActivity {
    TextView loinhan;
    ListView baihat;
    RelativeLayout mh;
    MediaPlayer song;
    ArrayList<String> mangTenBH,mangLoiNhan;
    ArrayList<Integer> mangMP3;

    public void AnhXa()
    {
        loinhan = (TextView)findViewById(R.id.loinhan);
        baihat = (ListView)findViewById(R.id.baihat);
        mh = (RelativeLayout)findViewById(R.id.manhinh);


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        //anh xa
        AnhXa();
        //hinh nen
        mh.setBackgroundResource(R.drawable.bg2);

        //play nhac nen
song = MediaPlayer.create(getApplicationContext(),R.raw.wewishyouamerrychristmas);
        song.start();

        //loi nhan
    loinhan.setText("Xin chao ban. Day la app cua Hien Nguyen");
        TaoAnimation();
        //tao mang
        TaoMang();

        //listView
        ArrayAdapter adapter = new ArrayAdapter(
                getApplicationContext(),android.R.layout.simple_list_item_1,mangTenBH
        );
        baihat.setAdapter(adapter);



        //listview onItemClick
        baihat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                song.stop();
                song = MediaPlayer.create(getApplicationContext(),mangMP3.get(position));
                song.start();


                loinhan.setText(mangLoiNhan.get(position));

                TaoAnimation();
            }
        });



        //hieu ung zoom cho loi nhan
        loinhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                song.stop();
                Intent mhMain = new Intent(getApplicationContext(),MainActivity.class));
                startActivity(mhMain);
            }
        });


    }
    public void TaoAnimation()
    {
        Animation zoom = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom);
        zoom.reset();
        loinhan.clearAnimation();
        loinhan.startAnimation(zoom);
    }

    public void TaoMang()
    {
mangTenBH = new ArrayList<String>();
        mangLoiNhan = new ArrayList<String>();
        mangMP3 = new ArrayList<Integer>();
        mangMP3.add(R.raw.chuabaogio);

        mangTenBH.add("Chua Bao Gio");
        mangLoiNhan.add("Da co luc em mong tinh minh be lai, de noi nho anh khong the nao them nua");


        mangMP3.add(R.raw.lamon);

        mangTenBH.add("Lam on");
        mangLoiNhan.add("Dung roi xa toi, vi toi da yeu nguoi mat roi");

        mangMP3.add(R.raw.niemkhuccuoi);

        mangTenBH.add("Niem Khuc Cuoi");
        mangLoiNhan.add("Du cho mua, toi xin dua em, den cuoi cuoc doi");


    }
}
