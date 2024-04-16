package chapter22;

import java.util.ArrayList;

public class ManageHeight {
    ArrayList<ArrayList<Integer>> gradeHeights = new ArrayList<>();

    public void setData() {
        int[][] classHeights = {
                {170, 180, 173, 175, 177},
                {160, 165, 167, 186},
                {158, 177, 187, 176},
                {173, 182, 181},
                {170, 180, 165, 177, 172}
        };
        for (int[] heights : classHeights) {
            ArrayList<Integer> classHeight = new ArrayList<>(heights.length);
            for (int height : heights) {
                classHeight.add(height);
            }
            gradeHeights.add(classHeight);
        }
    }

    public void printHeight(int classNo) {
        System.out.println("class no.:" + classNo);
        gradeHeights.get(classNo - 1)
                .forEach(System.out::println);
    }

    public void printAverage(int classNo) {
        Integer[] heights = gradeHeights.get(classNo - 1).toArray(new Integer[0]);
        double sum = 0.0;
        for (Integer h : heights) {
            sum += h;
        }
        System.out.println("class no.:" + classNo);
        System.out.println("height average:" + sum / heights.length);
    }

    public static void main(String[] args) {
        ManageHeight sample = new ManageHeight();
        sample.setData();
        for (int i = 1; i <= 5; i++) {
//            sample.printHeight(i);
            sample.printAverage(i);
        }
    }
}
