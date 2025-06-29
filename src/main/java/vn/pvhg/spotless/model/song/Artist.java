package vn.pvhg.spotless.model.song;

import jakarta.persistence.*;
import lombok.*;
import vn.pvhg.spotless.model.BaseModel;
import vn.pvhg.spotless.model.Image;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "artists")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Artist extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String fullName;

    @ManyToMany
    @JoinTable(
            name = "artist_images",
            joinColumns = @JoinColumn(name = "artist_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id")
    )
    private Set<Image> images = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "artist_songs",
            joinColumns = @JoinColumn(name = "artist_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    private Set<Song> songs = new HashSet<>();
}
