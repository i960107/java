package this_is_java;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Chapter16 {

    public void aggregateExample() {
        List<Student> students = List.of(
                new Student("hong", 100, Student.Sex.MALE, Student.City.Seoul),
                new Student("kim", 80, Student.Sex.FEMALE, Student.City.Seoul),
                new Student("park", 50, Student.Sex.MALE, Student.City.Pusan)
        ); //immutable list 생성. Arrays.asList는 mutable
        int totalScore = students.stream()
                .mapToInt(s -> s.getScore()) //IntStream
                .sum(); //숫자Stream에 대해서만 sum() 호출 가능.

        int maxScore = students.stream()
                .mapToInt(Student::getScore) // 매개변수의 메소드 참조 가능
                .max()
                .getAsInt();

        int maxScore2 = students.stream()
                .max((a, b) -> a.getScore() <= b.getScore() ? -1 : 1) // comparator로 비교하지만 stream요소 자체가 반환
                .get().getScore();
    }

    public void intStreamVsStreamInteger() {
        int[] arr = {1, 2, 3, 4, 5};
        IntStream intStream = Arrays.stream(arr);
        Stream<Integer> streamInteger = intStream.boxed();

        intStream.forEach(System.out::println);  //int를 받음
        streamInteger.forEach(integer -> System.out.println(integer.intValue())); //Integer를 받음 intValue()를 호출해야
    }

    public void mapExample() {
        int[] arr = {1, 2, 3, 4, 5};
        //1.asDoubleStream() :각 요소를 upcasting한 스트림 생성
        Arrays.stream(arr) //IntStream
                .asDoubleStream() //DoubleStream
                .forEach(System.out::println);

        //1.boxed(): Stream객체로 변환
        Arrays.stream(arr) //IntStream
                .boxed() // Stream<Integer>
                .forEach(Integer::intValue); //매개변수의 메소드 참조

        //3.mapToInt() : 각 요소를  downCasting한 IntStream객체를 생성
        //Arrays.stream()으로 만들어진 숫자 Stream은 mapToInt를 호출할 필요가 없음.
        //long to int 처럼 downcasting을 하거나 객체의 필드 값만 추출할때 사용.
        double[] doubleArr = {1.0, 2.0, 3.0, 4.0, 5.0};
        Arrays.stream(doubleArr)
                .mapToInt(d -> (int) d)
                .forEach(System.out::print);

        //4.mapToInt(): 객체 필드값 추출
        List<Student> students = List.of(
                new Student("hong", 100, Student.Sex.MALE, Student.City.Seoul),
                new Student("kim", 80, Student.Sex.FEMALE, Student.City.Seoul),
                new Student("park", 50, Student.Sex.MALE, Student.City.Pusan)
        ); //immutable list 생성. Arrays.asList는 mutable
        students.stream()
                .mapToInt(Student::getScore) // 매개변수의 메소드 참조 가능 IntStream
                .forEach(score -> System.out.println(score));

    }

    public void collectExample() {
        List<Student> students = List.of(
                new Student("hong", 100, Student.Sex.MALE, Student.City.Seoul),
                new Student("kim", 80, Student.Sex.FEMALE, Student.City.Seoul),
                new Student("park", 50, Student.Sex.MALE, Student.City.Pusan)
        );
        //사용자 정의 컨테이너에 수집하기
        Supplier<MaleStudent> supplier = MaleStudent::new;
        BiConsumer<MaleStudent, Student> accumulator = (container, student) -> container.accumulate(student);
        BiConsumer<MaleStudent, MaleStudent> combiner = (ms1, ms2) -> ms1.combine(ms2);
        MaleStudent maleStudent = students.stream()
                .filter(s -> s.getSex().equals(Student.Sex.MALE))
                .collect(supplier, accumulator, combiner);
        MaleStudent maleStudent12 = students.stream()
                .filter(s -> s.getSex().equals(Student.Sex.MALE))
                .collect(
                        MaleStudent::new,
                        MaleStudent::accumulate,
                        MaleStudent::combine
                );
    }

    public void groupingBy() {
        // 1. 성별 그룹핑
        List<Student> students = List.of(
                new Student("hong", 100, Student.Sex.MALE, Student.City.Seoul),
                new Student("kim", 80, Student.Sex.FEMALE, Student.City.Seoul),
                new Student("park", 50, Student.Sex.MALE, Student.City.Pusan)
        );
        Collector<Student, ?, Map<Student.Sex, List<Student>>> collector = Collectors.groupingBy(Student::getSex);
        Map<Student.Sex, List<Student>> mapBySex = students.stream().collect(collector);
        // 2. 도시별 학생 이름 그룹핑
        Map<Student.City, List<String>> studentNamesGroupByCity = students.stream()
                .collect(
                        Collectors.groupingBy(
                                Student::getCity,  // 분류 기준 Function
                                Collectors.mapping(Student::getName, Collectors.toList()))); // 이름만 리스트로 묶는다 Collector
        studentNamesGroupByCity.entrySet()
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
        // 3. 성별 평균 점수
        Map<Student.Sex, Double> avgScoreBySex = students.stream()
                .collect(
                        Collectors.groupingBy(
                                Student::getSex,
                                TreeMap::new,
                                Collectors.averagingDouble(Student::getScore)));
        avgScoreBySex.entrySet()
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
        // 4. 성별 학생 이름 문자열
        Map<Student.Sex, String> namesBySex = students.stream()
                .collect(
                        Collectors.groupingBy(
                                Student::getSex,
                                TreeMap::new,
                                Collectors.mapping(Student::getName, Collectors.joining(", "))));
        namesBySex.entrySet()
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
    }

    public static void main(String[] args) {
        Chapter16 sample = new Chapter16();
        sample.groupingBy();
    }


}
