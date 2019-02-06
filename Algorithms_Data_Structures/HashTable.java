public class HashTable {
  	private int a;
  	private int c;
  	private int m;
    public int buckets[];
    private double f;
    private int full;
    public HashTable(long _a, long _c, long _m) {
    	this.a = (int) _a; 
    	this.c = (int) _c;
    	this.m = (int) _m;
    	this.buckets = new int[m];
    }
    public void insert(int key) {
        int j=1;
    	int index = (key * a + c) % buckets.length;
    	System.out.print(index);
                if(buckets[index] ==0){
                buckets[index]=key;
            }
                
                else {
                    while(true){
                    if (buckets[index+j] == 0){
                        buckets[index+j]=key;
                        break;
                        }
                            j++;
                            if(index+j>=buckets.length){
                                this.addExtend(buckets.length*2, key);
                            }
    	full++;
    		}
    }
}

    public boolean find(int key) {
    	int index = (key * a + c) % buckets.length;
      int j=1;
      if (buckets[index]==key){
      
        return true;
    }else{
        while(true){
            if (buckets[index+j] == key){
                return true;
                        //break;
                        }
                            j++;
                            if(index+j>=buckets.length-1){
                                return false;
                            }
                        
                        } 
                    }
    }
    public double loadFactor() {
    	int v = 0;
    	for (int i = 0; i < buckets.length; i++){
    		if (buckets[i] != 0)
    			v++;
    		
    	}
    	double vf = (double) v;
    	double bf = (double) buckets.length;
    	f = vf/bf;
        return f;
    }
    public void remove(int key){
    	int index = (key * a + c) % buckets.length;
    	 int j=1;
      if (buckets[index]==key){
      
        buckets[index]=0;
    }else{
        while(true){
            if (buckets[index+j] == key){
                 buckets[index+j]=0;
                        //break;
                        }
                            j++;
                            if(index+j>=buckets.length-1){
                                break;
                            }
                        
                        } 
                    }
        }
    	

   public void addExtend(int newSize, int n) {
   		int temp[] = buckets;
   		buckets = new int[newSize];
 		for (int j = 0; j < temp.length; j++) {
   		int index = (temp[j] * a + c) % buckets.length;
    	while (buckets[index] != 0){
    		index++;
    		index%=buckets.length;
    	}
    	buckets[index] = temp[j];
   		}
 		this.insert(n);
   }
    private void display() {
    	for (int i = 0; i < buckets.length; i++) {
    		if(buckets[i] != 0) {
    		System.out.print(buckets[i]);
    		System.out.print(", ");
    		
    	}
    }
    	System.out.println();
    	System.out.println("The Hash table size is " + buckets.length);
}
}