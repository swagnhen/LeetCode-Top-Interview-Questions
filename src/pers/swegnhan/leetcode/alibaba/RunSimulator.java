package pers.swegnhan.leetcode.alibaba;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

class Source implements Serializable{

    public int num;

    public int step;

    public double distance;

}

class Runner implements Runnable{

    private static AtomicBoolean isWritingFile;

    private static AtomicBoolean state400;

    private static AtomicBoolean state800;

    private static AtomicBoolean state1000;

    private static ObjectOutputStream outputStream;

    private CountDownLatch startSignal;

    private CountDownLatch endSignal;

    static{
        isWritingFile = new AtomicBoolean();
        isWritingFile.set(false);
        state400 = new AtomicBoolean();
        state400.set(false);
        state800 = new AtomicBoolean();
        state800.set(false);
        state1000 = new AtomicBoolean();
        state1000.set(false);
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("result.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int num;

    private Source[] sources;

    public Runner(int num, Source[] sources, CountDownLatch startSignal, CountDownLatch endSignal){
        this.num = num;
        this.sources = sources;
        this.startSignal = startSignal;
        this.endSignal = endSignal;
    }

    @Override
    public void run(){
        Random random = new Random();
        try {
            startSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(sources[num].distance < 10000){
            while(isWritingFile.get()){}
            sources[num].step++;
            sources[num].distance += random.nextInt(6) + 8;
            if(sources[num].distance > 4000 && !state400.get()
               || sources[num].distance > 8000 && !state800.get()
               || sources[num].distance > 10000 && !state1000.get()){
                if(isWritingFile.get())
                    continue;
                isWritingFile.set(true);
                try {
                    Thread.sleep(500);
                    Source[] sourcesCopy = new Source[10];
                    for(int i = 0; i < 10; i++){
                        sourcesCopy[i] = new Source();
                        sourcesCopy[i].num = sources[i].num;
                        sourcesCopy[i].step = sources[i].step;
                        sourcesCopy[i].distance = sources[i].distance / 10.0;
                    }
                    Arrays.sort(sourcesCopy, (s1, s2) -> Double.compare(s2.distance, s1.distance));
                    for(Source source : sourcesCopy)
                        outputStream.writeObject(source);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (sources[num].distance > 10000) {
                        state1000.set(true);
                        try {
                            outputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    else if(sources[num].distance > 8000)
                        state800.set(true);
                    else if(sources[num].distance > 4000)
                        state400.set(true);
                    isWritingFile.set(false);
                }
            }
        }
        endSignal.countDown();
    }
}

public class RunSimulator {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        if(!"run".equals(input))
            return;
        Source[] sources = new Source[10];
        for(int i = 0; i < sources.length; i++) {
            sources[i] = new Source();
            sources[i].num = i + 1;
        }
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch endSignal = new CountDownLatch(10);
        for(int i = 0; i < 10; i++)
            new Thread(new Runner(i, sources, startSignal, endSignal)).start();
        startSignal.countDown();
        endSignal.await();
        System.out.println("结果如下：");
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("result.txt"));
        for(int i = 0; i < 30; i++){
            Source source = (Source)inputStream.readObject();
            if(i % 10 < 3)
                System.out.println("" + source.distance + ' ' + source.step);
        }
    }

}
