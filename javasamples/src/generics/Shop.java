package generics;

public class Shop {
	
	public static void main(String[] args) {
		
		Pair<Sock> socks = new Pair<Sock>(new Sock("Green", 10), new Sock("Green", 10));
		Pair<Glove> gloves = new Pair<Glove>(new Glove("Green", 10), new Glove("Green", 10));
		Pair<String> strings = new Pair<String>(new String("Green"), new String("Green"));
		
		ClothingPair<Sock> clothingSocks = new ClothingPair<Sock>(new Sock("Green", 10), new Sock("Green", 10));
		
		ClothingPair.match(new Sock("Green", 10), new Sock("Green", 10));
		
		/**
		 * Note: <Sock>match is not mandatory, as it can be written as only match
		 */
		ClothingPair.<Sock>match(new Sock("Green", 10), new Sock("Green", 10));

		
		socks.getLeft();
		socks.getRight();
		
		
	}

}
