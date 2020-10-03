package Domain.Models;

import Infrastructure.DataAccess.Abstracts.IGenericRepository;
import Infrastructure.DataAccess.Repositories.NoteRepository;
import Support.Entities.NoteEntity;

import java.util.ArrayList;
import java.util.List;

public class NoteModel {
    private int _id;
    private String _name;
    private String _description;
    private String _createdAt;
    private String _updatedAt;
    private IGenericRepository genericRepository;

    public NoteModel() {
        this.genericRepository = new NoteRepository();
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

    public String getDescription() {
        return _description;
    }

    public void setDescription(String _description) {
        this._description = _description;
    }

    public String getCreatedAt() {
        return _createdAt;
    }

    public void setCreatedAt(String _createdAt) {
        this._createdAt = _createdAt;
    }

    public String getUpdatedAt() {
        return _updatedAt;
    }

    public void setUpdatedAt(String _updatedAt) {
        this._updatedAt = _updatedAt;
    }

    private NoteEntity noteEntity() {
        NoteEntity noteObject = new NoteEntity();
        noteObject.setId(_id);
        noteObject.setName(_name);
        noteObject.setDescription(_description);

        return noteObject;
    }

    public List<NoteModel> getAllNotes() {
        Iterable<NoteEntity> result = this.genericRepository.getAll();
        List<NoteModel> noteModelList = new ArrayList<>();

        for (NoteEntity item : result) {
            NoteModel noteModel = new NoteModel();
            noteModel.setId(item.getId());
            noteModel.setName(item.getName());
            noteModel.setDescription(item.getDescription());
            noteModelList.add(noteModel);
        }

        return noteModelList;
    }

    public List<NoteModel> getANoteByValue(String value) {
        Iterable<NoteEntity> result = this.genericRepository.getByValue(value);
        List<NoteModel> noteModelList = new ArrayList<>();

        for (NoteEntity item : result) {
            NoteModel noteModel = new NoteModel();
            noteModel.setId(item.getId());
            noteModel.setName(item.getName());
            noteModel.setDescription(item.getDescription());
            noteModelList.add(noteModel);
        }

        return noteModelList;
    }
}
