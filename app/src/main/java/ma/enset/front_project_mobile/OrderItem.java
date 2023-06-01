package ma.enset.front_project_mobile;

import java.util.List;

public class OrderItem  {
    private String orderId;
    private String status;
    private List<ProductItem> productList;
    private double totalPrice;

    public OrderItem(String orderId, String status, List<ProductItem> productList) {
        this.orderId = orderId;
        this.status = status;
        this.productList = productList;
        this.totalPrice = calculateTotal();
    }

    public String getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }

    public List<ProductItem> getProductList() {
        return productList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    public double calculateTotal(){
        double totalPrice = 0.0;
        for (ProductItem productItem : getProductList()) {
            totalPrice += productItem.getPrice() * productItem.getQuantity();
        }
        return totalPrice;
    }
}
