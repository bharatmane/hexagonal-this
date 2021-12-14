package io.github.bharatmane.hexagonalthis.repository;

import io.github.bharatmane.hexagonalthis.domainapi.model.User;
import io.github.bharatmane.hexagonalthis.domainapi.model.port.ObtainUser;
import io.github.bharatmane.hexagonalthis.repository.dao.UserDao;
import io.github.bharatmane.hexagonalthis.repository.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public class UserRepository implements ObtainUser {
    private final UserDao userDao;

    public UserRepository(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers(){
        return userDao.findAll().stream().map(UserEntity::toModel).toList();
    }

    @Override
    public Optional<User> getUserById(int userId) {
        var userEntity = userDao.findById(userId);
        return userEntity.map(UserEntity::toModel);
    }

    @Override
    public void addUser(User user) {
        //userDao.addUser()
    }

    @Override
    public void updateUser(User user) {
        //TBD
    }

    @Override
    public void deleteUserById(int userId) {
        //TBD
    }
}
