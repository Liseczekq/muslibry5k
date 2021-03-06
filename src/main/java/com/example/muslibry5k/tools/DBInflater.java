package com.example.muslibry5k.tools;

import com.example.muslibry5k.model.Artist;
import com.example.muslibry5k.model.Publisher;
import com.example.muslibry5k.model.Song;
import com.example.muslibry5k.respositories.ArtistRepository;
import com.example.muslibry5k.respositories.PublisherRepository;
import com.example.muslibry5k.respositories.SongRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DBInflater implements ApplicationListener<ContextRefreshedEvent> {

    public DBInflater(SongRepository songRepository , ArtistRepository artistRepository, PublisherRepository publisherRepository){
        this.songRepository = songRepository;
        this.artistRepository=artistRepository;
        this.publisherRepository=publisherRepository;
    }

    private SongRepository songRepository;
    private ArtistRepository artistRepository;
    private PublisherRepository publisherRepository;


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
        publisherRepository.save(columbia);
        artistRepository.save(johnny);
        songRepository.save(hurt);


        Artist queen = new Artist("Queen","Band","Queenies");
        Publisher rosen = new Publisher("Rosen Publishing Group");
        Song bohemian = new Song("Bohemian Rhapsody","Rock","541312312314","1979",rosen);
        queen.getSongs().add(bohemian);
        bohemian.getArtists().add(queen);
        publisherRepository.save(rosen);
        artistRepository.save(queen);
        songRepository.save(bohemian);

        Artist beatles = new Artist("The", "Beatles", "Beatles");
        Publisher northern = new Publisher("Northern Songs Ltd");
        Song yesterday = new Song ("Yesterday","Pop","58123170937123","1965",northern);
        beatles.getSongs().add(yesterday);
        yesterday.getArtists().add(beatles);
        publisherRepository.save(northern);
        artistRepository.save(beatles);
        songRepository.save(yesterday);

    }

}
