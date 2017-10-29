import java.util.*;

class Bst{
	node root;
	node insert(node root, int x){
		if (root == null) {
			return new node(x);
		}
		if (root.data < x) {
			root.right = insert(root.right,x);
		}else
			root.left = insert(root.left,x);
		return root;
	}
	void insert(int x){
		root = insert(root,x);
	}
	void delete(node root,int x){
		node prev = null;
		node curr = root;
		while(curr != null){
			if (curr.data == x) {
				break;
			}
			prev = curr;
			if (curr.data < x) {
				curr = curr.right;
			}else
				curr = curr.left;
			
		}
		if (curr == null) {
			return;
		}
		boolean flag = true;//left child
		if (prev.left == curr ) {
			flag = true;
		}else{
			flag = false;
		}
		node temp;
		if (curr.left == null && curr.right == null) {
			temp = null;
		}else if(curr.left != null && curr.right != null){
			int n = inorderSuccessor(curr.right);
			temp = new node(n);
			temp.left = curr.left;
			temp.right = curr.right;
				
		}else if (curr.left != null) {
			temp = curr.left;
		}else{
			temp = curr.right;
		}
		if (flag) {
			prev.left = temp;	
		}else{
			prev.right = temp;
		}
		
	}
	int inorderSuccessor(node curr){
		node prev=null;
		while(curr.left!=null){
			prev = curr;
			curr = curr.left;
			
		}
		int x = curr.data;
		prev.left = curr.right;
		return x;
	}
	void printInorder(){
		node curr = root;
		Stack<node> st = new Stack<node>();
		while(curr!=null){
			st.push(curr);
			curr = curr.left;
		}
		while(!st.isEmpty()){
			curr = st.pop();
			System.out.println(curr.data);
			if (curr.right != null) {
				curr = curr.right;
				while(curr!= null){
					st.push(curr);
					curr = curr.left;
				}
			}

		}

	}
	void printPreorder(){
		node curr = root;
		Stack<node> st = new Stack<node>();
		
		st.push(curr);
		while(!st.isEmpty()){
			curr = st.pop();
			System.out.println(curr.data);
			if (curr.right != null) {
				
				st.push(curr.right);
			}
			if(curr.left != null){
				st.push(curr.left);
				
			} 
		}

	}
	/*

	void printTopView(){
		Queue<node> q = new LinkedList<node>();
		root.hd = 0;
		int hd = 0;
		q.offer(root);
		HashSet<Integer> hs = new HashSet<Integer>();
		while(!q.isEmpty()){

			node curr = q.poll();
			if (!hs.contains(curr.hd)) {
				hs.add(curr.hd);
				System.out.println(curr.data);
			}
			
			hd++;
			if (curr.left!=null) {
				curr.left.hd = hd;
				q.offer(curr.left);
			}
			if (curr.right!=null) {
				curr.right.hd = hd;
				q.offer(curr.right);
			}
		}


	}*/
	/*void concat(node a,node mid,node b){
		if (a == null && b == null) {
			head = mid;
		}
		if (a == ) {
			
		}
		a.right = mid;
		mid.left = a;
		mid.right = b;
		b.left = mid;
		b.right = a;
	}*/
	/*node tail,head;
	void convertToDLL(node curr){
		if(curr == null){
			return;
		}



	}*/

	public static void merge(node root1 , node root2){
        if(root1 == null){
            inorder(root2);
        }
        if(root2 == null){
            inorder(root1);
        }
        node curr1 = root1,curr2 = root2; 
        Stack<node> s1 = new Stack<node>();
        Stack<node> s2 = new Stack<node>();
       
        while(curr1!=null || curr2!=null ||
         !s1.isEmpty() || !s2.isEmpty()){
            
        if (curr1 != null || curr2 != null )
        {
            
            if (curr1 != null)
            {
                s1.push(curr1);
                curr1 = curr1.left;
               
            }
            if (curr2 != null)
            {
                s2.push(curr2);
             
                curr2 = curr2.left;
            }
 
        }
        else
        {
            if (s1.isEmpty())
            {
                while (!s2.isEmpty())
                {
                    curr2 = s2.pop();
                    curr2.left = null;
                    inorder(curr2);
                }
                return ;
            }
            if (s2.isEmpty())
            {
                while (!s1.isEmpty())
                {
                    curr1 = s1.pop();
                    curr1.left = null;
                    inorder(curr1);
                }
                return ;
            }
         
            int top1 = s1.peek().data;
            int top2 = s2.peek().data;
            curr2 = s2.pop();
         	curr1 = s1.pop();
            if( top1 > top2){
              
                System.out.print(curr2.data + " ");
                curr2 = curr2.right;
                s1.push(curr1);
                curr1 = null;
                
            }else{
               
                System.out.print(curr1.data + " ");
                curr1 = curr1.right;
                s2.push(curr2);
                curr2 = null;
            }
        }
        }  
    }
     static void inorder(node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
	public static void main(String[] args) {
		Bst bst = new Bst();
		bst.insert(5);
		bst.insert(3);
		bst.insert(15);
		bst.insert(10);
		bst.insert(23);
		bst.insert(17);
		bst.insert(4);

		Bst bst2 = new Bst();
		bst2.insert(5);
		bst2.insert(3);
		bst2.insert(15);
		bst2.insert(10);
		bst2.insert(23);
		bst2.insert(17);
		bst2.insert(4);
		bst2.printPreorder();
		merge(bst.root,bst2.root);
	}
}
class node{
	int data;
	node left , right;
	int hd;
	node(int x){
		data = x;
	}
}