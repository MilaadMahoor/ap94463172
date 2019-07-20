/* This program is for
  Advanvaned Programming Course 972 ZNU
  Assignment 9
  98/03/17
  Milad Zolfkhani
  94463172
 */


import java.util.HashMap;
import java.util.Map;

public class Myhashmap<K,V> extends HashMap<K,V> {

    Map<V,K> reverseMap = new HashMap<>();
    @Override
    public V put(K key,V value){
        reverseMap.put(value,key);
        return super.put(key,value);
    }
    public K getKey(V value){
        return reverseMap.get(value);
    }
}
