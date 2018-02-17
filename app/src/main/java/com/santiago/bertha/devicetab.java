package com.santiago.bertha;

import android.app.Fragment;
import android.content.Intent;
import android.view.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Agnieszka on 2/17/2018.
 */

public class devicetab extends android.support.v4.app.Fragment {

    private Button btnTEST;
    private static final String TAG = "devicetab";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.devicestab, container, false);

        btnTEST = (Button) view.findViewById(R.id.btnTEST2);

        btnTEST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Testing button 2", Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(devicetab.this, Pop.class));
            }
        });
        return view;
    }
}