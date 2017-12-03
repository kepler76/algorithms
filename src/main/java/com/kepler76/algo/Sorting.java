package com.kepler76.algo;


import java.util.LinkedList;
import java.util.List;

public class Sorting {

    private static void swapValues(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }


    public static int[] bubblesort(int[] array) {
        for(int iteration = 0; iteration < array.length; iteration++) {
            for(int index =0; index < array.length - 1 - iteration; index++) {
                if(array[index] > array[index+1]) {
                    swapValues(array, index, index + 1);
                }
            }
        }
      return array;

    }

    public static int[] insertionSort(int[] array) {
        for(int listIndex=0; listIndex < array.length; listIndex++) {
            int sortedIndex = listIndex;
            while(sortedIndex >0 && array[sortedIndex] < array[sortedIndex-1] ) {
                swapValues(array, sortedIndex, sortedIndex -1);
                sortedIndex--;
            }
        }
        return array;
    }

    public static int[] selectionSort(int[] array) {
        for(int sortedListSize = 0; sortedListSize < array.length; sortedListSize++) {
            int minValue = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int listIndex = sortedListSize; listIndex < array.length; listIndex++) {
                    if(array[listIndex] < minValue) {
                        minValue = array[listIndex];
                        minIndex = listIndex;
                    }
            }
            if(minIndex != -1) {
                swapValues(array, sortedListSize, minIndex);
            }
        }
        return array;
    }

    static List<Integer> merge(List<Integer> l1, List<Integer> l2) {
        List<Integer> combinedList = new LinkedList<>();
        while(!l1.isEmpty() && !l2.isEmpty()) {
           if (l1.get(0) < l2.get(0)) {
               combinedList.add(l1.get(0));
               l1 = l1.subList(1, l1.size());
           } else {
               combinedList.add(l2.get(0));
               l2 = l2.subList(1, l2.size());
           }
       }
       combinedList.addAll(l1);
       combinedList.addAll(l2);
       return combinedList;

   }

   public static  List<Integer> mergeSort(List<Integer> list) {
        if(list.size() <= 1) return list;
        int splitIndex = list.size()/2;
        List l1 = mergeSort(list.subList(0, splitIndex));
        List l2 = mergeSort(list.subList(splitIndex, list.size()));
        return  merge(l1, l2);
   }
}
