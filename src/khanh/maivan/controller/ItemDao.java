package khanh.maivan.controller;
import khanh.maivan.model.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemDao implements DAO<Item> {
    private List<Item> items = new ArrayList<>();
    public ItemDao() {
        items.add( new Item(1,"Tao",10 , 30) );
        items.add( new Item(2,"Chuoi",20 , 40) );
        items.add( new Item(3,"Nho",1 , 50) );
    }
    @Override
    public List<Item> getAll() {
        return items;
    }
    @Override
    public Optional<Item> get(int id) {
        return items.stream().filter( u -> u.getId() == id ).findFirst();
    }
    @Override
    public void add(Item item) {
        items.add(item);
    }
    @Override
    public void update(Item item) {
        get(item.getId()).ifPresent(existItem -> {
            existItem.setId(item.getId());
            existItem.setName(item.getName());
            existItem.setAmount(item.getAmount());
            existItem.setPrice(item.getPrice());
        });
    }
    @Override
    public void delete(Item item) {
        get( item.getId()).ifPresent(existItem -> items.remove(existItem)) ;
    }
}