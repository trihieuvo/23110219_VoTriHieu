package com.trihieu.strategy;
public class StudentCardPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println("Đang xử lý thanh toán thẻ sinh viên: " + String.format("%,.0f", amount) + "đ");
        return true;
    }
}
