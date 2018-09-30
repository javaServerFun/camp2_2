package pl.survival.camp2.spring.karma;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NewColleague {

    final String nick;

    final String phone;

    final String department;

    @JsonCreator
    public NewColleague(
            @JsonProperty("nick")
            String nick,
            @JsonProperty("phone")
            String phone,
            @JsonProperty("department")
            String department) {
        this.nick = nick;
        this.phone = phone;
        this.department = department;
    }
}
