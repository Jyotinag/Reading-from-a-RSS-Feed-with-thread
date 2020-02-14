package rssreader;

import java.io.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RSSReader {

    public static void main(String[] args) throws IOException {
       Thread t1 = new Thread(new readtoFile());
       Thread t2 = new Thread(new readImage());
       ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
       executor.scheduleAtFixedRate(t1, 0, 15, TimeUnit.SECONDS);
       executor.scheduleAtFixedRate(t2, 0, 20, TimeUnit.SECONDS);
       
    }
   
}
