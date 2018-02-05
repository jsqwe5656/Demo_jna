package com.example.zbf.demo_jna;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final JnaEcgAnalService ecg = new JnaEcgAnalService();
        final List<Short> ecgList = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            ecgList.add((short) 512);
        }
//        final JnaTestService testService = new JnaTestService();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        sleep(1000);
//                        int a = ecg.getEcgRate(1, ecgList);
                        int sum = 0;
                        sum = LAddLib.INSTANCE.add(10, 15);
                        Log.e("zbf", "sum = " + sum);
//                        String zbf = ecg.getText("zbf");
//                        Log.e("zbf", "zbf = " + zbf);
//                        Log.e("zbf", "a = " + a);
//                        Log.e("zbf", "test = " + testService.getWord());

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
