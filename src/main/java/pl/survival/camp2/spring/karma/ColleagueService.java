package pl.survival.camp2.spring.karma;

import io.vavr.collection.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.survival.camp2.spring.karma.db.ColleagueRepository;
import pl.survival.camp2.spring.karma.db.ColleagueRow;

import java.util.Optional;
import java.util.function.Function;

@Service
public class ColleagueService {

    private final ColleagueRepository repository;

    public ColleagueService(ColleagueRepository repository) {
        this.repository = repository;
    }

    List<Colleague> getColleagues() {
        return List.ofAll(this.repository.findAll())
                    .map(ColleagueRow::toColleague);
    }


    Colleague addColleague(final NewColleague newColleague) {
        return this.repository.save(new ColleagueRow(
                newColleague.nick,
                newColleague.phone,
                newColleague.department)).toColleague();
    }

    @Transactional
    public Optional<Colleague> changePhone( long colleagueId, String newPhone ) {
        final Optional<ColleagueRow> colleague = this.repository.findById(colleagueId);
        return colleague.map ( c -> {
            c.setPhone(newPhone);
            //repository.save(c);
            return c.toColleague();
        });
    }
}

