package this_is_java;

import java.util.Scanner;

public class Chapter05 {
    public static void main(String[] args) {
        Chapter05 chapter05 = new Chapter05();
        chapter05.exercise7();
        chapter05.exercise8();
        chapter05.exercise9();

    }

    public void exercise7() {
        int max = Integer.MIN_VALUE;
        int[] arr = {1, 5, 3, 8, 2};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("max = " + max);
    }

    public void exercise8() {
        int[][] arr = {
                {95, 86},
                {82, 92, 96},
                {78, 83, 93, 87, 88},
        };

        int sum = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            count += arr[i].length;
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
        }
        double avg = sum / (double) (count);

        System.out.println("sum = " + sum);
        System.out.println("avg = " + avg);
    }

    public void exercise9() {
        boolean run = true;

        int studentNum = 0;
        int[] scores = null;
        int max_score = Integer.MIN_VALUE;
        double avg_score = Double.MIN_VALUE;

        Scanner scanner = new Scanner(System.in);

        while (run) {
            System.out.println("------------------");
            System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5.종료");
            System.out.println("------------------");
            System.out.print("선택> ");

            int selectNo = scanner.nextInt();

            switch (selectNo) {
                case 1: {
                    System.out.print("학생수 > ");
                    studentNum = scanner.nextInt();
                    break;
                }
                case 2: {
                    scores = new int[studentNum];
                    for (int i = 0; i < studentNum; i++) {
                        System.out.printf("scores[%d] : ", i);
                        scores[i] = scanner.nextInt();
                    }
                    break;
                }
                case 3: {
                    for (int i = 0; i < studentNum; i++) {
                        System.out.printf("scores[%d] : %d\n", i, scores[i]);
                    }
                    break;
                }
                case 4: {
                    if (max_score == Integer.MIN_VALUE || avg_score == Double.MIN_VALUE) {
                        double sum = 0.0;
                        for (int i = 0; i < studentNum; i++) {
                            sum += scores[i];
                            if (scores[i] > max_score) {
                                max_score = scores[i];
                            }
                        }
                        avg_score = sum / studentNum;
                    }
                    System.out.println("최고 점수 : " + max_score);
                    System.out.println("평균 점수 : " + avg_score);
                    break;
                }
                case 5: {
                    run = false;
                    break;
                }
            }
        }

    }
}
