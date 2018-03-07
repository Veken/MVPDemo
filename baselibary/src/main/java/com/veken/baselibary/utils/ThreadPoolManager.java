package com.veken.baselibary.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import io.reactivex.disposables.CompositeDisposable;

/**
 * @author Veken
 * @date on 2018/1/16 17:26
 * @describe
 */

public class ThreadPoolManager {
    private static volatile ThreadPool Instance;

    //单例模式，获取线程池的实例
    public static ThreadPool getInstance(){
        if(Instance == null){
            synchronized (ThreadPool.class){
                if(Instance == null){
                    int threadCount = Runtime.getRuntime().availableProcessors();
                    Instance = new ThreadPool(threadCount,threadCount,1L);
                }
            }
        }
        return Instance;
    }


    public static class ThreadPool{

        private ThreadPoolExecutor executor;
        private  int corePoolSize;
        private  int maximumPoolSize;
        private  long keepAliveTime;

        public ThreadPool(int corePoolSize,int maximumPoolSize,long keepAliveTime) {
            this.corePoolSize = corePoolSize;
            this.maximumPoolSize = maximumPoolSize;
            this.keepAliveTime = keepAliveTime;
        }

        public  void execute(Runnable r){
            if(executor == null){

                //线程池执行者。
                //参1:核心线程数;参2:最大线程数;参3:线程休眠时间;参4:时间单位;参5:线程队列;参6:生产线程的工厂;参7:线程异常处理策略
                executor = new ThreadPoolExecutor(
                        corePoolSize,maximumPoolSize,keepAliveTime, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<Runnable>(), Executors.defaultThreadFactory(),
                        new ThreadPoolExecutor.AbortPolicy());
            }
            if(executor != null){

                executor.execute(r);
            }
        }
        //取消线程
        public void remove(Runnable r){
            if(executor != null){
                executor.getQueue().remove(r);
            }
        }
    }
}
