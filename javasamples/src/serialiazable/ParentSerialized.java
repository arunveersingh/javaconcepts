package serialiazable;

import java.io.Serializable;

public class ParentSerialized implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String parentName;
    
    public ParentSerialized() {

    }

    public ParentSerialized(String parentName) {
	this.parentName = parentName;
    }

    public String getParentName() {
	return parentName;
    }
    
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

}
