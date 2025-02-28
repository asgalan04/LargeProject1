package Library;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		MusicStore store=new MusicStore();
		ArrayList<File> curr=new ArrayList<File>();
		curr=store.processAlbums("albums.txt");
		store.readAlbumFile(curr.get(2));
		for(Album r: store.getAlbums()) {
			System.out.print(r.toString());
			
		}
		
		
	
	}

}
