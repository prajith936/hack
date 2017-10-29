class BinaryTreeDiameter{
	TreeNode root;
	static class TreeNode{
		int data;
		TreeNode right;
		TreeNode left;
		TreeNode(int d){
			data = d;
		}
	}
	static class decisionVal{
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
	}
	decisionVal diameter(TreeNode curr){
		if (curr.left == null && curr.right == null) {//leaf node ap
			return new decisionVal(1,1);
		}
		//
		decisionVal temp1 = new decisionVal(),temp2 = new decisionVal();
		if (curr.left!=null) {
			temp1 = diameter(curr.left);
		}
		if (curr.right!=null) {
			temp2 = diameter(curr.right);
		}
		//System.out.println(curr.data + " " + temp1.diameter + " " + temp2.diameter);
		int height = Math.max(temp1.getHeight(),temp2.getHeight());
		int diameter = Math.max(temp1.getDiameter(),temp2.getDiameter());
		diameter = Math.max(diameter,temp2.getHeight()+temp1.getHeight()+1);
		return new decisionVal(diameter,height+1);


	} 
	void insert(int data){
		TreeNode curr = root;
		TreeNode prev = null;
		if (root == null) {
			root = new TreeNode(data);
			return;
		}
		while(curr != null){
			prev = curr;
			if (curr.data < data) {
			
				curr = curr.right;
			}else {

				curr = curr.left;
			}
		}
		
			TreeNode a =new TreeNode(data);
			if (prev.data < data) {
				
				prev.right = a;
			}else{
				prev.left = a;
			}
		
	}	 
	void print(TreeNode curr){
		if (curr == null) {
			return;
		}
		print(curr.left);
		System.out.print(" "+ curr.data);
		print(curr.right);
	}
	public static void main(String[] args) {
		BinaryTreeDiameter btd = new BinaryTreeDiameter();
		btd.insert(50);
		btd.insert(30);
		btd.insert(20);
		btd.insert(10);
		btd.insert(5);
		btd.insert(40);
		btd.insert(45);
		btd.insert(49);
		btd.print(btd.root);
		decisionVal d = btd.diameter(btd.root);
		System.out.println(d.diameter);
	}
}
