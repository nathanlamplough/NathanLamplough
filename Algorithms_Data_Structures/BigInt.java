public class BigInt {
    public int ndigits;
    // public for test purposes
    public char data[];

    public BigInt(int _ndigits) {
    	this.ndigits = _ndigits;
    	this.data = new char[ndigits];
    }
    public BigInt(String s) {
    	this.ndigits = s.length();
    	this.data = new char[ndigits];
    	int j = 0;
    	for(int i = ndigits-1; i >= 0; i--){
    		int st = s.charAt(i) - '0';
    	    char g = (char) st;
    		this.data[j] = g;
    		j++;
    	}
    }

    public char get(int i) {
    	if(i >= data.length){
    		return 0;
    	}
        return data[i];
    }





    public BigInt Add(BigInt y) {
    	int n = 1;
      if(ndigits > y.ndigits) {
        n += ndigits;

      } else {
        n += y.ndigits;
      }

    	
        BigInt r = new BigInt(n);
        int c = 0;
          for(int i = 0; i < n; i++){
          	int s = get(i) + y.get(i) + c;
          	if(s > 9){
          		c = 1;
          		s = s % 10;
          	} else {
          		c = 0;
          	}
           
          	r.data[i] = (char) s;
          }
        return r;
    }
    public BigInt Sub(BigInt y) {
      int n = 0;
      if(ndigits > y.ndigits) {
        n += ndigits;

      } else {
        n += y.ndigits;
      }

        BigInt r = new BigInt(n);
        int c = 0;
          for(int i = 0; i < n; i++){
            int s = get(i) - y.get(i) - c;
            if(s < 0){
                c = 1;
                s = s + 10;
            } else {
                c = 0;
            }
          
            r.data[i] = (char) s;
          }
        return r;
            }
    public BigInt Shift(int n) {
        BigInt b = new BigInt(n+ndigits);
        int j = 0;
        for(int i = 0; i < n+ndigits; i++){
            if(i < n){
                b.data[i] = 0;
            }
            else {
                b.data[i] = data[j];
                j++;
            }
        }
        return b;
    }
    public BigInt MulByDigit(char c) {
         BigInt res = new BigInt(this.ndigits + c);
         int carry = 0;

    for(int j=0; j< c; j++) {
      for(int i=0; i<this.ndigits; i++) {
        int s = this.get(i) + this.get(i) + carry;
         if(s > 9){
                c = 1;
                s = s % 10;
            } else {
                c = 0;
            }

        res.data[i] = (char) s;
      }
    }

    return res;
    }
    // public BigInt Mul(BigInt y) {
    //     String a = "";
    //     String b = "";
    //     for(int i = ndigits - 1; i >= 0; i--){
    //         char c = (char)(data[i] + '0');
    //             a = a + c;
    //         }
    //      for(int i = y.ndigits-1; i >= 0; i--){
    //         char c = (char)(y.data[i] + '0');
    //             b = b + c;
    //         }
    //     int m = Integer.parseInt(b)*Integer.parseInt(a);
    //     BigInt temp = new BigInt(String.valueOf(m));

    //     return temp;
    // }
    // public BigInt Div(BigInt d) {
	   //  String a = "";
    //     String b = "";
    //     for(int i = ndigits-1; i >= 0; i--){
    //         char c = (char)(data[i] + '0');
    //             a = a + c;
    //         }
    //      for(int i = d.ndigits-1; i >= 0; i--){
    //         char c = (char)(d.data[i] + '0');
    //             b = b + c;
    //         }
    //     int m = Integer.parseInt(a)/Integer.parseInt(b);
    //     BigInt temp = new BigInt(String.valueOf(m));

    //     return temp;
    // }
    // public BigInt Rem(BigInt d) {
	   //  String a = "";
    //     String b = "";
    //     for(int i = ndigits-1; i >= 0; i--){
    //         char c = (char)(data[i] + '0');
    //             a = a + c;
    //         }
    //      for(int i = d.ndigits-1; i >= 0; i--){
    //         char c = (char)(d.data[i] + '0');
    //             b = b + c;
    //         }
    //     int m = Integer.parseInt(a)%Integer.parseInt(b);
    //     BigInt temp = new BigInt(String.valueOf(m));

    //     return temp;
    // }
}
