package com.example.test.DataStructures.Stacks;

import java.util.Stack;

//    Given an array arr[ ] of size N having distinct elements, the task is to find the next smaller element
//    for each element of the array in order of their appearance in the array.
//    Next greater element of an element in the array is the nearest element on the right which is smaller
//    than the current element.
//    If there does not exist next smaller of current element, then next smaleer element for current element is -1.
//    For example, next smaller of the last element is always -1.

public class NextSmallerElementToRight
{

    public static void main(String[] args) {
        long[] in = {5,7,2,5,1,8,9};
        long[] result = findNextSmallerElement(in,7);
        for(long x : result)
        {
            System.out.print(x+" ");
        }
        System.out.println();
    }
    public static long[] findNextSmallerElement(long[] arr, int n)
    {
        long[] ans = new long[n];
        Stack<Long> stack = new Stack<Long>();
        int k=n-1;
        for(int i=n-1;i>=0;i--)
        {
            if(stack.isEmpty())
            {
                ans[k--] = -1;
            }
            else if(stack.peek()<arr[i])
            {
                ans[k--] = stack.peek();
            }
            else
            {
                while(!stack.isEmpty() && stack.peek()>=arr[i])
                {
                    stack.pop();
                }
                if(stack.isEmpty())
                {
                    ans[k--] = -1;
                }
                else
                {
                    ans[k--] = stack.peek();
                }
            }
            stack.push(arr[i]);
        }

        return ans;
    }
}
