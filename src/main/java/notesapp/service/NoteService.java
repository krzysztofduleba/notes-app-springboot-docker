package notesapp.service;

import notesapp.model.Note;
import notesapp.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getNotes() {
        return noteRepository.findAll();
    }

    public Note getNoteById(Long id) throws Exception {
        return noteRepository.findById(id)
                .orElseThrow(() -> new Exception("Note by id " + id + " not found."));
    }

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public Note updateNote(Long id, Note newNote) throws Exception {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new Exception("Note by id " + id + " not found."));

        note.setTitle(newNote.getTitle());
        note.setContent(newNote.getContent());

        return noteRepository.save(note);
    }

    public void deleteNote(Long id) throws Exception {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new Exception("Note by id " + id + " not found."));

        noteRepository.delete(note);
    }
}
