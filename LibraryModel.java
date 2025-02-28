package model;
import java.util.*;

/*
 * Class: LibraryModel
 * Purpose: The main database for the user's experience.
 * Stores the users Songs, albums, and playlists.
 */
public class LibraryModel {
	
	private ArrayList<Album> albumList;
	private ArrayList<Playlist> playlists;
	private MusicStore store;
	
	/*
	 * Store needs: getSong(), getAlbums() - returns shallow reference, getAlbum()
	 * Album needs: getName(), getArtist(), getYear(), getSongs() - shallow reference
	 * addSong() - yes this makes mutable but we should be fine with references because I
	 * create copies when adding albums to the user.
	 * Song needs: getName(), getArtist(), getAlbum(), isFavorite()
	 */
	
	
	public LibraryModel() {
		albumList = new ArrayList<Album>();
		playlists = new ArrayList<Playlist>();
		store = new MusicStore();
	}
	
	/*
	 * Method: printsongs(songs)
	 * Purpose: print the songs in nice format from an input arraylist
	 */
	private void printSongs(ArrayList<Song> songs) {
		for (Song s : songs) {
			String printedString = "Song: " + s.getName()
									+ " by " + s.getArtist()
									 + " from the album " + s.getAlbum();
			System.out.println(printedString);
		}
	}
	
	/*
	 * Method: getSongTitle(title)
	 * Purpose: search for a song by title and print its attributes
	 */
	public void getSongTitle(String title) {
		
		ArrayList<Song> foundSongs = new ArrayList<Song>();
		for (Album a : albumList) {
			Song songSearch = a.getSong(title);
			if (songSearch != null) {
				foundSongs.add(songSearch);
			}
		}
		
		if (foundSongs.size() == 0) {
			System.out.println("Song not found in player's library.");
			return;
		}
		
		printSongs(foundSongs);
	}
	
	/*
	 * Method: getSongArtist(artist)
	 * Purpose: search for a song by artist and print its attributes
	 */
	public void getSongArtist(String artist) {
		
		ArrayList<Song> foundSongs = new ArrayList<Song>();
		for (Album a : albumList) {
			if (a.getArtist().equals(artist)) {
				for (Song s : a.getSongs()) {
					foundSongs.add(s);
				}
			}
		}
		
		if (foundSongs.size() == 0) {
			System.out.println("Artist not found in player's library.");
			return;
		}
		
		printSongs(foundSongs);
	}
	
	/*
	 * Method: printAlbums(albums)
	 * Purpose: Take an arraylist of albums and print their attributes and contents
	 */
	private void printAlbums(ArrayList<Album> albums) {
		for (Album a : albums) {
			System.out.println("Album: " + a.getName()
								+ " by " + a.getArtist()
								+ " from the year " + a.getYear());
			for (Song s : a.getSongs()) {
				System.out.println(s.getName());
			}
		}
	}
	
	/*
	 * Method: getAlbumTitle(albumName)
	 * Purpose: search for an album by name and print its contents
	 */
	public void getAlbumTitle(String albumName) {
		
		ArrayList<Album> foundAlbums = new ArrayList<Album>();
		for (Album a : albumList) {
			if (a.getName().equals(albumName)) {
				foundAlbums.add(a);
			}
		}
		
		if (foundAlbums.size() == 0) {
			System.out.println("Album not found in player's library.");
			return;
		}
		
		printAlbums(foundAlbums);
	}
	
	/*
	 * Method: getAlbumArtist(artistName)
	 * Purpose: search for an album by artist and print its contents
	 */
	public void getAlbumArtist(String artistName) {
		
		ArrayList<Album> foundAlbums = new ArrayList<Album>();
		for (Album a : albumList) {
			if (a.getArtist().equals(artistName)) {
				foundAlbums.add(a);
			}
		}
		
		if (foundAlbums.size() == 0) {
			System.out.println("Album not found in player's library.");
			return;
		}
		
		printAlbums(foundAlbums);
	}
	
	/*
	 * Method: hasAlbum(title)
	 * Purpose: check if an album with name title is found
	 * in the albumList
	 */
	private boolean hasAlbum(String title) {
		
		for (Album a : albumList) {
			if (a.getName().equals(title)) {
				return true;
			}
		}
		
		return false;
	}
	
	/*
	 * Method: hasSong(title)
	 * Purpose: check if an album with name title is found
	 * in the albumList
	 */
	private boolean hasSong(Album a, String title) {
		
		for (Song s : a.getSongs()) {
			if (s.getName().equals(title)) {
				return true;
			}
		}
		
		return false;
	}
	
