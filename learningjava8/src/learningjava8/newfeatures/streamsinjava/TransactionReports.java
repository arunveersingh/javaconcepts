package learningjava8.newfeatures.streamsinjava;

import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import learningjava8.streams.Trader;
import learningjava8.streams.Transaction;

/**
 * This class demonstrates usage of Streams API.
 * @author Arunveer Singh
 *
 */
public class TransactionReports {

	static Trader raoul = new Trader("Raoul", "Cambridge");
	static Trader mario = new Trader("Mario", "Milan");
	static Trader alan = new Trader("Alan", "Cambridge");
	static Trader brian = new Trader("Brian", "Cambridge");

	static List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);

	static List<Transaction> transactions = Arrays.asList(
			new Transaction(brian, 2011, 300, Currency.getInstance(Locale.US)),
			new Transaction(raoul, 2012, 1000, Currency.getInstance(Locale.UK)),
			new Transaction(raoul, 2011, 400, Currency.getInstance(Locale.KOREA)),
			new Transaction(mario, 2012, 710, Currency.getInstance(Locale.US)),
			new Transaction(mario, 2012, 700, Currency.getInstance(Locale.US)),
			new Transaction(alan, 2012, 950, Currency.getInstance(Locale.US)));

	public static void main(String[] args) {

		System.out.println("*** expensive transactions by currency ***");
		transactions.stream().filter(transaction -> transaction.getValue() > 300)
				.collect(Collectors.groupingBy(Transaction::getCurrency))
				.forEach((key, value) -> System.out.println(key + value.toString()));
		
		
	}

}
