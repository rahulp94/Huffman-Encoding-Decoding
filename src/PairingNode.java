import java.util.ArrayList;

public class PairingNode{
	
	public int data;
	public int element;
	PairingNode left;
	PairingNode nextSibling;
	ArrayList<PairingNode> plChildren = new ArrayList<PairingNode>();
	
	public PairingNode(int data){
		 this.data = data;
		 element = -1;
		 left = null;
		 nextSibling = null;
	 }
	 
	public PairingNode(int element,int data){
		this.data = data;
		this.element = element;
		left = null;
		nextSibling = null;
	} 
	
}