/* This program is for
  Advanced Programming Course 972 ZNU
  Assignment 8
  98/02/22
  Milad Zolfkhani
  94463172
 */
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class FileRead {




    public FileRead(){

    }


    public StringBuffer read(StringBuffer stringBuffer){
        try {

            FileReader fileReader = new FileReader(Main.file);

            int numCharsRead;
            char[] charArray = new char[1024];
            while ((numCharsRead = fileReader.read(charArray)) > 0) {
                stringBuffer.append(charArray, 0, numCharsRead);
            }
            fileReader.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer;
    }


    public void textAnalyse(StringBuffer e){
        StringTokenizer stringTokenizer = new StringTokenizer(this.read(e).toString(),"\t");

        while (stringTokenizer.hasMoreTokens()){
            System.out.println(stringTokenizer.nextToken());
        }


    }

}
