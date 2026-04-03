package com.trihieu.strategy;
public class EWalletPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println("Đang xử lý thanh toán ví điện tử: " + String.format("%,.0f", amount) + "đ");
        return true;
    }
}
