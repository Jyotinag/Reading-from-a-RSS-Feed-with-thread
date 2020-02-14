
package rssreader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class readtoFile implements Runnable {
    @Override
    public void run(){
        BufferedWriter out  = null;
        try {
            out = new BufferedWriter(new FileWriter("a.rss"));
            out.write(readRSS("http://rss.cnn.com/rss/edition.rss"));
        } catch (IOException ex) {
            Logger.getLogger(readtoFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try{
                if(out!=null){
                    out.close();
                } else {
                    System.out.println("Buffer Not Initialized");
                }
            } catch (IOException ex) {
                Logger.getLogger(readtoFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public static String readRSS(String urlAddress) throws MalformedURLException, IOException{
        URL rssUrl = new URL(urlAddress);
        String finalString;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(rssUrl.openStream()))) {
            finalString = "";
            String line;
            while((line = in.readLine())!=null){
                
                finalString += line+"\n";
            }
        }
        return finalString;
    }
}
