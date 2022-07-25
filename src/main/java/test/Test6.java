package test;

import common.ListNode;
import common.TreeNode;
import javafx.util.Pair;

import java.util.*;

/**
 * @description:
 * @author: sunhaiting
 * @create: 2022-06-08 10:22
 **/
public class Test6 {
//    public static void main(String[] args) {
//        int[] arr = {0, 2, 4};
//        int[] arr2 = {1, 3, 5, 7, 9};
//        ListNode node = ListNode.arrayToListNode(arr);
//        ListNode node2 = ListNode.arrayToListNode(arr2);
//        ListNode merge = merge(node, node2);
//        ArrayList<Integer> list = ListNode.listNodeToArray(merge);
//
////        for (int i : list) {
////            System.out.println(i);
////
////        }
//
//        int[] nums = {1, 5, 4, 2, 3};
//        int[] ints = insertSort(nums);
//        System.out.println(Arrays.toString(ints));
//
//    }


    public static ListNode merge(ListNode n1, ListNode n2) {
        if (n1 == null) return n2;
        if (n2 == null) return n1;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (n1 != null && n2 != null) {
            if (n1.value < n2.value) {
                cur.next = n1;
                n1 = n1.next;
            } else {
                cur.next = n2;
                n2 = n2.next;
            }
            cur = cur.next;
        }
        if (n1 != null) cur.next = n1;
        if (n2 != null) cur.next = n2;
        return dummy.next;

    }

    public static ListNode[] splitListToParts(ListNode head, int k) {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }

        int m = count / k;
        int n = count % k;

