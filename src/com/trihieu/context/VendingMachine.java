package com.trihieu.context;
import java.util.*;
import com.trihieu.model.Product;
import com.trihieu.state.*;
import com.trihieu.strategy.PaymentStrategy;
import com.trihieu.observer.VendingMachineObserver;

public class VendingMachine {
    private VendingMachineState state;
    private PaymentStrategy paymentStrategy;
    private List<VendingMachineObserver> observers = new ArrayList<>();
    private List<Product> inventory = new ArrayList<>();
    private Product selectedProduct;

    public VendingMachine() {
        this.state = new ReadyState(); // Trạng thái mặc định
    }

    public void addProduct(Product product) { inventory.add(product); }
    public void attach(VendingMachineObserver observer) { observers.add(observer); }
    public void setPaymentStrategy(PaymentStrategy strategy) { this.paymentStrategy = strategy; }
    public void setState(VendingMachineState state) { this.state = state; }
    
    public void displayProducts() {
        System.out.println("\n--- Sản phẩm có sẵn ---");
        for (Product p : inventory) {
            System.out.println(p);
        }
    }

    public void selectProduct(int index) {
        if (index >= 0 && index < inventory.size()) {
            state.selectProduct(this, inventory.get(index));
        } else {
            System.out.println("Chỉ số sản phẩm không hợp lệ.");
        }
    }

    public void insertMoney(double amount) {
        state.insertMoney(this, amount);
    }

    public void dispense() {
        state.dispense(this);
    }

    public void notifyObservers(Product product) {
        String message = product.getName() + " đã bán. Còn lại: " + product.getQuantity();
        for (VendingMachineObserver obs : observers) {
            obs.update(message);
        }
        if (product.getQuantity() < 3) {
            for (VendingMachineObserver obs : observers) {
                obs.update("CẢNH BÁO TỒN KHO THẤP: " + product.getName() + " chỉ còn " + product.getQuantity() + " sản phẩm!");
            }
        }
    }

    public Product getSelectedProduct() { return selectedProduct; }
    public void setSelectedProduct(Product selectedProduct) { this.selectedProduct = selectedProduct; }
    public PaymentStrategy getPaymentStrategy() { return paymentStrategy; }
}
