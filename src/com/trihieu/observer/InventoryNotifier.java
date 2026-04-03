package com.trihieu.observer;
public class InventoryNotifier implements VendingMachineObserver {
    @Override
    public void update(String message) {
        System.out.println("[Thông báo Kho] " + message);
    }
}
