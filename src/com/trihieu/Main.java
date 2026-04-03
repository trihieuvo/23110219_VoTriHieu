package com.trihieu;
import com.trihieu.context.VendingMachine;
import com.trihieu.factory.ProductFactory;
import com.trihieu.model.Product;
import com.trihieu.observer.*;
import com.trihieu.strategy.*;

public class Main {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();

        // 1. Thiết lập Observers
        machine.attach(new InventoryNotifier());
        machine.attach(new AdminNotifier());

        // 2. Thiết lập hàng hóa sử dụng Factory Pattern
        machine.addProduct(ProductFactory.createProduct("tea", 5));
        machine.addProduct(ProductFactory.createProduct("softdrink", 2)); // Kiểm tra tồn kho thấp
        machine.addProduct(ProductFactory.createProduct("mineralwater", 10));

        // 3. Người dùng chọn phương thức thanh toán (Strategy Pattern)
        machine.setPaymentStrategy(new EWalletPayment());

        // 4. Luồng Demo
        machine.displayProducts();

        System.out.println("\n--- Giao dịch 1: Mua Trà ---");
        machine.selectProduct(0); // Chọn Trà
        machine.insertMoney(37500);
        machine.dispense();

        System.out.println("\n--- Giao dịch 2: Mua Nước Ngọt (Cảnh báo tồn kho thấp) ---");
        machine.selectProduct(1); // Chọn Nước Ngọt
        machine.insertMoney(50000);
        machine.dispense();

        machine.displayProducts();
    }
}
