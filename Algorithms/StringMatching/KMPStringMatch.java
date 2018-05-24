public class KMPStringMatch extends StringMatch {
    public char myCharAt(String s, int i){
        this.counter.add(1);
        return s.charAt(i);
    }
	public int[] computePrefix(String p){
		int m = p.length();
		int pi[] = new int[m];
		int k = 0;

		for (int i = 1; i < m; i++){
			while (k > 0 && myCharAt(p,k) != myCharAt(p,i)){
				k = pi[k-1];
			}
		if(myCharAt(p,k) == myCharAt(p,i)){
			k++;
			pi[i] = k;
		}

       
    }
		return pi;
	
}

    public int match(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] pi = computePrefix(pattern);
        int q = 0;
        if (m == 0){
        	return 0;
        }
        
        if (n == 0){
        	return -1;
        } 
        for (int i = 0; i < n; i++){
        	while(q > 0 && myCharAt(pattern, q) != myCharAt(text, i)){
        		q = pi[q-1];
               
        	}
           
        	if(myCharAt(pattern, q) == myCharAt(text, i)){
        		q++;
            }
        	if (q == m){
        		return i - m + 1;
            }
        	
        }
        return -1;
    }
}
