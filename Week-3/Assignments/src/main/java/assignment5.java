import java.util.Arrays;

public class assignment5 {
    public static void main(String[] args) {
        int[] answer = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(answer));
    }
    static int[] twoSum(int[] nums, int target){
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1; j<nums.length;j++){
                if (nums[j]+nums[i]==target){
                    result[0]=i;
                    result[1]=j;
                }
            }
        }
        return result;
    }

}
