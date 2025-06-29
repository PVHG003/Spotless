package vn.pvhg.spotless.model.profile;

import jakarta.persistence.*;
import lombok.*;
import vn.pvhg.spotless.model.BaseModel;
import vn.pvhg.spotless.model.authentication.User;

import java.util.UUID;

@Entity
@Table(name = "superuser_profile")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SuperuserProfile extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String username;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
