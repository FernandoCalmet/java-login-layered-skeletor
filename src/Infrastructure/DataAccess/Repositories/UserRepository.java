package Infrastructure.DataAccess.Repositories;

import Infrastructure.Common.Cache.ActiveUser;
import Infrastructure.DataAccess.Abstracts.IGenericRepository;
import Infrastructure.DataAccess.Abstracts.IUserRepository;
import Support.Entities.UserEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository extends Repository implements IUserRepository, IGenericRepository<UserEntity> {
    @Override
    public UserEntity add(UserEntity entity) {
        try {
            String query = "INSERT INTO users (id, username, firstName, lastName, email, password, role, createdAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = this.GetConnection().prepareStatement(query);
            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getUsername());
            statement.setString(3, entity.getFirstName());
            statement.setString(4, entity.getLastName());
            statement.setString(5, entity.getEmail());
            statement.setString(6, entity.getPassword());
            statement.setString(7, entity.getRole());
            statement.setString(8, entity.getCreatedAt());
            int result = statement.executeUpdate();
            if (result == 0) {
                entity = null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return entity;
    }

    @Override
    public UserEntity edit(UserEntity entity) {
        try {
            String query = "UPDATE users SET firstName = ? , lastName = ?, email = ?, password = ?, role = ?, updatedAt = ? WHERE id = ?";
            PreparedStatement statement = this.GetConnection().prepareStatement(query);
            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setString(3, entity.getEmail());
            statement.setString(4, entity.getPassword());
            statement.setString(5, entity.getRole());
            statement.setString(6, entity.getUpdatedAt());
            statement.setInt(7, entity.getId());
            int result = statement.executeUpdate();
            if (result == 0) {
                entity = null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return entity;
    }

    @Override
    public boolean remove(int id) {
        boolean response = false;

        try {
            String query = "DELETE FROM users WHERE id = ? ";
            PreparedStatement statement = this.GetConnection().prepareStatement(query);
            statement.setInt(1, id);
            int result = statement.executeUpdate();
            if (result > 0) {
                response = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return response;
    }

    @Override
    public Iterable<UserEntity[]> getAll() {
        List<UserEntity[]> listUser = null;

        try {
            String query = "SELECT id, username, firstName, email FROM users ORDER BY id";
            PreparedStatement statement = this.GetConnection().prepareStatement(query);
            ResultSet result = statement.executeQuery();
            ResultSetMetaData meta = result.getMetaData();
            listUser = new ArrayList<>();
            while (result.next()) {
                UserEntity[] userEntity = new UserEntity[meta.getColumnCount()];
                for (int i = 0; i < userEntity.length; i++) {
                    userEntity[i] = (UserEntity) result.getObject(i + 1);
                }
                listUser.add(userEntity);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return listUser;
    }

    @Override
    public Iterable<UserEntity[]> getByValue(String value) {
        List<UserEntity[]> listUser = null;

        try {
            String query = "SELECT id, username, firstName, email WHERE email LIKE ? OR name LIKE ?";
            PreparedStatement statement = this.GetConnection().prepareStatement(query);
            ResultSet result = statement.executeQuery();
            ResultSetMetaData meta = result.getMetaData();
            listUser = new ArrayList<>();
            while (result.next()) {
                UserEntity[] userEntity = new UserEntity[meta.getColumnCount()];
                for (int i = 0; i < userEntity.length; i++) {
                    userEntity[i] = (UserEntity) result.getObject(i + 1);
                }
                listUser.add(userEntity);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return listUser;
    }

    @Override
    public boolean login(String user, String pass) {
        boolean response = false;

        try {
            String query = "SELECT * FROM users WHERE (email = ? AND password = ?) OR (userName = ? AND password = ?)";
            PreparedStatement statement = this.GetConnection().prepareStatement(query);
            statement.setString(1, user);
            statement.setString(2, pass);
            statement.setString(3, user);
            statement.setString(4, pass);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                ActiveUser.setId(result.getInt("id"));
                ActiveUser.setUsername(result.getString("username"));
                ActiveUser.setFirstName(result.getString("firstName"));
                ActiveUser.setEmail(result.getString("email"));
                ActiveUser.setPassword(result.getString("password"));
                ActiveUser.setRole(result.getString("role"));
                response = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return response;
    }
}
