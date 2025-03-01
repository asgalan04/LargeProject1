package Library;

import java.util.HashMap;

public class Album {
	private String authorName;
	private String albumName;
	// Hashmaps to look for things faster
	private HashMap<String, Song> songsCollection;

	public Album(String authorName, String albumName) {
		this.authorName = authorName;
		this.albumName = albumName;
		songsCollection = new HashMap<String, Song>();

	}

	public void addSong(String songName) {
		if (songName == null || songName.isEmpty()) {
			System.out.println("Somethis is wrong in the addsongMethod");
			return;
		}
		songsCollection.put(songName, new Song(songName));

	}

	// prints all of the album
	public String toString() {
		String message = "";
		message += "The author of the album is" + authorName + " the name of the album is " + albumName;
		for (String song : songsCollection.keySet()) {
			message += song + "\n";
		}
		return message;

	}

	public Song getSong(String songName) {
		if (songsCollection.containsKey(songName)) {
			return songsCollection.get(songName);
		}
		System.out.print("song not found in album");
		return null;

	}

}
