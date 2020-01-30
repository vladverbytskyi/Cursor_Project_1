package model;

import java.math.BigDecimal;

import java.util.List;
import java.util.Random;

public class Order {
    private long id;
    private List<PositionItem> itemList;
    private BigDecimal total;
    private String user;
    private StatusOrder statusOrder;

    public enum StatusOrder{
        COMPLITED,IN_PROCESS,REFUSAL
    }

    public Order(){}
    public Order(List<PositionItem> itemList, String user, StatusOrder statusOrder) {
        this.itemList = itemList;
        this.user = user;
        this.statusOrder = statusOrder;
        this.total = getTotal();
        this.id = new Random().nextInt(999999999);
    }

    public BigDecimal getTotal() {
        return itemList != null ?
                itemList.stream()
                        .map(a -> a.subTotal)
                        .reduce(BigDecimal::add)
                        .get() : BigDecimal.ZERO;
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

    public String getUser() {
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

        public PositionItem(){}
        public PositionItem(Product item, int amount) {
            this.item = item;
            this.amount = amount;
            this.subTotal = getSubTotal();
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
        return "\nOrder id = " + id + ", Owner = " + user + ", statusOrder = " + statusOrder + '}';
    }
}
