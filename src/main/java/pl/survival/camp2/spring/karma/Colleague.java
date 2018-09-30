package pl.survival.camp2.spring.karma;

public class Colleague {

    public final long id;

    public final String nick;

    public final String phone;

    public final String department;


    public Colleague(long id, String nick, String phone, String department) {
        this.id = id;
        this.nick = nick;
        this.phone = phone;
        this.department = department;
    }
}
