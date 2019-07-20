/* This program is for
  Advanvaned Programming Course 972 ZNU
  Assignment 9
  98/03/17
  Milad Zolfkhani
  94463172
 */

import java.io.File;
import java.util.ArrayList;

public class Layer {




    private int layerNum;
    private File file;
    private File[]files;
    ArrayList<String> folderDirectories=new ArrayList();
    ArrayList<File> thisLayerContents=new ArrayList();
    ArrayList<File[]> nextLayersContents = new ArrayList();
    ArrayList<String> nextLayersDirectories=new ArrayList();



    public Layer(ArrayList<String> folderDirectories, int layerNum) {
        this.folderDirectories = folderDirectories;
        this.layerNum = layerNum;

    }

    //this method creates a file for each directory and makes an Arraylist from them
    public void addressToFile(){
        for (int i = 0; i <folderDirectories.size() ; i++) {
            file=new File(folderDirectories.get(i));
            thisLayerContents.add(file);
        }


    }
    //this method generates whatever is in the folders for the next layer
    public void setNextlayersFiles(){
        for (File file:thisLayerContents) {
            if(file.isDirectory()){
                files=file.listFiles();
                nextLayersContents.add(files);
            }
        }



    }
    //this method generates an Arraylist of the next layers directories
    public void setNextLayersDirectories(){
        for (int i = 0; i <nextLayersContents.size() ; i++) {

            try {
                for (File file:nextLayersContents.get(i)) {
                    nextLayersDirectories.add(file.getPath());
                }
            }
            catch (Exception  e){

            }

        }
    }

    public void generate(){
        addressToFile();
        setNextlayersFiles();
        setNextLayersDirectories();
    }






















}
