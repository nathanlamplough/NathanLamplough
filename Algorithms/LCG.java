public class LCG {
	long a;
	long c;
	long m;
	long s;
	long sh;
    public LCG(long _a, long _c, long _m, long seed) { 
    	this.a = _a;
    	this.c = _c;
    	this.m = _m;
    	this.s = seed;
    }
    public LCG(long _a, long _c, long _m, long seed, long _shift) { 
    	this.a = _a;
    	this.c = _c;
    	this.m = _m;
    	this.s = seed;
    	this.sh = _shift;
    }
    public long next() {
    	if (sh > 0){
    	s = (s >> sh);
    } else{
    	s = (a * s + c) % m;
    }
    return s;
}
    public void seed(long seed) {
    	this.s = seed;
     }
}
