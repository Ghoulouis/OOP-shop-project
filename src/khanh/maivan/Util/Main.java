package khanh.maivan.Util;

import khanh.maivan.controller.DAO;
import khanh.maivan.controller.UserDao;
import khanh.maivan.controller.ItemDao;
import khanh.maivan.model.Item;
import khanh.maivan.model.User;

import java.security.Principal;

public class Main {
    private static DAO<Item> items;
    private static DAO<User> users;
    public static void Buy(int  idUser,int idItem, int amount ){
        if ( users.get(idUser).isEmpty() | items.get(idItem).isEmpty() ){
            System.out.println(" Khong ton tai");
            return;
        }
        Item x = items.get(idItem).get();
        User y = users.get(idUser).get();
        x.setAmount( x.getAmount() - amount );
        y.setValue( y.getValue() - amount * x.getPrice() );
        if ( x.getAmount() < 0 | y.getValue() < 0 ) {
            System.out.println(" Khong du tien ");
            return;
        }
        items.update(x);
        users.update(y);
    }
    public static void PrintItem() {
        items.getAll().forEach(item -> System.out.println( item.toString() ) );
    }

    public static void PrintUser() {
        users.getAll().forEach(user->System.out.println(user.toString()));
    }

    public static void main(String[] args) {
        users = new UserDao();
        items = new ItemDao();
        //ADD ITEM
        items.add( new Item(4, "Xoai" , 5, 100 ) );
        //ADD USER
        users.add( new User( 3 , "Nam" , 10000 ) );
        users.add( new User( 4 , "Khanh" , 10000 ) );
        //USER BUY ITEM
        Buy( 3 , 1 , 2 );
        //UPDATE ITEM
        items.update( new Item(4, "XOAI" , 100 , 80) );
        //UPDATE USER
        users.update( new User(3 , " NAM BEO" , 20000) );
        //DELETE ITEM
        items.delete( items.get(2).get() );
        //DELETE USER
        users.delete( users.get(1).get());
        PrintUser();

    }
}

