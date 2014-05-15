
class LongestIncreasingSubsequence{
    public int longestIncSub(int[] arry){
        
        //corner case
        if(arry.length==0) return 0;
        
        int max = Integer.MIN_VALUE;
        int[] DP = new int[arry.length];  //this costs n space
        
//        DP[0] = 1;  //initialize
        
        for(int i=0;i<arry.length;i++){
        	DP[i] = 1;  //initialize here b/c everything will start at 1 count itself
            for(int j=0;j<i;j++){
            
                if(arry[i]>arry[j]){
                    if(DP[j]+1 > DP[i]){
                        DP[i] = DP[j]+1;
                    }
                }
//                else{
//                    DP[i] = 1;  take this line away b/c all items initialized to 1
//                }
                
                if(DP[i]>max) max = DP[i];
            }
        }
        
        return max;
    }

    public static void main(String args[]){
    	int[] arry = {9,50,2,13,7,15};
    	LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
    	System.out.println(solution.longestIncSub(arry));
    }


}
