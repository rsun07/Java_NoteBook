package java8.stream.BasicStreams;

import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class distinct_sorted_Test {
    @Test
    public void test() throws IOException {
//        System.out.println("Please input a line of English sentence here: ");
//        Scanner scanner = new Scanner(System.in);
//        String line = scanner.nextLine();

        String line = "abc,dde,abe abc cde,eef";
        List<String> result = Stream.of(line)
                                .flatMap(word -> Stream.of(line.split(" ")))
                                .flatMap(word -> Stream.of(word.split(",")))
                                .map(String::toLowerCase)
                                .distinct()
                                .sorted()
                                .collect(Collectors.toList());

        System.out.println(result);

    }
}
