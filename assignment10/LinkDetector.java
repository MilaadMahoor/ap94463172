/* This program is for
  Advanced Programming Course 972 ZNU
  Assignment 10
  98/04/14
  Milad Zolfkhani
  94463172
 */
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ConcurrentModificationException;
import java.util.Set;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class LinkDetector {




    public LinkDetector() {

    }


    //this method extracts available links inside a set of urls and filters them with a same host filter
    public Set<URL> linkExtractor(Set<URL> urls){
       try {
           for (URL url:urls
                   ) {
               Document document;
               try {
                   document = Jsoup.connect(url.toString()).get();
                   Elements links = document.select("a[href]");


                   for (Element link : links) {
                       try {
                           URL url1 = new URL(link.attr("href").toString());
                           //this if filters requared domain
                           if(getHostName(url1).equalsIgnoreCase(getHostName(url))){
                               urls.add(url1);
                           }
                       }
                       catch (Exception e){

                       }

                   }

               } catch (IOException e) {
                   e.printStackTrace();
               }

           }
       }
       catch (ConcurrentModificationException e){
           e.printStackTrace();
       }

        return urls;
    }




    //this method returns domain of an url
    public String getHostName(URL url) throws URISyntaxException {

        String hostname = url.getHost();
        if (hostname != null) {
            return hostname.startsWith("www.") ? hostname.substring(4) : hostname;
        }
        return hostname;
    }
}
