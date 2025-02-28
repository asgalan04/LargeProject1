package view;

import java.util.ArrayList;
import model.Song;
import model.Album;
import model.LibraryModel;

public class UserInterface {
	
	LibraryModel userLib;
	
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
	 * Method: searchSongTitle(title)
	 * Purpose: communicate with library to search for a song and print it.
	 */
	private void searchSongTitle(String title) {
		
		ArrayList<Song> foundSongs = userLib.searchSongTitle(title);
		
		if (foundSongs.size() == 0) {
			System.out.println("Song not found in user's library.");
			return;
		}
		
		printSongs(foundSongs);
	}
	
	/*
	 * Method: searchSongArtist(artist)
	 * Purpose: communicate with library to search for a song and print it.
	 */
	private void searchSongArtist(String artist) {
		
		ArrayList<Song> foundSongs = userLib.searchSongArtist(artist);
		
		if (foundSongs.size() == 0) {
			System.out.println("Artist not found in user's library.");
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
	 * Method: searchAlbumTitle(title)
	 * Purpose: communicate with library to find a album by title and print its output
	 */
	private void searchAlbumTitle(String title) {
		
		ArrayList<Album> foundAlbums = userLib.searchAlbumTitle(title);
		
		if (foundAlbums.size() == 0) {
			System.out.println("Album not found in player's library.");
			return;
		}
		
		printAlbums(foundAlbums);
	}
	
	/*
	 * Method: searchAlbumTitle(title)
	 * Purpose: communicate with library to find a album by title and print its output
	 */
	private void searchAlbumArtist(String artist) {
		
		ArrayList<Album> foundAlbums = userLib.searchAlbumArtist(artist);
		
		if (foundAlbums.size() == 0) {
			System.out.println("Album not found in player's library.");
			return;
		}
		
		printAlbums(foundAlbums);
	}
	
	/*
	 * Method: addSongToLibrary(title)
	 * Purpose: add a song to the users library
	 */
	private void addSongToLibrary(String title) {
		if (userLib.addSong(title)) {
			System.out.println(title + " successfully added.");
		} else {
			System.out.println("Unable to add song. Either not in store or already in user library.");
		}
	}
	
	/*
	 * Method: addAlbumToLibrary(title)
	 * Purpose: add an album to the user's library
	 */
	private void addAlbumToLibrary(String title) {
		if (userLib.addAlbum(title)) {
			System.out.println(title + " successfully added.");
		} else {
			System.out.println("Unable to add album. Either not in store or already in user library.");
		}
	}
	
	/*
	 * Method: printSongs()
	 * Purpose: print all the songs in the user library
	 */
	private void printSongs() {
		
		ArrayList<String> songs = userLib.getSongTitles();
		
		if (songs.size() == 0) {
			System.out.print("No songs in library.");
			return;
		}
		
		System.out.println("-----------------\n      Songs\n-----------------");
		
		for (String s : songs) {
			System.out.println(s);
		}
		
		System.out.println("-----------------");
	}
	
	/*
	 * Method: printArtists()
	 * Purpose: print all the artists in the user library
	 */
	private void printArtists() {
		
		ArrayList<String> artists = userLib.getArtists();
		
		if (artists.size() == 0) {
			System.out.print("No artists in library.");
			return;
		}
		
		System.out.println("-----------------\n     Artists\n-----------------");
		
		for (String artist : artists) {
			System.out.println(artist);
		}
		
		System.out.println("-----------------");
	}
	
	/*
	 * Method: printAlbums()
	 * Purpose: print all the albums in the user library
	 */
	private void printAlbums() {
		
		ArrayList<Album> albums = userLib.getAlbums();
		
		if (albums.size() == 0) {
			System.out.print("No albums in library.");
			return;
		}
		
		System.out.println("------------------\n      Albums\n------------------");
		
		for (Album a : albums) {
			System.out.println(a.getName() + " by " + a.getArtist());
		}
		
		System.out.println("------------------");
	}
	
	/*
	 * Method: printPlaylists
	 * Purpose: print the users playlists
	 */
	private void printPlaylists() {
		
		ArrayList<String> playlists = userLib.getPlaylists();
		
		if (playlists.size() == 0) {
			System.out.println("No playlists in library.");
			return;
		}
		
		System.out.println("-----------------\n    Playlists\n-----------------");
		
		for (String name : playlists) {
			System.out.println(name);
		}
		
		System.out.println("-----------------");
	}
	
	/*
	 * Method: printSongsInPlaylist(title)
	 * Purpose: print the songs in a playlist
	 */
	private void printSongsInPlaylist(String title) {
		
		ArrayList<String> songs = userLib.getSongsInPlaylist(title);
		
		if (songs.size() == 0) {
			System.out.println("Playlist isn't in library or doesn't have any songs.");
			return;
		}
		
		System.out.println("-----------------\n Songs in " + title + "\n-----------------");
		
		for (String song : songs) {
			System.out.println(song);
		}
		
		System.out.println("-----------------");
	}
	
	/*
	 * Method: printFavoriteSongs()
	 * Purpose: print all the user's favorited songs
	 */
	private void printFavoriteSongs() {
		
		ArrayList<String> favSongs = userLib.getFavoriteSongs();
		
		if (favSongs.size() == 0) {
			System.out.print("No favorite songs found.");
			return;
		}
		
		System.out.println("------------------\n  Favorite Songs\n------------------");
		
		for (String song : favSongs) {
			System.out.println(song);
		}
		
		System.out.println("------------------");
	}
	
	/*
	 * Method: rateSong
	 * Purpose: rate a song with songName and artist
	 */
	private void rateSong(String songName, String artist, int rating) {
		
		if (userLib.rateSong(songName, artist, rating)) {
			System.out.println(songName + " has been rated " + rating);
		} else {
			System.out.println("Unable to rate song. Not found in library.");
		}
		
	}
	
	/*
	 * Method: setFavorite
	 * Purpose: favorite or unfavorite a song with songName and artist
	 */
	private void setFavorite(String songName, String artist, boolean favorite) {
		
		if (userLib.setFavorite(songName, artist, favorite)) {
			if (favorite) {
				System.out.println("Song favorited.");
			} else {
				System.out.println("Song unfavorited.");
			}
		} else {
			System.out.println("Unable to find song.");
		}
		
	}
	
	/*
	 * Method addPlaylist(name)
	 * Purpose: add a new playlist to library
	 */
	private void addPlaylist(String name) {
		if (userLib.createPlaylist(name)) {
			System.out.println("Playlist successfully created.");
		} else {
			System.out.println("Playlist with name " + name + " already exists in library.");
		}
	}
	
	private void removePlaylist(String name) {
		if (userLib.removePlaylist(name)) {
			System.out.println("Playlist successfully removed.");
		} else {
			System.out.println("Unable to find playlist.");
		}
	}
	
	private void printManual() {
		System.out.println("------------------------");
		System.out.println("   List of commands");
		System.out.println("------------------------");
		System.out.println("SEARCHING");
		System.out.println("  'findSongTitle <title>' - prints information about a song with name 'title'.");
		System.out.println("  'findSongArtist <artistName>' - prints information about a song with artist 'artistName'.");
		System.out.println("  'findAlbumTitle <title>' - prints information about a album with name 'title'.");
		System.out.println("  'findAlbumArtist <artistName>' - prints information about a album with artist 'artistName'.\n");
		System.out.println("ADDING/REMOVING");
		System.out.println("  'addSong <title>' - adds a song with name 'title' to user library if it is in the store.");
		System.out.println("  'addAlbum <title>' - adds a album with name 'title' and its songs to user library if it is in the store.");
		System.out.println("  'addPlaylist <name>' - adds a new playlist with name 'name' to user library.");
		System.out.println("  'removePlaylist <name>' - removes a playlist with name 'name' from user library.\n");
		System.out.println("LISTING");
		System.out.println("  'printSongs' - prints all songs in user library.");
		System.out.println("  'printAlbums' - prints all albums in user library.");
		System.out.println("  'printPlaylists' - prints all playlist names in user library.");
		System.out.println("  'printPlaylist <playlistName>' - prints all songs in playlist 'playlistName'.");
		System.out.println("  'printFavorites' - prints all favorited songs in user library.\n");
		System.out.println("RATING");
		System.out.println("  'favoriteSong <songName> <songArtist> <favorite/unfavorite>' - favorites/unfavorites a song with name 'songName' and 'songArtist'.");
		System.out.println("  'rateSong <songName> <songArtist> <rating (1-5)>' - rates a song (1-5) with name 'songName' and 'songArtist'.");
		System.out.println("------------------------");
	}
	
	private void inputHandler() {
		
	}
	
	public static void main(String[] args) {
		
		UserInterface ui = new UserInterface();
		
	}
}
