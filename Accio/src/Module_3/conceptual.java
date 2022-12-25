

package Module_3;

import java.util.*;

public class conceptual {

    // HASHMAP
    /*
    HashMap is like Dictionary in python.
    It's time complexity is O(1), for put, get, containsKeys.
     */
    public static void main(String[] args) {
        // Initialization
        Map<String, Integer> hm= new HashMap<>();
        // If need to sorted (like int String alphabetical order) -> use new TreeMap<>();

        // 1. Insertion
        hm.put("India", 150);
        hm.put("USA", 100);
        hm.put("Russia", 500);
        System.out.println(hm);

        // 2. get values by using key
        System.out.println(hm.get("India"));
        System.out.println(hm.get("us")); // null as it is not present in the dictionary

        // 3. update values
        hm.put("India", 200);
        System.out.println(hm);

        // 4. Iterarte over hashmap
        for(String key : hm.keySet()){
            System.out.println(key+" : "+ hm.get(key));
        }
    }
}
