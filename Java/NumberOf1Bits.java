/*
Question : Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

Link : https://leetcode.com/problems/number-of-1-bits/
*/

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