        ListNode[] res = new ListNode[k];
        ListNode pre = head;
        for (int i = 0; i < k; i++) {
            ListNode dummy = new ListNode(-1);
            ListNode current = dummy;

            for (int j = 0; j < m + (i < n ? 1 : 0); j++) {
                current.next = new ListNode(pre.value);
                current = current.next;
                pre = pre.next;
            }
            res[i] = pre.next;
        }
        return res;
    }


    public static int[] nextLargerNodes(ListNode head) {
        ListNode cur = head;
        ListNode pre = cur.next;
        ArrayList<Integer> list = new ArrayList<>();
        while (cur != null && cur.next != null) {
            while (pre != null) {
                if (cur.value > pre.value) {
                    pre = pre.next;
                } else {
                    list.add(pre.value);
                    break;
                }
            }
            if (pre == null) list.add(0);
            cur = cur.next;
            pre = cur.next;
        }

        list.add(0);

        int[] res = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    public static int getDecimalValue(ListNode head) {
        ListNode cur = head;
        int ans = 0;
        while (cur != null) {
            ans <<= 1;
            ans += cur.value;
            cur = cur.next;
        }
        return ans;

    }

    public static ListNode sortList(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.value < right.value) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
        }
        if (left != null) cur.next = left;
        if (right != null) cur.next = right;

        return dummy.next;
    }


    public static int[] insertSort(int[] nums) {

        int j;
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];

            for (j = i - 1; j >= 0 && nums[j] > tmp; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = tmp;
        }
        return nums;
    }


    public static ListNode insertSortList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode pre = dummy;
        ListNode end = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (end.value < cur.value) {
                end = cur;
                cur = cur.next;
            } else {
                ListNode tmp = cur.next;
                end.next = tmp;
                while (pre.next != null && pre.next.value < cur.value) {
                    pre = pre.next;
                }
                cur.next = pre.next;
                pre.next = cur;
                pre = dummy;
                cur = tmp;
            }

        }
        return dummy.next;
    }


    public static boolean hascycles(ListNode head) {
        if (head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;

    }


    public static ListNode fun(ListNode head) {
        if (head == null) return null;
        ListNode internode = iscycles(head);

        if (internode == null) return null;
        ListNode p1 = head;
        ListNode p2 = internode;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;


    }


    public static ListNode iscycles(ListNode head) {
        if (head == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;

    }


    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int[] dp = new int[triangle.size()];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + list.get(j);
            }
        }
        return dp[0];
    }


    public static ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode d = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = d;
        return head;

    }


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


    public static boolean fun1(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, sum - root.value));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            Integer i = pair.getValue();

            if (node.left == null && node.right == null) {
                if (i == 0) {
                    return true;
                }
                continue;
            }
            if (node.left != null) stack.push(new Pair<>(node.left, i - node.left.value));
            if (node.right != null) stack.push(new Pair<>(node.right, i - node.right.value));
        }
        return false;
    }


    public static List<List<Integer>> fun2(TreeNode root, int sum) {
        if (root == null) return null;

        List<List<Integer>> res = new ArrayList<>();
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, sum - root.value));

        Stack<List<Integer>> stack2 = new Stack<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(root.value);
        stack2.push(list1);

        while (!stack.isEmpty()) {

            Pair<TreeNode, Integer> pop = stack.pop();
            TreeNode node = pop.getKey();
            Integer value = pop.getValue();

            List<Integer> list = stack2.pop();
            if (node.left == null && node.right == null && value == 0) {
                res.add(list);
            }

            if (node.left != null) {
                stack.push(new Pair<>(node.left, value - node.left.value));
                List<Integer> list2 = new ArrayList<>();
                list2.addAll(list);
                list2.add(root.left.value);
                stack2.push(list2);
            }
            if (node.right != null) {
                stack.push(new Pair<>(node.right, value - node.right.value));
                ArrayList<Integer> list3 = new ArrayList<>();
                list3.addAll(list);
                list3.add(node.right.value);
                stack2.push(list3);
            }

        }
        return res;
    }


    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        int len = nums.length;
        return construct(nums, 0, len);
    }

    public static TreeNode construct(int[] nums, int l, int r) {

        if (l == r) return null;
        int max = maxIndex(nums, l, r);
        TreeNode node = new TreeNode(nums[max]);
        node.left = construct(nums, l, max);
        node.right = construct(nums, max + 1, r);
        return node;
    }

    public static int maxIndex(int[] nums, int l, int r) {
        int max = l;
        for (int i = l; i < r; i++) {
            if (nums[i] > nums[max]) max = i;

        }
        return max;
    }


    public static boolean isSubTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true;
        if (t1 == null) return false;

        return isSameTree(t1, t2) || isSubTree(t1.left, t2) || isSubTree(t1.right, t2);
    }

    public static boolean isSameTree(TreeNode t1, TreeNode t2) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(t1);
        q.add(t2);
        while (!q.isEmpty()) {
            TreeNode p1 = q.poll();
            TreeNode p2 = q.poll();

            if (p1 == null && p2 == null) continue;
            if (p1 == null || p2 == null) return false;
            if (p1.value != p2.value) return false;

            q.add(p1.left);
            q.add(p2.left);
            q.add(p1.right);
            q.add(p2.right);
        }
        return true;
    }


    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(t1);
        queue.add(t2);
        while (!queue.isEmpty()) {
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();

            if (n1.left != null && n2.left != null) {
                queue.add(n1.left);
                queue.add(n2.left);

            } else if (n1.left == null) {
                n1.left = n2.left;
            }

            if (n1.right != null && n2.right != null) {
                queue.add(n1.right);
                queue.add(n2.right);
            } else if (n1.right == null) {
                n1.right = n2.right;
            }
            n1.value = n1.value + n2.value;
        }
        return t1;
    }


    public static List<Integer> rightSideView2(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        q.add(root);

        while (!q.isEmpty()) {
            for (int i = 0; i < q.size(); i++) {
                TreeNode node = q.poll();
                if (i == 0) list.add(node.value);
                if (node.right != null) q.add(node.right);
                if (node.left != null) q.add(node.left);
            }
        }
        return list;
    }


    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return initTree(nums, 0, nums.length);

    }

    public static TreeNode initTree(int[] nums, int left, int right) {
        if (left == right) return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = initTree(nums, left, mid);
        node.right = initTree(nums, mid + 1, right);
        return node;

    }


    public static TreeNode sortedListnodeToBST(ListNode head) {
        if (head == null) return null;
        return binarySearch(head, null);
    }

    public static TreeNode binarySearch(ListNode head, ListNode tail) {
        if (head == tail) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode node = new TreeNode(slow.value);
        node.left = binarySearch(head, slow);
        node.right = binarySearch(slow.next, tail);
        return node;
    }


    public static ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode cur = head;
        ListNode pre = null;
        while (m > 1) {
            pre = cur;
            cur = cur.next;
            n--;
            m--;
        }
        ListNode con = pre, tail = cur;

        while (n > 0) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
            n--;
        }

        if (con != null) {
            con.next = pre;
        } else {
            head = pre;
        }

        tail.next = cur;
        return head;

    }


    public static ListNode reverseKGroup(ListNode head, int m) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            for (int i = 0; i < m && end != null; i++) {
                end = end.next;
            }
            if (end == null) break;
            ListNode start = pre.next;
            ListNode tmp = end.next;
            end.next = null;
            ListNode reverse = reverse(start);
            pre.next = reverse;
            start.next = tmp;
            pre = start;
            end = pre;


        }
        return dummy.next;

    }


    public static ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }


    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return null;
        List<List<Integer>> res = new ArrayList<>();

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            if (!s1.isEmpty()) {
                while (!s1.isEmpty()) {
                    TreeNode node = s1.pop();
                    list.add(node.value);
                    if (node.left != null) s1.push(node.left);
                    if (node.right != null) s1.push(node.right);
                }
                res.add(list);
            } else {
                while (!s2.isEmpty()) {
                    TreeNode node = s2.pop();
                    list.add(node.value);
                    if (node.right != null) s1.push(node.right);
                    if (node.left != null) s1.push(node.left);
                }
                res.add(list);
            }
        }
        return res;
    }


    public static int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[j] = G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }


