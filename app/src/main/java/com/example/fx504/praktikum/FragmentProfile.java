package com.example.fx504.praktikum;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentProfile extends Fragment {

    TextView tv_nama;
    TextView tv_email;
    TextView tv_phone;
    Button btn_logout;


    SharePref sharePref;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View frameView = inflater.inflate(R.layout.fragment_profile,container,false);

        sharePref = new SharePref(getActivity());

        tv_nama    = frameView.findViewById(R.id.tv_nama);
        tv_email   = frameView.findViewById(R.id.tv_email);
        tv_phone   = frameView.findViewById(R.id.tv_phone);
        btn_logout = frameView.findViewById(R.id.btn_logout);
        String nama     = sharePref.getDataString(SharePref.KEY_NAME);
        String email    = sharePref.getDataString(SharePref.KEY_EMAIL);
        String phone    = sharePref.getDataString(SharePref.KEY_PHONE);

        tv_nama.setText(""+nama);
        tv_email.setText(""+email);
        tv_phone.setText(""+phone);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharePref.setDataInt(SharePref.KEY_VALUE,0);
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        return frameView;

    }
}
