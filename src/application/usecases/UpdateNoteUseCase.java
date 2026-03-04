package application.usecases;

import domain.entities.Note;
import domain.repositories.NotesRepository;

public class UpdateNoteUseCase {
    //Repositories
    private NotesRepository notesRepository;

    //Constructor
    public UpdateNoteUseCase(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    //Executor
    public void execute(int id,  String title, String description){
        Note note = notesRepository.searchById(id);

        if(note == null){
            throw new RuntimeException("Error: Note Can't be found");
        }
        if(!title.isBlank()){
            note.setTitle(title);
        }
        if(!description.isBlank()){
            note.setDescription(description);
        }

    }
}
