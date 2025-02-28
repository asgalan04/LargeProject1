package Library;

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


	public String toString() {
		String message = "";
		message += "Album : " + albumName + " by "+ authorName+ ", Genre "+genre+
				" From the year : "+ year+"\n" ;
		for (Song song : songsCollection) {
			message += song.getName() + "\n";
		}
		return message;

	}

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
	
	public ArrayList<Song> getSongs(){
		ArrayList<Song>curr=new ArrayList<Song>(songsCollection);
		for(Song s: songsCollection) {
			curr.add(new Song(s.getName(),s.getAuthor(),s.getAlbum()));
		}
		return curr;
	}


}
