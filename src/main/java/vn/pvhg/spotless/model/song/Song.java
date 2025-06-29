package vn.pvhg.spotless.model.song;

import jakarta.persistence.*;
import lombok.*;
import vn.pvhg.spotless.model.BaseModel;
import vn.pvhg.spotless.model.Image;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "songs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Song extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;

    private long durationMs;

    private LocalDate releaseDate;

    private long listenCount = 0;

    private String audioUrl;

    @ManyToMany
    @JoinTable(
            name = "song_images",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id")
    )
    private Set<Image> images = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "song_genres",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres = new HashSet<>();

    @ManyToMany(mappedBy = "songs")
    private Set<Artist> artists = new HashSet<>();
}
