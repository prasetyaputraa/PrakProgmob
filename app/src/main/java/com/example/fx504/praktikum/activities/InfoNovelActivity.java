package com.example.fx504.praktikum.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fx504.praktikum.R;
import com.example.fx504.praktikum.admin.AddNovel;

import java.util.zip.Inflater;

public class InfoNovelActivity extends AppCompatActivity {

    Intent intent;

    ImageView iv_NovelCover;
    TextView tv_NovelTitle, tv_NovelGenre, tv_NovelRelease,tv_NovelDecs;
    TextView tv_readNow;
    Button btn_setFav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novelinfo);

        iv_NovelCover   = findViewById(R.id.iv_novelCover);
        tv_NovelTitle   = findViewById(R.id.tv_novelTitlle);
        tv_NovelGenre   = findViewById(R.id.tv_Novelgenre);
        tv_NovelRelease = findViewById(R.id.tv_Novelrelease);
        tv_NovelDecs    = findViewById(R.id.tv_NovelDesc);

        tv_readNow      = findViewById(R.id.tv_readNow);

        btn_setFav      = findViewById(R.id.btn_setFav);

        Bundle bundle = getIntent().getExtras();
        int novel_cover = bundle.getInt("novel_cover");
        String novel_title = getIntent().getStringExtra("novel_title");
        String novel_genre = getIntent().getStringExtra("novel_genre");
        String novel_desc = getIntent().getStringExtra("novel_desc");

        iv_NovelCover.setImageResource(novel_cover);
        tv_NovelTitle.setText(novel_title);
        tv_NovelGenre.setText(novel_genre);
        tv_NovelDecs.setText(novel_desc);

        btn_setFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(InfoNovelActivity.this, AddNovel.class);
                startActivity(intent);
            }
        });

        tv_readNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(InfoNovelActivity.this, NovelReadActivity.class);
                startActivity(intent);
            }
        });

    }
}
