package application.usecases;

import domain.entities.Note;
import domain.exceptions.BusinessException;
import domain.repositories.NotesRepository;

public class CreateNoteUseCase {
    //Repositories
    private NotesRepository notesRepository;

    //Constructor
    public CreateNoteUseCase(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    //Executor
    public void execute(String title, String description) {
        if (title.isBlank()) {
            throw new BusinessException("Error: Title cannot be empty");
        }
        if (description.isBlank()) {
            throw new BusinessException("Error: Description cannot be empty");
        }
        notesRepository.addNotes(new Note(title, description));
    }
}
