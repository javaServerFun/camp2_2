package pl.survival.camp2.spring.karma;

import io.vavr.collection.List;
import org.springframework.stereotype.Service;
import pl.survival.camp2.spring.karma.db.ColleagueRepository;
import pl.survival.camp2.spring.karma.db.ColleagueRow;

import java.util.function.Function;

@Service
public class ColleagueService {

    private final ColleagueRepository repository;

    public ColleagueService(ColleagueRepository repository) {
        this.repository = repository;
    }

    List<Colleague> getColleagues() {
        return List.ofAll(this.repository.findAll())
                    .map(getColleagueRowColleagueFunction()
                     );
    }

    private Function<ColleagueRow, Colleague> getColleagueRowColleagueFunction() {
        return dbObj ->
            new Colleague(
                    dbObj.getId(),
                    dbObj.getNick(),
                    dbObj.getPhone(),
                    dbObj.getDepartment());
    }

    Colleague addColleague(final NewColleague newColleague) {
        ColleagueRow created = this.repository.save(new ColleagueRow(
                newColleague.nick,
                newColleague.phone,
                newColleague.department));
        return getColleagueRowColleagueFunction().apply(created);
    }
}

