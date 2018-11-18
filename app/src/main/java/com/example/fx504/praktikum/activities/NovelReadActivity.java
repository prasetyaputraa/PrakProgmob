package com.example.fx504.praktikum.activities;

import android.graphics.Canvas;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.example.fx504.praktikum.R;
import com.example.fx504.praktikum.admin.AddNovel;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnDrawListener;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

import retrofit2.http.Url;

public class NovelReadActivity extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novelread);

        pdfView = findViewById(R.id.pdf_View);

//        pdfView.fromAsset("ijis03b.pdf").load();

        setPdfView();

//        new RetrivePDF().execute("http://ancestralauthor.com/download/sample.pdf");
    }


   public void setPdfView(){
        if (getIntent() != null){
            String viewType = getIntent().getStringExtra("ViewType");
            if (viewType != null || !TextUtils.isEmpty(null)){
                Uri novel = (Uri) Objects.requireNonNull(getIntent().getExtras()).get("pdfUri");
//                Uri pdfFile = Uri.parse(getIntent().getStringExtra("pdfUri"));


                pdfView.fromUri(novel).load();
            }
        }
   }



}
