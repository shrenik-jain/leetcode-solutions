/*
Question : Given a string S, find the number of different non-empty palindromic subsequences in S, 
           and return that number modulo 10^9 + 7. A subsequence of a string S is obtained by
           deleting 0 or more characters from S. A sequence is palindromic if it is equal to the sequence reversed. 

Link : https://leetcode.com/problems/count-different-palindromic-subsequences/
*/

class Solution {
    public int countPalindromicSubsequences(String str) {
        
    int mod = (int) Math.pow(10, 9) + 7;
		int[][] dps = new int[str.length()][str.length()];
		int[] next = new int[str.length()];
		int[] prev = new int[str.length()];
		HashMap<Character , Integer> map = new HashMap<>();
		
		for(int i = 0; i < str.length(); i++) {
		    char ch = str.charAt(i);
		    
		    if(map.containsKey(ch) == false) {
		        prev[i] = -1;
		    }
		    else {
		        prev[i] = map.get(ch);
		    }
		    
		    map.put(ch , i);
		}
		
		map.clear();
		
		for(int i = str.length() - 1; i >= 0; i--) {
		    char ch = str.charAt(i);
		    
		    if(map.containsKey(ch) == false) {
		        next[i] = -1;
		    }
		    else {
		        next[i] = map.get(ch);
		    }
		    
		    map.put(ch , i);
		}
		
		
		for(int g = 0; g < str.length(); g++) 
		{
		    for(int i = 0, j = g; j < str.length(); i++ , j++)
		    {
		        if(g == 0) {
		            dps[i][j] = 1;
		        }
		        else if(g == 1) {
		            dps[i][j] = 2;
		        }
		        else {
		            char sc = str.charAt(i);
		            char ec = str.charAt(j);
		            
		            if(sc != ec) {
		                dps[i][j] = (dps[i + 1][j] + dps[i][j - 1] - dps[i + 1][j - 1]) % mod;    
		            }
		            else {
		                int n = next[i];
		                int p = prev[j];
		                
		                if(n > p) {
		                    dps[i][j] = (2 * dps[i + 1][j - 1] + 2) % mod;
		                }
		                else if(n == p) {
		                    dps[i][j] = (2 * dps[i + 1][j - 1] + 1) % mod;   
		                }
		                else {
		                    dps[i][j] = (2 * dps[i + 1][j - 1] - dps[n + 1][p - 1]) % mod;
		                }
		            }
		            
		        }
                dps[i][j] = dps[i][j] < 0 ? dps[i][j] + mod : dps[i][j];
		    }
		}
		
		return dps[0][str.length() - 1]; 
    }
}
