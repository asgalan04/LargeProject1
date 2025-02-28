package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestingClass {

	@Test
	void SearchAlbumtest() {
		MusicStore music = new MusicStore();
        ArrayList<Album> albums = music.getAlbums();
        Album adele = albums.get(0);
        Album adele2 = music.searchAlbum("19");
        Assertions.assertTrue(adele.equals(adele2));
        
    }
	@Test
	void searchSong() {
		MusicStore music = new MusicStore();
        ArrayList<Album> albums = music.getAlbums();
        Album curr=albums.get(0);
        Song r=curr.getSong("Tired");
        Song adele = music.searchSong("Tired");
       
        Assertions.assertTrue(adele.equals(r));
		
	}
	
	
	
	}

