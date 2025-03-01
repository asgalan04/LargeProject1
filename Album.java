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
		message += "Album : '" + albumName + "' by '"+ authorName+ "', Genre '"+genre+
				"'. From the year : "+ year+"\n" ;
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
				Song newSong = new Song(song.getName(),song.getAuthor(),song.getAlbum());
				newSong.setFavorite(song.isFavorite());
				newSong.setRating(song.getRating());
				return newSong;
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
	 * sets a song to favorite or unfavorite given 
	 * a boolean value return true if value was set
	 * false if song not found 
	 */
	
	public boolean setFavorite(String songName, boolean favorite) {
		for (Song s : songsCollection) {
			if (s.getName().toLowerCase().equals(songName.toLowerCase())) {
				s.setFavorite(favorite);
				return true;
			}
		}
		return false;
	}
	
	/*
	 * rates a song given the song name and rating
	 * return true if was able to set false if
	 * song not found 
	 */
	
	public boolean rateSong(String songName, int rating) {
		for (Song s : songsCollection) {
			if (s.getName().toLowerCase().equals(songName.toLowerCase())) {
				s.setRating(rating);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean equals(Object obj) {
	    Album other = (Album) obj;
	    
	    if (albumName.equals(other.getAlbumName()) && authorName.equals(other.getAuthorName()) &&
	        genre.equals(other.getGenre()) && year == other.getYear() &&
	        songsCollection.size() == other.getSongs().size()) {
	        for (int i = 0; i < songsCollection.size(); i++) {
	            if (!songsCollection.get(i).equals(other.getSongs().get(i))) {
	                return false;
	            }
	        	}
	        return true; 
	    	}

	    return false; 
			}

}