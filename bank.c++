#include <iostream>
using namespace std;

class bank {
private:
    int balance = 0;   

public:
    void deposit(int value) {
        balance += value;
        cout << "Amount successfully deposited\n";
    }


    void withdraw(int amount) {
        if (balance < amount) {
            cout << "Insufficient funds\n";
        } else {
            balance -= amount;
            cout << "Amount withdrawn successfully\n";
        }
    }

    void showBalance() {
        cout << "Current Balance: " << balance << endl;
    }
};

int main() {
    bank b1;
    int choice, amount;

    while (true) {
        cout << "\n------ BANK MENU ------\n";
        cout << "1. Deposit\n";
        cout << "2. Withdraw\n";
        cout << "3. Check Balance\n";
        cout << "4. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
        case 1:
            cout << "Enter amount to deposit: ";
            cin >> amount;
            b1.deposit(amount);
            break;

        case 2:
            cout << "Enter amount to withdraw: ";
            cin >> amount;
            b1.withdraw(amount);
            break;

        case 3:
            b1.showBalance();
            break;

        case 4:
            cout << "Exiting program...\n";
            return 0;

        default:
            cout << "Invalid choice! Try again.\n";
        }
    }

    return 0;
}
