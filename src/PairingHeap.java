import java.util.ArrayList;

public class PairingHeap{
	
	public ArrayList<PairingNode> plChildren = new ArrayList<PairingNode>();
	public PairingNode root = null;
 	
	//Constructor
	public PairingHeap(){
		this.root = null;
		this.plChildren = new ArrayList<>();
	}
	
	public PairingHeap(PairingNode p){
		this.root = p;
		this.plChildren = new ArrayList<>();
	}

	public PairingNode getRoot() {
		return root;
	}

	public void setRoot(PairingNode root) {
		this.root = root;
	}
	
	public void pairingInsert(PairingNode temp){
		if(root == null) root = temp;
		else{
			if(temp.data > root.data){
				temp.plChildren.add(root);
				root = temp;
			}
			else{
				root.plChildren.add(temp);
			}
		}
	}
	
	public PairingNode meldNode(PairingNode p1, PairingNode p2){
		if(p1 == null) return p2;
		if(p2 == null) return p1;
		
		if(p1.data<p2.data){
			p1.plChildren.add(p2);
			root.plChildren.add(p1);
			return p1;
		}
		else{
			p2.plChildren.add(p1);
			root.plChildren.add(p2);
			return p2;
		}
	}
	
	public PairingNode mergeHeap(PairingNode node){
		if(node == null || node.nextSibling == null) return node;
		
		else{
			PairingNode a,b,temp;
			a= node;
			b= node.nextSibling;
			temp = node.nextSibling.nextSibling;
			
			a.nextSibling = null;
			b.nextSibling = null;
			
			return meldNode(meldNode(a,b),mergeHeap(temp));
		}
		
	}
	
	public PairingNode deleteMin(PairingNode node){
		return mergeHeap(node.left);
	}
	
	public PairingNode combine(PairingNode temp1, PairingNode temp2) {
		PairingNode newNode = new PairingNode(temp1.data + temp2.data);
		newNode.left = temp1;
		newNode.nextSibling = temp2;
		return newNode;
	}
	
	public void PairingHeapImplementation(int[] hm) {
		//BinaryHeap object = new BinaryHeap();
		PairingNode t1, t2, tc;
		int flag = 1;
		for (int i = 0; i < hm.length; i++) {
			if (hm[i] != 0) {
				if (flag == 1) {
					root = new PairingNode(hm[i]);
					flag = 0;
				} else {
					PairingNode temp = new PairingNode(hm[i]);
					pairingInsert(temp);
				}
			}
		}

		while (root.plChildren.size() != 0) {
			t1 = root;
			deleteMin(t1);
			t2 = root;
			deleteMin(t2);
			tc = combine(t1, t2);
			pairingInsert(tc);
		}
	}
	public void insert(PairingNode temp) {
		if (root == null)
			root = temp;
		else if (temp.data <= root.data) {
			temp.plChildren.add(root);
			root = temp;
		} else
			root.plChildren.add(temp);
	}
}