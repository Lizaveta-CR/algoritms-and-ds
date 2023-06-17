package test.singleLl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Main {
    public static void main(String args[]) {

        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        int minIndex = findMinIndex(nums);
//        int search = search(nums, 0);
//        System.out.println(minIndex);
//        System.out.println(search);
//        threeSum(new int[] {0, 1, 1});
//        maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7});
//        setZeroes(new int[][] {{0, 1}});
        System.out.println(5 - 2 % 5);
        ListNode node = new ListNode(1);
        ListNode next = new ListNode(2);
        ListNode next2 = new ListNode(3);
        ListNode next3 = new ListNode(4);
        ListNode next4 = new ListNode(5);
        node.next = next;
        next.next = next2;
        next2.next = next3;
        next3.next = next4;
//        hasCycle(node);
    }

    public static int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }

        int start = 0;
        int end = len - 1;
        int pivot = findMinIndex(nums);
        int middle = pivot;
        while (nums[middle] != target && start <= end) {
            if (target > nums[middle]) {
                start = pivot + 1;
            } else {
                end = pivot - 1;
            }
            middle = (start + end) / 2;
        }
        if (nums[middle] != target) {
            return -1;
        }
        return nums[middle];
    }

    public static int findMinIndex(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int middle = -1;
        while (start <= end) {
            middle = (start + end) / 2;
            if (middle > 0 && nums[middle] < nums[middle - 1]) {
                return middle;
            }
            if (nums[middle] >= nums[start] && nums[middle] > nums[end]) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return start;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList();
        }
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> elems = new ArrayList<>();
                    elems.add(nums[i]);
                    elems.add(nums[j]);
                    elems.add(nums[k]);
                    res.add(elems);
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }

        }
        return new ArrayList<>(res);
    }

    public static int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < height.length - 2; i++) {
            int left = i + 1;
            int right = height.length - 1;
            max = Math.max(max, (height[right] - height[i]) * height[i]);
            while (left < right) {
                int difference = height[right] - height[left];
                if (difference < 0) {
                    left++;
                } else {
                    max = Math.max(max, difference * height[i]);
                    right--;
                }

            }
        }
        return max;
    }

    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean indexI = false;
        boolean indexJ = false;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                indexI = true;
                break;
            }
        }

        for (int j = 0; j < columns; j++) {
            if (matrix[0][j] == 0) {
                indexJ = true;
                break;
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (indexI) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
        if (indexJ) {
            for (int j = 0; j < rows; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        List<Integer> indexes = new ArrayList<>();
        int pos = 0;
        boolean needIter = true;
        ListNode temp = head;
        boolean hasCycle = false;

        while (needIter) {
            if (temp.next != null) {
                pos++;
                if (indexes.contains(pos)) {
                    hasCycle = true;
                    needIter = false;
                } else {
                    indexes.add(pos);
                }
            } else {
                needIter = false;
            }
        }
        return hasCycle;
    }
}
