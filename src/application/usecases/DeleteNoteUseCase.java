package application.usecases;

import domain.entities.Note;
import domain.exceptions.BusinessException;
import domain.repositories.NotesRepository;

public class DeleteNoteUseCase {
    //Repositories
    private NotesRepository notesRepository;

    //Constructor
    public DeleteNoteUseCase(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    //Executor
    public void execute(int id){
        Note note = notesRepository.searchById(id);

        if (note == null) {
            throw new BusinessException("Error: Note can't be found");
        }
        notesRepository.deleteNotes(note);
    }
}
