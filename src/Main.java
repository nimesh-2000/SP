import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

        /* Problem 3 Method Calls */
        List<Long> first100Fib = generateFibonacci(100);
        System.out.println("Problem 3");
        System.out.println(first100Fib);
        System.out.println("---------------------------------------------------");

        /* Problem 4 Method Calls */
        List<Integer> numbers = Arrays.asList(50, 2, 1, 9);
        String largestNumber = largestFormedNumber(numbers);
        System.out.println("Problem 4");
        System.out.println("Largest Formed Number: " + largestNumber);
        System.out.println("---------------------------------------------------");

        /* Problem 5 Method Calls */
        System.out.println("Problem 5");
        findExpressions("", 1, 0, 0);
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

        public static String largestFormedNumber(List<Integer> numbers) {

            List<String> strNums = new ArrayList<>();
            for (int num : numbers) {
                strNums.add(String.valueOf(num));
            }

            Collections.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

            if (strNums.get(0).equals("0")) {
                return "0";
            }


            StringBuilder result = new StringBuilder();
            for (String s : strNums) {
                result.append(s);
            }

            return result.toString();
        }


        /* Problem 5 *



        /**
         * Recursive function to explore all combinations
         *
         * expression -> Current expression string
         * num -> Current number being considered (1 to 9)
         * sum -> Current total sum of expression
         * lastValue -> Last value added/subtracted (used for concatenation)
         */
        public static void findExpressions(String expression, int num, long sum, long lastValue) {
            if (num > 9) {
                if (sum == 100) {
                    System.out.println(expression);
                }
                return;
            }

            String currentStr = String.valueOf(num);

            if (expression.isEmpty()) {
                // First digit
                findExpressions(currentStr, num + 1, num, num);
            } else {
                // Add '+'
                findExpressions(expression + "+" + currentStr, num + 1, sum + num, num);

                // Add '-'
                findExpressions(expression + "-" + currentStr, num + 1, sum - num, -num);

                // Concatenate (no operator)
                long newLast = concatenate(lastValue, num);
                long newSum = sum - lastValue + newLast;
                findExpressions(expression + currentStr, num + 1, newSum, newLast);
            }
        }

        // Concatenate two numbers, preserving the sign of the first
        private static long concatenate(long base, int next) {
            boolean negative = base < 0;
            long abs = Math.abs(base);
            long result = abs * 10 + next;
            return negative ? -result : result;
        }
    }




