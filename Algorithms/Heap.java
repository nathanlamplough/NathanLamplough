import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


class Heap {
    // public for JUnit testing purposes
    public ArrayList<Integer> temp;
    public ArrayList<Integer> array;
    public int heap_size;

    public Heap(int size) {
      
        this.array=new ArrayList<Integer>(size);

        //this.heap_size=size;
       // size=this.heap_size;
    }
    public Heap(List<Integer> source) {
        this(source, false);
    }
    public Heap(List<Integer> source, boolean incremental) {
        // this.array = new ArrayList(source);
        // if(incremental){
        //     for (int i = 0; i < source.size(); i++) {
        //         insert(source.get(i));
        //     }
        //       //heap_size=heap_size+1;  
        //     }else{
        //         for(int k=0; k < source.size(); k++){
        //             this.array.add(source.get(k));
        //             // heap_size=array.size();
        //         }
        //         this.heap_size=array.size();
        //         buildMaxHeap();
        //     }
        this.array = new ArrayList<Integer>(source);
        if(incremental == false){
            buildMaxHeap();
        }else{
            this.array = new ArrayList<Integer>(0);
            this.temp = new ArrayList<Integer>(source);
                for (int i=0; i<temp.size(); i++){
                    insert(temp.get(i));
                }
        }
    }

    public static int parent(int index) {
        int parentt=(index-1)/2;
        return parentt;
    }
    public static int left(int index) {
        int leftt=(2*index)+1;
        return leftt;
    }
    public static int right(int index) {
        int rightt=(2*index)+2;
        return rightt;
    }
    
    public void maxHeapify(int i) {
        
        int l=left(i);
        int r=right(i);
        int largest=i;
        if(l<heap_size && array.get(l) > array.get(largest)){
            largest=l;
        } if(r<heap_size &&array.get(r) > array.get(largest)){
            largest=r;
        }
             if(largest !=i){
                int temp=array.get(i);
                    array.set(i, array.get(largest));
                    array.set(largest, temp);
                    maxHeapify(largest);
                }
            }
        
    
    public void buildMaxHeap() {
        heap_size=array.size();
        for(int j=array.size()/2; j>=0; j--){
            maxHeapify(j);
        }
    }
    public void insert(Integer k) {
        int temp=0;
        array.add(k);
        //array.set(array.get(heap_size), k);
        int i = this.heap_size;
        heap_size=heap_size+1;
        while(i>0 && array.get(parent(i))<array.get(i)){
            temp=array.get(i);
            array.set(i, array.get(parent(i)));
            array.set(parent(i), temp);
                //Collections.swap(array.get(i), array.get(parent(i)));
                i=parent(i);

        }
    }
    public Integer maximum() {
        return array.get(0);
    }
    public Integer extractMax() {
        int max=array.get(0);
        array.set(0, array.get(heap_size-1));
        heap_size=heap_size-1;
        maxHeapify(0);
        return max;
    }
}