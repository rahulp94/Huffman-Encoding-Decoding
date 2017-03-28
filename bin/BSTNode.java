public class BSTNode{
	public BSTNode left;
	public BSTNode right;
	public int data;
	public int huff;
	
	//Constructors
	public BSTNode(){
		left = null;
		right = null;
		data = 0;
		huff = -1;
	}
	
	public BSTNode(int n, int y){
		left = null;
		right = null;
		data = n;
		huff = y;
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