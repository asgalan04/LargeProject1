import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Playlist;
import model.Song;

class TestPlaylist {
	
	private Playlist PlayList;
	private Playlist PlayList2;
	private Song Song1;
	private Song Song2;
	
	@BeforeEach
    void setUp() {
        PlayList=new Playlist("mine");
        PlayList2=new Playlist("mine");
        Song1=new Song("Tu si","Tito","Incomodo");
        Song2=new Song("ella","Junior h","CT");
        PlayList.addSong(Song1);
        PlayList.addSong(Song2);
        PlayList2.addSong(Song1);
        PlayList2.addSong(Song2);
        
        
        
    }

	@Test
	void testGetName() {
		Assertions.assertEquals("mine",PlayList.getName());
	
	}

	@Test
	void testGetSongs() {
		ArrayList<Song> songs=PlayList.getSongs();
		Assertions.assertTrue(songs.get(0).equals(Song1));
		Assertions.assertTrue(songs.get(1).equals(Song2));
	
	}
	
	@Test
	
	void TestremoveSong() {
		PlayList.removeSong("tu si");
		PlayList2.removeSong("tu si");
		
		
		Assertions.assertTrue(PlayList.equals(PlayList2));
		
	}
	
	@Test
	void testEquals() {
		Assertions.assertTrue(PlayList2.equals(PlayList));
	}
	
	

}
