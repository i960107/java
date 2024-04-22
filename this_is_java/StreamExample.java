package this_is_java;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList(
                "This is a java book",
                "Lambda Expressions",
                "Java8 supports lambda expressions"
        );
        stringList.stream()
                .filter(string -> string.toLowerCase(Locale.ROOT).contains("java"))
                .forEach(System.out::println);

        List<Member> membersWithAge = Arrays.asList(
                new StreamExample.Member("홍길동", 30),
                new StreamExample.Member("신용권", 40),
                new StreamExample.Member("감자바", 26)
        );

        Double averageAge = membersWithAge.stream()
                .mapToInt(Member::getAge)
                .average()
                .getAsDouble();
        System.out.println("averageAge = " + averageAge);

        List<Member> membersWithJob = Arrays.asList(
                new StreamExample.Member("홍길동", "개발자"),
                new StreamExample.Member("김나리", "디자이너"),
                new StreamExample.Member("신용권", "개발자")
        );
        List<Member> developers = membersWithJob.stream()
                .filter(m -> m.getJob().equals("개발자"))
                .collect(Collectors.toList());
        developers.forEach(p -> System.out.println(p.getName()));

        Map<String, List<String>> namesByJob = membersWithJob.stream()
                .collect(Collectors.groupingBy(
                        Member::getJob,
                        Collectors.mapping(Member::getName, Collectors.toList())));
        namesByJob.forEach((job, names) -> System.out.println(
                job + " : " + names.stream().collect(Collectors.joining(" "))));

    }


    public static class Member {
        private String name;
        private int age;
        private String job;

        public Member(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Member(String name, String job) {
            this.name = name;
            this.job = job;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getJob() {
            return job;
        }
    }
}