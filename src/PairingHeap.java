import java.util.ArrayList;

public class PairingHeap{
	
	public PairingNode root = null;
 	
	//Constructor
	public PairingHeap(){
		this.root = null;
	}
	
	public PairingHeap(PairingNode p){
		this.root = p;
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
		//if(p1 == null) return p2;
		//if(p2 == null) return p1;
		
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
	
	/*
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
	*/
	
	public void deleteMin(){
		int size = root.plChildren.size();
		PairingNode node;
		if(size == 0) root = null;
		else if(size == 1) root = root.plChildren.get(0);
		else if(size == 2){
			if(root.plChildren.get(0).data < root.plChildren.get(1).data){
				root = root.plChildren.get(0);
				node = root.plChildren.get(1);
				root.plChildren.add(node);
			}
			else{
				node = root.plChildren.get(0);
				root = root.plChildren.get(1);
				root.plChildren.add(node);
			}
			
		}
		else if(size>2){
			ArrayList<PairingNode> temp = new ArrayList<PairingNode>();
			PairingNode p1,p2;
			int cnt=0;
			while(cnt<size){
				p1 = root.plChildren.get(0);
				p2 = root.plChildren.get(1);
				root.plChildren.remove(0);
				cnt++;
				if(cnt != size){
					root.plChildren.remove(0);
					cnt++;
					meldNode(p1,p2);
				}
				else if(cnt == size) root.plChildren.add(p1);
			}
			temp = root.plChildren;
			root = temp.get(0);
			for(int i =1; i<temp.size();i++){
				pairingInsert(temp.get(i));
			}
		}
	}
	
	public PairingNode combine(PairingNode temp1, PairingNode temp2) {
		PairingNode newNode = new PairingNode(temp1.data + temp2.data);
		newNode.left = temp1;
		newNode.nextSibling = temp2;
		return newNode;
	}
	
	public void PairingHeapImplementation(int[] arr) {
		//BinaryHeap obj = new BinaryHeap();
		PairingNode t1, t2, tc;
		int flag = 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				if (flag == 1) {
					root = new PairingNode(arr[i]);
					flag = 0;
				} else {
					PairingNode temp = new PairingNode(arr[i]);
					pairingInsert(temp);
				}
			}
		}

		while (root.plChildren.size() != 1) {
			t1 = root;
			deleteMin();
			t2 = root;
			deleteMin();
			tc = combine(t1, t2);
			pairingInsert(tc);
		}
	}
}