package base.java.test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2020-06-16 14:55
 **/
public class ThreadJavaTest {
    public static void main(String[] args) {

        Callable<String> oneCallable = new SomeCallable<String>();

        //使用Callable<Integer>创建一个FutureTask<Integer>对象：   
        FutureTask<String> oneTask = new FutureTask<String>(oneCallable);

        //注释：FutureTask<Integer>是一个包装器，它通过接受Callable<Integer>来创建，它同时实现了Future和Runnable接口。 
        //由FutureTask<Integer>创建一个Thread对象：   
        Thread oneThread = new Thread(oneTask);
    }


}


class SomeCallable<String> implements Callable<String> {
    @Override
    public String call() throws Exception {
        return null;
    }
}


