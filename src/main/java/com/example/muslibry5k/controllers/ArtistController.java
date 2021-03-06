package com.example.muslibry5k.controllers;

import com.example.muslibry5k.respositories.ArtistRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArtistController {

    private ArtistRepository artistRepository;

    public ArtistController(ArtistRepository artistRepository) {
        this.artistRepository= artistRepository;
    }

    @RequestMapping("/artists")
    public String getArtist(Model model) {
        model.addAttribute("artists", artistRepository.findAll());
return "artists";
    }
}
