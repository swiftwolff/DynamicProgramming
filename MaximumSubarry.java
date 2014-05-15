
public class MaximumSubarry {
	public int maxSubarry(int[] arry){
		int moveLength = 0;
		int startIndex = 0;
		int endIndex = 0;
		int[] spot = new int[2];
        int max = Integer.MIN_VALUE;
        int maxMoveLen = Integer.MIN_VALUE;
        if(arry.length==0){
            return 0;
        }
        int sum = 0;

        for(int i=0; i<arry.length;i++){
        
            if(sum + arry[i] >= arry[i]){
                sum = sum + arry[i];
                moveLength++;
                if(moveLength > maxMoveLen){ //cache it only if it has multiple adding value than before
                	spot[0] = startIndex;
                }
            }else{
                sum = arry[i];
                startIndex= i;  //start over
                moveLength=0;
            }
            if(sum>max){
            	endIndex = i;
            	spot[1] = endIndex;
            	max = sum;
            }
        }
        System.out.println(spot[0]); //locate the starting point
        System.out.println(spot[1]); //locate the ending point
        return max;
    }
	
	public static void main(String args[]){
		int[] arry = {1,2,-6,3,-2,4,-1,3,2,-4};
		MaximumSubarry solution = new MaximumSubarry();
		System.out.println(solution.maxSubarry(arry));
	}
}
