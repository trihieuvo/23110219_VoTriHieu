package com.trihieu.factory;
import com.trihieu.model.*;

public class ProductFactory {
    public static Product createProduct(String type, int quantity) {
        switch (type.toLowerCase()) {
            case "tea": return new Tea(quantity);
            case "softdrink": return new SoftDrink(quantity);
            case "mineralwater": return new MineralWater(quantity);
            default: throw new IllegalArgumentException("Loại sản phẩm không xác định");
        }
    }
}
