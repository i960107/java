package chapter24;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Hashtable;

public class RandomNumberStatistics {
    private static final int DATA_BOUNDARY = 50;
    private Hashtable<Integer, Integer> hashTable;

    public RandomNumberStatistics() {
        hashTable = new Hashtable<>();
    }

    public void getRandomNumberStatistics() {
        Random random = new Random();
        for (int i = 0; i < 5000; i++) {
            int num = random.nextInt(DATA_BOUNDARY);
            putCurrentNumber(num + 1);
        }
        printStatistics();
    }

    public void putCurrentNumber(int num) {
        if (hashTable.containsKey(num)) {
            hashTable.put(num, hashTable.get(num) + 1);
        } else {
            hashTable.put(num, 1);
        }
    }

    public void printStatistics() {
        for (int i = DATA_BOUNDARY; i >= 1; i--) {
            System.out.print(i + "="+ hashTable.get(i) + " ");
            if (i % 10 == 1) {
                System.out.println();
            }
        }

    }


    public static void main(String[] args) {
        RandomNumberStatistics sample = new RandomNumberStatistics();
        sample.getRandomNumberStatistics();
    }
}
