
package rssreader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class readImage implements Runnable {
    @Override
    public void run(){
        try {
            System.out.println(readImageInfo("a.rss"));
        } catch (IOException ex) {
            Logger.getLogger(readImage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static String readImageInfo(String fileName) throws FileNotFoundException, IOException{
        String imageInfo = "";
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String newLine;
        while((newLine=br.readLine())!=null){
            if(newLine.contains("<media:group>")){
                int firstPos = newLine.indexOf("<media:group>");
                String temp = newLine.substring(firstPos);
                temp = temp.replace("<media:group>", "");
                int lastPos = newLine.indexOf("</media:group");
                temp = temp.substring(0,lastPos);
                imageInfo += temp+"\n";
            }
        }
        br.close();
        return imageInfo;
    }
}
