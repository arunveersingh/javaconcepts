package serialiazable;

public class ChildNonSerializedExtendingParentSerialized
	extends ParentSerialized {
    
    private String name;

    public ChildNonSerializedExtendingParentSerialized(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }
}
