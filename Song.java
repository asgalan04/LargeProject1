package Library;

public class Song {
	private String songName;
	private int rating;

	public Song(String songName) {
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

	public String toString() {
		return songName;

	}

}
