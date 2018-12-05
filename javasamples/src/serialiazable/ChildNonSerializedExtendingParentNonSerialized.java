package serialiazable;

/**
 * ==================================== extends ParentSerialized works fine
 * ------------------------------------ extends ParentNonSerialized works fine
 * ====================================
 * 
 * @author arunveersingh9@gmail.com
 *
 */
public class ChildNonSerializedExtendingParentNonSerialized
	extends ParentNonSerialized {

    private String name;

    public ChildNonSerializedExtendingParentNonSerialized(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

}
