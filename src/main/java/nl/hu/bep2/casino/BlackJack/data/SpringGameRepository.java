package nl.hu.bep2.casino.BlackJack.data;

import nl.hu.bep2.casino.BlackJack.Domain.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringGameRepository extends JpaRepository<GameEntity, Long> {
    Optional<GameEntity> findById(Long aLong);
}
