package pl.survival.camp2.spring.karma;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/karma")
public class KarmaController {

    private List<String> users = new CopyOnWriteArrayList<>();

    {
        this.users.addAll(Arrays.asList("Irek", "Krzybiu", "Stefek"));
    }


    @RequestMapping(value = "/users",
           method = RequestMethod.GET
    )
    public List<String> getUsers() {
        return this.users;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public int addUser(@RequestBody String name) {
        this.users.add(name);
        return this.users.size();
    }
}
