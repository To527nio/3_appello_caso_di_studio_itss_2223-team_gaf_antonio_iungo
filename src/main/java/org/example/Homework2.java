package org.example;

import java.util.Arrays;

/* Java program for Merge Sort */
// Merges two subarrays of arr[].
// First subarray is arr[l..m]
// Second subarray is arr[m+1..r]
public class Homework2 {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    public static int[] mergeSort(int[] arr, int [] l, int[] r){

        if (arr == null || l == null || r == null) {
            System.out.println("Null Array");
            return null;
        }
        if (l.length <= r.length)
        {
            System.out.println("Impossibile riordinare l'array, l > r : " + Arrays.toString(arr));
        }
        if(arr.length > 1 && l.length == 0) //input che potrebbero arrivare in maniera incorretta
        {
            System.out.println("Impossibile riordinare l'array: " + Arrays.toString(arr));
            return arr;
        }
        if(arr.length == 1 && (l.length != 0 || !(Arrays.equals(r, arr)))) //input che potrebbero arrivare in maniera incorretta
        {
            System.out.println("Errore di input per l o r, restituisco l'array fornito in input: " + Arrays.toString(arr));
            return arr;
        }

        if (arr.length <= 1)
        {
            return arr;
        }

        int newM = calcoloM(l);
        int[] newL = calcoloL(l,newM);
        int[] newR = calcoloR(l,newM);

        mergeSort(l,newL,newR);

        newM = calcoloM(r);
        newL = calcoloL(r,newM);
        newR = calcoloR(r,newM);
        mergeSort(r,newL,newR);

        //riordina gli elementi l'array
        int i = 0, j = 0, k = 0;
        while (i < l.length && j < r.length) {
            if (l[i] <= r[j]) {
                arr[k++] = l[i++];
            } else {
                arr[k++] = r[j++];
            }
        }
        while (i < l.length) {
            arr[k++] = l[i++];
        }
        while (j < r.length) {
            arr[k++] = r[j++];
        }
        return arr;
    }


    /* A utility function to print array of size n */
    static void printArray(int[] arr)
    {
        int n = arr.length;
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }

    static int calcoloM(int[] arr)
    {
        if(arr == null)
        {
            return 0;
        }
        return arr.length / 2;
    }

    static int[] calcoloL(int[] arr, int m)
    {
        if(arr == null)
        {
            return null;
        }

        if(arr.length == 1)
        {
            return new int[]{};
        }
        return Arrays.copyOfRange(arr, 0, m);
    }

    static int[] calcoloR(int[] arr, int m)
    {
        if(arr == null)
        {
            return null;
        }
        return Arrays.copyOfRange(arr, m, arr.length);
    }

    // Driver code
    public static void main(String[] args){
        int[] arr = {2,4,6,7,8,1};
        System.out.println("Given Array");
        if(arr == null)
        {
            System.out.println("Null Array");
            System.out.println("\nSorted array");
            int m = calcoloM(arr);
            int[] l = calcoloL(arr,m);
            int[] r = calcoloR(arr,m);
            mergeSort(arr, l, r);
        }
        else
        {
            printArray(arr);
            int m = calcoloM(arr);
            // int[] l = {2,4,6};
            // int[] r = {7,8,1};
            int[] l = calcoloL(arr,m);
            int[] r = calcoloR(arr,m);
            System.out.println("\nSorted array");
            arr = mergeSort(arr, l, r);
            printArray(arr);
        }
    }
}