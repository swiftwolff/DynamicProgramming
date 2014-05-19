
public class KnapsackPickMultipleTimes {
	public int maxValue(int[] w, int[] v, int limit){
        if(w.length==0 || v.length==0) return 0;
//        int max = 0;
//        for(int i=0;i<w.length;i++){
//            if(w[i]>max) max = w[i];
//        }
        
        int[][] DP = new int[v.length+1][limit+1];
        
        for(int i=0;i<DP.length;i++){
            DP[i][0] = 0;
        }
        
        for(int j=0;j<DP[0].length;j++){
            DP[0][j] = 0;
        }
        
        for(int i=1; i<DP.length;i++){  //index of items to be taken out
            for(int j=1; j<DP[0].length;j++){  //w capacity
                if(w[i-1] > j){
                    DP[i][j] = DP[i-1][j];
                }else{
//                	System.out.println("i is "+i);
//                	System.out.println("j is "+j);
//                	System.out.println("DP[i][j-w[i-1]]+v[i-1] is " + DP[i][j-w[i-1]]+v[i-1]);
//                	System.out.println("DP[i-1][j] is "+DP[i-1][j]);
                    DP[i][j] = Math.max(DP[i][j-w[i-1]]+v[i-1],DP[i-1][j]);
//                    System.out.println("DP is " + DP[i][j]);
//                    System.out.println();
                }
            }
        }

        return DP[v.length][limit];
    
    }
	
	public static void main(String args[]){
		int[] w= {3,4,2};
		int[] v= {4,5,3};
		
		KnapsackPickMultipleTimes solution = new KnapsackPickMultipleTimes();
		System.out.println(solution.maxValue(w, v,7));
	}
}
