package nl.hu.bep2.casino.BlackJack.application;

import nl.hu.bep2.casino.BlackJack.Domain.GameState;
import nl.hu.bep2.casino.security.data.User;

public class Result {
    private final GameState state;
    private final User user;

    public Result(GameState state, User user) {
        this.state = state;
        this.user = user;
    }

    public GameState getStatus() {
        return state;
    }

    public User getUser() {
        return user;
    }
}
