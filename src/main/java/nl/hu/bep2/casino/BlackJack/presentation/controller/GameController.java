package nl.hu.bep2.casino.BlackJack.presentation.controller;

import nl.hu.bep2.casino.BlackJack.Domain.Rules;
import nl.hu.bep2.casino.BlackJack.application.GameService;
import nl.hu.bep2.casino.BlackJack.Domain.GameProgress;
import nl.hu.bep2.casino.BlackJack.presentation.dto.NewGameDTO;
import nl.hu.bep2.casino.security.data.UserProfile;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/blackjack/games")
public class GameController {
    private final GameService service;

    public GameController(GameService service) {
        this.service = service;
    }

    @PostMapping()
    public GameProgress newGame(Authentication authentication,
                                @RequestBody @Valid NewGameDTO request,
                                @RequestParam int numberOfDecks,
                                @RequestParam String tenplus,
                                @RequestParam String jokers,
                                @RequestParam int wincondition) {
        UserProfile profile = (UserProfile) authentication.getPrincipal();
        String username = profile.getUsername();

        boolean tenPluss;
        boolean jokerss;

        tenPluss = tenplus.equals("yes") || tenplus.equals("Yes");
        jokerss  = jokers.equals("yes")  || jokers.equals("Yes");

        GameProgress progress;

        Rules rules = new Rules(numberOfDecks, tenPluss, jokerss, wincondition);

        try {
            progress = service.startGame(username, request.bet, rules);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return progress;

    }


    @PostMapping("/{id}/hit")
    public GameProgress hit(Authentication authentication, @PathVariable Long id){
        UserProfile profile = (UserProfile) authentication.getPrincipal();
        String username = profile.getUsername();

        GameProgress progress;

        try {
            progress = service.hit(username, id);
        }catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return progress;
    }

    @PostMapping("/{id}/stand")
    public GameProgress stand(Authentication authentication, @PathVariable Long id){
        UserProfile profile = (UserProfile) authentication.getPrincipal();
        String username = profile.getUsername();

        GameProgress progress;

        try {
            progress = service.stand(username, id);
        }catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return progress;
    }

}
