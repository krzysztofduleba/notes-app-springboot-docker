package notesapp.controller;

import notesapp.model.Note;
import notesapp.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/notes")
    public ResponseEntity getNotes() {
        return new ResponseEntity(noteService.getNotes(), HttpStatus.OK);
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity getNoteById(@PathVariable(value = "id") Long id) throws Exception {
        return new ResponseEntity(noteService.getNoteById(id), HttpStatus.OK);
    }

    @PostMapping("/notes")
    public ResponseEntity createNote(@RequestBody Note note) {
        return new ResponseEntity(noteService.createNote(note), HttpStatus.CREATED);
    }

    @PutMapping("/notes/{id}")
    public ResponseEntity updateNote(@PathVariable(value = "id") Long id, @RequestBody Note note) throws Exception {
        return new ResponseEntity(noteService.updateNote(id, note), HttpStatus.CREATED);
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity deleteNote(@PathVariable(value = "id") Long id) throws Exception {
        noteService.deleteNote(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
