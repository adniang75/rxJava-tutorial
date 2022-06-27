package com.alassaneniang.rxjava.utils;

import com.alassaneniang.rxjava.models.Shape;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

class RxUtilsTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97})
    void testIsPrimeShouldReturnTrue(int number) {
        assertThat(RxUtils.isPrime(number)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 6, 8, 9, 10, 12, 14, 16, 18, 20, 21, 22, 24, 25, 26, 27, 28, 30, 32, 33, 34, 35, 36, 38, 39, 40, 42, 44, 45, 46, 48, 49, 50})
    void testIsPrimeShouldReturnFalse(int number) {
        assertThat(RxUtils.isPrime(number)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 20})
    void testShouldReturnAListOfPrimeNumbersOfNElements(int number) {
        List<Integer> primes = RxUtils.primeNumbers(number);
        assertThat(primes.stream().allMatch(RxUtils::isPrime)).isTrue();
        assertThat(primes).hasSize(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 20})
    void testShouldReturnAListOfNElements(int number) {
        List<Integer> positiveNumbers = RxUtils.positiveNumbers(number);
        assertThat(positiveNumbers.stream().allMatch(integer -> integer >= RxUtils.MIN && integer <= number)).isTrue();
        assertThat(positiveNumbers).hasSize(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 20})
    void testShouldReturnAListOfNShapes(int number) {
        List<Shape> shapes = RxUtils.shapes(number);
        assertThat(shapes.stream().allMatch(Objects::nonNull)).isTrue();
        assertThat(shapes).hasSize(number);
    }

}