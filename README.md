# Reading-from-a-RSS-Feed-with-thread

The whole project is devided into two parts and those two parts are implemented with Java Runnables.
The first part uses the URL class to read from a .rss file from "http://rss.cnn.com/rss/edition.rss" and saves it in the local disk.

The thread is executed in every 15 seconds. The thread uses BufferedReader class to read the feed and uses FileWriter and BufferedWriter class to save the contents to "a.rss".

The second part is executed with another thread that runs every 20 seconds and read from the "a.rss" file to search for images. I used the tags to find and split the image sources.
