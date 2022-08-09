package test;

import com.sun.org.apache.regexp.internal.REUtil;
import common.ListNode;
import common.TreeNode;
import javafx.util.Pair;
import scala.runtime.RichBoolean;

import java.util.*;


/**
 * @description:
 * @author: sunhaiting
 * @create: 2020-04-15 23:21
 **/
public class Top100 {
    public static void main(String[] args) {

//        String s = "abcddcba";
//        System.out.println(longestPalindrome(s));

//        int[] num1 = {1, 2, 3, 6};
//        int[] num2 = {1, 3, 4, 5, 9, 10};
//        System.out.println(findMedianSortedArrays(num1, num2));


//        String s = "abcdesed";
//        System.out.println(lengthOfLongestSubstring(s));


//        int[] num1 = {1, 3, 4};
//        int[] num2 = {2, 7, 9, 1};
//        ListNode l1 = ListNode.arrayToListNode(num1);
//        ListNode l2 = ListNode.arrayToListNode(num2);
//        ListNode node = addTwoNumbers(l1, l2);
//        ArrayList<Integer> arr = ListNode.listNodeToArray(node);
//        System.out.println(Arrays.toString(arr.toArray()));


//        int[] nums = {1, 2, 3, 4, 5};
//        int[] twonums = twonums(nums, 9);
//        System.out.println(Arrays.toString(twonums));

//        boolean valid = isValid("{(})");
//        System.out.println(valid);

//        int[] arr1 = {1, 4, 5};
//        int[] arr2 = {1, 3, 4};
//        int[] arr3 = {2, 6};
//        ListNode node1 = ListNode.arrayToListNode(arr1);
//        ListNode node2 = ListNode.arrayToListNode(arr2);
//        ListNode node3 = ListNode.arrayToListNode(arr3);
//        ListNode[] arr = {node1, node2, node3};
//        ListNode listNode = mergeKLists2(arr);
//        ArrayList<Integer> arrayList = ListNode.listNodeToArray(listNode);
//        System.out.println(Arrays.toString(arrayList.toArray()));

//        List<String> strings = generateParenthesis(3);
//        System.out.println(Arrays.toString(strings.toArray()));

//        int[] nums = {3, 2, 1};
//        System.out.println(Arrays.toString(nextPermutation(nums)));


//        int[] nums = {4, 5, 6, 7, 0, 1, 2, 3};
//        int search = search(nums, 7);
//        System.out.println(search);


//        int[] nums = {1, 2, 3, 4, 4, 4, 5, 6};
//        int[] ints = searchRange(nums, 6);
//        System.out.println(Arrays.toString(ints));
//        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        List<List<String>> lists = groupAnagrams(strs);
//        for (List<String> list : lists) {
//            System.out.println(Arrays.toString(list.toArray()));
//        }

//        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] merge = merge(intervals);
//        for (int i = 0; i < merge.length; i++) {
//
//            System.out.println(Arrays.toString(merge[i]));
//        }

//        int i = climbStairs(3);
//        System.out.println(i);

//        int[] nums = {1, 2, 3};
//        List<List<Integer>> subsets = subsets2(nums);
//        System.out.println(Arrays.toString(subsets.toArray()));

//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(3);
//        TreeNode treeNode4 = new TreeNode(4);
//        TreeNode treeNode5 = new TreeNode(5);
//        TreeNode treeNode6 = new TreeNode(6);
//        TreeNode treeNode7 = new TreeNode(7);
//        TreeNode treeNode8 = new TreeNode(8);
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//        treeNode2.left = treeNode4;
//        treeNode2.right = treeNode5;
//        treeNode3.right = treeNode6;
//        treeNode4.left = treeNode7;
//        treeNode4.right = treeNode8;
//        List<List<Integer>> lists = levelOrder(treeNode1);
//        System.out.println(Arrays.toString(lists.toArray()));
        int[]nums = {2,2,1,1,1,2,2};
        int i = majorityElement(nums);
        System.out.println(i);

    }


