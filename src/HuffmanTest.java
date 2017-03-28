import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HuffmanTest{
	public static void main(String[] args){
		BinaryHeap binaryheap = new BinaryHeap();
		FourWayHeap fourwayheap = new FourWayHeap();
		PairingHeap pairingheap = new PairingHeap();
		//BufferedReader br;
		Scanner scanner;
		int[] freqTable = new int[100000000];
		
		try {
			scanner = new Scanner(new File(args[0]));
			int temp;
			while(scanner.hasNextInt())
			{
				temp = scanner.nextInt();
				freqTable[temp]++;

			}
			
			long startTime = System.currentTimeMillis();
			for(int i =0;i<10;i++)
			//	binaryheap.BinaryHeapImplementation(freqTable);
			//System.out.println((((System.currentTimeMillis()-startTime))/10)+" = time to make huffman trees using binary heap ");
			
			startTime = System.currentTimeMillis();
			//for(int i =0;i<10;i++)			
				fourwayheap.FourWayHeapImplementation(freqTable);
			//System.out.println((((System.currentTimeMillis()-startTime))/10)+" = time to make huffman trees using 4-way heap");
			
			startTime = System.currentTimeMillis();
			for(int i =0;i<10;i++)	{
			//	pairingheap.PairingHeapImplementation(freqTable);
			}
			//System.out.println((((System.currentTimeMillis()-startTime))/10)+" = time to make huffman trees using pairing heap");
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}