public class Xorshift {
	long a;
	long c;
	long b;
	long x;
    public Xorshift(long _a, long _b, long _c, long seed) {
    	this.a = _a;
    	this.c = _c;
    	this.b = _b;
    	this.x = seed;

     }
    public long next() {
        x ^= (x << a) % 4294967296L;
  		x ^= (x >> b) % 4294967296L;
  		x ^= (x << c) % 4294967296L;

  			return x;
    }
    public void seed(long seed) {
    	this.x = seed;
     }
}
