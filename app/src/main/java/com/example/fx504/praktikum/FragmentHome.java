package com.example.fx504.praktikum;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class FragmentHome extends Fragment {

    FragmentTransaction fragmentTransaction;

    ViewFlipper vf_novel;
    LinearLayout layout_fav;


    ImageView iv_all, iv_action, iv_comedy, iv_scifi, iv_history;
    ImageView iv_romance, iv_sport, iv_horror, iv_fantasy;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View frameView = inflater.inflate(R.layout.fragment_home,container,false);

        int novel_cover[] = {R.drawable.cat_eye, R.drawable.dead_in_deep_water, R.drawable.strange_winds};





        //View Promosi Novel Baru

        vf_novel   = frameView.findViewById(R.id.vf_novel);
        for (int i =0; i<novel_cover.length;i++){
            flipperImage(novel_cover[i]);
        }

        // View Favorit Novel --> cuma uji coba, belum sesuai
        layout_fav = frameView.findViewById(R.id.layout_Fav);
        goToFragFav();

        //Genre Novel
        iv_all     = frameView.findViewById(R.id.iv_all);
        iv_action  = frameView.findViewById(R.id.iv_action);
        iv_romance = frameView.findViewById(R.id.iv_romance);
        iv_fantasy = frameView.findViewById(R.id.iv_fantasy);
        iv_sport   = frameView.findViewById(R.id.iv_sport);
        iv_comedy  = frameView.findViewById(R.id.iv_comedy);
        iv_history = frameView.findViewById(R.id.iv_history);
        iv_horror  = frameView.findViewById(R.id.iv_horror);
        iv_scifi   = frameView.findViewById(R.id.iv_scifi);


        setFungsiGenre(iv_all,"All Novel");
        setFungsiGenre(iv_action,"Genre Action");
        setFungsiGenre(iv_romance,"Genre Romance");
        setFungsiGenre(iv_fantasy,"Genre Fantasy");
        setFungsiGenre(iv_sport,"Genre Sport");
        setFungsiGenre(iv_comedy,"Genre Comedy");
        setFungsiGenre(iv_history,"Genre History");
        setFungsiGenre(iv_horror,"Genre Horror");
        setFungsiGenre(iv_scifi,"Genre Sci Fi");

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


    public void goToFragFav(){
        layout_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ini error gak tau kenapa, tapi sebelumnya mau
//                fragmentTransaction.replace(R.id.frag_layout, new FragmentFavorites()).commit();
                Toast.makeText(getContext(), "Sabar, error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setFungsiGenre(ImageView button, final String value){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), ""+value, Toast.LENGTH_SHORT).show();
            }
        });
    }


}
