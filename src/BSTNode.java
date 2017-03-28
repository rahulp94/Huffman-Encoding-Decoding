public class BSTNode{
	public BSTNode left;
	public BSTNode right;
	public int data;
	public int huff;
	
	//Constructors
	public BSTNode(int n){
		left = null;
		right = null;
		data = n;
		huff = -1;
	}
	
	public BSTNode(int n, int str){
		left = null;
		right = null;
		data = n;
		huff = str;
	}

	public BSTNode getLeft() {
		return left;
	}

	public void setLeft(BSTNode left) {
		this.left = left;
	}

	public BSTNode getRight() {
		return right;
	}

	public void setRight(BSTNode right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
}