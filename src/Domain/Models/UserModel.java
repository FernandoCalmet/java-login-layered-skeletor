package Domain.Models;

import Domain.ValueObjects.EntityState;
import Infrastructure.DataAccess.Abstracts.IGenericRepository;
import Infrastructure.DataAccess.Abstracts.IUserRepository;
import Infrastructure.DataAccess.Repositories.UserRepository;
import Support.Entities.UserEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FernandoCalmet
 * @version 2.0
 * @since 2020-01-10
 */
public class UserModel {

    private int _id;
    private String _name;
    private String _email;
    private String _password;
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

    public void setId(int _id) {
        this._id = _id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
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
        userObject.setName(_name);
        userObject.setEmail(_email);
        userObject.setPassword(_password);

        return userObject;
    }

    public String saveChanges() {
        String result = null;

        try {
            switch (getState()) {
                case Added:
                    this.genericRepository.add(userEntity());
                    result = "Se guardo exitosamente";
                    break;
                case Edited:
                    this.genericRepository.edit(userEntity());
                    if (isEditMyUserProfile() == true) {
                        LogIn(getEmail(), getPassword());
                    }
                    result = "Se modifico exitosamente";
                    break;
                case Removed:
                    genericRepository.remove(getId());
                    result = "Se elimino exitosamente";
                    break;
            }
        } catch (Exception ex) {
            throw new IllegalArgumentException("Se ha producido un error: " + ex.getMessage());
        }

        return result;
    }

    public boolean LogIn(String user, String pass) {
        try {
            return this.userRepository.login(user, pass);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Se ha producido un error: " + ex.getMessage());
        }
    }

    public List<UserModel> getAllUsers(String value) {
        Iterable<UserEntity> result = this.genericRepository.getByValue(value);
        List<UserModel> userModelList = new ArrayList<>();

        for (UserEntity item : result) {
            UserModel userModel = new UserModel();
            userModel.setId(item.getId());
            userModel.setName(item.getName());
            userModel.setEmail(item.getEmail());
            userModel.setPassword(item.getPassword());
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
            userModel.setName(item.getName());
            userModel.setEmail(item.getEmail());
            userModel.setPassword(item.getPassword());
            userModelList.add(userModel);
        }

        return userModelList;
    }
}
