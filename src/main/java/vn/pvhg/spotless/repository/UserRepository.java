package vn.pvhg.spotless.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.pvhg.spotless.model.authentication.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);

    @Query("""
            SELECT DISTINCT u FROM User u
            JOIN FETCH u.role r
            JOIN r.permissions p
            WHERE u.email = :email
            """)
    Optional<User> findByEmailWithRoleAndPermissions(@Param("email") String email);

    boolean existsByEmail(String email);
}
