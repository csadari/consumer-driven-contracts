package org.xpdojo.bank.cdc.account.domain;

import java.io.PrintStream;
import java.util.List;

import static java.time.LocalDateTime.now;
import static org.xpdojo.bank.cdc.account.domain.Money.anAmountOf;

public class ConsoleStatementWriter implements StatementWriter {

    private final PrintStream printStream;

    public ConsoleStatementWriter(final PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void printBalanceOf(Money balance) {
        printStream.println("------------------");
        printStream.println("| date | balance |");
        printStream.println("------------------");
        printStream.println("| " + now() + " | " + balance.toString() + " |");
        printStream.println("------------------");
    }

    @Override
    public void printFullStatementWith(List<Transaction> transactions) {
        printStream.println("----------------------------------------");
        printStream.println("| date | debit/credit amount | balance |");
        printStream.println("----------------------------------------");
        transactions.stream().forEachOrdered(t -> printStatementLineTo(printStream, t, anAmountOf(0.0d)));
        printStream.println("----------------------------------------");
    }

    private void printStatementLineTo(PrintStream printStream, Transaction t, Money balance) {
        printStream.println("| " + t.getDateTime() + " | " + t.balanceImpact() + " | " + balance + " |");
    }
}
