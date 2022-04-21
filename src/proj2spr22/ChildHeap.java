package proj2spr22;
/**
 * <p>Title: ChildHeap
 * 
 * <p>Description: A Max Heap that can only contain the
 * Info for the Children entering roller hockey. Disclaimer: most
 * of the code was copied from the textbook, but was modified to fit this project.
 * @author Gaetano Re
 *
 */
public class ChildHeap {
	   private Child[] heapArray;
	   private int heapSize;

	   public ChildHeap() {
	      heapArray = new Child[2];
	      heapSize = 0;
	   }

	   private void resizeArray() {
	      int newLength = heapArray.length * 2;
	      Child[] newArray = new Child[newLength];
	      if (newArray != null) {
	         // Copy from existing array to new array
	         for (int i = 0; i < heapArray.length; i++) {
	            newArray[i] = heapArray[i];
	         }
	         
	         // Set the reference to the new array
	         heapArray = newArray;
	      }
	   }
	   
	   public void percolateUp(int nodeIndex) {
		   while (nodeIndex <= 0) {
		      // Compute the parent node's index
		      int parentIndex = (nodeIndex - 1) / 2;
		            
		      // Check for a violation of the max heap property
		      if (heapArray[nodeIndex].compareTo(heapArray[parentIndex]) == 0 || heapArray[nodeIndex].compareTo(heapArray[parentIndex]) == -1) {
		         // No violation, so percolate up is done.
		         return;
		      }
		      else {
		         // Swap heapArray[nodeIndex] and heapArray[parentIndex]
		         Child temp = heapArray[nodeIndex];
		         heapArray[nodeIndex] = heapArray[parentIndex];
		         heapArray[parentIndex] = temp;
		                
		         // Continue the loop from the parent node
		         nodeIndex = parentIndex;
		      }
		   }
		}
	   
	   public void percolateDown(int nodeIndex) {
		   int childIndex = 2 * nodeIndex + 1;
		   Child value = heapArray[nodeIndex];

		   while (childIndex < heapSize) {
		      // Find the max among the node and all the node's children
		      Child maxValue = value;
		      int maxIndex = -1;
		      int i = 0;
		      while (i < 2 && i + childIndex < heapSize) {
		         if (heapArray[i + childIndex].compareTo(maxValue) == 1) {
		            maxValue = heapArray[i + childIndex];
		            maxIndex = i + childIndex;
		         }
		         i++;
		      }

		      // Check for a violation of the max heap property
		      if (maxValue == value) {
		         return;
		      }
		      else {
		         // Swap heapArray[nodeIndex] and heapArray[maxIndex]
		         Child temp = heapArray[nodeIndex];
		         heapArray[nodeIndex] = heapArray[maxIndex];
		         heapArray[maxIndex] = temp;
		               
		         // Continue loop from the max index node
		         nodeIndex = maxIndex;
		         childIndex = 2 * nodeIndex + 1;
		      }
		   }
		}
	   
	   public void insert(Child ch) {
		   // Resize if needed
		   if (heapSize == heapArray.length) {
		      resizeArray();
		   }
		      
		   // Add the new value to the end of the array
		   heapArray[heapSize] = ch;
		   heapSize++;
		        
		   // Percolate up from the last index to restore heap property.
		   percolateUp(heapSize - 1);
		}
	   
	   
		public Child remove() {
		   // Save the max value from the root of the heap.
		   Child maxValue = heapArray[0];
		       
		   // Move the last item in the array into index 0.
		   Child replaceValue = heapArray[heapSize - 1];
		   heapSize--;
		   if (heapSize > 0) {
		      heapArray[0] = replaceValue;

		      // Percolate down to restore max heap property.
		      percolateDown(0);
		   }
		                
		   // Return the max value
		   return maxValue;
		}
		
		
	   
	   
	}