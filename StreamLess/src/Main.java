import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.util.Arrays;
import java.util.List;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //PuttingIntoPractice
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        Trader ivan = new Trader("ivan", "Moscow");
        List<Trader> traiders = Arrays.asList(raoul,mario,alan,brian,ivan);
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950),
                new Transaction(raoul, 2011, 200)
        );


        //зд 1
            List<Transaction> transac=transactions.stream()
                    .filter(transaction -> transaction.getYear()==2011)
                    .sorted(new TransactionComparator())
                    .toList();
        for(Transaction transaction : transac)
        {
            System.out.println(transaction);
        }
        //зд 2
                traiders.stream()
                .map(trader -> trader.getCity())
                .distinct()
                .forEach(city->System.out.println(city));
        System.out.println();
        //зд 3
        List<Trader> traders=traiders.stream()
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .toList();
        for(Trader trader : traders)
        {
            System.out.println(trader);
        }
        
        //зд 4
        System.out.println();
        String traderNames=  traiders.stream()
                .map(p->p.getName())
                .collect(Collectors.joining(","));

        System.out.println(traderNames);

        //зд 5
        System.out.println();
        boolean milan=  traiders.stream()
                .anyMatch(s->s.getCity().equals("Milan"));
        System.out.println(milan);

        //зд 6
        System.out.println();
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .forEach(transaction -> System.out.println(transaction.getValue()));
        //зд 7
        System.out.println();
        var max=transactions.stream()
                .mapToInt(transaction ->transaction.getValue())
                .max();
        System.out.println(max);
        //зд 7
        System.out.println();
        var min=transactions.stream()
                .mapToInt(transaction ->transaction.getValue())
                .min();
        System.out.println(min);

    }


 static class TransactionComparator implements Comparator<Transaction>
    {
        public int compare(Transaction a,Transaction b)
        { Integer aSumm=a.getValue();
            Integer bSumm=b.getValue();

            return  aSumm.compareTo(bSumm);
        }
    }
    }
