package Library;

public class Song {
	private String songName;
	private String authorName;
	private String album;
	private int rating;

	public Song(String songName,String authorName,String album) {
		this.album=album;
		this.authorName=authorName;
		this.songName = songName;
		this.rating = 0;
	}

	public void setFavorite() {
		this.rating = 5;

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

	public String toString() {
		return "Song name: "+songName+ "Author: "+authorName+"album name "+ album;

	}

}
