package enumexamples;

/**
 * Enums can implement interface
 *
 */
public enum ColorEnumWithName implements ColorInterface {
    
    RED("redName", "redDesc", "redSomething"), //
    GREEN("greenName", "greenDesc", "greenSomething");
    
    private String name, desc;
    
    private ColorEnumWithName(String name, String desc, String something) {
	this.name = name;
	this.desc = desc;
    }

    @Override
    public String getColorName() {
	return name;
    }

    @Override
    public String getColorDesc() {
	return desc;
    }

}
