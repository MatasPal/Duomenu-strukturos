package Tests;
import Utils.DequeArray;
import Utils.DequeLinkedList;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.BenchmarkParams;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import java.util.Random;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(time = 1, timeUnit = TimeUnit.SECONDS)
public class Benchmark {

    @State(Scope.Benchmark)
    public static class BenchmarkTest {

        int[] numbers; //testing data
        DequeLinkedList<Integer> linkedListSet;
        DequeArray<Integer> arrayListSet;

        //Generating elements
        @Setup(Level.Iteration)
        public void generateElements(BenchmarkParams params) {
            numbers = Benchmark.generateElements(Integer.parseInt(params.getParam("elementCount")));
        }

        //Filling LinkedList set
        @Setup(Level.Invocation)
        public void fillLinkedListSet(BenchmarkParams params) {
            linkedListSet = new DequeLinkedList<>();
            addElementsToLL(numbers, linkedListSet);
        }

        //Filling Array set
        @Setup(Level.Invocation)
        public void fillArraySet(BenchmarkParams params) {
            arrayListSet = new DequeArray<>(100);
            addElementsToAR(numbers, arrayListSet);
        }
    }

    //Elements amount
    @Param({"10000", "20000", "40000", "80000"})
    public int elementCount;

    //Generating random elements
    public static int[] generateElements(int count) {
        Random picker = new Random();
        int[] numbers = new int[count];
        int minValue = 0;
        int maxValue = 1000;
        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = picker.nextInt((maxValue - minValue) + 1) + minValue;
        }
        return numbers;
    }
    //Adding elements to LinkedList
    public static void addElementsToLL(int[] carArray, DequeLinkedList<Integer> carSet) {
        for (Integer car : carArray) {
            carSet.addLast(car);
        }
    }
    //Adding elements to Array
    public static void addElementsToAR(int[] carArray, DequeArray<Integer> carSet) {
        for (Integer car : carArray) {
            carSet.addLast(car);
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Benchmark.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

    /*
    ///addFirst benchmark
    @org.openjdk.jmh.annotations.Benchmark
    public void addFirstLinkedList(BenchmarkTest test) {
        for(Integer x: test.numbers){
            test.linkedListSet.addFirst(x);
        }
    }
    @org.openjdk.jmh.annotations.Benchmark
    public void addFirstArray(BenchmarkTest test) {
        for(Integer x: test.numbers){
            test.arrayListSet.addFirst(x);
        }
    }



    ///addLast benchmark
    @org.openjdk.jmh.annotations.Benchmark
    public void addLastLinkedList(BenchmarkTest test) {
        for(Integer x: test.numbers){
            test.linkedListSet.addFirst(x);
        }
    }
    @org.openjdk.jmh.annotations.Benchmark
    public void addLastArray(BenchmarkTest test) {
        for(Integer x: test.numbers){
            test.arrayListSet.addLast(x);
        }
    }


    ///removeFirst benchmark
   @org.openjdk.jmh.annotations.Benchmark
   public void removeFirstLinkedList(BenchmarkTest test) {
            test.linkedListSet.removeFirst();
    }
    @org.openjdk.jmh.annotations.Benchmark
    public void removeFirstArray(BenchmarkTest test) {
            test.arrayListSet.removeFirst();
    }


    ///removeLast benchmark
    @org.openjdk.jmh.annotations.Benchmark
    public void removeLastLinkedList(BenchmarkTest test) {
        test.linkedListSet.removeLast();
    }
    @org.openjdk.jmh.annotations.Benchmark
    public void removeLastArray(BenchmarkTest test) {
        test.arrayListSet.removeLast();
    }




    ///getFirst benchmark
    @org.openjdk.jmh.annotations.Benchmark
    public void getFirstLinkedList(BenchmarkTest test) {
        test.linkedListSet.getFirst();
    }
    @org.openjdk.jmh.annotations.Benchmark
    public void getFirstArray(BenchmarkTest test) {
        test.arrayListSet.getFirst();
    }
    */

    //getLast benchmark
    @org.openjdk.jmh.annotations.Benchmark
    public void getLastLinkedList(BenchmarkTest test) {
        test.linkedListSet.getLast();
    }

    @org.openjdk.jmh.annotations.Benchmark
    public void getLastArray(BenchmarkTest test) {
        test.arrayListSet.getLast();
    }


}

