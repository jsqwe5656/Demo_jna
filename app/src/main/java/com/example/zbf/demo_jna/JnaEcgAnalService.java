package com.example.zbf.demo_jna;

import android.util.Log;

import com.example.zbf.demo_jna.JNAEcgAnal;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.*;

/**
 * Created by root on 17-3-29.
 */
public class JnaEcgAnalService {
    private JNAEcgAnal jnaEcgAnal = JNAEcgAnal.JNAEcgAnalInstance;

    private Vector<Integer> list = new Vector<>();
    ExecutorService es = Executors.newFixedThreadPool(10);

    public int getEcgRate(final int deviceId, final List<Short> ecg) {

        Integer result = null;
        if (!list.contains(deviceId)) {
            int a = jnaEcgAnal.InitEcgAnalHR(deviceId);
            Log.e("zbf", "aaa= " + a);
            list.add(deviceId);
        }
        Future future = es.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = 0;
                for (int _ecg : ecg) {
                    _ecg = _ecg - 512;
                    _ecg *= 3;
//                    short rs = jnaEcgAnal.eaGetHr_Analysis(deviceId, (short) (_ecg), (short) (_ecg));
                    result = 0;
                }
                if (result < 15) {
                    result = 0;
                } else if (result > 300) {
                    result = 300;
                }
                return result;
            }
        });
//        try {
//            Object rs = future.get(100, TimeUnit.MILLISECONDS);
//            if (rs != null) {
//                result = (Integer) rs;
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        }

        if (result != null) {
            return result;
        } else {
            return 0;
        }
    }

    public String getText(String str) {
        String text = jnaEcgAnal.Test(str);
        Log.e("zbf", text);
        return text;
    }

    /**
     * 设备离线释放资源
     *
     * @param deviceId
     */
    public synchronized void release(String deviceId) {
        int id = Integer.parseInt(deviceId, 16);
        jnaEcgAnal.EndEcgAnalHR(id);
        list.removeElement(id);
    }
}
