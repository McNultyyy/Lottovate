package com.mcnulty;

import com.mcnulty.javaMillions.JavaMillions;
import com.mcnulty.javaMillions.JavaMillionsPrize;
import com.mcnulty.javaMillions.JavaMillionsResult;
import com.mcnulty.javaMillions.JavaMillionsTicket;
import com.mcnulty.springLotto.SpringLotto;
import com.mcnulty.springLotto.SpringLottoPrize;
import com.mcnulty.springLotto.SpringLottoResult;
import com.mcnulty.springLotto.SpringLottoTicket;

import java.util.*;
import java.util.stream.Collectors;

public class TicketPrizeCalculator {

    public static void main(String[] args) throws Exception {

        new TicketPrizeCalculator().run(args);
    }

    void run(String[] args) throws Exception {

        validate(args);
        String lotteryType = args[0];
        List<Integer> winningValues = toIntList(args[1]);
        List<Integer> userValues = toIntList(args[2]);

        System.out.println("William McNulty v1.0.0");

        switch (lotteryType) {
            case "JavaMillions":
                JavaMillionsResult jmResult = new JavaMillions().calculate(new JavaMillionsTicket(winningValues), new JavaMillionsTicket(userValues));
                if (jmResult.isWinner()) {
                    JavaMillionsPrize prize = jmResult.getPrize().get();
                    System.out.println(String.format("This ticket won a prize of class %s and amount £%s", prize.getPrizeClass(), prize.getPrizeAmount()));
                    System.out.println(String.format(
                            "Matched the numbers [%s] from pool 1 and the numbers [%s] from pool 2.",
                            toCSV(jmResult.getMatchedPool1Values()),
                            toCSV(jmResult.getMatchesPool2Values()))
                    );
                } else {
                    System.out.println("This ticket did not win a prize.");
                }
                break;

            case "SpringLotto":
                SpringLottoResult slResult = new SpringLotto().calculate(new SpringLottoTicket(winningValues), new SpringLottoTicket(userValues));
                if (slResult.isWinner()) {
                    SpringLottoPrize prize = slResult.getPrize().get();
                    System.out.println(String.format("This ticket won a prize of class %s and amount £%s", prize.getPrizeClass(), prize.getPrizeAmount()));
                    System.out.println(String.format("Matched the numbers [%s] from pool 1.", toCSV(slResult.getMatchedValues())));
                } else {
                    System.out.println("This ticket did not win a prize.");
                }
                break;
            default:
                throw new Exception(lotteryType + " is not a valid lottery to enter");
        }
    }

    /**
     * A String of comma delimited integers to a List of Integer.
     * e.g. "1,2,3" would return a List with values 1,2,3
     */
    private List<Integer> toIntList(String csv) {
        String[] split = csv.split(",");
        ArrayList<Integer> output = new ArrayList<>();

        for (String string : split) {
            Integer integer = Integer.parseInt(string);
            output.add(integer);
        }
        return output;
    }

    /**
     * Converts a List of Integers to a String csv.
     */
    private String toCSV(List<Integer> list) {
        return String.join(",", list.stream().map(Object::toString).collect(Collectors.toList()));
    }

    private void validate(String[] args) {
        if (args.length != 3) {
            System.err.println("Usage: \"Lottery Type\" \"1,2,3,4,5,6\" \"1,3,3,2,6,6\"" );
            throw new IllegalArgumentException("Invalid number of arguments provided.");
        }
        List<String> validLotteries = Arrays.asList("JavaMillions", "SpringLotto");
        if (!validLotteries.contains(args[0])) {
            throw new IllegalArgumentException(args[0] + " is not a valid lottery.");
        }

    }

}


