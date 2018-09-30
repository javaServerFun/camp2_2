package pl.survival.camp2.spring.karma;

import io.vavr.collection.List;

public class ColleagueService {

    private List<Colleague> colleagues = List.empty();

    List<Colleague> getColleagues() {
        return this.colleagues;
    }

    Colleague addColleague(final NewColleague newColleague) {
        Colleague created = new Colleague(
                colleagues.size()+1, newColleague.nick, newColleague.phone, newColleague.department);
        colleagues = colleagues.prepend(created);
        return created;
    }
}
