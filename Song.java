public abstract class Song {
    private String title;
    private String filePath;
    private int duration;  // Thời gian bài hát tính bằng giây
    private String artist; // Tên nghệ sĩ

    public Song(String title, String filePath, int duration, String artist) {
        this.title = title;
        this.filePath = filePath;
        this.duration = duration;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getFilePath() {
        return filePath;
    }

    public int getDuration() {
        return duration;
    }

    public String getArtist() {
        return artist;
    }

    // Phương thức abstract mà các lớp con phải triển khai
    public abstract String getDescription();

    @Override
    public String toString() {
        return getDescription();
    }
}