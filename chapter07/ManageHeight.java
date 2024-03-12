package chapter07;

public class ManageHeight {
    public static int NUMBER_OF_CLASSES = 5;
    public int[][] gradeHeights = new int[NUMBER_OF_CLASSES][];

    public void setData() {
        gradeHeights[0] = new int[]{170, 180, 173, 175, 177};
        gradeHeights[1] = new int[]{160, 165, 167, 186};
        gradeHeights[2] = new int[]{158, 177, 187, 176};
        gradeHeights[3] = new int[]{173, 182, 181};
        gradeHeights[4] = new int[]{170, 180, 165, 177, 172};
    }

    public void printHeight(int classNo) {
        int numStudent = gradeHeights[classNo - 1].length;
        for (int i = 0; i < numStudent; i++) {
            System.out.println(gradeHeights[classNo - 1][i]);
        }
    }

    public void printAverage(int classNo) {
        int numStudent = gradeHeights[classNo - 1].length;
        double sum = 0;
        for (int i = 0; i < numStudent; i++) {
            sum += gradeHeights[classNo - 1][i];
        }
        double average = sum / numStudent;
        System.out.println("Height average : " + average);
    }

    public static void main(String[] args) {
        ManageHeight mh = new ManageHeight();
        mh.setData();
        for (int classNo = 1; classNo <= NUMBER_OF_CLASSES; classNo++) {
            System.out.println("Class No. " + classNo);
//            mh.printHeight(classNo);
            mh.printAverage(classNo);
        }

    }
}
