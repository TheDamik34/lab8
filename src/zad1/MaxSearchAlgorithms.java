package zad1;

import java.util.ArrayList;
import java.util.List;

public class MaxSearchAlgorithms {

    List<Integer> leftToRightScan(int[] array) {
        List<Integer> result = new ArrayList<>();
        int max = array[0];
        result.add(max);
        for(int i = 0 ; i < array.length; ++i) {
            if(max < array[i]) {
                max = array[i];
                result.add(max);
            }
        }
        return result;
    }

    List<Integer> rightToLeftScan(int[] array) {
        List<Integer> result = new ArrayList<>();
        int max = array[array.length - 1];
        result.add(max);
        for(int i = array.length - 1 ; i >= 0 ; --i) {
            if(max < array[i]) {
                max = array[i];
                result.add(max);
            }
        }
        return result;
    }

    List<Integer> evenToOddScan(int[] array) {
        List<Integer> result = new ArrayList<>();
        int max = array[0];
        result.add(max);
        for(int i = 0 ; i < array.length; i+=2) {
            if(max < array[i]) {
                max = array[i];
                result.add(max);
            }
        }

        for(int i = 1 ; i < array.length; i+=2) {
            if(max < array[i]) {
                max = array[i];
                result.add(max);
            }
        }
        return result;
    }

    int odfiltrowana() {
        return 5;
    }
}
