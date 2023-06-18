package org.example.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//49. Group Anagrams
public class Anagram {

    public static void main(String[] args) {
        List<List<String>> res = groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(res);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String elem : strs) {
            char[] ch = elem.toCharArray();
            Arrays.sort(ch);
            String elemToCheck = new String(ch);
            if (!map.containsKey(elemToCheck)) {
                map.put(elemToCheck, new ArrayList<>());
                map.get(elemToCheck).add(elem);
            } else {
                map.get(elemToCheck).add(elem);
            }
        }
        return new ArrayList<>(map.values());
    }

    //695. Max Area of Island
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(i, j, grid));
                }
            }
        }
        return max;
    }

    public boolean isPalindrome(String s) {
        int head = 0;
        int tail = s.length() - 1;
        while (head <= tail) {
            if (!Character.isLetterOrDigit(s.charAt(head))) {
                head++;
            } else if (!Character.isLetterOrDigit(s.charAt(tail))) {
                tail--;
            } else {
                if (Character.toLowerCase(s.charAt(head)) != Character.toLowerCase(s.charAt(tail))) {
                    return false;
                }
                head++;
                tail--;
            }
        }
        return true;
    }

    // O(n log n)
    public boolean isAnagram(String s, String t) {
        if (t.length() == 0) {
            return true;
        }
        char[] ch = t.toCharArray();
        Arrays.sort(ch);
        char[] ch2 = s.toCharArray();
        Arrays.sort(ch2);
        return new String(ch2).equals(new String(ch));
    }

    //O(n)
    public boolean isAnagramWithHashing(String s, String t) {
        if (t.length() == 0) {
            return true;
        }

        if (s.length() != t.length()) {
            return false;
        }
        //only lowercase by task (numOfEnglishLetters)
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char sCh = s.charAt(i);
            char tCh = t.charAt(i);
            //sCh - 'a':  'a' maps to 0, 'b' maps to 1, and so on. This is done by subtracting 'a' from the ASCII value of the. For example, '' - 'a' is 0, 'b' - 'a' is 1, and so on.
            counter[sCh - 'a']++;
            counter[tCh - 'a']--;
        }

        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;
        Map<Character, Integer> chToOccurance = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (chToOccurance.containsKey(ch)) {
                int lastOccurance = chToOccurance.get(ch);
                start = Math.max(start, lastOccurance + 1);
            }
            max = Math.max(max, i - start + 1);
            chToOccurance.put(ch, i);
        }
        return max;
    }

    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || j >= grid[0].length || j < 0 || i >= grid.length || grid[i][j] == 0) {
            return 0;
        }

        if (grid[i][j] == 1) {
            grid[i][j] = 0;
        }
        int left = dfs(i - 1, j, grid);
        int right = dfs(i + 1, j, grid);
        int up = dfs(i, j - 1, grid);
        int down = dfs(i, j + 1, grid);

        return 1 + left + right + up + down;
    }
}
