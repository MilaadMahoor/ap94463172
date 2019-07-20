/* This program is for
  Advanced Programming Course 972 ZNU
  Assignment 10
  98/04/14
  Milad Zolfkhani
  94463172
 */

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;



public class WebPageDownloader {


    public WebPageDownloader() {

    }


    public void downloadFile(URL url , String saveDir) throws IOException {
        saveDir=addresschecker(saveDir);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();

        //  checking HTTP response code first
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String fileName = "";
            String disposition = httpConn.getHeaderField("Content-Disposition");


            if (disposition != null) {
                // extracts file name from header field
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                    fileName = disposition.substring(index + 10,
                            disposition.length() - 1);
                }
            } else {
                // extracts file name from URL
               if(url.toString().endsWith("/")){
                   fileName =url.toString().substring(url.toString().indexOf("/")+2,url.toString().lastIndexOf("/"))+".html";
               }
               else {
                   fileName =url.toString().substring(url.toString().lastIndexOf("/") + 1,
                           url.toString().length())+".html";
               }
            }


            System.out.println("fileName = " + fileName);

            // opens input stream from the HTTP connection
            InputStream inputStream = httpConn.getInputStream();
            String saveFilePath = saveDir + File.separator + fileName;


            saveFilePath=saveFilePath.replace("/",".");
            // opens an output stream to save into file
            File file = new File(saveFilePath);

            try {

                FileOutputStream outputStream = new FileOutputStream(saveFilePath);


                int bytesRead = -1;
                byte[] buffer = new byte[4096];
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                outputStream.close();
                inputStream.close();

                System.out.println("File downloaded");
            }

            catch (FileNotFoundException fnfe){
                fnfe.printStackTrace();
            }
        }
        httpConn.disconnect();
    }


    public String addresschecker(String dir){
        File theDir = new File(dir);

        if (!theDir.exists()) {
            System.out.println("creating directory: " + theDir.getName());
            try{
                theDir.mkdir();

            }
            catch(SecurityException se){

            }

        }
        return  dir;
    }



}


