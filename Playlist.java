package model;
import java.util.*;

public class Playlist {
	
	private ArrayList<Song> songs;
	private String name;
	
	public Playlist(String name) {
		this.name = name;
		songs = new ArrayList<Song>();
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Song> getSongs() {
		return new ArrayList<Song>(songs);
	}
	
	public void addSong(Song s) {
		songs.add(s);
	}
	
	public void removeSong(String title) {
		for (Song s : songs) {
			if (s.getName().equals(title)) {
				songs.remove(s);
			}
		}
	}
}
