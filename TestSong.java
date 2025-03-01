package model;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class TestSong {
	
	private Song Song1;
	private Song Song2;
	private Song Song3;
	
	@BeforeEach
    void setUp() {
        Song1=new Song("Tu si","Tito","Incomodo");
        Song2=new Song("ella","Junior h","CT");
        Song3=new Song("Tu si","Tito","Incomodo");
        

    }
	
	

	@Test
	void TestIsFavorite() {
		Song1.setFavorite(true);
		 Assertions.assertTrue(Song1.isFavorite());
		 
		
	}
	
	@Test 
	void TestToString() {
		String message="";
		 message+="Song name: '"+"Tu si"+ "'. Author: '"+"Tito"+"'. Album Name '"+ "Incomodo" + "'";
		 Assertions.assertEquals(message,Song1.toString());
		
	}
	
	@Test
	void getRating() {
		Assertions.assertEquals(Song1.getRating(), 0);
	}
	@Test
	void getName() {
		Assertions.assertEquals(Song1.getName(), "Tu si");
	}
	@Test
	void getAuthor() {
		Assertions.assertEquals(Song1.getAuthor(), "Tito");
	}
	
	@Test 
	void testEquals() {
		Assertions.assertTrue(Song1.equals(Song3));
	}

}
