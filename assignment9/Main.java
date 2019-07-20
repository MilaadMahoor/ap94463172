/* This program is for
  Advanvaned Programming Course 972 ZNU
  Assignment 9
  98/03/17
  Milad Zolfkhani
  94463172
 */


import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class Main {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long  startTimer;
        ArrayList<String> directories = new ArrayList();
        FindFile findFile= new FindFile();

        ArrayList<File> searchedFiles = new ArrayList();
       Myhashmap<ArrayList<File>,String> cach = new Myhashmap();




        Layer layer = null;
        findFile.setCache(cach);


        System.out.println("For search Type \"search\"");
        System.out.println("For Exit Type \"exit\"");

        String command =scanner.next();

        while (command!="exit"){

            switch (command){
                case "search":{
                    System.out.println("Directory");
                    String directory = scanner.next();
                    directories.add(directory);
                    System.out.println("AccessLeveL:");
                    int accessLevel=scanner.nextInt();
                    System.out.println("Keyword:");
                    String keyWord = scanner.next();

                    if(findFile.isInCach(cach,keyWord)){
                        startTimer = System.currentTimeMillis();
                        System.out.println(findFile.isInCach(cach,keyWord));
                        List lists=cach.reverseMap.entrySet().stream().filter(key->key.getKey().equalsIgnoreCase(keyWord)).collect(Collectors.toList());
                        for (Object files:lists) {
                            System.out.println(files.toString());
                        }


                        System.out.println("executed time:"+(System.currentTimeMillis()-startTimer)+" ms");
                        System.out.println("Done");
                    }
                    else {


                        startTimer= System.currentTimeMillis();
                        for (int i = 0; i <=accessLevel ; i++) {
                            layer = new Layer(directories,i);
                            layer.generate();

                            directories=layer.nextLayersDirectories;

                        }
                        searchedFiles=findFile.search(layer,keyWord) ;
                        findFile.showSearchedFiles(searchedFiles);
                        cach.put(searchedFiles,keyWord);

                        System.out.println("executed time:"+(System.currentTimeMillis()-startTimer)+" ms");
                        System.out.println("Done");
                    }

                }
                command=scanner.next();
                break;
                case "exit":{
                    return;
                }
                default:{
                    System.out.println("Invalid");
                }
                command=scanner.next();
                break;
            }


        }


    }


}
