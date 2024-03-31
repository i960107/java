package chapter21;

public class Util {
    public static <K, V> V getValue(Pair<K, V> pair, K key) {
        return pair.isKeyEqualTo(key) ? pair.getValue() : null;
    }

    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("홍길동", 35);
        Integer age = Util.getValue(pair, "홍길동");
        System.out.println("age = " + age);

        ChildPair<String, Integer> childPair = new ChildPair<>("홍삼원", 20);
        Integer childAge = Util.getValue(childPair, "홍삼순");
        System.out.println("childAge = " + childAge);

        OtherPair<String, Integer> otherPair = new OtherPair<>("홍삼원", 20);
        // Integer otherAge = Util.getValue(otherPair, "홍삼순"); 타입체크 컴파일 에러 발생.
    }
}
