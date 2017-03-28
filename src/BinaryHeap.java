import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;


public class BinaryHeap{
	
	ArrayList<BSTNode> al = new ArrayList<BSTNode>();
	
	public int leftChild(int i){
	int left_child = 2*i+1;
	return left_child;
	}
	
	public int rightChild(int i){
		int right_child = 2*i+2;
		return right_child;
		}
	
	public void minHeapify(ArrayList<BSTNode> a,int i){
		int smallest;
		int l = leftChild(i);
		int r = rightChild(i);
		int len = a.size();
		if(l<len && a.get(l).data <= a.get(i).data){
			smallest = l;
		}
		else{
			smallest = i;
		}
		
		if(r<len && a.get(r).data <= a.get(smallest).data){
			smallest = r;
		}
		
		if(smallest!=i){
			Collections.swap(a, i, smallest);
			minHeapify(a,smallest);
		}
	}
	
	public void buildMinHeap(ArrayList<BSTNode> a){
		int len = a.size();
		for(int i = (len/2)-1;i>=0; i++){
			minHeapify(a, i);
		}
	}
	
	public BSTNode removeMin(ArrayList<BSTNode> a){
		int len = a.size();
		BSTNode min = a.get(0);
		a.set(0, a.get(len-1));
		a.remove(len-1);
		minHeapify(a, 0);
		return min;
	}
	
	public void minHeapInsert(ArrayList<BSTNode> a, BSTNode bstnode){
		a.add(bstnode);
		int i = a.size()-1;
		while(i>0 && a.get(i-1/2).data>a.get(i).data){
			Collections.swap(a, i, (i-1)/2);
			i = (i-1)/2;
		}
	}
	
	public BSTNode nodeCombine(BSTNode b1, BSTNode b2){
		BSTNode bNew = new BSTNode(b1.data + b2.data);
		bNew.left = b1;
		bNew.right = b2;
		return bNew;
	}
	
	public void BinaryHeapImplementation(int[] hm){
		ArrayList<BSTNode> al = new ArrayList<BSTNode>();
		BSTNode b1,b2,b;
		for (int i =0;i<hm.length;i++) {
			if(hm[i]!=0){
				al.add(new BSTNode(hm[i],i)); 
			}
		}
		
		buildMinHeap(al);
		while(al.size()!=1){
			b1 = removeMin(al);
			b2 = removeMin(al);
			b = nodeCombine(b1,b2);
			minHeapInsert(al,b);
		}
	}
	
	public void printLevelOrder(BSTNode root) throws Exception {
		
		Queue<BSTNode> q = new LinkedList<BSTNode>();
		q.add(root);
		BSTNode temp;
		int len;
		
		while(!q.isEmpty()){
			len = q.size();
			int i=0;
			while(i<len){
				temp = q.poll();
				if(temp!=null){
					System.out.println("Frequency value: " + temp.data);
					if(temp.left != null) q.add(temp.left);
					if(temp.right != null) q.add(temp.right);
				}
				else 
					throw new Exception("No record found");
				i++;
			}
			System.out.println();
		}
	}
}