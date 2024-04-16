package chapter23;

import java.util.HashSet;
import java.util.Random;

public class RandomNumberMaker {
    private Random random = new Random();

    public HashSet<Integer> getSixNumber() {
        HashSet<Integer> numbers = new HashSet<>();
        while (numbers.size() <= 6) {
            numbers.add(random.nextInt(45));
        }
        return numbers;
    }

    public static void main(String[] args) {
        //Collection은 toString에서 메모리 주소 아니고 값을 출력함
        //[] 배열은 toString에서 메모리 주소를 출력함.
        RandomNumberMaker sample = new RandomNumberMaker();
        for (int i = 0; i < 10; i++) {
            System.out.println(sample.getSixNumber());
        }

    }
}
