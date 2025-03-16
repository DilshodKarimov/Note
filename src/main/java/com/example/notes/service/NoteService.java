package com.example.notes.service;

import com.example.notes.model.Note;
import com.example.notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }

    public List<Note> findAll(){
        return noteRepository.findAll();
    }

    public Note createNote(Note note){
        return noteRepository.save(note);
    }

    public void deleteById(Long id){
        noteRepository.deleteById(id);
    }

    public Note findById(Long id){
        return noteRepository.getOne(id);
    }

    public void update(Note note, Long id){
        noteRepository.saveAndFlush(note);
    }
}
