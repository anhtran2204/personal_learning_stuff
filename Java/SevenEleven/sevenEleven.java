public class sevenEleven {
    String[] products = {"Milk", "Coffee", "Coke", "Beer", "Ramen", "Cheetos", "Sandwich", "Doritos", "Cigarettes", "Toothpastes", "Razor"};
    double[] prices = {2.99, 5.99, 3.99, 9.99, 12.99, 6.99, 8.99, 8.99, 5.99, 4.99, 7.99};

    public sevenEleven (String product, double price) {
        String products = product;
        double prices = price;
    }

    public void list () {
        for (int i = 0; i < products.length; i++) {
            System.out.println("The cost of " + products[i] + " is " + prices[i]);
        } 
        
    }
    public static void main (String[] args) {
        sevenEleven shopList = new sevenEleven("Ramen", 3.99);
        shopList.list();
    }
}