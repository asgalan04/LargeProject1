package Library;

public class Song {
	private String songName;
	private String authorName;
	private String album;
	private int rating;
	private boolean favorite;

	public Song(String songName,String authorName,String album) {
		this.album=album;
		this.authorName=authorName;
		this.songName = songName;
		this.rating = 0;
		this.favorite=false;
	}
	


	public void setFavorite(boolean value) {
		this.favorite = value;
		

	}
	
	public void setRating(int value) {
		if(value==5) {
			favorite=true;
		}
		rating=value;
		
		
	}
	public boolean isFavorite() {
		return favorite;
	}

	public int getRating() {
		return rating;
	}

	public String getName() {
		return songName;

	}
	public String getAlbum() {
		return album;
	}
	
	public String getAuthor() {
		return authorName;
	}

	public String toString() {
		return "Song name: "+songName+ "Author: "+authorName+"album name "+ album;

	}



	

}
