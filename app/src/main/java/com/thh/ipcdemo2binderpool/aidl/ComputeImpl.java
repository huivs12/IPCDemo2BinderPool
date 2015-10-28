package com.thh.ipcdemo2binderpool.aidl;

import android.os.RemoteException;

import com.thh.ipcdemo2binderpool.ICompute;

/**
 * Created by TangHui on 2015/10/28.
 */
public class ComputeImpl extends ICompute.Stub {
    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}
