package nl.hu.bep2.casino.BlackJack.presentation.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class NewGameDTO {
    @NotNull
    @Min(1)
    public Long bet;

}
