package com.trihieu.state;
import com.trihieu.context.VendingMachine;
import com.trihieu.model.Product;

public class DispensingState implements VendingMachineState {
    @Override public void selectProduct(VendingMachine machine, Product product) { System.out.println("Đang phát sản phẩm, vui lòng đợi."); }
    @Override public void insertMoney(VendingMachine machine, double amount) { System.out.println("Đang phát sản phẩm, vui lòng đợi."); }
    @Override
    public void dispense(VendingMachine machine) {
        Product product = machine.getSelectedProduct();
        System.out.println("Đang phát " + product.getName());
        product.setQuantity(product.getQuantity() - 1);
        machine.notifyObservers(product);
        machine.setState(new ReadyState());
        machine.setSelectedProduct(null);
    }
}
