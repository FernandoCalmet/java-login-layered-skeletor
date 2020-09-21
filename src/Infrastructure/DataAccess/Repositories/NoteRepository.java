package Infrastructure.DataAccess.Repositories;

import Infrastructure.DataAccess.Abstracts.IGenericRepository;
import Infrastructure.DataAccess.Abstracts.INoteRepository;
import Support.Entities.NoteEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FernandoCalmet
 * @version 2.0
 * @since 2020-01-10
 */
public class NoteRepository extends Repository implements INoteRepository, IGenericRepository<NoteEntity> {

    @Override
    public NoteEntity add(NoteEntity entity) {
        try {
            String query = "INSERT INTO notes (id, name, description, createdAt) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = this.GetConnection().prepareStatement(query);
            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getName());
            statement.setString(3, entity.getDescription());
            statement.setString(4, entity.getCreatedAt());
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
    public NoteEntity edit(NoteEntity entity) {
        try {
            String query = "UPDATE notes SET name = ? , description = ?, updatedAt = ? WHERE id = ?";
            PreparedStatement statement = this.GetConnection().prepareStatement(query);
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getDescription());
            statement.setString(3, entity.getUpdatedAt());
            statement.setInt(4, entity.getId());
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
            String query = "DELETE FROM notes WHERE id = ? ";
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
    public Iterable<NoteEntity[]> getAll() {
        List<NoteEntity[]> listNote = null;

        try {
            String query = "SELECT id, name, description FROM notes ORDER BY id";
            PreparedStatement statement = this.GetConnection().prepareStatement(query);
            ResultSet result = statement.executeQuery();
            ResultSetMetaData meta = result.getMetaData();
            listNote = new ArrayList<>();
            while (result.next()) {
                NoteEntity[] noteEntity = new NoteEntity[meta.getColumnCount()];
                for (int i = 0; i < noteEntity.length; i++) {
                    noteEntity[i] = (NoteEntity) result.getObject(i + 1);
                }
                listNote.add(noteEntity);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return listNote;
    }

    @Override
    public Iterable<NoteEntity[]> getByValue(String value) {
        List<NoteEntity[]> listNote = null;

        try {
            String query = "SELECT id, name, description WHERE name LIKE ?";
            PreparedStatement statement = this.GetConnection().prepareStatement(query);
            ResultSet result = statement.executeQuery();
            ResultSetMetaData meta = result.getMetaData();
            listNote = new ArrayList<>();
            while (result.next()) {
                NoteEntity[] noteEntity = new NoteEntity[meta.getColumnCount()];
                for (int i = 0; i < noteEntity.length; i++) {
                    noteEntity[i] = (NoteEntity) result.getObject(i + 1);
                }
                listNote.add(noteEntity);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return listNote;
    }
}
