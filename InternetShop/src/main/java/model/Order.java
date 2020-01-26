package model;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    private long id;
    private List<PositionItem> itemList;
    private BigDecimal total;
    private User user;

    public Order(List<PositionItem> itemList, User user) {
        this.itemList = itemList;
        this.user = user;
    }

    public BigDecimal getTotal() {
        return itemList != null ?
                itemList.stream()
                        .map(a -> a.subTotal)
                        .reduce(BigDecimal::add)
                        .get() : null;
    }

    public long getId() {
        return id;
    }

    public List<PositionItem> getItemList() {
        return itemList;
    }


    public User getUser() {
        return user;
    }

    class PositionItem {
        private Product item;
        private int amount;
        private BigDecimal subTotal;

        public PositionItem(Product item, int amount) {
            this.item = item;
            this.amount = amount;
        }


        public Product getItem() {
            return item;
        }

        public int getAmount() {
            return amount;
        }

        public BigDecimal getSubTotal() {
            return item != null ? item.getPrice().multiply(BigDecimal.valueOf(amount)) : BigDecimal.ZERO;
        }
    }
}
