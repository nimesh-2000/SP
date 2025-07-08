import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        /* Problem 1 Method Calls */
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println("Problem 1");
        System.out.println("For Loop Sum: " + sumWithFor(nums));
        System.out.println("While Loop Sum: " + sumWithWhile(nums));
        System.out.println("Recursive Sum: " + sumWithRecursion(nums, 0));
        System.out.println("---------------------------------------------------");

        /* Problem 2 Method Calls */
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<Integer> list2 = Arrays.asList(1, 2, 3);

        List<Object> merged = mergeAlternately(list1, list2);
        System.out.println("Problem 2");
        System.out.println(merged);
        System.out.println("---------------------------------------------------");

        /* problem 3 Method Calls */
        List<Long> first100Fib = generateFibonacci(100);
        System.out.println("Problem 3");

        System.out.println(first100Fib);
    }





    /*   Problem 1 */

    public static int sumWithFor(int [] numbers){
            int total = 0;
            for (int num : numbers) {
                total += num;
            }
            return total;
        }

    public static int sumWithWhile(int[] numbers) {
        int total = 0;
        int i = 0;
        while (i < numbers.length) {
            total += numbers[i];
            i++;
        }
        return total;
    }

    public static int sumWithRecursion(int[] numbers, int index) {
        if (index >= numbers.length) {
            return 0;
        }
        return numbers[index] + sumWithRecursion(numbers, index + 1);
    }

      /* Problem 2 */

        public static List<Object> mergeAlternately(List<?> list1, List<?> list2) {
            List<Object> result = new ArrayList<>();
            int size = Math.min(list1.size(), list2.size());

            for (int i = 0; i < size; i++) {
                result.add(list1.get(i));
                result.add(list2.get(i));
            }


            if (list1.size() > size) {
                result.addAll(list1.subList(size, list1.size()));
            } else if (list2.size() > size) {
                result.addAll(list2.subList(size, list2.size()));
            }

            return result;
        }

   /* Problem 3 */

        public static List<Long> generateFibonacci(int count) {
            List<Long> fibList = new ArrayList<>();

            if (count <= 0) return fibList;

            fibList.add(0L);  // First Fibonacci number

            if (count == 1) return fibList;

            fibList.add(1L);  // Second Fibonacci number

            for (int i = 2; i < count; i++) {
                long next = fibList.get(i - 1) + fibList.get(i - 2);
                fibList.add(next);
            }

            return fibList;
        }

        /* Problem 4 */










    public static void problem_2(){

    }
    public static void problem_3(){

    }
}

