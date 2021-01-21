package nl.hu.bep2.casino.BlackJack.Domain;

import nl.hu.bep2.casino.security.data.User;

import javax.persistence.*;

@Entity
@Table(name = "game")
public class GameEntity {
    @Id
    private Long id;

    @ManyToOne
    @MapsId
    private User user;

    @Lob
    private Game game;

    public GameEntity() {
    }

    public GameEntity(User user, Game game) {
        this.user = user;
        this.game = game;
    }

    public User getUser() {
        return user;
    }

    public Game getGame() {
        return game;
    }
}
