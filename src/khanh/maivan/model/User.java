package khanh.maivan.model;


public class User {
    private int id;
    private String name;
    private int value;

    public User(int id, String name, int value){
        this.id = id;
        this.name = name ;
        this.value = value;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getValue(){
        return value;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setValue(int value){
        this.value = value;
    }
    public String toString() {
        return "User " +
                "id=" + id +
                " name=" + name +
                " Value=" + value ;
    }
}
