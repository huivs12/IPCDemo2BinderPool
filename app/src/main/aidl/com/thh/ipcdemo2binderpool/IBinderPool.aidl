// IBinderPool.aidl
package com.thh.ipcdemo2binderpool;

// Declare any non-default types here with import statements

interface IBinderPool {

    IBinder queryBinder(int binderCode);
}
