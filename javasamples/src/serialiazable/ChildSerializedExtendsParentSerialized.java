package serialiazable;

import java.io.Serializable;

public class ChildSerializedExtendsParentSerialized extends ParentSerialized
	implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;

    public ChildSerializedExtendsParentSerialized(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

}
