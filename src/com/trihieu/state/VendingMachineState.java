package com.trihieu.state;
import com.trihieu.context.VendingMachine;
import com.trihieu.model.Product;

public interface VendingMachineState {
    void selectProduct(VendingMachine machine, Product product);
    void insertMoney(VendingMachine machine, double amount);
    void dispense(VendingMachine machine);
}
