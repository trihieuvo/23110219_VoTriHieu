package com.trihieu.state;
import com.trihieu.context.VendingMachine;
import com.trihieu.model.Product;

public class OutOfStockState implements VendingMachineState {
    @Override public void selectProduct(VendingMachine machine, Product product) { System.out.println("Hết hàng!"); }
    @Override public void insertMoney(VendingMachine machine, double amount) { System.out.println("Hết hàng!"); }
    @Override public void dispense(VendingMachine machine) { System.out.println("Hết hàng!"); }
}
