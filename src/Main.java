import LeetCode.Problem271To280;
import LeetCode.Problem91To100;
import Problem11To20.FourSum;
import Problem1To10.Median_Two_Sorted_Arrays;
import Problem1To10.String_to_Integer;
import Problem21To30.Divide_Two_Integers;
import Problem21To30.Generate_Parentheses;
import Problem21To30.Substring_with_Concatenation_of_All_Words;
import Problem31To40.Next_Permutation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Next_Permutation obj = new Next_Permutation();
        int[] input = new int[]{1, 5, 1};
        obj.nextPermutation(input);
        for (int num: input) System.out.println(num);
    }

}

