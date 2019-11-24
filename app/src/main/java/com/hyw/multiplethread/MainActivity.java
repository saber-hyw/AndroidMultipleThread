package com.hyw.multiplethread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "hyw";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    // init function
    public void init() {
        // 1. new myThread
        myThread mt = new myThread();
        mt.start();

        // 2. new myRunnable and new Thread
        myRunnable mrt = new myRunnable();
        Thread thread_2 = new Thread(mrt);
        thread_2.start();

        // 3. Direct use new Thread() and new Runnable()
        new Thread(new Runnable() {
            @Override
            public void run() {
                // to do, 子线程中执行的操作
                Log.d(TAG, "run: new Thread(new Runnable(){}).start");
            }
        }).start();
    }


    /**
     * （一）Thread 开线程的方法
     */
    // 继承Thread类，重写run()方法
    public class myThread extends Thread {
        @Override
        public void run() {
            super.run();
            // to do, 子线程中执行的操作
            Log.d(TAG, "run: extends Thread");
        }
    }

    /**
     * （一）Runnable 开线程的方法
     */
    public class myRunnable implements Runnable {
        @Override
        public void run() {
            // to do, 子线程中执行的操作
            Log.d(TAG, "run: implements Runnable");
        }
    }

}
