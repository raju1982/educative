package core.Streams;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {

    public static void main(String[] args) throws IOException {

        //example
        // INteger Stream - IntStream.range
        //Terminal operation    forEach((x) -> System.out.println(x))
        IntStream.range(1,10).forEach((x) -> System.out.print(x));

        System.out.println();

        //example
        //Integer Stream with Skip (5 element of stream)
        IntStream.range(1,10). //source
                skip(5).  //intermediate operation
                forEach((x) -> System.out.print(x)); //terminal operation

        System.out.println();

        //example
        int val = IntStream.range(1,5). //source
                sum(); //terminal operation
        System.out.println(val);

        //example
        Stream.of("hello", "bottle", "africa") //source
                .sorted().   //intermediate operation
                findFirst().  //terminal operation
                ifPresent((x) -> System.out.println(x)); //to protect against null pointer exception


        //example
        String[] items = {"car","computer","toothpaste","box","pencil","tent"};
        Stream.of(items)        //source
                .filter((x) -> x.startsWith("t"))       //intermediate operation
                .sorted()                               //intermediate operation
                .forEach(x->System.out.print(x + "," ));    //terminal operation
        System.out.println();

        //example
        Arrays.stream(new int[] {2,4,6,8,10})
                .map((x) -> x*x)   //intermediate operation
                .average()          //terminal operation
                .ifPresent(n->System.out.print(n)); //to protect against null pointer exception


        System.out.println();

        //example
        List<String> listOfItems = Arrays.asList("computer","toothpaste","box","pencil","tent", "car");
        listOfItems.stream()
                .map(x->x.toLowerCase())
                .filter(x->x.startsWith("c"))
                .sorted()
                .forEach(x->System.out.print(x+","));

        System.out.println("\n");

        //example
        Stream<String> lines = Files.lines(Paths.get("/Users/rakeshkandpal/rakesh-work/github/educative/src/main/java/Streams/wordFile"));
        lines
                .sorted() //intermediate operation
                .filter(l->l.length()>6) //intermediate operation
                .forEach(x->System.out.print(x + ", "));   //terminal operation
        lines.close(); //close stream

        System.out.println("\n");

        //example
        List<String> words = Files.lines(Paths.get("/Users/rakeshkandpal/rakesh-work/github/educative/src/main/java/Streams/wordFile"))
                .filter(x-> x.contains("th")).   //intermediate operation
                        collect(Collectors.toList()); //terminal operation //save result into collection

        words.forEach(x->System.out.print(x + ", "));

        System.out.println("\n");

        //example
        Stream<String> rows = Files.lines(Paths.get("/Users/rakeshkandpal/rakesh-work/github/educative/src/main/java/Streams/stockDataCsv.txt"));
        int rowCount = (int) rows.map(x->x.split(",")).filter(x->x.length>3).count();
        System.out.println(rowCount + " good rows");
        rows.close();

        System.out.println("\n");

        //example
        Stream<String> row100 = Files.lines(Paths.get("/Users/rakeshkandpal/rakesh-work/github/educative/src/main/java/Streams/stockDataCsv.txt"));
        row100.map(x->x.split(","))
                .filter(x->x.length>3)
                .filter(x->Integer.parseInt(x[1].trim())>15)
                .forEach(x->System.out.println(x[0].trim() +  " " + x[2].trim() + " " + x[3].trim()));
        row100.close();
    }
}
