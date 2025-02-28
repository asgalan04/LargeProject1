package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Album {
	private String authorName;
	private String albumName;
	private final int year;
	private String genre;
	private ArrayList<Song> songsCollection;


	public Album(String authorName, String albumName,int year,String genre) {
		this.genre=genre;
		this.authorName = authorName;
		this.albumName = albumName;
		this.year=year;
		
		songsCollection = new ArrayList<Song>();

	}
	
	
  
	public void addSong(Song song) {
		songsCollection.add(song);

	}

    /*
     * returns the album as a string as albumName authorName Genre Year
     * list of songs
     */
   
	public String toString() {
		String message = "";
		message += "Album : " + albumName + " by "+ authorName+ ", Genre "+genre+
				" From the year : "+ year+"\n" ;
		for (Song song : songsCollection) {
			message += song.getName() + "\n";
		}
		return message;

	}
	
	/*
	 * gets the song by name and returns a copy of the 
	 * song object . null if song not found 
	 * 
	 */

	public Song getSong(String songName) {
		for (Song song: songsCollection) {
			if(song.getName().toLowerCase().equals(songName.toLowerCase())) {
				return new Song(song.getName(),song.getAuthor(),song.getAlbum());
			}
		}
		
		return null;
		

	}
	
	public String getAlbumName() {
		return albumName;
	}
	
	public String getAuthorName() {
		return authorName;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public int getYear() {
		return year;
	}
	
	/*
	 * returns a deep copy of the arrayList of songs
	 */
	public ArrayList<Song> getSongs(){
		ArrayList<Song>curr=new ArrayList<Song>();
		for(Song s: songsCollection) {
			Song newSong=new Song(s.getName(),s.getAuthor(),s.getAlbum());
			newSong.setFavorite(s.isFavorite());
			newSong.setRating(s.getRating());
			curr.add(newSong);
		}
		return curr;
	}
	/*
	 * Compares if to albums are the same
	 */
	@Override
	public boolean equals(Object obj) {
	    Album first = (Album) obj;
	    if (first.getAlbumName().equals(albumName) && first.getAuthorName().equals(authorName) &&
	    		first.getGenre().equals(genre) &&  first.getYear() == year) {
	    	for (int i = 0; i < first.getSongs().size(); i++) {
		        if (!first.getSongs().get(i).equals(songsCollection.get(i))) {
		            return false;
		        }
	    }
	    if (first.getSongs().size() != songsCollection.size()) {
	   
	}
	    }
		return true;
	}
}


