
    public class RockSong extends Song {
        private String guitarSolo; // Thuộc tính riêng cho bài hát Rock
    
        public RockSong(String title, String filePath, int duration, String artist, String guitarSolo) {
            super(title, filePath, duration, artist);
            this.guitarSolo = guitarSolo;
        }
    
        public String getGuitarSolo() {
            return guitarSolo;
        }
    
        @Override
        public String getDescription() {
            return "Rock Song [Title: " + getTitle() + ", Artist: " + getArtist() +
                   ", File: " + getFilePath() + ", Duration: " + getDuration() +
                   " seconds, Guitar Solo: " + guitarSolo + "]";
        }
    }
    

