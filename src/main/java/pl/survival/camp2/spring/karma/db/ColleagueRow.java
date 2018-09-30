package pl.survival.camp2.spring.karma.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ColleagueRow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nick;

    private String phone;

    private String department;

    public ColleagueRow(String nick, String phone, String department) {
        this.nick = nick;
        this.phone = phone;
        this.department = department;
    }

    protected ColleagueRow() {
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
