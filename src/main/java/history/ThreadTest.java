package history;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.*;

public class ThreadTest {

    private static final ListeningExecutorService pool = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        final ListenableFuture<Integer> listenableFuture = pool.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                System.out.println("call execute..");
                TimeUnit.SECONDS.sleep(5);
                return 7;
            }
        });

        Integer res = listenableFuture.get(10,TimeUnit.SECONDS);
        System.out.println(res);
    }
}
