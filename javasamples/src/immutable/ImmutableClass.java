package immutable;

public final class ImmutableClass {

    private final String str;
    
    private int x;
    
    private NonImmutableClass nonImm;

    public ImmutableClass(String str, int x, NonImmutableClass nonImm) {
	this.str = str;
	this.x = x;
	this.nonImm = nonImm;

    }

    public String getStr() {
	return str;
    }

    public int getX() {
        return x;
    }

    public NonImmutableClass getNonImm() {
	
	//ImmutableClass copy = new ImmutableClass(str, x, nonImm);
	
	NonImmutableClass nonImmutableClass = new NonImmutableClass();
	//nonImmutableClass.se
	
        return nonImm;
    }
}
