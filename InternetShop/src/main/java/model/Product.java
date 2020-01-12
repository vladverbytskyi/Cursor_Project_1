package model;

public class Product {
    private String name;
    private String brandName;
    private String type;
    private Integer productId;
    private String description;
    private Integer price;
    private boolean inStock;

    public Product(String name, String brandName, String type, Integer productId,
                   String description, Integer price, boolean inStock) {
        this.name = name;
        this.brandName = brandName;
        this.type = type;
        this.productId = productId;
        this.description = description;
        this.price = price;
        this.inStock = inStock;
    }

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public Product(String name, String brandName) {
        this.name = name;
        this.brandName = brandName;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;

    }
}
