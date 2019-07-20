/* This program is for
  Advanvaned Programming Course 972 ZNU
  Assignment 9
  98/03/17
  Milad Zolfkhani
  94463172
 */

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class FindFile {



    ArrayList<File> searchedFiles = new ArrayList();
    HashMap<ArrayList<File>,String> cache = new HashMap<>();
    String keyWord;


    public FindFile() {
    }

    public ArrayList<File> search(Layer layer,String keyWord){
        this.keyWord=keyWord;
        for (int i = 0; i < layer.thisLayerContents.size(); i++) {
            if(layer.thisLayerContents.get(i).toString().contains(keyWord)){
                searchedFiles.add(layer.thisLayerContents.get(i));
            }
        }
        cache.put(searchedFiles,keyWord);
        return searchedFiles;
    }

    public void setCache(HashMap<ArrayList<File>, String> cache) {
        this.cache = cache;
    }

    public boolean isInCach(HashMap<ArrayList<File>, String> cache,String key){
        if(cache.containsValue(key)){
            return true;
        }
        else {
            return false;
        }
    }
    public void showSearchedFiles(ArrayList<File> files){
        for (File file: files
             ) {
            System.out.println(file);
        }
    }

}
