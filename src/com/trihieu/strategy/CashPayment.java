package com.trihieu.strategy;
public class CashPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println("Đang xử lý thanh toán tiền mặt: " + String.format("%,.0f", amount) + "đ");
        return true;
    }
}
