package codes.java.systemdesign;

import java.util.*;
import java.util.stream.Collectors;

public class SplitWise {

    List<User> users = new ArrayList<>();
    List<Expense> expenses = new ArrayList<>();
    List<Contribution> contributions = new ArrayList<>();
    void makeExpense(String input) {
        String[] arr = input.split(" ");
        int n = arr.length;
        String payerId = arr[1];
        double amount = Double.parseDouble(arr[2]);
        int noOfUsers = Integer.parseInt(arr[3]);
        List<String> usersToPay = new ArrayList<>();
        usersToPay.addAll(Arrays.asList(arr).subList(4, noOfUsers + 4));

        String expenseType = arr[4 + noOfUsers];
        if(expenseType.equals("EQUAL")) {
            double eachAmount = Math.round(amount / (noOfUsers));
        }
         else {
            List<Double> amounts = new ArrayList<>();
            for (int i = 0; i < noOfUsers; i++) {
                amounts.add(Double.parseDouble(arr[i + 5]));
            }

        }
    }

    void show() {
        for(Contribution contribution: contributions) {
            double amount = contribution.amount;
            if(amount > 0) {
                System.out.println(contribution.payeeId + " owes " + contribution.payerId + " " + amount);
            }
        }
    }

    void show(String userId) {
        List<Contribution> getAllOfUser =
                contributions.stream()
                .filter(contribution -> contribution.payerId.equals(userId))
                .collect(Collectors.toList());

        System.out.println(getAllOfUser);
    }

    void createUser(String id, String name) {
        User user = new User(id, name);
        users.add(user);
    }

    public static void main(String[] args) {
        SplitWise splitWise = new SplitWise();

        splitWise.createUser("u1", "u1");
        splitWise.createUser("u2", "u2");
        splitWise.createUser("u3", "u3");
        splitWise.createUser("u4", "u4");

        splitWise.makeExpense("EXPENSE user1 1000 4 user1 user2 user3 user4 EQUAL");
    }
}

enum ExpenseType{
    EQUAL, EXACT
}

class Expense {
    String id;
    String userIdWhoPaid;
    ExpenseType expenseType;
    double expenseAmount;

    public Expense() {
    }

    public Expense(String id, String userIdWhoPaid, ExpenseType expenseType, double expenseAmount) {
        this.id = id;
        this.userIdWhoPaid = userIdWhoPaid;
        this.expenseType = expenseType;
        this.expenseAmount = expenseAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserIdWhoPaid() {
        return userIdWhoPaid;
    }

    public void setUserIdWhoPaid(String userIdWhoPaid) {
        this.userIdWhoPaid = userIdWhoPaid;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }
}

class Contribution{
    String expenseId;
    String payerId;
    String payeeId;
    double amount;

    public Contribution() {
    }

    public Contribution(String expenseId, String payerId, String payeeId, double amount) {
        this.expenseId = expenseId;
        this.payerId = payerId;
        this.payeeId = payeeId;
        this.amount = amount;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public String getPayerId() {
        return payerId;
    }

    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }

    public String getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

class User {
    String id;
    String name;

    public User() {
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
