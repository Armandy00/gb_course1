package lesson3;

import java.util.Arrays;

public class HomeWorkApp {
    public static void main(String[] args) {
        int[] firstArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        int[] secondArray = new int[100];
        int[] thirdArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[][] foursArray = {{2, 3, 4, 5, 6, 7}, {2, 3, 4, 5, 6, 7}, {2, 3, 4, 5, 6, 7}, {2, 3, 4, 5, 6, 7}, {2, 3, 4, 5, 6, 7}, {2, 3, 4, 5, 6, 7}};
        int[] fifthArray = {3, 55, 87, -1, 56, 22, -2, 6, -3};
        int[] sixthArray = {2, 2, 2, 1, 2, 2, 10, 1};

        //первое задание
        for (int i = 0; i < firstArray.length; i++) {
            if (firstArray[i] == 0) {
                firstArray[i] = 1;
            } else {
                firstArray[i] = 0;
            }
        }

        //второе задание
        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = i + 1;
        }
        //третье задание
        for (int i = 0; i < thirdArray.length; i++) {
            if (thirdArray[i] < 6) {
                thirdArray[i] = thirdArray[i] * 2;
            }
        }
        //четвертое задание
        for (int i = 0; i < foursArray.length; i++) {
            for (int j = 0, k = foursArray[i].length - 1; j < foursArray[i].length; j++, k--) {
                if (i == j || i == k) foursArray[i][j] = 1;
            }
        }

        //пятое задание
        fullArray(4, 567);

        //шестое задание
        Integer max = Arrays.stream(fifthArray).max().getAsInt();
        Integer min = Arrays.stream(fifthArray).min().getAsInt();

        //cедьмое задание
        System.out.println(checkBalance(sixthArray));

        //восьмое задание
        driftArray(fifthArray, 3);
    }

    static int[] fullArray(int len, int initialValue) {
        int[] newArray = new int[len];
        for (int i = 0; i < len; i++) {
            newArray[i] = initialValue;
        }
        return newArray;
    }

    static boolean checkBalance(int[] workArray) {
        int rubicon = workArray.length - 1;
        int sumStart = Arrays.stream(workArray).sum();
        int sumEnd = 0;

        while (rubicon > 0) {
            sumStart = sumStart - workArray[rubicon];
            sumEnd = sumEnd + workArray[rubicon];
             if (sumStart == sumEnd) {
                return true;
            }
            rubicon--;
        }
        return false;
    }

    static int[] driftArray(int[] workArray, int drift) {
        if (drift == 0) {
            return workArray;
        }

        int index = workArray.length;
        workArray = Arrays.copyOf(workArray, index + Math.abs(drift));
        if (drift > 0) {
            while (index > 0) {
                index--;
                workArray[index + drift] = workArray[index];
            }
            while (index < drift) {
                workArray[index] = workArray[workArray.length - drift + index];
                index++;
            }
            workArray = Arrays.copyOfRange(workArray, 0, workArray.length - drift);
        } else if (drift < 0) {
            drift = Math.abs(drift);
            int i = 0;
            while (i < drift) {
                workArray[index + i] = workArray[i];
                i++;
            }
            workArray = Arrays.copyOfRange(workArray, drift, workArray.length);
        }
        return workArray;
    }
}
