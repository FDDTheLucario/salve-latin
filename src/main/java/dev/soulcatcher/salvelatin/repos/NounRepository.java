package dev.soulcatcher.salvelatin.repos;

import dev.soulcatcher.salvelatin.models.Noun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NounRepository extends JpaRepository<Noun, UUID> {

}
