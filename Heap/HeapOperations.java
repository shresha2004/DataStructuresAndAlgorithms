import java.util.*;

class HeapDataStructure{
    ArrayList<Integer> heap;
    HeapDataStructure(){
        heap=new ArrayList<>();
        insert(-1);
    }

    //Insertion
    public void insert(int ele){
        //Add at the last
        heap.add(ele);
        int index = heap.size()-1;
        while(index > 1){
        //Get parent index
        int parent = index/2;

        //Compare with parent (max heap)
        if(heap.get(parent)<heap.get(index)){
            int temp = heap.get(parent);
            heap.set(parent,heap.get(index));
            heap.set(index, temp);
            index=parent;
        }
        else{
            return;
        }
        }
    }

    public void delete(){
        int deleteIndex = 1;//Deleting root node
        int lastIndex = heap.size()-1;

        //Step 1 swap with last index
        swap(heap,lastIndex,deleteIndex);

        //Step 2 correct the heap
        int index =1;
        while(index < heap.size()){
            int leftIndex = 2*index;
            int rightIndex = (2*index)+1;

            if(leftIndex < heap.size() && heap.get(leftIndex)>heap.get(index)){
                swap(heap, leftIndex, index);
                index=leftIndex;
            }
            else if(rightIndex < heap.size() && heap.get(rightIndex)>heap.get(index)){
                swap(heap,rightIndex,index);
                index=rightIndex;
            }
            else return;
        }
    }

    public void heapify(ArrayList<Integer> arr, int index){
        int largest = index;
        int leftIndex = 2*largest;
        int rightIndex = (2*largest)+1;
        if(leftIndex <= arr.size()-1 && arr.get(leftIndex)>arr.get(largest))
            largest = leftIndex;
         if(rightIndex <= arr.size()-1 && arr.get(rightIndex)>arr.get(largest))
            largest=rightIndex;
        
            if(largest != index){
                swap(arr, largest, index);
                heapify(arr, largest);
            }
            
    }
    private void swap(ArrayList<Integer> arr,int a,int b){
        int temp = arr.get(a);
        arr.set(a,arr.get(b));
        arr.set(b,temp);
    }
}
public class HeapOperations {
    public static void main(String[] args) {
        HeapDataStructure hp = new HeapDataStructure();
        hp.insert(40);
        hp.insert(50);
        hp.insert(30);
        hp.insert(20);
        hp.insert(10);
        hp.insert(15);
        System.out.println("Insert to Heap:"+hp.heap);
        hp.delete();
        System.out.println("Delete from heap:"+hp.heap);

        ArrayList<Integer> convertToHeap = new ArrayList<>(Arrays.asList(-1,50,60,80,10,100));
        int n = convertToHeap.size();
        //Not to consider leaf node
        for(int i=n/2;i>0;i--){
          hp.heapify(convertToHeap,i);
        }
        System.out.println("Heapify:"+convertToHeap);
    }
}
