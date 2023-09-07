package com.example;

import java.util.HashSet;
import java.util.Set;

public class WordFinder {

    private final Dictionary dictionary;
    public WordFinder(Dictionary dictionary) {
        this.dictionary = dictionary;
    }
    public Set<String> findEnglishWordsInString(String input) {

        int n = input.length();

        Set<String> stringPermuteList = permute(input, 0, n - 1, new HashSet<String>());
        System.out.println(stringPermuteList.size());
        return stringPermuteList;

    }

    private Set<String> permute(String str, int l, int r, Set<String> stringPermuteList) {
        if (l == r) {
            for (int i = 0; i < str.length(); i++) {
                for (int j = i + 1; j <= str.length(); j++) {
                    String word = str.substring(i, j);
                    if (dictionary.isEnglishWord(word)) {
                        stringPermuteList.add(word);
                    }
                }
            }
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r, stringPermuteList);
                str = swap(str, l, i);
            }
        }
        return stringPermuteList;
    }

    /**
     * Swap Characters at position
     *
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}


