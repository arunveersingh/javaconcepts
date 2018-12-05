/**
 * 
 */
package serialiazable;

/**
 * @author SinghAru
 *
 */
public class ParentNonSerialized {
    
    private String parentName;

    public ParentNonSerialized() {
	// TODO Auto-generated constructor stub
    }
    
    public ParentNonSerialized(String parentName) {
	this.parentName = parentName;
    }

    public String getParentName() {
	return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
    
    
}
