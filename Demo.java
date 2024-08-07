import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tạo các bài hát ví dụ
        List<Song> songs = new ArrayList<>();
        songs.add(new RockSong("Rock Anthem", "/path/to/rock.mp3", 210, "Rock Artist", "Epic Solo"));
        songs.add(new EDMSong("EDM Hit", "/path/to/edm.mp3", 190, "EDM Artist", "128 BPM"));
        //songs.add(new RelaxSong("Calm Waves", "/path/to/relax.mp3", 300, "Relax Artist", "Peaceful", "Piano"));

        // Tạo playlist
        Playlist playlist = new Playlist("My Playlist");
        for (Song song : songs) {
            playlist.addSong(song);
        }

        // Tạo MusicPlayer
        MusicPlayer player = new MusicPlayer();
        player.setCurrentPlaylist(playlist);

        while (true) {
            // Hiển thị menu
            System.out.println("\nMusic Player Menu:");
            System.out.println("1. Play a song");
            System.out.println("2. Next song");
            System.out.println("3. Set volume");
            System.out.println("4. Toggle repeat");
            System.out.println("5. Display playlist info");
            System.out.println("6. Search for a song");
            System.out.println("7. Show song count and list");
            System.out.println("8. Show album and artist info");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự newline

            switch (choice) {
                case 1: // Play a song
                    System.out.print("Enter the title of the song to play: ");
                    String titleToPlay = scanner.nextLine();
                    Song songToPlay = player.searchSong(titleToPlay);
                    if (songToPlay != null) {
                        player.playSong(songToPlay);
                    } else {
                        System.out.println("Song not found.");
                    }
                    break;

                case 2: // Next song
                    player.nextSong();
                    break;

                case 3: // Set volume
                    System.out.print("Enter the volume (0-100): ");
                    int volume = scanner.nextInt();
                    player.setVolume(volume);
                    break;

                case 4: // Toggle repeat
                    player.toggleRepeat();
                    break;

                case 5: // Display playlist info
                    player.displayPlaylistInfo();
                    break;

                case 6: // Search for a song
                    System.out.print("Enter the title of the song to search: ");
                    String titleToSearch = scanner.nextLine();
                    Song foundSong = player.searchSong(titleToSearch);
                    if (foundSong != null) {
                        System.out.println(foundSong.getDescription());
                    } else {
                        System.out.println("Song not found.");
                    }
                    break;

                case 7: // Show song count and list
                    if (player.getCurrentPlaylist() != null) {
                        List<Song> playlistSongs = player.getCurrentPlaylist().getSongs();
                        System.out.println("Number of songs in the playlist: " + playlistSongs.size());
                        System.out.println("List of songs:");
                        for (Song song : playlistSongs) {
                            System.out.println(song.getDescription());
                        }
                    } else {
                        System.out.println("No playlist is currently set.");
                    }
                    break;

                case 8: // Show album and artist info
                    System.out.println("1. Display album info");
                    System.out.println("2. Display artist info");
                    System.out.print("Choose an option: ");
                    int subChoice = scanner.nextInt();
                    scanner.nextLine(); // Đọc ký tự newline

                    if (subChoice == 1) {
                        System.out.print("Enter the album title: ");
                        String albumTitle = scanner.nextLine();
                        player.displayAlbumInfo(albumTitle);
                    } else if (subChoice == 2) {
                        System.out.print("Enter the artist name: ");
                        String artistName = scanner.nextLine();
                        player.displayArtistInfo(artistName);
                    } else {
                        System.out.println("Invalid option.");
                    }
                    break;

                case 9: // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
