package generics;

public class Calculator {
	
	@SuppressWarnings("unchecked")
	public <T extends Number> T multiply(T t, T t2) {
		
		if(t instanceof Integer && t2 instanceof Integer) {
			Integer lt =  (Integer) t;
			Integer lt2 =  (Integer) t2;
			
			return (T) new Integer(lt*lt2);
			
		}
		

		if(t instanceof Long && t2 instanceof Long) {
			Long lt =  (Long) t;
			Long lt2 =  (Long) t2;
			
			
			
			return (T) new Long(lt * lt2);
			
		}
		
		return null;
	}
	
	public static void main(String [] args) {
		Integer x = new Calculator().multiply(new Integer(4), new Integer(3));
		System.out.println(x.intValue());
		
		Long xL = new Calculator().multiply(4L, 3L);
		System.out.println(xL.intValue());
	}

}
