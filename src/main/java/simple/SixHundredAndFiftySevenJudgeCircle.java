package simple;

/**
 * @description: 657. 机器人能否返回原点
 * 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
 * 移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。
 * 如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
 * @author: sunhaiting
 * @create: 2021-05-19 10:44
 **/
public class SixHundredAndFiftySevenJudgeCircle {
    public static void main(String[] args) {

        String s ="RLUD";
        boolean b = judgeCircle(s);
        System.out.println(b);
    }


    /**
     * @param moves
     * @return
     */
    public static boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        int length = moves.length();
        for (int i = 0; i < length; i++) {
            char c = moves.charAt(i);
            if (c == 'R') {
                x++;
            } else if (c == 'L') {
                x--;
            } else if (x == 'U') {
                y++;
            } else if (x == 'D') {
                y--;
            }
        }
        return x == 0 && y == 0;
    }
}
