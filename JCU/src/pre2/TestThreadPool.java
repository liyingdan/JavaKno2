package pre2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestThreadPool {
    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        List<Future<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Future<Integer> future =  pool.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int sum = 0;
                    for (int i = 0; i <= 100; i++) {
                        sum += i;
                    }
                    return sum;
                }
            });
            list.add(future);
        }
        pool.shutdown();
        for (Future<Integer> future : list) {
            System.out.println(future.get());
        }

    }

}
class ThreadPoolDemo implements Runnable{
    private int i = 0;
    @Override
    public void run() {
        while (i <= 100){
            System.out.println(Thread.currentThread().getName() + ":" + i++);
        }
    }
}
