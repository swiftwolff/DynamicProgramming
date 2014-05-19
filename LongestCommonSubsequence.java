
public class LongestCommonSubsequence {
	 public int LongestCommonSubquence(String a, String b){
	        
	        if(a.length()==0 || a==null &&b.length()==0 || b==null){ 
	            return 0;
	        }
	        
	        int[][] DP = new int[a.length()+1][b.length()+1];  //O(nxm) space
	        
	        for(int i=0;i<DP.length;i++){
	            DP[i][0] = 0;
	        }
	    
	        for(int j=0;j<DP[0].length;j++){
	            DP[0][j] = 0;
	        }
	    
	        for(int i=1;i<=a.length();i++){  //row O(n^2)
	            for(int j=1;j<=b.length();j++){  //col
	                if(a.substring(i-1,i+1-1).equals(b.substring(j-1,j+1-1))){
	                    DP[i][j] = DP[i-1][j-1] + 1;
	                }else{
	                    DP[i][j] = Math.max(DP[i-1][j],DP[i][j-1]);
	                }
	            }
	        }
	    
	        return DP[a.length()][b.length()];
	    }
	 
	 public static void main(String args[]){
		 LongestCommonSubsequence solution = new LongestCommonSubsequence();
		 System.out.println(solution.LongestCommonSubquence("aabcda", "badeca"));
	 }
}
