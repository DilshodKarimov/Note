package com.example.notes.controllers;


import com.example.notes.model.Note;
import com.example.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    private final NoteService noteService;
    Long id = (long)-1;

    @Autowired
    public MainController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/")
    public String main(){
        return "main";
    }

    @GetMapping("/main.html")
    public String mainHtml(){
        return "main";
    }

    @GetMapping("/create.html")
    public String createForm(Note note){
        return "create.html";
    }

    @PostMapping("/create.html")
    public String create(Note note){
        noteService.createNote(note);
        return "redirect:/read.html";
    }

    @GetMapping("/delete.html/{id}")
    public String delete(@PathVariable("id") Long id){
        noteService.deleteById(id);
        return "redirect:/read.html";
    }

    @GetMapping("/read.html")
    public String read(Model model){
        List<Note> notes = noteService.findAll();
        model.addAttribute("notes", notes);
        return "read.html";
    }

    @GetMapping("/update.html/{id}")
    public String update(@PathVariable("id") Long id, Model model){
        Note note = noteService.findById(id);
        this.id =  id;
        model.addAttribute("notes", note);
        return "update.html";
    }

    @PostMapping("/update.html")
    public String update( Note note){

        note.setId(id);
        noteService.update(note,id);


        return "redirect:/read.html";
    }

    @RequestMapping(value="/update.html", params="cancel", method = RequestMethod.POST)
    public String cancel(){
        return "redirect:/read.html";
    }


}
