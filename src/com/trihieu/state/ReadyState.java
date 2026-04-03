package com.trihieu.state;
import com.trihieu.context.VendingMachine;
import com.trihieu.model.Product;

public class ReadyState implements VendingMachineState {
    @Override
    public void selectProduct(VendingMachine machine, Product product) {
        if (product.getQuantity() > 0) {
            System.out.println("Đã chọn " + product.getName() + " (" + String.format("%,.0f", product.getPrice()) + "đ)");
            machine.setSelectedProduct(product);
            machine.setState(new ProcessingPaymentState());
        } else {
            System.out.println(product.getName() + " đã hết hàng!");
            machine.setState(new OutOfStockState());
        }
    }
    @Override public void insertMoney(VendingMachine machine, double amount) { System.out.println("Vui lòng chọn sản phẩm trước."); }
    @Override public void dispense(VendingMachine machine) { System.out.println("Vui lòng chọn sản phẩm trước."); }
}
