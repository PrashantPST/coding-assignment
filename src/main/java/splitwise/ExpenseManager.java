package splitwise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {
    List<Expense>                    expenses;
    Map<String, User>                users;
    Map<String, Map<String, Double>> balanceSheet;

    public ExpenseManager() {
        expenses = new ArrayList<>();
        users = new HashMap<>();
        balanceSheet = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
        balanceSheet.put(user.getId(), new HashMap<>());
    }

    public void showBalances() {
        for (String userId : balanceSheet.keySet()) {
            for (String anotherUserId : balanceSheet.get(userId).keySet()) {
                Double balance = balanceSheet.get(userId).get(anotherUserId);
                printBalance(userId, anotherUserId, balance);
            }
        }
    }

    public void showBalance(String userId) {
        for (String anotherUserId: balanceSheet.get(userId).keySet()) {
            Double balance = balanceSheet.get(userId).get(anotherUserId);
            printBalance(userId, anotherUserId, balance);
        }
    }

    private void printBalance(String user1, String user2, double amount) {
        String user1Name = users.get(user1).getName();
        String user2Name = users.get(user2).getName();
        if (amount < 0) {
            System.out.println(user1Name + " owes " + user2Name + ": " + Math.abs(amount));
        }
        else if (amount > 0) {
            System.out.println(user2Name + " owes " + user1Name + ": " + Math.abs(amount));
        }
    }

    public void addExpense(ExpenseType expenseType, Double amount, String paidBy, List<Split> splits, ExpenseMeta expenseMeta) {

    }
}
