package serialiazable;

import java.io.Serializable;

/**
 * ==================================== extends ParentSerialized works fine
 * ------------------------------------ extends ParentNonSerialized works fine
 * ====================================
 * 
 * @author arunveersingh9@gmail.com
 *
 */
public class ChildSerializedExtendsParentNonSerialized extends
	ParentNonSerialized implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    public ChildSerializedExtendsParentNonSerialized(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

}
