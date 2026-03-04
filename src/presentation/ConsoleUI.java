package presentation;

import application.usecases.*;
import domain.entities.Note;
import domain.exceptions.BusinessException;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    Scanner scan = new Scanner(System.in);

    //UseCases
    CreateNoteUseCase createNote;
    DeleteNoteUseCase deleteNote;
    ReadNotesUseCase readNotes;
    SearchNoteUseCase searchNote;
    UpdateNoteUseCase updateNote;

    //Constructor
    public ConsoleUI(CreateNoteUseCase createNote, DeleteNoteUseCase deleteNote,  SearchNoteUseCase searchNote, UpdateNoteUseCase updateNote, ReadNotesUseCase getNotes) {
        this.createNote = createNote;
        this.deleteNote = deleteNote;
        this.searchNote = searchNote;
        this.updateNote = updateNote;
        this.readNotes = getNotes;
    }

    //Default presentation
    public void separationRows(){
        System.out.println("======================");
    }
    public void showTitle(String titulo){
        separationRows();
        System.out.println(titulo);
        separationRows();
    }

    //Pages
    public void MainInterface(){
        int option = 0;
        boolean systemRunning = true;
        while (systemRunning){
            showTitle("Note book");
            System.out.println("Select a action:");
            System.out.println("1. Create Note");
            System.out.println("2. Delete Note");
            System.out.println("3. Search Note");
            System.out.println("4. Update Note");
            System.out.println("5. Read all Notes");
            System.out.println("0. Close System");
            separationRows();
            System.out.print("Your option:");

            try{
                option = Integer.parseInt(scan.nextLine());
                switch(option){
                    case 1:
                        noteCreationPage();
                        break;
                    case 2:
                        noteDeletionPage();
                        break;
                    case 3:
                        noteSearchPage();
                        break;
                    case 4:
                        noteUpdatingPage();
                        break;
                    case 5:
                        noteReadingPage();
                        break;
                    case 0:
                        systemRunning = false;
                }

            } catch (NumberFormatException e){
                System.out.println("Error: Invalid input");
            } catch (BusinessException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void noteCreationPage(){
        showTitle("Note Creation");
        System.out.println("Whats is the title?");
        String title = scan.nextLine();

        System.out.println("What is the note content?");
        String content = scan.nextLine();

        try {
            createNote.execute(title,content);
            System.out.println("Note created successfully");
        }
        catch (BusinessException e){
            System.out.println(e.getMessage());
        }
    }

    public void noteDeletionPage(){
        showTitle("Note Deletion");
        System.out.println("Select the note ID you want to delete");
        int id = Integer.parseInt(scan.nextLine());

        deleteNote.execute(id);

    }

    public void noteSearchPage(){
        showTitle("Note Search");
        System.out.println("Select the note ID you want to search");
        int id = Integer.parseInt(scan.nextLine());

        searchNote.execute(id);

    }

    public void noteUpdatingPage(){
        showTitle("Note Updating");
        System.out.println("Select the note ID you want to update");
        int id = Integer.parseInt(scan.nextLine());

        System.out.print("Write the new title: ");
        String title = scan.nextLine();

        System.out.print("Write the new content: ");
        String content = scan.nextLine();

            updateNote.execute(id, title, content);
    }

    public void noteReadingPage(){
        showTitle("All Notes");

        List<Note> list = readNotes.execute();
        for (Note note : list){
            showTitle(note.toString());
        }
    }

}
