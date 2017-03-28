import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;


public class FourWayHeap{
	
	ArrayList<BSTNode> al = new ArrayList<BSTNode>();

	public int firstChild(int i){
	int first_child = 4*i+1;
	return first_child;
	}
	
	public int secondChild(int i){
		int second_child = 4*i+2;
		return second_child;
	}
	
	public int thirdChild(int i){
		int third_child = 4*i+3;
		return third_child;
	}
	
	public int fourthChild(int i){
		int fourth_child = 4*i+4;
		return fourth_child;
	}
	
	public void minHeapify(ArrayList<BSTNode> a,int i){
		int smallest;
		int first = firstChild(i);
		int second = secondChild(i);
		int third = thirdChild(i);
		int fourth = fourthChild(i);
		int len = a.size();
		if(first<len && a.get(first).data <= a.get(i).data){
			smallest = first;
		}
		else{
			smallest = i;
		}
		
		if(second<len && a.get(second).data <= a.get(smallest).data){
			smallest = second;
		}
		
		if(third<len && a.get(third).data <= a.get(smallest).data){
			smallest = third;
		}
		
		if(fourth<len && a.get(fourth).data <= a.get(smallest).data){
			smallest = fourth;
		}
		
		if(smallest!=i){
			Collections.swap(a, i, smallest);
			minHeapify(a,smallest);
		}
	}
	
	public void buildMinHeap(ArrayList<BSTNode> a){
		int len = a.size();
		for(int i = ((len/4)-1)+3;i>=3; i++){
			minHeapify(a, i);
		}
	}
	
	public BSTNode removeMin(ArrayList<BSTNode> a){
		int len = a.size();
		BSTNode min = a.get(3);
		a.set(3, a.get(len-1));
		a.remove(len-1);
		minHeapify(a, 3);
		return min;
	}
	
	public void minHeapInsert(ArrayList<BSTNode> a, BSTNode bstnode){
		a.add(bstnode);
		int i = a.size()-1;
		while(i>0 && a.get(((i-4)/4)+3).data>a.get(i).data){
			Collections.swap(a, i, ((i-4)/4)+3);
			i = ((i-4)/4)+3;
		}
	}
	
	public BSTNode nodeCombine(BSTNode b1, BSTNode b2){
		BSTNode bNew = new BSTNode(b1.data + b2.data);
		bNew.left = b1;
		bNew.right = b2;
		return bNew;
	}
	
	
	public void FourWayHeapImplementation(int[] hm){
		
		ArrayList<BSTNode> al = new ArrayList<BSTNode>();
		//Adding leading zeros to the array list
		al.add(null);
		al.add(null);
		al.add(null);

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