package domain.repositories;

import domain.entities.Note;

import java.util.List;

public interface NotesRepository {
    void addNotes(Note note);
    void deleteNotes(Note note);
    List<Note> getNotes();
    Note searchById(int id);
    int getLastId();
}
