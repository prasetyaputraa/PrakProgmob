package com.example.fx504.praktikum;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.ImageViewCompat;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class FragmentHome extends Fragment {

    FragmentTransaction fragmentTransaction;

    ViewFlipper vf_novel;
    LinearLayout layout_fav;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View frameView = inflater.inflate(R.layout.fragment_home,container,false);


        int novel_cover[] = {R.drawable.cat_eye, R.drawable.dead_in_deep_water, R.drawable.strange_winds};
        vf_novel   = frameView.findViewById(R.id.vf_novel);
        layout_fav = frameView.findViewById(R.id.layout_Fav);

        fragmentTransaction = getFragmentManager().beginTransaction();

        for (int i =0; i<novel_cover.length;i++){
            flipperImage(novel_cover[i]);
        }
        goToFragFav();

        return frameView;
    }

    public void flipperImage(int img){
        ImageView imageView= new ImageView(getContext());
        imageView.setBackgroundResource(img);

        vf_novel.addView(imageView);
        vf_novel.setFlipInterval(2500); //1000 = 1 detik
        vf_novel.setAutoStart(true);

        //animation
        vf_novel.setInAnimation(getContext(), android.R.anim.slide_in_left);
        vf_novel.setOutAnimation(getContext(), android.R.anim.slide_out_right);
    }

    public void changeColor(int color){

    }

    public void goToFragFav(){
        layout_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction.replace(R.id.frag_layout, new FragmentFavorites()).commit();
            }
        });
    }
}
