package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		MusicStore store=new MusicStore();
		Album search=store.searchAlbum("19");
		System.out.print(search.toString());
		
		
		
		
	
	}


}