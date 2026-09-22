class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        Integer dp[][]=new Integer[n][m];
        return helper(dp,n-1,m-1,word1,word2);
        
    }
    public static int helper(Integer dp[][],int n,int m,String word1,String word2){
        if(n<0){
            return m+1;
        }
        if(m<0){
            return n+1;
        }
        if(dp[n][m]!=null){
            return dp[n][m];
        }
        if(word1.charAt(n)==word2.charAt(m)){
            return dp[n][m]=helper(dp,n-1,m-1,word1,word2);
        }
        int insert=helper(dp,n-1,m,word1,word2);
        int delete=helper(dp,n,m-1,word1,word2);
        int replace=helper(dp,n-1,m-1,word1,word2);
        return dp[n][m]=1+Math.min(insert,Math.min(delete,replace));
    }
}