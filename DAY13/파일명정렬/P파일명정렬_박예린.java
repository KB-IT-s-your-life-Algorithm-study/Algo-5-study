import java.util.Arrays;
import java.util.Comparator;

class Solution {
    static class File {
        String fileName;
        String head;
        int number;

        public File(String fileName, String head, int number) {
            this.fileName = fileName;
            this.head = head;
            this.number = number;
        }
    }

    public static String[] solution(String[] files) {

        int len = files.length;

        File[] file = new File[len];

        for (int i = 0; i < len; i++) {
            String[] str = parsing(files[i]);
            file[i] = new File(files[i], str[0], Integer.parseInt(str[1]));
        }

        Arrays.sort(file, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                if ((o1.head).equals(o2.head)) {
                    return o1.number - o2.number;
                } else {
                    return (o1.head).compareTo(o2.head);
                }
            }
        });

        String[] answer = new String[files.length];

        for (int i = 0; i < files.length; i++) {
            answer[i] = file[i].fileName;
        }


        return answer;
    }

    static String[] parsing(String file) {
        String[] info = new String[2];

        int cnt = 0;

        // head 담기
        for (int j = 0; j < file.length(); j++) {
            if (!Character.isDigit(file.charAt(j))) {
                cnt++;
            } else {
                break;
            }
        }

        info[0] = file.substring(0, cnt);
        info[0] = info[0].toUpperCase();
        file = file.substring(cnt);

        cnt = 0;

        // number 담기
        for (int j = 0; j < file.length(); j++) {
            if (Character.isDigit(file.charAt(j))) {
                cnt++;
            } else {
                break;
            }
        }
        info[1] = file.substring(0, cnt);

        return info;
    }

    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
//        String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};

        System.out.println(Arrays.toString(solution(files)));

//        solution(files);
    }
}