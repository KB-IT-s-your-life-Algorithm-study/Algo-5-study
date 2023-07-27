import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

class Solution {
    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        ArrayList<Integer>[] block = new ArrayList[Math.max(m, n)];
        int[] drop = new int[n];

//        Stack<Character>[] stack = new Stack[n];

        String[] rotate = new String[m];
        Arrays.fill(rotate, ""); // 초기화 해줘야 함

        System.out.println(Arrays.toString(rotate));

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                rotate[i] += board[m - 1 - i].charAt(j);
            }
        }

        System.out.println(Arrays.toString(rotate));

        String[] result = rotate.clone();

//        for(int i = 0; i < n; i++){
//            stack[i] = new Stack<>();
//        }

//        for(int i = 0; i < m ; i++) {
//            for(int j = 0; j < n; j++) {
//                stack[i].add(board[j].charAt(i));
//            }
//        }

//        System.out.println(Arrays.toString(stack));

        for(int i = 0; i < Math.max(m, n); i++){
            block[i] = new ArrayList<>();
        }


        for(int i = 0; i < m - 1; i++) {
            System.out.println("i = " + i);
            for(int j = 0; j < n - 1; j++) {
                if (checkBlock(i, j, rotate)) {
//                    if(drop.contains(new int[]{i, j})) {
//                        System.out.println("i = " + i);
//                        System.out.println("j = " + j);
//                    }

                    result[i] = result[i].substring(0, j) + '_' + result[i].substring(j + 1);
                    result[i] = result[i].substring(0, j + 1) + '_' + result[i].substring(j + 2);
                    result[i + 1] = result[i + 1].substring(0, j) + '_' + result[i + 1].substring(j + 1);
                    result[i + 1] = result[i + 1].substring(0, j + 1) + '_' + result[i + 1].substring(j + 2);



                    System.out.println(Arrays.toString(result));


                    if(block[i].contains(j)) {
                        // j 체크해서 --
                        System.out.println("i = " + i);
                        System.out.println("j = " + j);

                        drop[j]--;
                    }
                    block[i].add(j);
                    block[i].add(j + 1);
                    block[i + 1].add(j);
                    block[i + 1].add(j + 1);

                    drop[j] += 2;
                    drop[j + 1] += 2;

//                    drop.add(new int[]{i, j + 1});
//                    drop.add(new int[]{i + 1, j});
//                    drop.add(new int[]{i + 1, j + 1});
                }
            }
        }



//        for(int i = 0; i < drop.size(); i++) {
//            System.out.println(Arrays.toString(drop.get(i)));
//        }

        System.out.println(Arrays.toString(rotate));
        System.out.println(Arrays.toString(drop));
        System.out.println(Arrays.toString(block));

//        List<Object> resultList = block[0].parallelStream().distinct().collect(Collectors.toList());

        // [TTTANT, __FA__, ___F__, T__RAA, TTMMMF, TMMTTJ]
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
            }
        }


        // i = x, j = y
        // i = x + 1, j = y
        // i = x, j = y + 1
        // i = x + 1, j = y + 1


//        (0, 0) (0, 1) (0, 2) (0, 3) (0, 4) (0, 5)
//        (1, 0) (1, 1) (1, 2) (1, 3) (1, 4) (1, 5)
//        (2, 0) (2, 1) (2, 2) (2, 3) (2, 4) (2, 5)
//        (3, 0) (3, 1) (3, 2) (3, 3) (3, 4) (3, 5)
//        (4, 0) (4, 1) (4, 2) (4, 3) (4, 4) (4, 5)
//        (5, 0) (5, 1) (5, 2) (5, 3) (5, 4) (5, 5)


        // i가 연속해서 같은 게 있으면 => a, a + 1
        // j가

        // [TTTANT, __FA__, ___F__, T__RAA, TTMMMF, TMMTTJ]
        // 이렇게 밀면 안될거 같음..
//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < m; j++) {
//                if(result[i].charAt(m) == '_') {
//                    result[i] = result[i].substring(0, j) + '_' + result[i].substring(j + 1);
//
//                }
//            }
//        }






        return answer;
    }

    // 가로 && 세로 && 대각선이 같은 건지 확인
    public static boolean checkBlock(int i, int j, String[] board) {
        return board[i].charAt(j) == board[i + 1].charAt(j)
                && board[i].charAt(j) == board[i].charAt(j + 1)
                && board[i].charAt(j) == board[i + 1].charAt(j + 1);
    }

    public static void main(String[] args) {
        // Test case 1 : 14
//        int m = 4;
//        int n = 5;
//        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};

        // Test case 2 : 15
        int m = 6;
        int n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};

        solution(m, n, board);
    }
}