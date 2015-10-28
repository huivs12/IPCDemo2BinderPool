package com.thh.ipcdemo2binderpool;

import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.thh.ipcdemo2binderpool.aidl.BinderPool;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(){
            @Override
            public void run() {
                doWork();
            }
        }.start();
    }

    private void doWork() {
        BinderPool binderPool = BinderPool.getInstance(this);
        IBinder iBinder = binderPool.queryBinder(BinderPool.BINDER_COMPUTE);
        ICompute iCompute = ICompute.Stub.asInterface(iBinder);
        try {
            int count = iCompute.add(3, 6);
            Log.i("thhi","[MainActivity doWork] count:"+count);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        IBinder iBinder1 = binderPool.queryBinder(BinderPool.BINDER_SUCURITY_CENTER);
        ISecurityCenter iSecurityCenter = ISecurityCenter.Stub.asInterface(iBinder1);
        try {
            String encrypt = iSecurityCenter.encrypt("abcdefghyjklmn");
            Log.i("thhi","[MainActivity doWork] encrypt:"+encrypt);
            String decrypt = iSecurityCenter.decrypt(encrypt);
            Log.i("thhi","[MainActivity doWork] decrypt:"+decrypt);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
