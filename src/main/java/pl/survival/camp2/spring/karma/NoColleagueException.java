package pl.survival.camp2.spring.karma;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoColleagueException extends RuntimeException {
    public NoColleagueException(long id) {
        super("Colleague "+ id+" does not exist");
    }
}
