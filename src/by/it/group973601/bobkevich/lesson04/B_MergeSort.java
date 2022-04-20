package by.it.group973601.bobkevich.lesson04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Реализуйте сортировку слиянием для одномерного массива.
Сложность алгоритма должна быть не хуже, чем O(n log n)

Первая строка содержит число 1<=n<=10000,
вторая - массив A[1…n], содержащий натуральные числа, не превосходящие 10E9.
Необходимо отсортировать полученный массив.

Sample Input:
5
2 3 9 2 9
Sample Output:
2 2 3 9 9
*/
public class B_MergeSort {

    private static void mergeSort(int[] arr) {//рекурсия(функция вызывает сама себя); тут разбиваем массив на левую и правую части
        int n = arr.length;
        if (n == 1) return;
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; i++)
            left[i] = arr[i];
        for (int i = 0; i < n - mid; i++)
            right[i] = arr[i + mid];

        mergeSort(left);
        mergeSort(right);
        merge (arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {// берем сам массив и левую и правую части
        int leftSize = left.length, rightSize = right.length, i = 0, j = 0, idx = 0;//смотрим размеры лев и прав

        while (i < leftSize && j < rightSize) {//Тут конкретно сортируем
            if (left[i] <= right[j]) {//сами числа сравниваем левое и правое
                arr[idx] = left[i];//присваеваем arr значения (тут left)
                i++;
                idx++;
            } else {
                arr[idx] = right[j];
                j++;
                idx++;
            }
        }
        for (int ll = i; ll < leftSize; ll++)//присваивание аргументов arr{2,3}; left {2}; idx 1; i 1
            arr[idx++] = left[ll];//присваеваем arr left
        for (int rr = j; rr < rightSize; rr++)
            arr[idx++] = right[rr]; //arr{2,3} right {3} idx 2
    }


    int[] getMergeSort(InputStream stream) throws FileNotFoundException {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!

        //размер массива
        int n = scanner.nextInt();
        //сам массив
        int[] a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            System.out.println(a[i]);
        }

        // тут ваше решение (реализуйте сортировку слиянием)
        // https://ru.wikipedia.org/wiki/Сортировка_слиянием
             // считали данные и переходим к сортировке
        mergeSort(a);




        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return a;
    }
    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group973601/bobkevich/lesson04/dataB.txt");
        B_MergeSort instance = new B_MergeSort();
        //long startTime = System.currentTimeMillis();
        int[] result=instance.getMergeSort(stream);
        //long finishTime = System.currentTimeMillis();
        for (int index:result){
            System.out.print(index+" ");
        }
    }


}
