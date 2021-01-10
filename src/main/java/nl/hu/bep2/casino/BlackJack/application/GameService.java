package nl.hu.bep2.casino.BlackJack.application;

import nl.hu.bep2.casino.BlackJack.Domain.Game;
import nl.hu.bep2.casino.BlackJack.Domain.GameEntity;
import nl.hu.bep2.casino.BlackJack.Domain.GameProgress;
import nl.hu.bep2.casino.BlackJack.Domain.Rules;
import nl.hu.bep2.casino.BlackJack.data.SpringGameRepository;
import nl.hu.bep2.casino.BlackJack.Domain.participant.Player;
import nl.hu.bep2.casino.chips.application.ChipsService;
import nl.hu.bep2.casino.security.application.UserService;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private final SpringGameRepository gameRepository;
    private final UserService userService;
    private final ChipsService chipsService;

    public GameService(SpringGameRepository gameRep, UserService userService, ChipsService chipsService) {
        this.gameRepository = gameRep;
        this.userService    = userService;
        this.chipsService   = chipsService;
    }

    public GameProgress startGame(String username, Long bet, Rules rules) {
        var user= userService.loadUserByUsername(username);
        var gameRules = new Rules(rules.getAmount(),rules.isTenPlus(), rules.areJokersAvailable(), rules.getWincondition());
        var game  = new Game(bet, username, new Player(user.getUsername(), user.getFirstName()), gameRules);

        chipsService.withdrawChips(username, bet);
        var progress = game.start();

        gameRepository.save(new GameEntity(user, game));

        return progress;
    }

    public GameProgress hit(String username, Long id) {
        GameProgress progress;

        if (isGameExisting(id)) {
            //noinspection OptionalGetWithoutIsPresent
            var game = gameRepository.findById(id).get().getGame();
            var user = userService.loadUserByUsername(username);

            progress = game.hit();

            gameRepository.save(new GameEntity(user, game));

            return progress;
        }
        return null;
    }

    public GameProgress stand(String username, Long id) {
        GameProgress progress;

        if (isGameExisting(id)) {
            //noinspection OptionalGetWithoutIsPresent
            var game = gameRepository.findById(id).get().getGame();
            var user = userService.loadUserByUsername(username);

            progress = game.stand();


            gameRepository.save(new GameEntity(user, game));

            return progress;
        }
        return null;
    }

    private boolean isGameExisting(Long id) {
        return gameRepository.findById(id).isPresent();
    }
}
