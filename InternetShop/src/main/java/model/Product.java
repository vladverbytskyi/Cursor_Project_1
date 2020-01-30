package model;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private String name;
    private String brandName;
    private String type;
    private Integer productId;
    private String description;
    private BigDecimal price;
    private boolean inStock;
    private int amountInStock;

    public Product(String name, String brandName, String type, Integer productId,
                   String description, BigDecimal price, int amountInStock) {
        this.name = name;
        this.brandName = brandName;
        this.type = type;
        this.productId = productId;
        this.description = description;
        this.price = price;
        this.amountInStock = amountInStock;
    }
  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return isInStock() == product.isInStock() &&
                Objects.equals(getName(), product.getName()) &&
                Objects.equals(getBrandName(), product.getBrandName()) &&
                Objects.equals(getType(), product.getType()) &&
                Objects.equals(getProductId(), product.getProductId()) &&
                Objects.equals(getDescription(), product.getDescription()) &&
                Objects.equals(getPrice(), product.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getBrandName(), getType(), getProductId(), getDescription(), getPrice(), isInStock());
    }

    @Override
    public String toString() {
        return "Product: "+ name +
                ", Brand= " + brandName +
                ", Type='" + type +
                ", Description='" + description +
                ", price=" + price ;
    }
}
