package com.trihieu.observer;
public class AdminNotifier implements VendingMachineObserver {
    @Override
    public void update(String message) {
        System.out.println("[Thông báo Quản trị] " + message);
    }
}
