package com.atguigu;

/**
 * @Description
 * @create 2022-03-28 22:37
 */
public class Test {
    private static  int state = 1;

    public static void main(String[] args) {
        final Test t=new Test();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (t) {
                        if (state != 1) {
                            try {
                                t.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            System.out.println("轮到线程一开始执行");
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //线程1执行一秒
                        state=2;
                        t.notifyAll();
                    }
                }
            }
        },"线程1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (t) {
                        if (state != 2) {
                            try {
                                t.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            System.out.println("轮到线程二开始执行");
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //线程1执行一秒
                        state=1;
                        t.notifyAll();
                    }
                }
            }
        },"线程二").start();
    }
}
