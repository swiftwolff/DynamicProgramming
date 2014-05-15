public class MaxStickValue {
    public int maxValue(int[] values, int stickLen){
        
        int[] DP = new int[stickLen+1];
        
        for(int i=1; i<=stickLen;i++){
            for(int j=1; j<=i; j++){
                if(DP[i-j] + values[j]>DP[i]){
                    DP[i] = DP[i-j] + values[j];
                }
            }
        }
     
        return DP[stickLen];
    }       
    
    public static void main(String args[]){
    	int[] values = {0,1,5,8,9,10,17,17,20,24,30};
    	MaxStickValue solution = new MaxStickValue();
    	System.out.println(solution.maxValue(values, 4));
    }
}
