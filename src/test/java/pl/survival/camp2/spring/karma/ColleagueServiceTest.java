package pl.survival.camp2.spring.karma;

import io.vavr.collection.List;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.survival.camp2.spring.karma.db.ColleagueRepository;
import pl.survival.camp2.spring.karma.db.ScoreRepository;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ColleagueServiceTest {

    @Autowired
    private ColleagueRepository repository;

    @Autowired
    private ScoreRepository scoreRepository;

    @After
    public void cleanAfterTest() {
        this.repository.deleteAll();
    }

    @Test
    public void getEmptyList() {
        final ColleagueService service = new ColleagueService(repository, scoreRepository);

        final List<Colleague> colleagues = service.getColleagues();

        assertTrue(colleagues.isEmpty());
    }

    @Test
    public void addColl( ) {
        final ColleagueService service = new ColleagueService(repository, scoreRepository);

        final Colleague created = service.addColleague(
                new NewColleague("Irasiad", "555-555-551", "HR"));

        assertNotNull(created);
    }

    @Test
    public void addedCollIsReturned( ) {
        final ColleagueService service = new ColleagueService(repository, scoreRepository);

        final Colleague created = service.addColleague(
                new NewColleague("Irasiad", "555-555-551", "HR"));

        final List<Colleague> all = service.getColleagues();

        assertEquals("Irasiad", all.head().nick);
    }

    @Test
    public void addedCollHasNewId( ) {
        final ColleagueService service = new ColleagueService(repository, scoreRepository);
        final Colleague created1 = service.addColleague(
                new NewColleague("Irasiad", "555-555-551", "HR"));
        final Colleague created2 = service.addColleague(
                new NewColleague("Jurek", "555-555-552", "HR"));

        assertNotEquals(created1.id, created2.id);
        assertEquals(2, service.getColleagues().size());
    }

}