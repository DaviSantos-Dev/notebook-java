package application;

import application.usecases.*;
import domain.repositories.NotesRepository;
import infra.NotesRepositoryInMemory;
import presentation.ConsoleUI;

public class AppConfig {
    //Repositories
    NotesRepository notesRepository = new NotesRepositoryInMemory();

    //UseCases
    CreateNoteUseCase createNote = new CreateNoteUseCase(notesRepository);
    DeleteNoteUseCase deleteNote = new DeleteNoteUseCase(notesRepository);
    ReadNotesUseCase readNotes = new ReadNotesUseCase(notesRepository);
    SearchNoteUseCase searchNote = new SearchNoteUseCase(notesRepository);
    UpdateNoteUseCase updateNote = new UpdateNoteUseCase(notesRepository);

    //Interface
    ConsoleUI consoleUI = new ConsoleUI(createNote, deleteNote, searchNote, updateNote, readNotes);

    //Initializer
    public void initialize() {
        consoleUI.MainInterface();
    }
}
