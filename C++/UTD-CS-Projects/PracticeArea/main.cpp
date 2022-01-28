#include <iostream>
#include <iomanip>
#include <cmath>
#include <random>
#include <string>
#include <sstream>
#include <list>

using namespace std;

class Person {
public:
    string name;
    int age;
    string description;

    Person(){
        name = "John Smith";
        age = 30;
        description = "Just a normal man";
    }

    Person(string name, int age, string description) {
        name = name;
        age = age;
        description = description;
    }

    static void greetings() {
        cout << "Hello World!" << endl;
    }

    void introduction() {
        cout << "My name is " << name << "." << endl;
        cout << "I'm " << age << " years old." << endl;
        cout << description << endl;
    }
};

/* ------------------------------------------------ */


/**
 * The Items class instantiates Items objects
 * which would be put into ShoppingCart
 * which holds the itemName, itemID,
 * itemPrice, and the itemQuantity
 */
class Items {
public:
    string item_Name;
    string item_ID;
    double item_Price;
    int item_Quantity;

    Items() {
        this->item_Name = "Item";
        this->item_ID = "AAA000";
        this->item_Price = 0.0;
        this->item_Quantity = 0;
    }

    Items(string name, double cost, int quantity) {
        this->item_Name = name;
        this->item_ID = idAssign();
        this->item_Price = cost;
        this->item_Quantity = quantity;
    }

    static string idAssign() {
        const string alphanum =
                "0123456789"
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                "abcdefghijklmnopqrstuvwxyz";

        random_device random;
        mt19937 engine(random());
        uniform_int_distribution<int> range(0, alphanum.size() - 1);

        string s;
        for (int i = 0; i < 7; i++) {
            s += alphanum[range(engine)];
        }
        return s;
    }
};

/* *
 * ShoppingCart class is a class that creates
 * a list each time it's instantiated and takes
 * in Items, just like a regular shopping cart would. */
class ShoppingCart {
private:
    string cartName;

    list<Items> cart;
    list<Items>::iterator it;

public:
    ShoppingCart() {
        this->cartName = "Empty Cart";
    }

    ShoppingCart(string cartName) {
        this->cartName = cartName;
    }

    void addItemToCart(Items item) {
        cart.push_back(item);
    }

    void removeItemFromCart(string itemName, string itemID) {
        while (it != cart.end()) {
            if ((it->item_ID == itemName) && (it->item_ID == itemID)) {
                cart.erase(it);
            }
        }
    }

private: void printItemDetails() {
        int count = 1;
        for (it = cart.begin(); it != cart.end(); it++) {
            cout << to_string(count) << ".\tName: " <<it->item_Name
                 << "\n\tID: " << it->item_ID
                 << "\n\tPrice: " << fixed << setprecision(2) << to_string(it->item_Price)
                 << "\n\tQuantity: " << to_string(it->item_Quantity) << "\n\n";
            count++;
        }
    }

public: void printCartDetails() {
        cout << "Cart name: " + this->cartName + "\n";
        printItemDetails();
    }
};

int main() {
    string itemName;
    double itemPrice;
    int itemQuantity;
    ShoppingCart cart{"Anh's Cart"};

    int choice;
    unsigned a = 23;
    unsigned b = 22;
    cout << (a || b) << endl;
    cout << "What would you like to do?"
            "\nEnter:"
            "\n\t1 to add item"
            "\n\t2 to remove item"
            "\n\t0 to quit\n";
    cin >> choice;
    cin.ignore();

    while (true) {
        switch (choice) {
            case 1: {
                cout << "Enter item's name: ";
                getline(cin, itemName);

                cout << "Enter item's price: ";
                cin >> itemPrice;

                cout << "Enter item's quantity: ";
                cin >> itemQuantity;

                Items item{itemName, itemPrice, itemQuantity};

                cart.addItemToCart(item);
                cart.printCartDetails();
            }

            case 2: {
                cout << "Enter item's name: ";
                getline(cin, itemName);

                string id;
                cout << "Enter item's ID: ";
                cin >> id;

                cart.removeItemFromCart(itemName, id);
                cart.printCartDetails();
            }

            default:
                break;
        }
        break;
    }

    return 0;
}