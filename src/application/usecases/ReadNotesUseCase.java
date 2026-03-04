package application.usecases;

import domain.entities.Note;
import domain.repositories.NotesRepository;

import java.util.ArrayList;
import java.util.List;

public class ReadNotesUseCase {
    //Repositories
    private NotesRepository notesRepository;

    //Constructor
    public ReadNotesUseCase(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    //Executor
    public List<Note> execute(){
        return notesRepository.getNotes();
    }
}
