import java.io.*;
import java.util.*;

public class Solution {
    static void swap(char[] word, int i, int j) {
        char t = word[i];
        word[i] = word[j];
        word[j] = t;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            char[] word = sc.next().toCharArray();
            int max = -1, lower = 0;
            for (int i = word.length-1; i > max; i--) {
                for (int j = i - 1; j >= Math.max(0, max); j--) {
                    if (word[i] > word[j]) {
                        if (j > max) {
                            max = j;
                            lower = i;
                        }
                    }
                }
            }
            if (max == -1)
                System.out.println("no answer");
            else {
                swap(word, max, lower);
                Arrays.sort(word, max+1, word.length);
                System.out.println(word);
            }
        }
    }
}