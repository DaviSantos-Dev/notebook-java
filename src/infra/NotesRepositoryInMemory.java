package infra;

import domain.entities.Note;
import domain.repositories.NotesRepository;

import java.util.ArrayList;
import java.util.List;

public class NotesRepositoryInMemory implements NotesRepository {
    //Atributes
    List<Note> notes;

    //Constructor
    public NotesRepositoryInMemory() {
        notes = new ArrayList<Note>();
    }

    //Methods
    @Override
    public void addNotes(Note note) {
        note.setId(getLastId() + 1);
        notes.add(note);
    }

    @Override
    public void deleteNotes(Note note) {
        notes.remove(note);
    }

    @Override
    public List<Note> getNotes() {
        return new ArrayList<>(notes);
    }

    @Override
    public Note searchById(int id) {
        for (Note note : notes) {
            if (note.getId() == id) {
                return note;
            }
        }
        return null;
    }

    @Override
    public int getLastId() {
        int currentId = 0;
        for (Note note : notes) {
           if (note.getId() > currentId) {
               currentId = note.getId();
           }
        }
        return currentId;
    }
}
