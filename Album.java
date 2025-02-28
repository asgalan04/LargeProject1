package Library;

import java.util.ArrayList;
import java.util.HashMap;

public class Album {
	private String authorName;
	private String albumName;
	private ArrayList<Song> songsCollection;

	public Album(String authorName, String albumName) {
		this.authorName = authorName;
		this.albumName = albumName;
		songsCollection = new ArrayList<Song>();

	}
	
	

	public void addSong(Song song) {
		songsCollection.add(song);

	}

	// prints all of the album
	public String toString() {
		String message = "";
		message += "The author of the album is " + authorName +
				" the name of the album is " + albumName+"\n";
		for (Song song : songsCollection) {
			message += song.getName() + "\n";
		}
		return message;

	}

	public Song getSong(String songName) {
		for (Song song: songsCollection) {
			if(song.getName().equals(songName)) {
				return song;
			}
		}
		
		return null;
		

	}
	
	public String getAlbumName() {
		return albumName;
	}

}
