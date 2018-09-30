package pl.survival.camp2.spring.karma;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
