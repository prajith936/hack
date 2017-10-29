import java.util.*;
class CodeChef{
/*	static class decisionVal{
		int diameter;
		int height;
		decisionVal(){
			diameter = 0;
			height = 0;
		}
		decisionVal(int d,int h){
			diameter = d;
			height = h;
		}
		public int getHeight(){
			return height;
		} 
		public int getDiameter(){
			return diameter;
		} 
	}*/
	static boolean isSafe(int node,int size){
		if (node <= size) {
			return true;
		}
		return false;
	}
	static int maxDiameterSum(int i, int[] tree){
		
		return diam(1,tree,tree.length);

	}
	static int diam(int i , int[] tree,int size){
		if (i <= size) {
			
		
		int left = 2*i+1;
		int right = 2*i +2;
		int leftSum = 0;
		int rightSum = 0;
		if (isSafe(left,size)) {
			leftSum = diam(left,tree,size);
		}
		if (isSafe(right,size)) {
			rightSum = diam(right,tree,size);
		}
			int max = Math.max(leftSum,rightSum);
			max = Math.max(max , Math.max(leftSum + tree[i],rightSum + tree[i]));
			max = Math.max(max , leftSum+rightSum+tree[i]);
			return max;
		
		}
		return 0;
	}
	/*int dia(){
		if (curr.left == null && curr.right == null) {//leaf node
			return new decisionVal(1,1);
		}
		decisionVal temp1 = new decisionVal(),temp2 = new decisionVal();
		if (curr.left!=null) {
			temp1 = diameter(curr.left);
		}
		if (curr.right!=null) {
			temp2 = diameter(curr.right);
		}
		
		int height = Math.max(temp1.getHeight(),temp2.getHeight());
		int diameter = Math.max(temp1.getDiameter(),temp2.getDiameter());
		diameter = Math.max(diameter,temp2.getHeight()+temp1.getHeight()+1);
		return new decisionVal(diameter,height+1);
	}*/

}