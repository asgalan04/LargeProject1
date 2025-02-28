package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MusicStore {
	private ArrayList<Album> albums;
	
	
	public MusicStore() {
		albums=new ArrayList<Album>();
		ArrayList<File> curr=new ArrayList<File>();
		try {
			curr=processAlbums("src/albumFiles/albums.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (File file: curr) {
			try {
				readAlbumFile(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
			
	}
	
	public Song searchSong(String songName) {
		for(Album songs: albums) {
			if(songs.getSong(songName)!=null) {
				return songs.getSong(songName);
			}
		}
		return null;
	}

	public ArrayList<Album> getAlbums(){
		ArrayList<Album> deepCopy=new ArrayList<Album>();
		for(Album album: albums) {
			Album current=new Album(album.getAuthorName(),album.getAlbumName(),
					album.getYear(),album.getGenre());
			for(Song s: album.getSongs()) {
				current.addSong(s);
			}
			deepCopy.add(current);
			
		}
		return deepCopy;
	}
	
	//new object 
	public Album searchAlbum(String albumName) {
		for (Album album: albums) {
			if(album.getAlbumName().toLowerCase().equals(albumName.toLowerCase())) {
				Album current=new Album(album.getAuthorName(),album.getAlbumName(),
						album.getYear(),album.getGenre());
				for(Song s: album.getSongs()) {
					current.addSong(s);
					
				}
				return current;
			}
		}
		return null;
		
	}
	
	public void readAlbumFile(File fileName) throws FileNotFoundException {
		Scanner scan=new Scanner(fileName);
		String [] attributes= scan.nextLine().split(",");
		String albumTitle=attributes[0];
		String Artist=attributes[1]; 
		String genre=attributes[2];
		int year=Integer.parseInt(attributes[3]);
		Album current=new Album(Artist,albumTitle,year,genre);
		while(scan.hasNextLine()) {
			current.addSong(new Song(scan.nextLine().trim(),Artist,albumTitle));
		}
		
		albums.add(current);
		
		
	}
	
	public ArrayList<File> processAlbums(String fileName) throws FileNotFoundException {
		ArrayList<File> fileNames=new ArrayList<File>();
		File file=new File(fileName);
		Scanner scan=new Scanner(file);
		while(scan.hasNextLine()) {
			String[] names=scan.nextLine().split(",");
			fileNames.add(new File("src/albumFiles/"+names[0]+"_"+names[1]+".txt"));
		}
		return fileNames;
		
		
	}
	
}
