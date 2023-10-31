import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DemoMain {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

//        Example - Type Erasure
//        What is the class type of numbers
        System.out.println(numbers.getClass().getName());

        HashSet<Boolean> booleans = new HashSet<>();
        booleans.add(true);
        booleans.add(false);
        System.out.println(booleans.getClass().getName());
    }
}