//    public static int numDecodings(String s) {
//        char[] c = s.toCharArray();
//        int[] dp = new int[c.length + 1];
//
//        dp[0] = 1;
//        dp[1] = c[1] == '0' ? 0 : 1;
//
//
//
//
//    }


    public static int removeDuplicates(int[] nums) {
        int count = 1;
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[j - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }


    public static int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i;
    }

    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(0);
        }
        int i = 0;
        while (i >= 0) {
            list.set(i, list.get(i) + 1);
            if (list.get(i) > n) {
                i--;
            } else if (i == k - 1) {
                res.add(new ArrayList<>(list));
            } else {
                i++;
                list.set(i, list.get(i - 1));
            }
        }
        return res;
    }


    public static int[] sortColors(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int cur = 0;
        while (cur <= j) {
            if (nums[cur] == 0) {
                int tmp = nums[cur];
                nums[cur++] = nums[i];
                nums[i++] = tmp;
            } else if (nums[cur] == 2) {
                int tmp = nums[j];
                nums[j--] = nums[cur];
                nums[cur] = tmp;
            } else {
                cur++;
            }
        }

        return nums;
    }


    public static boolean searchMatrix2(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row * col - 1;


        int mid, m, n;
        while (left <= right) {
            mid = left + (right - left) / 2;
            m = mid / col;
            n = mid % col;
            if (target == matrix[m][n]) {
                return true;
            } else if (target < matrix[m][n]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }


    public static int[][] setZeroes(int[][] matrix) {
        int m = 0, n = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                m = 1;
            }
        }
        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == 0) {
                n = 1;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }


        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == 0) {
                setRowZero(matrix, i);
            }
        }

        for (int j = 1; j < col; j++) {
            if (matrix[0][j] == 0) {
                setColZero(matrix, j);
            }
        }

        if (m == 1) {
            setColZero(matrix, 0);
        }

        if (n == 1) {
            setRowZero(matrix, 0);
        }
        return matrix;
    }

    public static void setRowZero(int[][] matrix, int m) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[m][i] = 0;
        }
    }

    public static void setColZero(int[][] matrix, int n) {
        for (int j = 0; j < matrix.length; j++) {
            matrix[j][n] = 0;
        }
    }


    public static ListNode mergeList(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        return dummy.next;

    }


    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) grid[0][j] = grid[0][j - 1] + grid[0][j];
                else if (j == 0) grid[i][0] = grid[i - 1][0] + grid[i][0];
                else grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
            }
        }
        return grid[m - 1][n - 1];
    }


    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;
        int n = 1;
        ListNode old_head = head;
        while (old_head.next != null) {
            old_head = old_head.next;
            n++;
        }
        old_head.next = head;

        k = k % n;

        ListNode tail = head;
        for (int j = 0; j < n - k - 1; j++) {
            tail = tail.next;
        }
        ListNode new_head = tail.next;
        tail.next = null;
        return new_head;

    }


    public static String getPermutation(int n, int k) {
        int[] fact = new int[n];
        ArrayList<Integer> list = new ArrayList<>();

        fact[0] = 1;
        list.add(1);
        for (int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i;
            list.add(i + 1);
        }

        StringBuffer buffer = new StringBuffer();
        k = k - 1;
        for (int j = n - 1; j >= 0; j--) {
            int m = k / fact[j];
            buffer.append(list.get(m));
            k = k % fact[j];
            list.remove(m);
        }
        return buffer.toString();
    }


    //合并区间[[1,3],[2,4]]
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));

        LinkedList<int[]> list = new LinkedList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (list.size() == 0 || list.getLast()[1] < intervals[i][0]) {
                list.add(intervals[i]);

            } else {
                list.getLast()[1] = Math.max(list.getLast()[1], intervals[i][1]);
            }
        }

        int[][] ints = new int[list.size()][2];
        int index = 0;
        while (!list.isEmpty()) {
            ints[index] = list.removeFirst();
            index++;
        }
        return ints;
    }


    public static boolean fun(int[] nums) {
        int pos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= pos) {
                pos = i;
            }
        }
        return pos == 0;
    }


    public static String addStrings(String s1, String s2) {

        int i = s1.length() - 1;
        int j = s2.length() - 1;
        StringBuffer buffer = new StringBuffer();
        int n1, n2;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                n1 = s1.charAt(i) - '0';
            } else {
                n1 = 0;
            }
            if (j >= 0) {
                n2 = s2.charAt(j) - '0';
            } else {
                n2 = 0;
            }

            int num = n1 + n2 + carry;
            carry = num / 10;
            int res = num % 10;
            buffer.append(res);
            i--;
            j--;
        }
        if (carry > 0) buffer.append(carry);
        return buffer.reverse().toString();
    }


    public static String multiply(String s1, String s2) {
        if (s1 == "0" || s2 == "0") return "0";
        String result = "0";
        for (int i = s2.length() - 1; i >= 0; i--) {

            StringBuffer buffer = new StringBuffer();

            for (int j = s2.length() - 1 - i; j > 0; j--) {
                buffer.append(0);
            }
            int n2 = s2.charAt(i) - '0';
            int carry = 0;
            int len = s1.length() - 1;
            while (len >= 0 || carry > 0) {
                int n1 = len < 0 ? 0 : s1.charAt(len) - '0';
                int a = n1 * n2 + carry;
                buffer.append(a % 10);
                carry = a / 10;
                len--;
            }
            result = addStrings(result, buffer.reverse().toString());
        }

        return result;
    }

    public static String multiply2(String s1, String s2) {
        if (s1 == "0" || s2 == "0") return "0";
        int[] res = new int[s1.length() + s2.length()];
        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                int n1 = s1.charAt(i) - '0';
                int n2 = s2.charAt(j) - '0';
                int num = n1 * n2 + res[i + j + 1];
                res[i + j + 1] = num % 10;
                res[i + j] = res[i + j] + num / 10;
            }
        }

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            buffer.append(res[i]);
        }

        return buffer.toString();
    }


    public static double pow(double x, int n) {
        if (n < 0) {
            x = x / 1;
            n = -n;
        }
        return fastPow(x, n);


    }

    private static double fastPow(double x, int n) {
        if (n == 0) return 1;
        double d = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return d * d;
        } else {
            return d * d * x;
        }
    }


    public static double pow2(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double result = 1.0;
        while (n > 0) {
            if (n % 2 == 1) {
                result = result * x;
            }
            x = x * x;
            n = n / 2;
        }

        return result;
    }


    public static List<List<String>> groupAnagrams2(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                int m = str.charAt(i) - 'a';
                count[m]++;
            }

            StringBuffer buffer = new StringBuffer();
            for (int j = 0; j < 26; j++) {
                buffer.append(count[j]);

            }

            List<String> list = map.getOrDefault(buffer.toString(), new ArrayList<>());
            list.add(str);
            map.put(buffer.toString(), list);
        }

        return new ArrayList<>(map.values());
    }