	/*
	 * Method: addSong(title)
	 * Purpose: add a song to the user library into the appropriate album,
	 * make the album if there isn't one already
	 */
	public void addSong(String title) {
		
		Song foundSong = store.getSong();
		
		if (foundSong == null) {
			System.out.println("Song isn't found in the music store.");
			return;
		}
		
		// If the album isn't in our library, we make it
		if (!hasAlbum(foundSong.getAlbum().getName())) {
			for (Album a : store.getAlbums()) {
				if (a.getName().equals(foundSong.getAlbum().getName())) {
					albumList.add(new Album(/*TODO: album constructor*/));
				}
			}
		}
		
		for (Album a : albumList) {
			if (a.getName().equals(foundSong.getAlbum().getName())) {
				if (!hasSong(a, foundSong.getName())) {
					a.addSong(foundSong);
				} else {
					System.out.println("Song is already in library.");
				}
			}
		}
	}
	
	/*
	 * Method: addAlbum(title)
	 * Purpose: add an entire album to the user's library, if its in the store
	 * and not already in the user's library
	 */
	public void addAlbum(String title) {
		
		Album foundAlbum = store.getAlbum(title);
		
		if (foundAlbum == null) {
			System.out.println("Album isn't found in the music store.");
			return;
		}
		
		if (!hasAlbum(title)) {
			
			Album newAlbum = new Album(/* TODO: album constructor*/);
			albumList.add(newAlbum);
			
			for (Song s : foundAlbum.getSongs()) {
				newAlbum.addSong(s);
			}
			
		} else {
			System.out.println("Album is already in library.");
		}
	}
	
	/*
	 * Method: getSongTitles()
	 * Purpose: print to the user a list of song titles
	 */
	public void getSongTitles() {

		if (albumList.size() == 0) {
			System.out.print("No songs in library.");
			return;
		}
		
		System.out.println("-----------------\n      Songs\n-----------------");
		
		for (Album a : albumList) {
			for (Song s : a.getSongs()) {
				System.out.println(s.getName());
			}
		}
		
		System.out.println("-----------------");
	}
	
	/*
	 * Method: getArtists()
	 * Purpose: print to the user a list of artists
	 */
	public void getArtists() {
		ArrayList<String> printedArtists = new ArrayList<String>();
		
		if (albumList.size() == 0) {
			System.out.print("No artists in library.");
			return;
		}
		
		System.out.println("-----------------\n     Artists\n-----------------");
		
		for (Album a : albumList) {
			if (!printedArtists.contains(a.getArtist())) {
				System.out.println(a.getArtist());
				printedArtists.add(a.getArtist());
			}
		}
		
		System.out.println("-----------------");
	}
	
	/*
	 * Method: getAlbums()
	 * Purpose: print to the user a list of albums
	 */
	public void getAlbums() {
		
		if (albumList.size() == 0) {
			System.out.print("No albums in library.");
			return;
		}
		
		System.out.println("------------------\n      Albums\n------------------");
		
		for (Album a : albumList) {
			System.out.println(a.getName() + " by " + a.getArtist());
		}
		
		System.out.println("------------------");
	}
	
	/*
	 * Method: getPlaylists()
	 * Purpose: print to the user their list of playlists
	 */
	public void getPlaylists() {
		
		if (playlists.size() == 0) {
			System.out.println("No playlists in library.");
			return;
		}
		
		System.out.println("-----------------\n    Playlists\n-----------------");
		
		for (Playlist p : playlists) {
			System.out.println(p.getName());
		}
		
		System.out.println("-----------------");
	}
	
	/*
	 * Method: getSongsInPlaylist(title)
	 * Purpose: print out the songs in a playlist
	 */
	public void getSongsInPlaylist(String title) {
		
		if (playlists.size() == 0) {
			System.out.println("No playlists in library.");
			return;
		}
		
		for (Playlist p : playlists) {
			if (p.getName().equals(title)) {
				System.out.println("-----------------\n Songs in " + p.getName() + "\n-----------------");
				printSongs(p.getSongs());
			}
		}
		
		System.out.println("-----------------");
	}
	
	/*
	 * Method: getFavoriteSongs()
	 * Purpose: print out the users favorite songs
	 */
	public void getFavoriteSongs() {
		
		if (albumList.size() == 0) {
			System.out.print("No songs in library.");
			return;
		}
		
		System.out.println("------------------\n  Favorite Songs\n------------------");
		
		for (Album a : albumList) {
			for (Song s : a.getSongs()) {
				if (s.isFavorite()) {
					System.out.println(s.getName());
				}
			}
		}
		
		System.out.println("------------------");
	}
	
	/*
	 * Method: createPlaylist(name)
	 * Purpose: creates a new playlist with name
	 */
	public void createPlaylist(String name) {
		playlists.add(new Playlist(name));
	}
	
	/*
	 * Method: removePlaylist(name)
	 * Purpose: removes a playlist with name
	 */
	public void removePlaylist(String name) {
		for (Playlist p : playlists) {
			if (p.getName().equals(name)) {
				playlists.remove(p);
			}
		}
	}
	
	
}
