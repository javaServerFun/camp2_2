package pl.survival.camp2.spring.karma;

import io.vavr.collection.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.survival.camp2.spring.karma.db.ColleagueRepository;
import pl.survival.camp2.spring.karma.db.ColleagueRow;
import pl.survival.camp2.spring.karma.db.ScoreRepository;
import pl.survival.camp2.spring.karma.db.ScoreRow;

import java.util.Optional;

@Service
public class ColleagueService {

    private final ColleagueRepository colleagueRepository;
    private final ScoreRepository scoreRepository;

    public ColleagueService(ColleagueRepository repository, ScoreRepository scoreRepository) {
        this.colleagueRepository = repository;
        this.scoreRepository = scoreRepository;
    }

    List<Colleague> getColleagues() {
        return List.ofAll(this.colleagueRepository.findAll())
                    .map(ColleagueRow::toColleague);
    }


    Colleague addColleague(final NewColleague newColleague) {
        return this.colleagueRepository.save(new ColleagueRow(
                newColleague.nick,
                newColleague.phone,
                newColleague.department)).toColleague();
    }

    @Transactional
    public Optional<Colleague> changePhone( long colleagueId, String newPhone ) {
        final Optional<ColleagueRow> colleague = this.colleagueRepository.findById(colleagueId);
        return colleague.map ( c -> {
            c.setPhone(newPhone);
            //colleagueRepository.save(c);
            return c.toColleague();
        });
    }

    @Transactional
    public Optional<Integer> addScore(final long colleagueId, final Score score) {
        final Optional<ColleagueRow> colleague = this.colleagueRepository.findById(colleagueId);
        return colleague.map( c-> {
            int existingScore = List.ofAll(c.getScores())
                    .foldLeft(0, (p, s)-> p + s.getScores());

            final ScoreRow newScore = new ScoreRow(
                   score.score,
                   score.comment,
                   c);
            this.scoreRepository.save(newScore);
            return existingScore + score.score;

        });


    }
}

