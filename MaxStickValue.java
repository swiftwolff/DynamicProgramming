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
    
    public int waysofCutting(int len, int cutLen){
        
        int nextCutLen=0;
        switch(cutLen){
        case 4:
            nextCutLen = 3;
            break;
        case 3:
            nextCutLen = 2;
            break;
        case 2:
            nextCutLen = 1;
            break;
        case 1:
            return 1;
        }
       
        int sum = 0;
        for(int i=0; i*cutLen<=len;i++){
            sum+= waysofCutting(len-i*cutLen, nextCutLen);
        }
    
        return sum;
    
    }
    
    public static void main(String args[]){
    	int[] values = {0,1,5,8,9,10,17,17,20,24,30};
    	MaxStickValue solution = new MaxStickValue();
//    	System.out.println(solution.maxValue(values, 4));
    	System.out.println(solution.waysofCutting(0, 3));
    }
}
