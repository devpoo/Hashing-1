package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//#hashing
//#prime
public class GroupAnagrams {

    //N* (k log(k) + o(k))

    public List<List<String>> groupAnagrams(String[] strings) {
        HashMap<String, List<String>> result= new HashMap<>();

        for (String str: strings) {
            char[] sortedArray = str.toCharArray();
            Arrays.sort(sortedArray);
            String sortedString = sortedArray.toString();

            if(!result.containsKey(sortedString)) {
                result.put(sortedString, new ArrayList<>());
            }
            result.get(sortedString).add(str);
        }
        return new ArrayList<>(result.values());
    }

    public List<List<String>> groupAnagramsHash(String[] strings) {
        HashMap<Double, List<String>> result= new HashMap<>();
        for (String str: strings) {
            double hash = getHash(str);
            if(!result.containsKey(hash)) {
                result.put(hash, new ArrayList<>());
            }
            result.get(hash).add(str);
        }
        return new ArrayList<>(result.values());
    }


    public double getHash(String str) {
        int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        double hash = 1;

        for(char c : str.toCharArray()) {
            hash *= primes[c - 'a'];
        }
        return hash;
    }
}
