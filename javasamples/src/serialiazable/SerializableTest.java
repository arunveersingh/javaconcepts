package serialiazable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableTest {

    public static void main(String[] args) {
	// new SerializableTest().pnscns();
	// new SerializableTest().pscns();
	new SerializableTest().pscs();
	new SerializableTest().pnscs();
    }

    // Parent is Serializable, Child is non Serializable.
    void pscns() {
	
	/**
	 * Note: If parent is serialized, child is serialized by itself.
	 */

	ChildNonSerializedExtendingParentSerialized pscns = new ChildNonSerializedExtendingParentSerialized(
		ChildNonSerializedExtendingParentSerialized.class.getName());
	pscns.setParentName(ParentSerialized.class.getName());

	try {

	    // Serialize
	    FileOutputStream fos = new FileOutputStream("object.ser");
	    ObjectOutputStream oos = new ObjectOutputStream(fos);
	    oos.writeObject(pscns);
	    oos.close();
	    fos.close();

	    // De-serialize
	    FileInputStream fis = new FileInputStream("object.ser");
	    ObjectInputStream ois = new ObjectInputStream(fis);
	    ChildNonSerializedExtendingParentSerialized si = (ChildNonSerializedExtendingParentSerialized) ois
		    .readObject();
	    fis.close();
	    ois.close();
	    System.out.println(si.getName()); // O/P:
					      // serialiazable.ChildNonSerializedExtendingParentSerialized
	    System.out.println(si.getParentName()); // O/P:


	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}

    }

    // Parent is Serializable, Child is Serializable.
    void pscs() {
	
	ChildSerializedExtendsParentSerialized csps = new ChildSerializedExtendsParentSerialized(
		ChildSerializedExtendsParentSerialized.class.getName());
	
	csps.setParentName(ParentSerialized.class.getName());

	try {

	    // Serialize
	    FileOutputStream fos = new FileOutputStream("object.ser");
	    ObjectOutputStream oos = new ObjectOutputStream(fos);
	    oos.writeObject(csps);
	    oos.close();
	    fos.close();

	    // De-serialize
	    FileInputStream fis = new FileInputStream("object.ser");
	    ObjectInputStream ois = new ObjectInputStream(fis);
	    ChildSerializedExtendsParentSerialized si = (ChildSerializedExtendsParentSerialized) ois
		    .readObject();
	    fis.close();
	    ois.close();
	    System.out.println(si.getName()); // O/P:
					      // serialiazable.ChildSerializedExtendsParentSerialized
	    System.out.println(si.getParentName()); // O/P:


	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}

    }

    // Parent is non Serializable, Child is non Serializable.
    void pnscns() {

	/**
	 * java.io.NotSerializableException:
	 * serialiazable.ChildNonSerializedExtendingParentNonSerialized at
	 * java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1184)
	 * at
	 * java.io.ObjectOutputStream.writeObject(ObjectOutputStream.java:348)
	 * at serialiazable.SerializableTest.pnscns(SerializableTest.java:26) at
	 * serialiazable.SerializableTest.main(SerializableTest.java:13)
	 * 
	 */

	ChildNonSerializedExtendingParentNonSerialized cns = new ChildNonSerializedExtendingParentNonSerialized(
		ChildNonSerializedExtendingParentNonSerialized.class.getName());
	cns.setParentName(ChildNonSerializedExtendingParentNonSerialized.class.getName());

	try {

	    // Serialize
	    FileOutputStream fos = new FileOutputStream("object.ser");
	    ObjectOutputStream oos = new ObjectOutputStream(fos);
	    oos.writeObject(cns);
	    oos.close();
	    fos.close();

	    // Deserialize

	    FileInputStream fis = new FileInputStream("object.ser");
	    ObjectInputStream ois = new ObjectInputStream(fis);
	    ChildNonSerializedExtendingParentNonSerialized si = (ChildNonSerializedExtendingParentNonSerialized) ois
		    .readObject();
	    fis.close();
	    ois.close();
	    System.out.println(si.getName());
	    System.out.println(si.getParentName()); // O/P:


	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}

    }

    // Parent is non Serializable, Child is Serializable.
    void pnscs() {
	
	ChildSerializedExtendsParentNonSerialized cns = new ChildSerializedExtendsParentNonSerialized(
		ChildSerializedExtendsParentNonSerialized.class.getName());
	
	cns.setParentName(ChildSerializedExtendsParentNonSerialized.class.getName());

	try {

	    // Serialize
	    FileOutputStream fos = new FileOutputStream("object.ser");
	    ObjectOutputStream oos = new ObjectOutputStream(fos);
	    oos.writeObject(cns);
	    oos.close();
	    fos.close();

	    // Deserialize
	    FileInputStream fis = new FileInputStream("object.ser");
	    ObjectInputStream ois = new ObjectInputStream(fis);
	    ChildSerializedExtendsParentNonSerialized si = (ChildSerializedExtendsParentNonSerialized) ois
		    .readObject();
	    
	    
	    
	    fis.close();
	    ois.close();
	    System.out.println(si.getName());
	    System.out.println(si.getParentName());


	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
    }

}
