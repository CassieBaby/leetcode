package leetcode.medium;

 /**
 * @author miss cassie
 * Given an array of n integers where n > 1, nums, 
 * return an array output such that output[i] is equal to 
 * the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 *
 */
public class ProductofArray {
	
	 public int[] productExceptSelf(int[] nums) {
		 
		 int[] output = new int[nums.length];
		 
		 if(nums.length == 0)
			 return output;
		 if(nums.length == 1){
			 output[0] = nums[0];
			 return output;
		 }
			 
		 output[output.length-1] = 1;
		 //求元素后面部分的乘积
		 for(int i = output.length - 2; i>=0; i-- ){
			 output[i] = output[i+1] * nums[i+1];
		 }
		 
		 int left = 1;
		 //将元素后面部分的乘积和元素前面部分的乘积相乘
		 for(int j = 0; j < output.length; j++){
			 output[j] = output[j] * left;
			 left = left * nums[j];
		 }
	        
		 return output;
	 }
	 
	 public static void main(String[] args){
		 
		 int[] nums = {1,2,3,4};
		 ProductofArray pa = new ProductofArray();
		 int[] product = pa.productExceptSelf(nums);
		 int i = 0;
		 while(i < product.length){
			 System.out.println(product[i]);
			 i++;
		 }
		 
	 }

}
