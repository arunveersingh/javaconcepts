package learningjava8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import static java.util.stream.Collectors.*;

public class TestTraderTransaction {

	public static void main(String[] args) {

		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);

		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300, Currency.getInstance(Locale.US)),
				new Transaction(raoul, 2012, 1000, Currency.getInstance(Locale.UK)),
				new Transaction(raoul, 2011, 400, Currency.getInstance(Locale.KOREA)),
				new Transaction(mario, 2012, 710, Currency.getInstance(Locale.US)),
				new Transaction(mario, 2012, 700, Currency.getInstance(Locale.US)),
				new Transaction(alan, 2012, 950, Currency.getInstance(Locale.US)));
	
		

		/*
		 * 1. Find all transactions in the year 2011 and sort them by value (small to
		 * high).
		 * 
		 * 2. What are all the unique cities where the traders work?
		 * 
		 * 3. Find all traders from Cambridge and sort them by name.
		 * 
		 * 4. Return a string of all traders’ names sorted alphabetically.
		 * 
		 * 5. Are any traders based in Milan?
		 * 
		 * 6. Print all transactions’ values from the traders living in Cambridge.
		 * 
		 * 7. What’s the highest value of all the transactions?
		 * 
		 * 8. Find the transaction with the smallest value.
		 */

		// ******* ANSWER 1 ************ //
		transactions.stream().filter(transaction -> transaction.getYear() == 2011)
				.sorted(Comparator.comparing((Transaction::getValue))).collect(toList());

		System.out.println(transactions.stream().filter(transaction -> transaction.getYear() == 2011)
				.sorted(Comparator.comparing((Transaction::getValue))).collect(toList()));

		System.out.println(transactions.stream().filter(transaction -> transaction.getYear() == 2011)
				.sorted(Comparator.comparing((Transaction tx) -> tx.getValue())).collect(toList()));

		// ** Answer 2: What are all the unique cities where the traders work? ** //

		System.out.println(traders.stream().map(Trader::getCity).distinct().collect(toList()));

		System.out.println("Ans 2: " + transactions.stream().map(t -> t.getTrader()).collect(toList()).stream()
				.map(Trader::getCity).distinct().collect(toList()));

		// ** Answer 3: Find all traders from Cambridge and sort them by name. ** //
		System.out.println(transactions.stream().map(t -> t.getTrader()).collect(toList()).stream()
				.filter(trader -> trader.getCity().equals("Cambridge"))
				.sorted((t1, t2) -> t1.getName().compareTo(t2.getName())).collect(toList()));

		System.out.println(transactions.stream().map(t -> t.getTrader()).collect(toList()).stream()
				.filter(trader -> trader.getCity().equals("Cambridge")).sorted(Comparator.comparing(Trader::getName))
				.collect(toList()));

		// ** Answer 4: Return a string of all traders’ names sorted alphabetically. **
		System.out.println(transactions.stream().map(t -> t.getTrader()).collect(toList()).stream()
				.map(t -> t.getName()).sorted((String s1, String s2) -> s1.compareTo(s2)).distinct().collect(toList()));

		// ** Answer 5: Are any traders based in Milan? **//
		System.out.println(transactions.stream().map(t -> t.getTrader()).collect(toList()).stream()
				.filter(t -> t.getCity().equals("Milan")).distinct().collect(toList()));

		// ** Answer 6: Print all transactions’ values from the traders living in
		// Cambridge. ** //
		transactions.stream().filter(tx -> tx.getTrader().getCity().equals("Cambridge")).collect(toList()).stream()
				.forEach(t -> System.out.println(t.getValue()));

		// ** Answer 7: What’s the highest value of all the transactions? ** //
		System.out.println(transactions.stream().map(tx -> tx.getValue()).max(Integer::compareTo).get());

		// ** Answer 8: Find the transaction with the smallest value. ** //
		Date start = new Date();
		System.out.println(start);
		transactions.stream().sorted(Comparator.comparing(Transaction::getValue)).limit(1).forEach(System.out::println);
		Date endFirst = new Date();
		System.out.println(endFirst);
		System.out.println("time with sequential stream " + (endFirst.getTime() - start.getTime()));
		Date startSecond = new Date();
		System.out.println(startSecond);
		transactions.parallelStream().sorted(Comparator.comparing(Transaction::getValue)).limit(1).forEach(System.out::println);
		Date endSecond = new Date();
		System.out.println(endSecond);
		System.out.println("time with parallel stream " +  (endSecond.getTime() - startSecond.getTime()));
		
		
		Map<Currency, List<Transaction>> transactionsByCurrencies = transactions.stream()
				.collect(groupingBy(Transaction::getCurrency));
		
		
		
		System.out.println(transactionsByCurrencies.toString());
	}
}
