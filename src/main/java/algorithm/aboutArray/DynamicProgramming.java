package algorithm.aboutArray;

/**
 * 数组相关的动态规划的问题
 *
 * @author ：chenxin
 * @date ：Created in 2019-9-27 17:09
 * @description：数组相关的动态规划的问题
 * @modified By：
 * @version: 1.0$
 */
public class DynamicProgramming {

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 示例:
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * 来源：力扣（LeetCode）编号：53
     *
     * 解法：动态规划,做了个增强 能够记录是哪一段是最大
     *
      *@Description
      *@Params [nums]
      *@Return int
      *@Author chenxin
      *@Date 2019-9-27 17:10
      *@Version 1.0
      **/
    public static int maxSubArrayDyPg(int[] nums) {
        //值最大的子数组，初始为第一个
        int max = nums[0];
        //最大子数组的开始下标
        int begin =0;
        //最大子数组的结束下标
        int end =0;
        //当前数据范围的值
        int betw = 0;
        for(int i = 0; i < nums.length ; i++){
            betw += nums[i];
            if(max < betw){
                end = i;
            }
            max = Math.max(max, betw);
            //数据范围的值小于0，则刷新数值范围值
            if(betw < 0){
                betw =0;
                begin = i+1;
            }
        }
        System.out.println(begin+"===="+end);
        return max;
    }

    /**
     * 承上一题，归并解法
      *@Description
      *@Params [nums]
      *@Return int
      *@Author chenxin
      *@Date 2019-9-27 17:23
      *@Version 1.0
      **/
    public static int maxSubArrayMerger(int[] nums) {
        return subArray(nums,0,nums.length-1);
    }
    /**
     * 分
     * @param nums
     * @param begin
     * @param end
     * @return
     */
    public static int subArray(int[] nums ,int begin ,int end){
        if(begin >= end){
            return nums[begin];
        }else{
            //和
            int mid = (begin + end)/2;
            int left = subArray(nums,begin,mid);
            int right = subArray(nums,mid+1,end);
            int midMax = max(nums,begin,mid,end);
            if(left >= right){
                return Math.max(midMax, left);
            }else{
                return (Math.max(midMax, right));
            }
        }
    }
    /**
     * 算出含中间的最大值
     * @param nums
     * @param begin
     * @param end
     * @return
     */
    public static int max(int[] nums,int begin,int mid,int end){
        int max = nums[mid];
        int i =mid;
        int betw = nums[mid];
        mid++;
        while(mid <= end ){
            betw +=nums[mid];
            if(betw > max){
                max = betw;
            }
            mid++;
        }
        i--;
        betw = max;
        while(i >= begin ){
            betw +=nums[i];
            if(betw > max){
                max = betw;
            }
            i--;
        }
        return max;
    }
}
