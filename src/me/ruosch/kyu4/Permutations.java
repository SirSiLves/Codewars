package me.ruosch.kyu4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 *
 *   Permutations
 *   https://www.codewars.com/kata/5254ca2719453dcc0b00027d
 *
 * */


public class Permutations {

    public static void main(String[] args) {
//        singlePermutations("ab");
        singlePermutations("bbcc");
    }

    public static List<String> singlePermutations(String s) {
        List<String> permutationLis = new ArrayList<>();
        permute(s, 0, s.length() - 1, permutationLis);
        //remove duplicates
        return permutationLis.stream().distinct().collect(Collectors.toList());
    }

    private static void permute(String str, int left, int right, List<String> permutationLis) {
        if (left == right) permutationLis.add(str);
        else {
            for (int i = left; i <= right; i++) {
                str = swap(str, left, i);
                //call recursive
                permute(str, left + 1, right, permutationLis);
                str = swap(str, left, i);
            }
        }
    }

    private static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }


}
