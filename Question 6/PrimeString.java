import java.util.*;
 
class Solution{
     
    static int MOD = 1000000007;
    static boolean[] prime = new boolean[1000000];
    
    static boolean isPrime(String number){
        int num = Integer.valueOf(number);
        return prime[num];
    }
     
    static int recursion(String number, int i, int[] dp) {
        if (dp[i] != -1)
            return dp[i];
        int cnt = 0;
     
        for(int j = 1; j <= 6; j++) {
           if (i - j >= 0 &&
               number.charAt(i - j) != '0' &&
               isPrime(number.substring(i - j, i))) {
               cnt += recursion(number, i - j, dp);
               cnt %= MOD;
           }
        }
        return dp[i] = cnt;
    }
    
    static int countPrimeStrings(String number) {
        Arrays.fill(prime, true);
     
        prime[0] = false;
        prime[1] = false;
     
        for(int p = 2; p * p <= 1000000; p++){
     
           if (prime[p] == true){
               for(int i = p * p; i < 1000000; i += p){
                  prime[i] = false;
               }
           }
        }
        
        int n = number.length();
        int[] dp = new int[n + 1];
         
        Arrays.fill(dp, -1);
        dp[0] = 1;
     
        return recursion(number, n, dp);
    }
     
    public static void main(String[] args){
        String s1 = "11373113731137311373113731137311373113731137311373113731137311373113731137311373113731137311373113731137311373113731137311373113731137311373";
     
        System.out.print(countPrimeStrings(s1) + "\n");
    }
}
 