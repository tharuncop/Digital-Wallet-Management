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

        Map<Integer, DigitalWallet> users = new HashMap<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter User ID & Balance of user-" + i);
            int userID = in.nextInt();
            int init_balance = in.nextInt();

            users.put(userID, new DigitalWallet(userID, init_balance));
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
            in.nextLine(); // Consume newline

            if (!users.containsKey(senderID) || !users.containsKey(receiverID)) {
                System.out.println("\nInvalid User ID. Transaction Failed.");
                continue;
            }

            if (users.get(senderID).sendAmount(amount)) {
                users.get(receiverID).receiveAmount(amount);
                System.out.println("\nSuccess");
            } else {
                System.out.println("\nFailure");
            }
        }

        // Sorting wallets based on balance using a list

        List<DigitalWallet> sortedWallets = new ArrayList<>(users.values());
        sortedWallets.sort(Comparator.comparingInt(DigitalWallet::getBalance));

        System.out.println("\nSorted Wallets based on their balances (low to high): ");
        for (DigitalWallet user : sortedWallets) {
            System.out.println(user.getUserID() + " " + user.getBalance());
        }

        in.close();
    }
}
