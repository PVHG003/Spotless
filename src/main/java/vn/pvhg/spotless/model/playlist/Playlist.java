package vn.pvhg.spotless.model.playlist;

import jakarta.persistence.*;
import lombok.*;
import vn.pvhg.spotless.model.BaseModel;
import vn.pvhg.spotless.model.profile.UserProfile;
import vn.pvhg.spotless.model.song.Song;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(
        name = "playlists",
        uniqueConstraints = @UniqueConstraint(columnNames = {"name", "user_profile_id"}))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Playlist extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "playlist_songs",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"playlist_id", "song_id"})
    )
    private Set<Song> songs = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "user_profile_id")
    private UserProfile userProfile;
}
