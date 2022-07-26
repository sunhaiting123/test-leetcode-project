package secondary.treeNode;

/**
 * @description: 96. 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * @author: sunhaiting
 * @create: 2020-04-12 21:28
 **/
public class NinetySixNumTrees {
    public static void main(String[] args) {
        int i = numTrees(3);
        System.out.println(i);
    }

    /**
     * 输入: 3
     * 输出: 5
     * 解释:
     * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
     * 1         3     3      2      1
     * \       /     /      / \      \
     * 3     2     1      1   3      2
     * /     /       \                 \
     * 2     1         2                 3
     * <p>
     * G(n)= G(0)⋅G(n-1)+G(1)⋅G(n-2)+...+G(n-2)⋅G(1)+G(n-1)G(0)
     *
     * @param n
     * @return
     */
    public static int numTrees(int n) {

        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
