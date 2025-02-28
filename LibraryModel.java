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
	 * Store needs: getAlbums() - returns deep reference, searchAlbum() - search for and return copy of album
	 * Album needs: getName(), getArtist(), getYear(), getSongs() - deep reference
	 * addSong() - yes this makes mutable but we should be fine with references because I
	 * create copies when adding albums to the user.
	 * Song needs: getName(), getArtist(), getAlbum(), isFavorite(), setFavorite(), setRating()
	 */
	
	
	public LibraryModel() {
		albumList = new ArrayList<Album>();
		playlists = new ArrayList<Playlist>();
		store = new MusicStore();
	}
	
	/*
	 * Method: searchSongTitle(title)
	 * Purpose: search for a song by title and return a list of found songs
	 */
	public ArrayList<Song> searchSongTitle(String title) {
		
		ArrayList<Song> foundSongs = new ArrayList<Song>();
		for (Album a : albumList) {
			Song songSearch = a.getSong(title);
			if (songSearch != null) {
				foundSongs.add(songSearch);
			}
		}
		
		return foundSongs;
	}
	
	/*
	 * Method: searchSongArtist(artist)
	 * Purpose: search for a song by artist and return a list of found songs
	 */
	public ArrayList<Song> searchSongArtist(String artist) {
		
		ArrayList<Song> foundSongs = new ArrayList<Song>();
		for (Album a : albumList) {
			if (a.getArtist().toLowerCase().equals(artist.toLowerCase())) {
				for (Song s : a.getSongs()) {
					foundSongs.add(s);
				}
			}
		}

		return foundSongs;
	}
	
	/*
	 * Method: searchAlbumTitle(albumName)
	 * Purpose: search for an album by name and print its contents
	 */
	public ArrayList<Album> searchAlbumTitle(String albumName) {
		
		ArrayList<Album> foundAlbums = new ArrayList<Album>();
		for (Album a : albumList) {
			if (a.getName().toLowerCase().equals(albumName.toLowerCase())) {
				foundAlbums.add(a);
			}
		}
		
		return foundAlbums;
	}
	
	/*
	 * Method: searchAlbumArtist(artistName)
	 * Purpose: search for an album by artist and print its contents
	 */
	public ArrayList<Album> searchAlbumArtist(String artistName) {
		
		ArrayList<Album> foundAlbums = new ArrayList<Album>();
		for (Album a : albumList) {
			if (a.getArtist().toLowerCase().equals(artistName.toLowerCase())) {
				foundAlbums.add(a);
			}
		}
		
		return foundAlbums;
	}
	
	/*
	 * Method: hasAlbum(title)
	 * Purpose: check if an album with name title is found
	 * in the albumList
	 */
	private boolean hasAlbum(String title) {
		
		for (Album a : albumList) {
			if (a.getName().toLowerCase().equals(title.toLowerCase())) {
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
			if (s.getName().toLowerCase().equals(title.toLowerCase())) {
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
	public boolean addSong(String title) {
		
		Song foundSong = store.searchSong(title);
		
		if (foundSong == null) {
			return false;
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
					return true;
				} 
			}
		}
		
		return false;
	}
	
	/*
	 * Method: addAlbum(title)
	 * Purpose: add an entire album to the user's library, if its in the store
	 * and not already in the user's library
	 */
	public boolean addAlbum(String title) {
		
		Album foundAlbum = store.searchAlbum(title);
		
		if (foundAlbum == null) {
			return false;
		}
		
		if (!hasAlbum(title)) {
			
			Album newAlbum = new Album(/* TODO: album constructor*/);
			albumList.add(newAlbum);
			
			for (Song s : foundAlbum.getSongs()) {
				newAlbum.addSong(s);
			}
			
			return true;
		} 
		
		return false;
	}
	
	/*
	 * Method: getSongTitles()
	 * Purpose: print to the user a list of song titles
	 */
	public ArrayList<String> getSongTitles() {

		ArrayList<String> songs = new ArrayList<String>();
		
		for (Album a : albumList) {
			for (Song s : a.getSongs()) {
				songs.add(s.getName());
			}
		}
		
		return songs;
	}
	
	/*
	 * Method: getArtists()
	 * Purpose: print to the user a list of artists
	 */
	public ArrayList<String> getArtists() {
		ArrayList<String> printedArtists = new ArrayList<String>();
		
		for (Album a : albumList) {
			if (!printedArtists.contains(a.getArtist())) {
				printedArtists.add(a.getArtist());
			}
		}
		
		return printedArtists;
	}
	
	/*
	 * Method: getAlbums()
	 * Purpose: print to the user a list of albums
	 */
	public ArrayList<Album> getAlbums() {
		
		ArrayList<Album> albumList = new ArrayList<Album>();

		for (Album a : albumList) {
			albumList.add(new Album(/*TODO: ALBUM CONSTRUCTOR*/))
		}
		
		return albumList;
	}
	
	/*
	 * Method: getPlaylists()
	 * Purpose: print to the user their list of playlists
	 */
	public ArrayList<String> getPlaylists() {
		
		ArrayList<String> playlistNames = new ArrayList<String>();
		
		for (Playlist p : playlists) {
			playlistNames.add(p.getName());
		}
		
		return playlistNames;
	}
	
	/*
	 * Method: getSongsInPlaylist(title)
	 * Purpose: print out the songs in a playlist
	 */
	public ArrayList<String> getSongsInPlaylist(String title) {
		
		ArrayList<String> songs = new ArrayList<String>();
		
		for (Playlist p : playlists) {
			if (p.getName().toLowerCase().equals(title.toLowerCase())) {
				for (Song s : p.getSongs()) {
					songs.add(s.getName());
				}
			}
		}
		
		return songs;
	}
	
	/*
	 * Method: getFavoriteSongs()
	 * Purpose: print out the users favorite songs
	 */
	public ArrayList<String> getFavoriteSongs() {
		
		ArrayList<String> favSongs = new ArrayList<String>();
		
		for (Album a : albumList) {
			for (Song s : a.getSongs()) {
				if (s.isFavorite()) {
					favSongs.add(s.getName());
				}
			}
		}
		
		return favSongs;
	}
	
	/*
	 * Method: createPlaylist(name)
	 * Purpose: creates a new playlist with name
	 */
	public boolean createPlaylist(String name) {
		
		for (Playlist p : playlists) {
			if (p.getName().toLowerCase().equals(name.toLowerCase())) {
				return false;
			}
		}
		
		playlists.add(new Playlist(name));
		return true;
	}
	
	/*
	 * Method: removePlaylist(name)
	 * Purpose: removes a playlist with name
	 */
	public boolean removePlaylist(String name) {
		for (Playlist p : playlists) {
			if (p.getName().toLowerCase().equals(name.toLowerCase())) {
				playlists.remove(p);
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Method: rateSong
	 * Purpose: search for a song by title and artist and assign it a rating
	 */
	public boolean rateSong(String songName, String artist, int rating) {
		
		ArrayList<Song> songsWithName = this.searchSongTitle(songName);
		
		for (Song s : songsWithName) {
			if (s.getArtist().toLowerCase().equals(artist.toLowerCase())) {
				s.setRating(rating);
				return true;
			}
		}
		
		return false;
	}
	
	/*
	 * Method: setFavorite()
	 * Purpose: search for a song by title and artist and set to favorite or unfavorite
	 */
	public boolean setFavorite(String songName, String artist, boolean favorite) {
		
		ArrayList<Song> songsWithName = this.searchSongTitle(songName);
		
		for (Song s : songsWithName) {
			if (s.getArtist().toLowerCase().equals(artist.toLowerCase())) {
				s.setFavorite(favorite);
				return true;
			}
		}
		
		return false;
	}
}
