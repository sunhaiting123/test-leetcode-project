package base.java.test;


/**
 * @description:
 * @author: sunhaiting
 * @create: 2020-05-26 11:37
 **/
public class TestThreadAndRunnable {
    public static void main(String[] args) {

//        int i=1;
//        process(i);
//        System.out.println(i);

        Integer n1=new Integer(9);
        Integer n2=new Integer(3);
        n2=n1;

        System.out.println(n2);


//        Count count = new Count();
//        Thread t1 = new Thread(count);
//        Thread t2 = new Thread(count);
//        t1.start();
//        t2.start();
//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.print(Count.getCount());
    }




    public  static void  process(int i){
        i++;
        System.out.println("====="+i);
        return;
    }
}



class Count implements Runnable {
    private static int sCount = 0;

    public static int getCount() {
        return sCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (this) {
                sCount++;
            }
        }
    }
}

