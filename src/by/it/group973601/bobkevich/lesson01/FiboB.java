package by.it.group973601.bobkevich.lesson01;

import java.math.BigInteger;

/*
 * Вам необходимо выполнить способ вычисления чисел Фибоначчи с вспомогательным массивом
 * без ограничений на размер результата (BigInteger)
 */

public class FiboB {

    private long startTime = System.currentTimeMillis();

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {

        //вычисление чисел простым быстрым методом
        FiboB fibo = new FiboB();
        int n = 55555;
        System.out.printf("fastB(%d)=%d \n\t time=%d \n\n", n, fibo.fastB(n), fibo.time());
    }

    BigInteger fastB(Integer n) {
        //здесь нужно реализовать вариант с временем O(n) и памятью O(n)
        if (n == 0)
            return BigInteger.ZERO;
        else if (n == 1)
            return BigInteger.ONE;
        else {
            BigInteger[] integers = new BigInteger[n];
            integers[0] = BigInteger.ZERO;
            integers[1] = BigInteger.ONE;
            for (int i = 2; i < n; i++) {
                integers[i] = integers[i - 1].add(integers[i - 2]);
            }
            return integers[n - 1].add(integers[n - 2]);
        }

    }

}

