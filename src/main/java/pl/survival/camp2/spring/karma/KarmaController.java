package pl.survival.camp2.spring.karma;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/karma")
public class KarmaController {

    private final ColleagueService service;

    public KarmaController(ColleagueService service) {
        this.service = service;
    }

    @RequestMapping(value = "/colleagues",
           method = RequestMethod.GET,
           produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public List<Colleague> getUsers() {
        return this.service.getColleagues().asJava();
    }

    @RequestMapping(value = "/colleagues", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public Colleague addUser(@RequestBody NewColleague colleague) {
        return this.service.addColleague(colleague);
    }

    @RequestMapping(value = "/colleagues/{id}/phone/{phone}", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public Colleague setPhone(@PathVariable("id") long id, @PathVariable("phone") String phone) {
        return this.service.changePhone(id, phone).orElseThrow(
                () -> new NoColleagueException( id)
        );
    }

    @RequestMapping(value = "/colleagues/{id}/scores", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public int addScore(@PathVariable("id") long id, @RequestBody Score score) {
       return this.service.addScore(id, score)
               .orElseThrow(
                       () -> new NoColleagueException( id)
            );
    }
}
