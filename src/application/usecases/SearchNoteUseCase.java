package application.usecases;

import domain.entities.Note;
import domain.repositories.NotesRepository;

public class SearchNoteUseCase {
    //Repositories
    private NotesRepository notesRepository;

    //Constructor
    public SearchNoteUseCase(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    //Executor
    public Note execute(int id){
        return notesRepository.searchById(id);
    }
}
