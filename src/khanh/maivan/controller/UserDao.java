package khanh.maivan.controller;
import khanh.maivan.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao implements DAO<User> {
    private List<User> users = new ArrayList<>();
    public UserDao(){
        users.add( new User(1, "ADMIN 1" , 1000000 ) );
        users.add( new User(2, "ADMIN 2" , 1000000 ) );
    }
    @Override
    public List<User> getAll() { return users; }
    @Override
    public Optional<User> get(int id) {
        return users.stream().filter( u -> u.getId() == id ).findFirst();
    }
    @Override
    public void add(User user) { users.add(user); }
    @Override
    public void update(User user) {
        get(user.getId()).ifPresent(existUser -> {
            existUser.setId(user.getId());
            existUser.setName(user.getName());
            existUser.setValue(user.getValue());
        });
    }
    @Override
    public void delete(User user) {
        get(user.getId()).ifPresent( existUser -> users.remove(existUser) );
    }
}
