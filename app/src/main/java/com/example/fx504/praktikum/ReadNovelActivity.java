package com.example.fx504.praktikum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ReadNovelActivity extends AppCompatActivity {

    ImageView iv_NovelCover;
    TextView tv_NovelTitle, tv_NovelGenre, tv_NovelRelease,tv_NovelDecs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_novel);

        iv_NovelCover   = findViewById(R.id.iv_novelCover);
        tv_NovelTitle   = findViewById(R.id.tv_novelTitlle);
        tv_NovelGenre   = findViewById(R.id.tv_Novelgenre);
        tv_NovelRelease = findViewById(R.id.tv_Novelrelease);
        tv_NovelDecs    = findViewById(R.id.tv_NovelDesc);

        Bundle bundle = getIntent().getExtras();
        int novel_cover = bundle.getInt("novel_cover");
        String novel_title = getIntent().getStringExtra("novel_title");
        String novel_genre = getIntent().getStringExtra("novel_genre");
        String novel_desc = getIntent().getStringExtra("novel_desc");

        iv_NovelCover.setImageResource(novel_cover);
        tv_NovelTitle.setText(novel_title);
        tv_NovelGenre.setText(novel_genre);
        tv_NovelDecs.setText(novel_desc);

    }
}
