package secondary.matrix;


import java.util.HashMap;
import java.util.Map;

/**
 * @description: 36：有效数独
 * @author: sunhaiting
 * @create: 2020-04-26 11:37
 **/
public class ThirtySixToIsValidSudoku {
    public static void main(String[] args) {
        char[][] a = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        boolean flag = isValidSudoku(a);
        System.out.println(flag);


    }

    public static boolean isValidSudoku(char[][] board) {

        Map<Integer, Integer>[] row = new HashMap[9];
        Map<Integer, Integer>[] col = new HashMap[9];
        Map<Integer, Integer>[] box = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            row[i] = new HashMap<>();
            col[i] = new HashMap<>();
            box[i] = new HashMap<>();
        }


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = num - '0';
                    int box_index = (i / 3) * 3 + j / 3;
                    row[i].put(n, row[i].getOrDefault(n, 0) + 1);
                    col[j].put(n, col[j].getOrDefault(n, 0) + 1);
                    box[box_index].put(n, box[box_index].getOrDefault(n, 0) + 1);

                    if (row[i].get(n) > 1 || col[j].get(n) > 1 || box[box_index].get(n) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
