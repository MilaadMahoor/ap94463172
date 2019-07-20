/* This program is for
  Advanced Programming Course 972 ZNU
  Assignment 10
  98/04/14
  Milad Zolfkhani
  94463172
 */
import java.io.IOException;
import java.net.URL;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Set;

public class DownloadManager implements Runnable  {
    WebPageDownloader webPageDownloader= new WebPageDownloader();
    Set<URL> urls = new HashSet<>();
    Set<URL> downloads = new HashSet<>();
    int pagesNumber;
    String dir;

    public DownloadManager(Set<URL> urls, Set<URL> downloads, int pagesNumber, String dir) {
        this.urls = urls;
        this.downloads = downloads;
        this.pagesNumber = pagesNumber;
        this.dir = dir;
    }

    @Override
    public void run() {
       try {

           for (URL u: urls
                   ) {
               try {
                   webPageDownloader.downloadFile(u,dir);
                   downloads.add(u);
                   if(downloads.size()>pagesNumber){
                       return;
                   }
               } catch (IOException e) {
                   e.printStackTrace();
               }


           }
       }
       catch (ConcurrentModificationException e){
           e.printStackTrace();
       }

    }
}
