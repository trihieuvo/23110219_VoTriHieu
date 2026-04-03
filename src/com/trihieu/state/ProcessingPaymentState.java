package com.trihieu.state;
import com.trihieu.context.VendingMachine;
import com.trihieu.model.Product;

public class ProcessingPaymentState implements VendingMachineState {
    @Override public void selectProduct(VendingMachine machine, Product product) { System.out.println("Đang xử lý thanh toán."); }
    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        Product product = machine.getSelectedProduct();
        if (machine.getPaymentStrategy().pay(product.getPrice())) {
            System.out.println("Thanh toán thành công.");
            machine.setState(new DispensingState());
        } else {
            System.out.println("Thanh toán thất bại.");
            machine.setState(new ReadyState());
        }
    }
    @Override public void dispense(VendingMachine machine) { System.out.println("Vui lòng thanh toán trước."); }
}
