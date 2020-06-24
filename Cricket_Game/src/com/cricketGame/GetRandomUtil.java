package com.cricketGame;

import java.util.Random;

public class GetRandomUtil {
    private final static Random rand = new Random();

    public static int getRandomNumber(int range) {
        int t1 = rand.nextInt(range);
        return t1;
    }


    public static int findCeil(int arr[], int r, int l, int h) {
        int mid;
        while (l < h) {
            mid = l + ((h - l) >> 1);
            if (r > arr[mid])
                l = mid + 1;
            else
                h = mid;
        }
        return (arr[l] >= r) ? l : -1;
    }

    public static int getRun(int arr[], int freq[], int n) {
        int prefix[] = new int[n], i;
        prefix[0] = freq[0];
        for (i = 1; i < n; ++i)
            prefix[i] = prefix[i - 1] + freq[i];
        int r = ((int) (Math.random() * (323567)) % prefix[n - 1]) + 1;
        int index = findCeil(prefix, r, 0, n - 1);
        return arr[index];
    }

}
