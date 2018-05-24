public class BinarySearch {
	public int counter = 0;
    public boolean search(int array[], int key, int lo, int hi) {
    	int mid = (lo + hi - 1)/2;
    	boolean found = false;
    	if(lo == hi){
    		found = false;
    	}
    	else if (array[mid] == key){
    		found = true;
    	}
    	else if (key < array[mid]){
    		return search(array, key, lo, mid);
    	}
    	else {
    		return search(array, key, mid + 1, hi);
    	}
    	return found;
    }
    public int count(int array[], int key, int lo, int hi){
    	int mid = (lo + hi - 1)/2;
    	if(lo == hi){

    		return counter;
    	}
    	else if (array[mid] == key){
    		counter++;
    		int result = counter;
    		counter = 0;
    		return result;
    	}
    	else if (key < array[mid]){
    		counter++;
    		return count(array, key, lo, mid);
    	}
    	else {
    		counter++;
    		return count(array, key, mid + 1, hi);
    	}
    }
}
