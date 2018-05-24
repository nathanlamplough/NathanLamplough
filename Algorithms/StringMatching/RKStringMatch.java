public class RKStringMatch extends StringMatch {
	public int count;
	public char myCharAt(String s, int i){
        this.counter.add(1);
        count++;
        return s.charAt(i);
    }
	public int hash(String s, int st, int en){
		int sum = 0;
		int hash = 0;
		for (int i = st; i < en; i++){
			sum = sum + myCharAt(s, i);
		}
		hash = sum%256;
		return hash;
	}
    public int match(String text, String pattern) {
        int m = pattern.length();
        int n = text.length();
        int e = m;
        if (m == 0){
        	System.out.println(count);
        	return 0;
        }
        if (n == 0){
        	System.out.println(count);
        	return -1;
        }
        
        int hm = hash(pattern, 0, pattern.length());
        
       for (int i = 0; i <= text.length()-m; i++){
       		boolean found = true;
       		if(hash(text, i, e) == hm){
       			e++;
        		for(int j = 0; j < m; j++){
        			if(myCharAt(text, i+j) != myCharAt(pattern, j)){
        				found = false;
        				break;
        			}
        		}
        		if (found){
        			System.out.println(count);
        			return i;
        		}
        	} else{
		e++;
		}	
    }
    System.out.println(count);
    return -1;
}
}
