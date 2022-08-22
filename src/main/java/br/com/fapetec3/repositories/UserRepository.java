package br.com.fapetec3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fapetec3.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.id > :id")
    public List<User> findAllMoreThan(@Param("id") Long id);

    public List<User> findByIdGreaterThan(Long id);
    
}
