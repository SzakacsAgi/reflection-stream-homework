package reflect;

import java.lang.reflect.*;
import java.lang.String;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Homework1 {


    /**
     * Prints the declared methods of java.lang.String sorted by name.
     */
    public void streamPipeline1() {
        Arrays.stream(String.class.getMethods())
                .map(method -> method.getName())
                .sorted()
                .forEach(System.out::println);
    }

    /**
     *  Prints all distinct names of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline2() {
        Arrays.stream(String.class.getMethods())
                .map(method -> method.getName())
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String with two or more parameters whose parameters are all of the same type, sorted by name.
     */
    public  void  streamPipeline3() {
        Arrays.stream(String.class.getDeclaredMethods())
                .filter(method -> method.getParameterCount() >= 2)
                .filter(method -> Arrays.stream(method.getParameterTypes()).collect(Collectors.toSet()).size() == 1)
                .map(Method::getName)
                .sorted()
                .forEach(System.out::println);
    }


    /**
     * Prints all distinct return types of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline4() {
        Arrays.stream(String.class.getDeclaredMethods())
                .map(method -> method.getReturnType().getName())
                .sorted()
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String with at least one boolean parameter, sorted by name.
     */
    public void streamPipeline5() {
        Arrays.stream(String.class.getDeclaredMethods())
                .filter(method -> method.getReturnType().getName().contains("boolean"))
                .map(Method::getName)
                .sorted()
                .forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String whose parameters are all of type int, sorted by name.
     */
    public void streamPipeline6() {
        Arrays.stream(String.class.getDeclaredMethods())
                .filter(method -> method.getReturnType().getName().contentEquals("int"))
                .map(Method::getName)
                .sorted()
                .forEach(System.out::println);
    }

    /**
     * Returns the longest name of the declared methods of java.lang.String.
     */
    public String streamPipeline7() {
            return Arrays.stream(String.class.getDeclaredMethods())
                    .max(Comparator.comparing(m -> m.getName().length()))
                    .map(m -> m.getName())
                    .toString();
        }


    /**
     *  Returns the longest one from the names of the public declared methods of java.lang.String.
     */
    public String streamPipeline8() {
        return Arrays.stream(String.class.getDeclaredMethods())
                .filter(method -> method.toString().contains("public"))
                .max(Comparator.comparing(m -> m.getName().length()))
                .map(m -> m.getName())
                .toString();
    }

    /**
     * Returns summary statistics about the number of parameters for the declared methods of java.lang.String.
     */
    public IntSummaryStatistics streamPipeline9() {
        return Arrays.stream(String.class.getDeclaredMethods())
                .mapToInt(method -> method.getParameterCount())
                .summaryStatistics();
    }

    /**
     * Returns the maximum number of parameters accepted by the declared methods of java.lang.String.
     */
    public int streamPipeline10() {
        return Arrays.stream(String.class.getDeclaredMethods())
                .mapToInt(method -> method.getParameterCount())
                .max().getAsInt();
    }

    /**
     * Returns the declared method of java.lang.String with the most number of parameters.
     */
    public Method streamPipeline11() {
        return Arrays.stream(String.class.getDeclaredMethods())
                .max(Comparator.comparingInt(method -> method.getParameterCount()))
                .get();
    }


    /**
     * Prints all distinct parameter types of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline12() {
            Arrays.stream(String.class.getDeclaredMethods())
                    .map(method -> method.getReturnType())
                    .sorted()
                    .distinct()
                    .forEach(System.out::println);
    }

}