    /**
     * 169. 多数元素
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int count = 0;
        int res = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
            }
            if (num == res) {
                count++;
            } else {
                count--;
            }
        }
        return res;
    }

    /**
     * 121. 买卖股票的最佳时机
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                if (prices[i] - minPrice > maxProfit) {
                    maxProfit = prices[i] - minPrice;
                }

            }
        }
        return maxProfit;
    }


    /**
     * 114. 二叉树展开为链表
     *
     * @param root
     */
    public static void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }


    /**
     * 104. 二叉树的最大深度
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {

        if (root == null) return 0;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 1));
        int depth = 0;
        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> poll = q.poll();
            TreeNode node = poll.getKey();
            Integer value = poll.getValue();
            depth = Math.max(depth, value);

            if (node.left != null) q.add(new Pair<>(node.left, depth + 1));
            if (node.right != null) q.add(new Pair<>(node.right, depth + 1));
        }
        return depth;
    }

    /**
     * 102. 二叉树的层序遍历
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return null;
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                list.add(node.value);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            res.add(list);
        }
        return res;
    }


    /**
     * 94.二叉树中序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> stack = new LinkedList<>();
        while (stack.size() > 0 || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                list.add(node.value);
                root = node.right;
            }

        }
        return list;
    }


    /**
     * 二叉树顺序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> readLevel(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            list.add(node.value);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return list;
    }

    /**
     * 二叉树前序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.value);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return list;
    }


    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> newSubSets = new ArrayList<>();
            for (List<Integer> cur : output) {
                List<Integer> list = new ArrayList<>(cur);
                list.add(num);
                newSubSets.add(list);
            }

            output.addAll(newSubSets);
        }
        return output;

    }

    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        int n = nums.length;
        for (int i = (int) Math.pow(2, n); i < Math.pow(2, n + 1); i++) {
            String s = Integer.toBinaryString(i).substring(1);
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    list.add(nums[j]);
                }
            }
            output.add(list);
        }
        return output;

    }


    /**
     * 70. 爬楼梯
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int first = 1;
        int second = 2;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int third;
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    /**
     * 64. 最小路径和
     *
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if (j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[m - 1][n - 1];
    }


    /**
     * 62. 不同路径
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];

    }

    /**
     * 56. 合并区间
     *
     * @param intervals
     * @return
     */

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        LinkedList<int[]> list = new LinkedList<>();

        for (int i = 0; i < intervals.length; i++) {

            if (list.isEmpty() || list.getLast()[1] < intervals[i][0]) {
                list.add(intervals[i]);
            } else {
                list.getLast()[1] = Math.max(list.getLast()[1], intervals[i][1]);
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    /**
     * 55. 跳跃游戏
     *
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int len = nums.length - 1;
        int pos = len;
        for (int i = len; i >= 0; i--) {
            if (i + nums[i] >= pos) {
                pos = i;
            }
        }
        return pos == 0;
    }

    public static boolean canJump2(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int cover = nums[0];
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }


    /**
     * 53. 最大子数组和
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int pre = 0, max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(max, pre);
        }
        return max;
    }


    /**
     * 49. 字母异位词分组
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            int len = str.length();
            for (int j = 0; j < len; j++) {
                count[str.charAt(j) - 'a']++;
            }


            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    buffer.append('a' + i);
                    buffer.append(count[i]);
                }
            }
            List<String> list = map.getOrDefault(buffer.toString(), new ArrayList<>());
            list.add(str);
            map.put(buffer.toString(), list);
        }
        ArrayList<List<String>> list = new ArrayList<>(map.values());
        return list;

    }


    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};

        int left = 0;
        int right = nums.length - 1;
        //找左边界
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                if (mid == 0 || nums[mid - 1] < target) {
                    res[0] = mid;
                    break;
                } else {
                    right = mid - 1;
                }
            }
        }

        //找右边界
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                if (mid == nums.length - 1 || nums[mid + 1] > target) {
                    res[1] = mid;
                    break;
                } else {
                    left = mid + 1;
                }
            }
        }

        return res;
    }

    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > nums[left]) {
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }


    public static int[] nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] > nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] > nums[j]) {
                j--;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            int tmp1 = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp1;
            left++;
            right--;
        }
        return nums;
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0) return list;
        dfs("", n, n, list);
        return list;
    }

    private static void dfs(String s, int left, int right, List<String> list) {
        if (left == 0 && right == 0) {
            list.add(s);
        }
        //左括号的个数大于右括号的个数，剪枝
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(s + "(", left - 1, right, list);
        }
        if (right > 0) {
            dfs(s + ")", left, right - 1, list);
        }
    }


    public static ListNode mergeKLists(ListNode[] lists) {
        return helper1(lists, 0, lists.length);

    }

    public static ListNode helper1(ListNode[] lists, int left, int right) {

        if (left == right) return lists[left];
        int mid = (left + right) / 2;
        ListNode begin = helper1(lists, left, mid);
        ListNode end = helper1(lists, mid + 1, right);
        return mergeTwoLists(begin, end);


    }


    public static ListNode mergeKLists2(ListNode[] lists) {
        int len = lists.length;
        while (len > 1) {
            for (int i = 0; i < len / 2; i++) {
                lists[i] = mergeTwoLists(lists[i], lists[len - 1 - i]);
            }
            len = (len + 1) / 2;
        }
        return lists[0];
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            int v1 = list1.value;
            int v2 = list2.value;
            if (v1 < v2) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) cur.next = list1;
        if (list2 != null) cur.next = list2;
        return dummy.next;
    }


    public static boolean isValid(String s) {

        LinkedList<Character> stack = new LinkedList<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        //s="{()}"
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode cur1 = dummy;
        int i = 0;
        while (i < n) {
            cur = cur.next;
            i++;
        }
        while (cur.next != null) {
            cur = cur.next;
            cur1 = cur1.next;
        }
        cur1.next = cur1.next.next;
        return dummy.next;

    }


    public static List<String> result = new ArrayList<>();
    static String[] letter_map = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    public static List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) return result;

        iter(digits, "", 0);
        return result;

    }

    private static void iter(String digits, String s, int index) {

        if (digits.length() == index) {
            result.add(s);
            return;
        }

        char c = digits.charAt(index);
        int i = c - '0';
        String s1 = letter_map[i];
        for (int j = 0; j < s1.length(); j++) {
            iter(digits, s + s1.charAt(j), index + 1);
        }


    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            int sum = nums[i] + nums[j] + nums[k];
            ArrayList<Integer> list = new ArrayList<>();
            while (j < k) {
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                }
            }
        }
        return res;

    }

    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length;
        int maxArea = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                maxArea = Math.max(maxArea, (r - l) * height[l]);
                l++;
            } else {
                maxArea = Math.max(maxArea, (r - l) * height[r]);
                r--;
            }
        }
        return maxArea;
    }


    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;

        int maxLen = 1;
        int begin = 0;

        boolean[][] b = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            b[i][i] = true;
        }

        //枚举子串的长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                if (j >= len) break;

                if (s.charAt(i) != s.charAt(j)) {
                    b[i][j] = false;
                } else {
                    if (j - i < 3) {
                        b[i][j] = true;
                    } else {
                        b[i][j] = b[i + 1][j - 1];
                    }
                }

                if (b[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        //左边最大值
        int mid1 = 0;
        //右边最小值
        int mid2 = 0;
        int left = 0;
        int right = m;
        while (left <= right) {
            // 前一部分包含 nums1[0 .. i-1] 和 nums2[0 .. j-1]
            // 后一部分包含 nums1[i .. m-1] 和 nums2[j .. n-1]
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;
            //考虑边界问题
            int n1_left = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int n1_right = i == m ? Integer.MAX_VALUE : nums1[i];
            int n2_left = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int n2_right = j == n ? Integer.MAX_VALUE : nums2[j];
            //存在一个最大的 i 满足A[i−1]≤B[j],这时候的A[i]>B[j−1]
            if (n1_left <= n2_right) {
                mid1 = Math.max(n1_left, n2_left);
                mid2 = Math.min(n1_right, n2_right);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }

        return (m + n) % 2 == 0 ? (mid1 + mid2) / 2.0 : mid1;
    }


    public static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        HashSet<Character> set = new HashSet<>();

        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                max = Math.max(max, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {

            int m = l1 == null ? 0 : l1.value;
            int n = l2 == null ? 0 : l2.value;
            int c = m + n + carry;

            ListNode tmp = new ListNode(c % 10);
            carry = c / 10;
            cur.next = tmp;
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry != 0) cur.next = new ListNode(carry);
        return dummy.next;
    }

    public static int[] twonums(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }


}
