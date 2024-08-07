import java.util.HashMap;
import java.util.Map;

public class MusicPlayer {
    private Playlist currentPlaylist;
    private Map<String, Album> albums;
    private Map<String, Artist> artists;
    private int volume;
    private boolean isRepeating;
    private int currentSongIndex;

    public MusicPlayer() {
        this.currentPlaylist = null;
        this.albums = new HashMap<>();
        this.artists = new HashMap<>();
        this.volume = 50;  // Âm lượng mặc định là 50%
        this.isRepeating = false;
        this.currentSongIndex = -1;  // Chưa có bài hát nào được phát
    }

    // Thêm album
    public void addAlbum(Album album) {
        albums.put(album.getTitle(), album);
        if (!artists.containsKey(album.getArtist().getName())) {
            artists.put(album.getArtist().getName(), album.getArtist());
        }
    }

    // Thêm nghệ sĩ
    public void addArtist(Artist artist) {
        artists.put(artist.getName(), artist);
    }

    // Thiết lập playlist hiện tại
    public void setCurrentPlaylist(Playlist playlist) {
        this.currentPlaylist = playlist;
        this.currentSongIndex = 0;  // Bắt đầu phát từ bài hát đầu tiên khi playlist được thiết lập
    }

    // Thay đổi âm lượng
    public void setVolume(int volume) {
        if (volume < 0) {
            this.volume = 0;
        } else if (volume > 100) {
            this.volume = 100;
        } else {
            this.volume = volume;
        }
        System.out.println("Volume set to: " + this.volume + "%");
    }

    // Bật/tắt chức năng lập lại
    public void toggleRepeat() {
        this.isRepeating = !this.isRepeating;
        System.out.println("Repeat mode: " + (this.isRepeating ? "ON" : "OFF"));
    }

    // Phát bài hát
    public void playSong(Song song) {
        
        System.out.println("Now playing: " + song.getDescription() + " from file: " + song.getFilePath() +
                           " at volume: " + volume + "%");
    }

    // Chuyển đến bài hát kế tiếp
    public void nextSong() {
        if (currentPlaylist == null || currentPlaylist.getSongs().isEmpty()) {
            System.out.println("No songs in playlist.");
            return;
        }

        if (currentSongIndex >= 0) {
            currentSongIndex++;
            if (currentSongIndex >= currentPlaylist.getSongs().size()) {
                if (isRepeating) {
                    currentSongIndex = 0;  // Lặp lại từ đầu playlist
                } else {
                    System.out.println("End of playlist.");
                    return;
                }
            }
        } else {
            currentSongIndex = 0;  // Bắt đầu từ bài hát đầu tiên nếu chưa có bài nào được phát
        }

        Song nextSong = currentPlaylist.getSongs().get(currentSongIndex);
        playSong(nextSong);
    }

    // Hiển thị thông tin về album
    public void displayAlbumInfo(String albumTitle) {
        Album album = albums.get(albumTitle);
        if (album != null) {
            System.out.println(album);
        } else {
            System.out.println("Album not found.");
        }
    }

    // Hiển thị thông tin về nghệ sĩ
    public void displayArtistInfo(String artistName) {
        Artist artist = artists.get(artistName);
        if (artist != null) {
            System.out.println(artist);
        } else {
            System.out.println("Artist not found.");
        }
    }

    // Hiển thị thông tin về playlist
    public void displayPlaylistInfo() {
        if (currentPlaylist != null) {
            System.out.println(currentPlaylist);
        } else {
            System.out.println("No playlist is currently set.");
        }
    }

    // Tìm bài hát theo tiêu đề từ playlist hiện tại
    public Song searchSong(String title) {
        if (currentPlaylist != null) {
            for (Song song : currentPlaylist.getSongs()) {
                if (song.getTitle().equalsIgnoreCase(title)) {
                    return song;
                }
            }
        }
        return null;
    }

    public Playlist getCurrentPlaylist() {
        return currentPlaylist;
    }
}
    

