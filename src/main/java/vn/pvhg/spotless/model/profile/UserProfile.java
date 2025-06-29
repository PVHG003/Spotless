package vn.pvhg.spotless.model.profile;

import jakarta.persistence.*;
import lombok.*;
import vn.pvhg.spotless.model.BaseModel;
import vn.pvhg.spotless.model.Image;
import vn.pvhg.spotless.model.authentication.User;
import vn.pvhg.spotless.model.playlist.Playlist;
import vn.pvhg.spotless.model.song.Song;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "user_profile")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfile extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String username;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "user_images",
            joinColumns = @JoinColumn(name = "regular_user_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id")
    )
    private Set<Image> images = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "user_favorite_songs",
            joinColumns = @JoinColumn(name = "regular_user_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    private Set<Song> favoriteSongs = new HashSet<>();

    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Playlist> playlists = new HashSet<>();
}
