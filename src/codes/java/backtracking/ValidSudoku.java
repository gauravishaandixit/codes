package codes.java.backtracking;

import java.util.HashMap;
import java.util.HashSet;

public class ValidSudoku {
    boolean isValidSudoku1(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i/3 + "-" + j/3))
                        return false;
            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        HashMap<Integer, HashSet<Character>> row = new HashMap<>();
        HashMap<Integer, HashSet<Character>> col = new HashMap<>();
        HashMap<String, HashSet<Character>> cube = new HashMap<>();


        for(int i = 0; i < 9; i++)
        {
            row.put(i, new HashSet<>());
            col.put(i, new HashSet<>());
        }

        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                cube.put("" + i + j, new HashSet<>());


        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                if(board[i][j] != '.')
                {
                    if(!row.get(i).add(board[i][j]))
                        return false;

                    if(!col.get(j).add(board[i][j]))
                        return false;

                    if(!cube.get("" + i/3 + j/3).add(board[i][j]))
                        return false;
                }
            }
        }
        return true;
    }
}
