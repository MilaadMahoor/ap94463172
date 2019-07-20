/* This program is for
  Advanced Programming Course 972 ZNU
  Assignment 10
  98/04/14
  Milad Zolfkhani
  94463172
 */
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
   static Scanner scanner= new Scanner(System.in);
   static String dir;

    public static void main(String[] args) throws MalformedURLException {
        Set<URL> urls = new HashSet<>();
        Set<URL> downloads = new HashSet<>();
        LinkDetector linkDetector = new LinkDetector();


        System.out.println("Please Set your valid directory for download destination:");
        dir=scanner.next();
        System.out.println("Please Set your URL:");
        String address=scanner.next();
        System.out.println("till how many pages?");
        int pagesNumber = scanner.nextInt();
        System.out.println("In how many Threads?:");
        int threads = scanner.nextInt();
        URL url = new URL(address);
        urls.add(url);
        urls=linkDetector.linkExtractor(urls);

        while (downloads.size()<=pagesNumber) {
            for (int i = 0; i <threads ; i++) {
                DownloadManager downloadManager = new DownloadManager(urls,downloads,pagesNumber,dir);
                Thread thread = new Thread(downloadManager);

                thread.run();

                if(downloads.size()>pagesNumber-1){
                    System.out.println("Done");
                    return;
                }

            }







        }






}



}


