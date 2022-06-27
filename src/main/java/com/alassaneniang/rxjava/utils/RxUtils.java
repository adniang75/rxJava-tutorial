package com.alassaneniang.rxjava.utils;

import com.alassaneniang.rxjava.models.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RxUtils {

    private static final Random random = new Random();
    private static final int MIN = 1;

    private RxUtils() {
    }

    public static List<Integer> positiveNumbers(Integer number) {
        return IntStream.rangeClosed(MIN, number)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Shape> shapes(Integer number) {
        return IntStream.rangeClosed(MIN, number)
                .boxed()
                .map(index -> new Shape(randomShape(), randomColor()))
                .collect(Collectors.toList());
    }

    private static String randomColor() {
        String[] colors = {"blue", "green", "red", "yellow", "pink"};
        return colors[random.nextInt(getRandomNumberInRange(4))];
    }

    private static String randomShape() {
        String[] shape = {"square", "triangle", "circle", "pentagon", "hexagon", "stars"};
        return shape[random.nextInt(getRandomNumberInRange(6))];
    }

    private static int getRandomNumberInRange(int max) {
        if (RxUtils.MIN >= max) {
            throw new IllegalArgumentException("max must be greater the min");
        }
        return random.nextInt((max - RxUtils.MIN) + 1) + RxUtils.MIN;
    }

    /**
     * Geneate List of prime numbers
     *
     * @param n
     * @return
     */
    public static List<Integer> primeNumbers(Integer n) {
        //List to hold primeNumbers of size n
        List<Integer> primeNumbers = new ArrayList<>(n);

        //
        boolean totalPrimeCollected = false;
        int i = 1;
        int totalNumbers = 0;
        //Iterate over n elements and add to list
        while (!totalPrimeCollected) {
            if (isPrime(i)) {
                primeNumbers.add(i);
                totalNumbers++;
            }
            i++;
            if (totalNumbers == n) {
                totalPrimeCollected = true;
            }
        }
        return primeNumbers;

    }

    /**
     * Find if number is prime
     *
     * @param n
     * @return the result in boolean
     */
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
