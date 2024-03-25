package coding.thread;

import java.io.IOException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ZeroEvenOdd {
    public static int n = 10;

    private volatile boolean printOdd = true;
    public static CyclicBarrier oddBarrier = new CyclicBarrier(2);
    public static CyclicBarrier evenBarrier = new CyclicBarrier(2);
    public static CyclicBarrier zeroBarrier = new CyclicBarrier(2);
    public static IntConsumer printNumber = new IntConsumer();

    synchronized boolean getPrintOdd(){
        return printOdd;
    }

    synchronized void setPrintOdd(boolean val){
        printOdd = val;
    }

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public ZeroEvenOdd() {
    }

    public static void main(String[] args) throws IOException {
        ZeroEvenOdd z = new ZeroEvenOdd();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ZeroTask(zeroBarrier, oddBarrier, evenBarrier, printNumber , n, z));
        exec.execute(new OddTask(zeroBarrier, oddBarrier, printNumber , n, z));
        exec.execute(new EvenTask(zeroBarrier, evenBarrier, printNumber , n, z));

        exec.shutdown();
    }
}

class ZeroTask implements Runnable{
    private CyclicBarrier oddBarrier;
    private CyclicBarrier evenBarrier;
    private CyclicBarrier zeroBarrier;
    private IntConsumer printNumber;
    private int n;
    private ZeroEvenOdd z;

    public ZeroTask(CyclicBarrier zeroBarrier, CyclicBarrier oddBarrier, CyclicBarrier evenBarrier, IntConsumer intConsumer, int n, ZeroEvenOdd zeroEvenOdd) {
        this.oddBarrier = oddBarrier;
        this.evenBarrier = evenBarrier;
        this.zeroBarrier = zeroBarrier;
        this.printNumber = intConsumer;
        this.n = n;
        this.z = zeroEvenOdd;
    }


    @Override
    public void run() {
        try {
            for (int i = 1; i <= n; i++){
                printNumber.accept(0);

                if (z.getPrintOdd()){
                    oddBarrier.await();
                }else {
                    evenBarrier.await();
                }

                zeroBarrier.await();
            }
        }catch (BrokenBarrierException e){

        }catch (InterruptedException e){

        }
    }
}

class OddTask implements Runnable{
    private CyclicBarrier oddBarrier;
    private CyclicBarrier zeroBarrier;
    private IntConsumer printNumber;
    private int n;
    private ZeroEvenOdd z;

    public OddTask(CyclicBarrier zeroBarrier, CyclicBarrier oddBarrier, IntConsumer intConsumer, int n, ZeroEvenOdd zeroEvenOdd) {
        this.oddBarrier = oddBarrier;
        this.zeroBarrier = zeroBarrier;
        this.printNumber = intConsumer;
        this.n = n;
        this.z = zeroEvenOdd;
    }


    @Override
    public void run() {
        try {
            for (int i = 1; i <= n; i+=2){
                oddBarrier.await();
                printNumber.accept(i);
                z.setPrintOdd(false);
                zeroBarrier.await();
            }
        }catch (BrokenBarrierException e){

        }catch (InterruptedException e){

        }
    }
}
class EvenTask implements Runnable{
    private IntConsumer printNumber;
    private CyclicBarrier evenBarrier;
    private CyclicBarrier zeroBarrier;
    private int n;
    private ZeroEvenOdd z;

    public EvenTask(CyclicBarrier zeroBarrier, CyclicBarrier evenBarrier, IntConsumer intConsumer, int n, ZeroEvenOdd zeroEvenOdd) {
        this.evenBarrier = evenBarrier;
        this.printNumber = intConsumer;
        this.zeroBarrier = zeroBarrier;
        this.n = n;
        this.z = zeroEvenOdd;
    }


    @Override
    public void run() {
        try {
            for (int i = 2; i <= n; i+=2){
                evenBarrier.await();
                printNumber.accept(i);
                z.setPrintOdd(true);
                zeroBarrier.await();
            }
            System.out.println();
        }catch (BrokenBarrierException e){

        }catch (InterruptedException e){

        }
    }
}
