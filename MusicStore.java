package Library;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MusicStore {
	private ArrayList<Album> albums;
	
	
	public MusicStore() {
		albums=new ArrayList<Album>();
	}
	
	public Song searchSong(String songName) {
		for(Album a: albums) {
			if(a.getSong(songName)!=null) {
				return a.getSong(songName);
			}
		}
		return null;
	}
	
	public ArrayList<Album> getAlbums(){
		return new ArrayList<Album>(albums);
	}
	public Album searchAlbum(String album) {
		for (Album a: albums) {
			if(a.getAlbumName().equals(album)) {
				return a;
			}
		}
		return null;
		
	}
	
	public void readAlbumFile(File fileName) throws FileNotFoundException {
		
		Scanner scan=new Scanner(fileName);
		String [] attributes= scan.nextLine().split(",");
		String albumTitle=attributes[0];
		String Artist=attributes[1]; 
		Album current=new Album(Artist,albumTitle);
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
			fileNames.add(new File(names[0]+"_"+names[1]+".txt"));
		}
		return fileNames;
		
		
	}
	
}
