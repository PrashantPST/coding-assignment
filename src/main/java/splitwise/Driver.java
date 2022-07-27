/*
There will be 3 types of input:

Expense in the format:
expense <paid_by> <amount> <no-of-users> <space-separated-list-of-users> <EQUAL/EXACT/PERCENT> <space-separated-values-in-case-of-non-equal>
Show balances for all: show
Show balances for a single user: show <user-id>
 */
package splitwise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        ExpenseManager expenseManager = new ExpenseManager();
        expenseManager.addUser(new User("u1", "User1", "gaurav@workat.tech", "9876543210"));
        expenseManager.addUser(new User("u2", "User2", "sagar@workat.tech", "9876543210"));
        expenseManager.addUser(new User("u3", "User3", "hi@workat.tech", "9876543210"));
        expenseManager.addUser(new User("u4", "User4", "mock-interviews@workat.tech", "9876543210"));
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            String[] commands = command.split("\\s+");
            String commandType = commands[0];
            switch (commandType) {
                case "show":
                    if (commands.length == 1) {
                        expenseManager.showBalances();
                    }
                    else {
                        expenseManager.showBalance(commands[1].toLowerCase());
                    }
                    break;
                case "expense":
                    String paidBy = commands[1];
                    Double amount = Double.parseDouble(commands[2]);
                    int noOfUsers = Integer.parseInt(commands[3]);
                    String expenseType = commands[4 + noOfUsers];
                    List<Split> splits = new ArrayList<>();
                    switch (expenseType) {
                        case "equal":
                            for (int i = 0; i < noOfUsers; i++) {
                                splits.add(new EqualSplit(expenseManager.users.get(commands[4 + i])));
                            }
                            expenseManager.addExpense(ExpenseType.EQUAL, amount, paidBy, splits, null);
                            break;
                        case "exact":
                            for (int i = 0; i < noOfUsers; i++) {
                                splits.add(new ExactSplit(expenseManager.users.get(commands[4 + i]),
                                                          Double.parseDouble(commands[5 + noOfUsers + i])));
                            }
                            expenseManager.addExpense(ExpenseType.EXACT, amount, paidBy, splits, null);
                            break;
                        case "percent":
                            for (int i = 0; i < noOfUsers; i++) {
                                splits.add(new PercentSplit(expenseManager.users.get(commands[4 + i]),
                                                            Double.parseDouble(commands[5 + noOfUsers + i])));
                            }
                            expenseManager.addExpense(ExpenseType.PERCENT, amount, paidBy, splits, null);
                            break;
                    }
                    break;
                case "nop":
                    return;
            }

        }

    }
}
