package com.example.muslibry5k.tools;

import com.example.muslibry5k.model.Artist;
import com.example.muslibry5k.model.Publisher;
import com.example.muslibry5k.model.Song;
import com.example.muslibry5k.respositories.ArtistRepository;
import com.example.muslibry5k.respositories.PublisherRespository;
import com.example.muslibry5k.respositories.SongRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class DBInflater implements ApplicationListener<ContextRefreshedEvent> {

    private SongRepository songRepository;
    private ArtistRepository artistRepository;
    private PublisherRespository publisherRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        initData();
    }

    private void initData() {
        Artist johnny = new Artist("Johnny", "Cash", "cash");
        Publisher columbia = new Publisher("Columbia Records");
        Song hurt = new Song("Hurt" , "Alternative rock" , "123123134","2003", columbia);
        johnny.getSongs().add(hurt);
        hurt.getArtists().add(johnny);
        artistRepository.save(johnny);
        songRepository.save(hurt);


        Artist queen = new Artist("Queen","Band","Queenies");
        Publisher rosen = new Publisher("Rosen Publishing Group");
        Song bohemian = new Song("Bohemian Rhapsody","Rock","541312312314","1979",rosen);
        queen.getSongs().add(bohemian);
        bohemian.getArtists().add(queen);
        artistRepository.save(queen);
        songRepository.save(bohemian);

        Artist beatles = new Artist("The", "Beatles", "Beatles");
        Publisher northern = new Publisher("Northern Songs Ltd");
        Song yesterday = new Song ("Yesterday","Pop","58123170937123","1965",northern);
        beatles.getSongs().add(yesterday);
        yesterday.getArtists().add(beatles);
        artistRepository.save(beatles);
        songRepository.save(yesterday);

    }

















}
