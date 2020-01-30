package model;

import java.math.BigDecimal;
import java.util.ArrayList;

import java.util.List;

public class Order {

    private long id;
    private List<PositionItem> itemList;
    private BigDecimal total;
    private User user;
    private StatusOrder statusOrder;

    public enum StatusOrder{
        COMPLITED,IN_PROCESS,REFUSAL
    }

    public Order(List<PositionItem> itemList, User user, StatusOrder statusOrder) {
        this.itemList = itemList;
        this.user = user;
        this.statusOrder = statusOrder;
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

    public void printAllItem(){
        List<PositionItem> m = getItemList();
        for (PositionItem s : m){
            String k = "Product: "+ s.item.getName() +
                    ", Brand= " + s.item.getBrandName() +
                    ", Type='" + s.item.getType() +
                    ", Description='" + s.item.getDescription() +
                    ", price=" + s.item.getPrice()+
                    ", amount=" + s.amount + ", subTotal="
                    + s.subTotal;
            System.out.println(k);
        }
    }

    public User getUser() {
        return user;
    }

    public static class PositionItem {
        private Product item;
        private int amount;
        private BigDecimal subTotal;

        @Override
        public String toString() {
            return "Product=" + item + ", amount=" + amount + ", subTotal=" + subTotal+"\n";
        }

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
  
    @Override
    public String toString() {
        return "\nOrder id = " + id + ", Owner = " + user.getName() + ", statusOrder = " + statusOrder + '}';
    }
}
