import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * This is my LambdaDemo. Run it to see how we use Lambda expressions
 * in various demo programs, and how we use the functional interfaces to enhance our
 * program.
 */
public class LambdaDemo
{

    public static void runDemo()
    {
        System.out.println("Starting our Demos.\n\n");
        // demo Runnable
        
        // Runnable allows us to do multi-threading, when we need to run an operation
        // in a thread so that we can run many parallel processes at the same time. We
        // have one of two choices, we either extend the thread class or we implement the Runnable interface.
        Runnable th1 = () -> {
                    System.out.println("Interrupting to bring you...");
                    System.out.println("Runnable Demo.");
                    System.out.println("Running within a runnable thread.");
            };

        // Here we tell Thread to start running, but threads don't necessarily immediately start running.
        // They are put on a scheduler to be run when they are alotted CPU time. 
        // It will pop-up randomly each time we run it, because it is on a seperate thread than our main thread.
        new Thread(th1).start();

        // demo MathOperation
        int x = 12;
        int y = 6;
        int ans = demoAddOperation(x, y);
        System.out.println("Demoing our MathOperation interface with Add Operation");
        System.out.println("X + Y = Z: " + x + " + " + y + " = " + ans);
        System.out.println("");

        ans = demoSubOperation(x,y);
        System.out.println("Demoing our MathOperation interface with Sub Operation");
        System.out.println("X - Y = Z: " + x + " - " + y + " = " + ans);
        System.out.println("");            

        ans = demoMultiplicationOperation(x,y);
        System.out.println("Demoing our MathOperation interface with Multiplication Operation");
        System.out.println("X * Y = Z: " + x + " * " + y + " = " + ans);
        System.out.println("");            

        ans = demoDivisionOperation(x,y);
        System.out.println("Demoing our MathOperation interface with Divison Operation");
        System.out.println("X / Y = Z: " + x + " / " + y + " = " + ans);
        System.out.println("");                        
        System.out.println("---------------------------------------------------------------------------------");
        // demo Sort criteria
        ArrayList<String> fruits = new ArrayList<String>();
        fruits.add("Banana");
        fruits.add("Coconut");
        fruits.add("Apple");
        fruits.add("Watermelon");
        fruits.add("Lychee");

        System.out.println("Using Lamda to sort a list of strings");
        System.out.println("");                        

        System.out.println("Original List Order:");
        System.out.println(fruits);
        System.out.println("");                        

        System.out.println("After sorting in alphabetical order from z-a:");

        Collections.sort(fruits, (f1, f2) -> (-1 * f1.compareToIgnoreCase(f2)));
        System.out.println(fruits);
        System.out.println("---------------------------------------------------------------------------------");

        
        // demo Filter criteria
        ArrayList<Integer> testNums = new ArrayList<Integer>();
        testNums.add(14);
        testNums.add(23);
        testNums.add(31);
        testNums.add(36);
        testNums.add(4);
        testNums.add(16);
        testNums.add(15);

        System.out.println("");                        
        System.out.println("Using Lamda to Filter Out Even Numbers");
        System.out.println("");                        
        System.out.println("Original List: " + testNums);
        System.out.println("");                        
        testNums.removeIf(e -> e % 2 == 0);
        System.out.println("Filtered List: " + testNums);
        System.out.println("");                        
        System.out.println("---------------------------------------------------------------------------------");

        // demo Predicate Interface
        Predicate<String> empty = es -> (es.length() == 0);
        System.out.println("Demonstrating Predicate interface");
        System.out.println("");                        
        String notempty = "   ";
        String blank = "";
        boolean isempty = empty.test(notempty);
        System.out.println("first string is empty: " + isempty);
        isempty = empty.test(blank);
        System.out.println("second string is empty: " + isempty);
        System.out.println("");  
        System.out.println("---------------------------------------------------------------------------------");
       
        // demo Function Interface
        Function<String, String> ucase = s -> s.toUpperCase();
        System.out.println("Demonstrating Function interface lambda:");
        System.out.println("");                        
        String lower = "this world";
        System.out.println("Original String: " + lower);
        System.out.println("Results: " + ucase.apply(lower));
        System.out.println("");                        
        System.out.println("---------------------------------------------------------------------------------");

        // demo andThen 
        Function<Integer, Integer> addOne = n -> n + 1;
        addOne = addOne.andThen(n -> 10 * n);
        System.out.println("Demonstrating andThen case: ");
        int n1 = 15;
        System.out.println("Original Int: " + n1);
        System.out.println("Results: " + addOne.apply(n1));
        System.out.println("");                        
        System.out.println("---------------------------------------------------------------------------------");

        // StringOperation demo
        System.out.println("Demonstrating StringOperation Functional Interface");
        System.out.println("");                        
        System.out.println("Concatenating two strings with StringOperation lambda: ");
        System.out.println("");                        
        String str01 = "Hello ";
        String str02 = "Functional";
        System.out.println("First String: " + str01);
        System.out.println("Second String: " + str02);
        StringOperation concat = (s1, s2)->(s1.concat(s2));
        StringOperation largerOrFirst = (s1, s2)->(s1.length() >= s2.length()?s1:s2);
        System.out.println("Results: " + useStringOp(str01, str02, concat));
        System.out.println("");                        
        System.out.println("Finding the larger string lambda: ");
        System.out.println("Results: " + useStringOp(str01, str02, largerOrFirst));
        System.out.println("");                        
        System.out.println("---------------------------------------------------------------------------------");

    }
    public static int useMath(int a, int b, MathOperation op)
    {
        return op.operate(a,b);
    }

    public static String useStringOp(String s1, String s2, StringOperation op)
    {
        return op.apply(s1, s2);
    }

    //  Wrapper for unit test only
    public static int demoAddOperation(int x, int y)
    {
        MathOperation add = (x1,y1)-> x1 + y1;
        return useMath(x, y, add);
    }

    public static int demoSubOperation(int x, int y)
    {
        MathOperation subtract = (x1,y1)-> x1 - y1;
        return useMath(x, y, subtract);       
    }

    public static int demoMultiplicationOperation(int x, int y)
    {
        MathOperation multiply = (x1,y1)-> x1 * y1;
        return useMath(x, y, multiply);        
    }

    public static int demoDivisionOperation(int x, int y)
    {
        MathOperation division = (x1,y1)-> x1 / y1;
        return useMath(x, y, division);        
    }

}
