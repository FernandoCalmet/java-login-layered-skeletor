package Domain.Models;

import Domain.ValueObjects.EntityState;
import Infrastructure.DataAccess.Abstracts.IGenericRepository;
import Infrastructure.DataAccess.Abstracts.IUserRepository;
import Infrastructure.DataAccess.Repositories.UserRepository;
import Support.Entities.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserModel {
    private int _id;
    private String _username;
    private String _firstName;
    private String _lastName;
    private String _email;
    private String _password;
    private String _role;
    private EntityState _state;
    private boolean _editMyUserProfile = false;
    private IUserRepository userRepository;
    private IGenericRepository genericRepository;

    public UserModel() {
        this.genericRepository = new UserRepository();
        this.userRepository = new UserRepository();
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getUsername() {
        return _username;
    }

    public void setUsername(String username) {
        this._username = username;
    }

    public String getFirstame() {
        return _firstName;
    }

    public void setFirstName(String name) {
        this._firstName = name;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String name) {
        this._lastName = name;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String _email) {
        this._email = _email;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }

    public String getRole() {
        return _role;
    }

    public void setRole(String role) {
        this._role = role;
    }

    public EntityState getState() {
        return _state;
    }

    public void setState(EntityState _state) {
        this._state = _state;
    }

    public boolean isEditMyUserProfile() {
        return _editMyUserProfile;
    }

    public void setEditMyUserProfile(boolean _editMyUserProfile) {
        this._editMyUserProfile = _editMyUserProfile;
    }

    private UserEntity userEntity() {
        UserEntity userObject = new UserEntity();
        userObject.setId(_id);
        userObject.setUsername(_username);
        userObject.setFirstName(_firstName);
        userObject.setLastName(_lastName);
        userObject.setEmail(_email);
        userObject.setPassword(_password);
        userObject.setRole(_role);

        return userObject;
    }

    public String saveChanges() {
        String result = null;

        try {
            switch (getState()) {
                case ADDED:
                    this.genericRepository.add(userEntity());
                    result = "Saved successfully";
                    break;
                case EDITED:
                    this.genericRepository.edit(userEntity());
                    if (isEditMyUserProfile() == true) {
                        LogIn(getUsername(), getPassword());
                    }
                    result = "Updated successfully";
                    break;
                case REMOVED:
                    genericRepository.remove(getId());
                    result = "Deleted successfully";
                    break;
            }
        } catch (Exception ex) {
            throw new IllegalArgumentException("An error has occurred: " + ex.getMessage());
        }

        return result;
    }

    public boolean LogIn(String user, String pass) {
        try {
            return this.userRepository.login(user, pass);
        } catch (Exception ex) {
            throw new IllegalArgumentException("An login error has occurred, probably no connection to the database has been established. " + ex.getMessage());
        }
    }

    public List<UserModel> getAllUsers() {
        Iterable<UserEntity> result = this.genericRepository.getAll();
        List<UserModel> userModelList = new ArrayList<>();

        for (UserEntity item : result) {
            UserModel userModel = new UserModel();
            userModel.setId(item.getId());
            userModel.setUsername(item.getUsername());
            userModel.setFirstName(item.getFirstName());
            userModel.setLastName(item.getLastName());
            userModel.setEmail(item.getEmail());
            userModel.setPassword(item.getPassword());
            userModel.setRole(item.getRole());
            userModelList.add(userModel);
        }

        return userModelList;
    }

    public List<UserModel> getAUserByValue(String value) {
        Iterable<UserEntity> result = this.genericRepository.getByValue(value);
        List<UserModel> userModelList = new ArrayList<>();

        for (UserEntity item : result) {
            UserModel userModel = new UserModel();
            userModel.setId(item.getId());
            userModel.setUsername(item.getUsername());
            userModel.setFirstName(item.getFirstName());
            userModel.setLastName(item.getLastName());
            userModel.setEmail(item.getEmail());
            userModel.setPassword(item.getPassword());
            userModel.setRole(item.getRole());
            userModelList.add(userModel);
        }

        return userModelList;
    }
}
