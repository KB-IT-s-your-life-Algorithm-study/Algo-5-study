import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        String[] result = board.clone();

        while(true) {
            int cnt = popBlock(m, n, result);
            if(cnt == 0) break;
            answer += cnt;

            dropBlock(m, n, result);
        }

        return answer;
    }
    private static void dropBlock(int m, int n, String[] result) {
        for(int c = 0 ; c < n ; ++c) {
            for(int r = m - 1 ; r >= 0 ; --r) {
                if(result[r].charAt(c) == '_') {
                    for(int nr = r - 1 ; nr >= 0 ; --nr) {
                        if(result[nr].charAt(c) != '_') {
                            result[r] = result[r].substring(0, c) + result[nr].charAt(c) + result[r].substring(c + 1);
                            result[nr] = result[nr].substring(0, c) + '_' + result[nr].substring(c + 1);

                            break;
                        }
                    }
                }
            }
        }
    }

    static void drop(int m, int n, String[] result) {

        for(int i = 0; i < m; i++) {
            StringBuilder underscore = new StringBuilder();
            StringBuilder character = new StringBuilder();

            if(result[i].contains("_")) {
                for(int j = 0; j < n; j++) {
                    if(result[i].charAt(j) == '_') {
                        underscore.append("_");
                    } else {
                        character.append(result[i].charAt(j));
                    }
                }

                result[i] = "";
                result[i] = underscore.toString() + character.toString();

            }

        }
    }

    static void masking(int i, int j, String[] result) {
        result[i] = result[i].substring(0, j) + '_' + result[i].substring(j + 1);
        result[i] = result[i].substring(0, j + 1) + '_' + result[i].substring(j + 2);
        result[i + 1] = result[i + 1].substring(0, j) + '_' + result[i + 1].substring(j + 1);
        result[i + 1] = result[i + 1].substring(0, j + 1) + '_' + result[i + 1].substring(j + 2);

    }

    static int popBlock(int m, int n, String[] result) {
        int cnt = 0;
        boolean[][] isChecked = new boolean[m][n];

        for(int i = 0 ; i < m - 1 ; ++i) {
            for(int j = 0 ; j < n - 1 ; ++j) {
                if(result[i].charAt(j) == '_') continue;
                checkBlock(i, j, result, isChecked);
            }
        }

        for(int i = 0 ; i < m; ++i) {
            for(int j = 0 ; j < n; ++j) {
                if(isChecked[i][j]) {
                    cnt++;
                    result[i] = result[i].substring(0, j) + '_' + result[i].substring(j + 1);
                }
            }
        }

        return cnt;
    }

    // 가로 && 세로 && 대각선이 같은 건지 확인
    static void checkBlock(int i, int j, String[] board, boolean[][] isChecked) {
        char block = board[i].charAt(j);

        for(int r = i ; r < i + 2 ; ++r) {
            for (int c = j; c < j + 2; ++c) {
                if (board[r].charAt(c) != block) return;
            }
        }

        for (int r = i; r < i + 2; ++r) {
            for (int c = j; c < j + 2; ++c) {
                isChecked[r][c] = true;
            }
        }
    }

    public static void main(String[] args) {
        // Test case 1 : 14
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};

        // Test case 2 : 15
//        int m = 6;
//        int n = 6;
//        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};

//        solution(m, n, board);
        System.out.println(solution(m, n, board));
    }
}