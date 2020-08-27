import java.util.*;
public class HashSet_HashMapDemo {
    
    //HashSet uses HashMap, and HashMap uses Hashing
    //TreeSet and TreeMap uses Self Balancing BST(Red Black Tree)
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        //Insertion order won't preserved
        hs.add(10);
        hs.add(20);
        hs.add(5);
        hs.add(34);
        hs.add(2);
        System.out.println(hs);
        
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        //Maintaining the insertion order by doubly linked list
        lhs.add(10);
        lhs.add(20);
        lhs.add(5);
        lhs.add(34);
        lhs.add(2);
        System.out.println(lhs);
        
        HashMap<Integer, String> hm = new HashMap<>();
        //doen't matter insertion order
        hm.put(6, "FGH");
        hm.put(2, "BCD");
        hm.put(4, "DEF");
        hm.put(1, "ABC");
        hm.put(67, "asndfka");
        System.out.println(hm);
        
        LinkedHashMap<Integer, String> lhm = new LinkedHashMap<>();
        //maintain insertion order
        lhm.put(6, "FGH");
        lhm.put(2, "BCD");
        lhm.put(4, "DEF");
        lhm.put(1, "ABC");
        System.out.println(lhm);
    }
}
