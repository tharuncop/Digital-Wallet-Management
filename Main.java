import java.io.*;
import java.util.*;

class DigitalWallet {

    int balance;
    int userID;

    DigitalWallet(int id, int amount) {
        this.userID = id;
        this.balance = amount;
    }

    int getUserID() {
        return userID;
    }

    int getBalance() {
        return balance;
    }

    boolean sendAmount(int amount) {
        if (balance < amount) {
            return false;
        }

        balance -= amount;
        return true;
    }

    void receiveAmount(int amount) {
        balance += amount;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter no. of users: ");
        int n = in.nextInt();

        DigitalWallet[] users = new DigitalWallet[n];

        for (int i = 0; i < n; i++) {

            System.out.println("UserId & Balance of user-" + i);

            int userID = in.nextInt();
            int init_balance = in.nextInt();

            users[userID] = new DigitalWallet(userID, init_balance); // given, userID's are in the range of (0, n-1)
        }

        System.out.println("Enter no. of transactions: ");
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {

            System.out.println("Sender ID: ");
            int senderID = in.nextInt();

            System.out.println("Receiver ID: ");
            int receiverID = in.nextInt();

            System.out.println("Transaction amount: ");
            int amount = in.nextInt();

            if (users[senderID].sendAmount(amount)) {

                users[receiverID].receiveAmount((amount));
                System.out.println("\nSuccess");

            } else {
                System.out.println("\nFailure");
            }

        }

        // sorting users objects based on their balance

        for (int i = 0; i < n - 1; i++) {

            for (int j = i + 1; j < n; j++) {
                if (users[i].getBalance() > users[j].getBalance()) {
                    DigitalWallet tempObject = users[i];
                    users[i] = users[j];
                    users[j] = tempObject;
                }
            }
        }

        System.out.println("\nSorted Wallets based on their balances (low to high): ");

        for (int i = 0; i < n; i++) {
            System.out.println(users[i].userID + " " + users[i].getBalance());
        }

        in.close();
    }
}