//    public static List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//        if (nums.length == 0) return list;
//        boolean[] used = new boolean[nums.length];
//        ArrayList<Integer> path = new ArrayList<>();
//        dfs(nums, nums.length, 0, used, path, list);
//        return list;
//
//    }
//
//
//    public static void dfs(int[] nums, int length, int depth, boolean[] used, ArrayList<Integer> path, List<List<Integer>> list) {
//
//        if (depth == length) {
//            list.add(new ArrayList<>(path));
//            return;
//        }
//        for (int i = 0; i < length; i++) {
//            if (!used[i]) {
//                path.add(nums[i]);
//                used[i] = true;
//                dfs(nums, length, depth + 1, used, path, list);
//                used[i] = false;
//                path.remove(path.size() - 1);
//            }
//        }
//    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0) return list;
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        ArrayList<Integer> path = new ArrayList<>();
        dfs2(nums, nums.length, 0, used, path, list);
        return list;

    }


    public static void dfs2(int[] nums, int length, int depth, boolean[] used, ArrayList<Integer> path, List<List<Integer>> list) {

        if (depth == length) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < length; i++) {
            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if ((i > 0 && !used[i - 1] && nums[i] == nums[i - 1]) || (used[i])) continue;

            path.add(nums[i]);
            used[i] = true;
            dfs2(nums, length, depth + 1, used, path, list);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }


    public static boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][][] box = new int[3][3][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    row[i][index]++;
                    col[j][index]++;
                    box[i / 3][j / 3][index]++;
                    if (row[i][index] > 1 || col[j][index] > 1 || box[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static int[] nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        if (i == -1) {
            int a = 0;
            int b = nums.length - 1;
            while (a < b) {
                int tmp = nums[a];
                nums[a] = nums[b];
                nums[b] = tmp;
                a++;
                b--;
            }
        } else {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] < nums[i]) {
                j--;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;

            int k = nums.length - 1;
            while (i + 1 < k) {
                int tmp1 = nums[k];
                nums[k] = nums[i + 1];
                nums[i + 1] = tmp1;
                i++;
                k--;
            }
        }
        return nums;
    }


    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            ListNode first = pre.next;
            ListNode second = pre.next.next;
            pre.next = second;
            first.next = second.next;
            second.next = first;
            pre = first;

        }
        return dummy.next;
    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = dummy;
        for (int i = 0; i <= n; i++) {
            p = p.next;
        }

        while (p != null) {
            p = p.next;
            q = q.next;

        }
        q.next = q.next.next;
        return dummy.next;
    }


    public static int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += (nums[i] - min);
        }
        return count;
    }


    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = nums[index] * (-1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;

    }


    public static int numberOfBoomerangs(int[][] points) {
        int result = 0;
        HashMap<Double, Integer> map = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            map.clear();
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                double pow = Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2);
                map.put(pow, map.getOrDefault(pow, 0) + 1);
            }

            for (Map.Entry<Double, Integer> entry : map.entrySet()) {
                int m = entry.getValue();
                result += m * (m - 1);
            }
        }
        return result;
    }


    public static Pair<Integer, char[]> compress(char[] chars) {
        int left = 0;
        int size = 0;
        for (int right = 0; right <= chars.length; right++) {
            if (right == chars.length || chars[left] != chars[right]) {
                chars[size] = chars[left];
                size++;
                if (right - left > 1) {
                    String k = (right - left) + "";
                    for (char i : k.toCharArray()) {
                        chars[size] = i;
                        size++;
                    }
                }
                left = right;
            }
        }
        return new Pair<>(size, chars);
    }


    public static int thirdMax2(int[] nums) {
        int one = nums[0];
        int two = Integer.MIN_VALUE;
        int three = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int now = nums[i];
            if (now > one) {
                three = two;
                two = one;
                one = now;
            } else if (now > two) {
                three = two;
                two = now;
            } else {
                three = now;
            }
        }
        if (three == Integer.MIN_VALUE) {
            return one;
        } else {
            return three;
        }
    }

    public static List<String> fizzBuzz2(int n) {
        List<String> res = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(i + "");
            }

        }
        return res;
    }


    public static int longestPalindrome(String s) {
        int[] nums = new int[58];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'A']++;
        }

        int count = 0;
        for (int num : nums) {
            count = count + num / 2 * 2;
            if (num % 2 == 1 && count % 2 == 0) {
                count++;
            }
        }

        return count;
    }


    public static String toHex(int num) {

        if (num == 0) return "0";
        String res = "";
        String s = "0123456789abcdef";
        while (num != 0 && res.length() < 8) {
            int a = num & 15;
            res = s.charAt(a) + res;
            num = num >> 4;
        }
        return res;

    }


    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair<TreeNode, Boolean>> q = new LinkedList<>();
        q.add(new Pair<>(root, false));
        int sum = 0;
        while (!q.isEmpty()) {
            Pair<TreeNode, Boolean> pair = q.poll();
            TreeNode node = pair.getKey();
            Boolean b = pair.getValue();
            if (node.left == null && node.right == null && b) {
                sum += node.value;
            }

            if (node.left != null) {
                q.add(new Pair<>(node.left, true));
            }

            if (node.right != null) {
                q.add(new Pair<>(node.right, false));
            }
        }
        return sum;
    }


    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> timeList = new ArrayList<>();
        int sum = 1;
        for (int i = 0; i < 12; i++) {
            int minuteOnes = Integer.bitCount(i);
            if (minuteOnes > turnedOn) {
                continue;
            }
            for (int j = 0; j < 60; j++) {
                //Integer.bitCount(j) 返回值是j的二进制表示中1的个数
                int secondOnes = Integer.bitCount(j);
                if (minuteOnes + secondOnes == turnedOn) {
                    System.out.println(i + "===" + j);
                    timeList.add(String.format("%d:%02d", i, j));
                    System.out.println(sum + "===" + Arrays.toString(timeList.toArray()));
                    sum++;
                }
            }
        }
        return timeList;
    }


    public static char findTheDifference(String s1, String s2) {
        int c = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            c = c ^ c1;
        }
        for (int j = 0; j < s2.length(); j++) {
            char c2 = s2.charAt(j);
            c = c ^ c2;
        }
        return (char) c;
    }


    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }


    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] a = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            a[magazine.charAt(i) - 'a']++;
        }

        for (int j = 0; j < ransomNote.length(); j++) {
            a[ransomNote.charAt(j) - 'a']--;
            if (a[ransomNote.charAt(j) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }


    public static int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int guess = guess(mid);
            if (guess == 0) return mid;
            if (guess == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int NUM = 6;

    public static int guess(int n) {
        if (n < NUM) {
            return -1;
        } else if (n > NUM) {
            return 1;
        } else {
            return 0;
        }
    }


    public static int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }


    public static int mySqrt(int a) {
        if (a == 0) return 0;
        int x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return x;
    }

    public static boolean isPerfectSquare(int num) {

        if (num < 2) return false;
        int a = num;
        while (a * a > num) {
            a = (a + num / a) / 2;
        }
        return a * a == num;
    }


    public static int[] intersect(int[] num1, int[] num2) {
        if (num1.length > num2.length) {
            intersect(num2, num1);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : num1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int k = 0;
        for (int n2 : num2) {
            Integer i = map.getOrDefault(n2, 0);
            if (i != 0) {
                num1[k] = n2;
                k++;
                map.put(n2, i - 1);
            }
        }
        return Arrays.copyOfRange(num1, 0, k);
    }

    public static int[] intersect2(int[] num1, int[] num2) {
        Arrays.sort(num1);
        Arrays.sort(num2);

        int i = 0, j = 0, k = 0;
        while (i < num1.length && j < num2.length) {
            if (num1[i] > num2[j]) {
                j++;
            } else if (num1[i] < num2[j]) {
                i++;
            } else {
                num1[k] = num1[i];
                i++;
                j++;
                k++;
            }
        }
        return Arrays.copyOfRange(num1, 0, k);

    }


    public static char[] reverseString(char[] c) {
        int left = 0;
        int right = c.length - 1;
        while (left < right) {
            char tmp = c[left];
            c[left] = c[right];
            c[right] = tmp;
            left++;
            right--;
        }
        return c;
    }


    public static String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            if (!isVowel(chars[left])) {
                left++;
            }
            if (!isVowel(chars[right])) {
                right--;
            }

            if (isVowel(chars[left]) && isVowel(chars[right])) {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    public static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) >= 0;
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);

        //左边最大值
        int mid1 = 0;
        //右边最小值
        int mid2 = 0;

        int left = 0;
        int right = m;
        while (left <= right) {
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            int i_left = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
            int i_right = (i == m ? Integer.MAX_VALUE : nums1[i]);
            int j_left = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            int j_right = (j == n ? Integer.MAX_VALUE : nums2[j]);
            if (i_left <= j_right) {
                mid1 = Math.max(i_left, j_left);
                mid2 = Math.min(i_right, j_right);
                left = i - 1;
            } else {
                right = i + 1;
            }
        }
        return (m + n) % 2 == 0 ? (mid1 + mid2) / 2.0 : mid1;
    }

    public static void main(String[] args) {

//        System.out.println("aeiouAEIOU".indexOf('b'));

        String s = "hello";
        String s1 = reverseVowels(s);
        System.out.println(s1);

//        int[] num1 = {1, 2, 2, 1};
//        int[] num2 = {2, 2};
//        int[] res = intersect2(num1, num2);
//        System.out.println(Arrays.toString(res));


//        System.out.println(isPerfectSquare(17));

//        int a = 6, b = 5;
//        int sum = getSum(a, b);
//        System.out.println(sum);

//        String ransomNote = "bc", magazine = "bcdef";
//
//        System.out.println(canConstruct(ransomNote, magazine));
//        String s1 = "abcddca";
//        System.out.println(firstUniqChar(s1));

//        String s1 = "abcddca";
//        String s2 = "abcde";
//        char theDifference = findTheDifference(s1, s2);
//        System.out.println(theDifference);

//        List<String> strings = readBinaryWatch(8);
//        System.out.println(Arrays.toString(strings.toArray()));


//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(3);
//        TreeNode treeNode4 = new TreeNode(4);
//        TreeNode treeNode5 = new TreeNode(5);
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//        treeNode3.left = treeNode4;
//        treeNode3.right = treeNode5;
//        int i = sumOfLeftLeaves(treeNode1);
//        System.out.println(i);

//        String s = toHex(-1);
//        System.out.println(s);

//        String str = "abbccccdde";
//        int i = longestPalindrome(str);
//        System.out.println(i);

//        int[] nums = {1, 2, 3, 4, 5};
//        int i = thirdMax2(nums);
//        System.out.println(i);


//        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
//
//        Pair<Integer, char[]> pair = compress(chars);
//        char[] c = pair.getValue();
//        Integer key = pair.getKey();
//        System.out.println(key);
//        System.out.println(Arrays.toString(c));


//        int[][] nums = {{0, 0}, {1, 0}, {2, 0}, {3, 0}};
//        int i = numberOfBoomerangs(nums);
//        System.out.println(i);

//        int[] nums = {1, 2, 4, 4, 4, 6};
//        List<Integer> disappearedNumbers = findDisappearedNumbers(nums);
//        System.out.println(Arrays.toString(disappearedNumbers.toArray()));

//        int[] nums = {1, 2, 3};
//        int i = minMoves(nums);
//        System.out.println(i);
//        int[] arr = {1, 2, 3, 4, 5};
//        ListNode node = ListNode.arrayToListNode(arr);
//        ListNode listNode = removeNthFromEnd(node, 3);
//        ArrayList<Integer> arrayList = ListNode.listNodeToArray(listNode);
//        System.out.println(Arrays.toString(arrayList.toArray()));


//        int[] nums = {5, 6, 3, 2, 1};
//        int[] ints = nextPermutation(nums);
//        System.out.println(Arrays.toString(ints));


//        int[] nums = {1, 2, 3, 4, 4, 4, 5, 6, 6};
//        int[] ints = searchRange(nums, 4);
//        System.out.println(Arrays.toString(ints));


//        char[][] board = {
//                {'5', '3', '.', '.', '9', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        };
//
//        boolean validSudoku = isValidSudoku(board);
//        System.out.println(validSudoku);


//        int[] nums = {1, 1, 3};
//        List<List<Integer>> permute = permuteUnique(nums);
//
//        for (List<Integer> list : permute) {
//            System.out.println(Arrays.toString(list.toArray()));
//        }
//
//        boolean[] used = new boolean[nums.length];
//        System.out.println(Arrays.toString(used));

//        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        List<List<String>> lists = groupAnagrams2(strs);
//        for (List<String> list : lists) {
//            System.out.println(Arrays.toString(list.toArray()));
//        }
//        System.out.println(lists.toArray());


//        double pow = pow(2, 5);
//        System.out.println(pow);


//        String s1 = "123";
//        String s2 = "456";
//
//        String s = addStrings(s1, s2);
////        System.out.println(s);
//        String multiply = multiply2(s1, s2);
//        System.out.println(multiply);

//        int[] arr = {0, 2, 4};
//        int[] arr = {1, 2, 3, 4, 5};
//        ListNode node = ListNode.arrayToListNode(arr);
//
//        ListNode listNode = rotateRight(node, 2);
//        ArrayList<Integer> arrayList = ListNode.listNodeToArray(listNode);
//        for (int i : arrayList) {
//            System.out.println(i);
//        }

//        ListNode node2 = ListNode.arrayToListNode(arr2);
//        ListNode merge = merge(node, node2);
//        ArrayList<Integer> list = ListNode.listNodeToArray(merge);

//        for (int i : list) {
//            System.out.println(i);
//
//        }

//        int[] nums = {2, 1, 0, 1, 2, 0};
//        int[] ints = sortColors(nums);
////        System.out.println(Arrays.toString(ints));
//
////        int[][] nums1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
//        int[][] nums1 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
//        int[][] zeroes = setZeroes(nums1);
////        for (int i = 0; i < zeroes.length; i++) {
////            System.out.println(Arrays.toString(zeroes[i]));
////        }
//        int[][] nums2 = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
//        int i = minPathSum(nums2);
//        System.out.println(i);
    }


}