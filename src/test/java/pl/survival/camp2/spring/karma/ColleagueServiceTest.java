package pl.survival.camp2.spring.karma;

import io.vavr.collection.List;
import org.junit.Test;

import static org.junit.Assert.*;

public class ColleagueServiceTest {

    @Test
    public void getEmptyList() {
        final ColleagueService service = new ColleagueService();

        final List<Colleague> colleagues = service.getColleagues();

        assertTrue(colleagues.isEmpty());
    }

    @Test
    public void addColl( ) {
        final ColleagueService service = new ColleagueService();

        final Colleague created = service.addColleague(
                new NewColleague("Irasiad", "555-555-551", "HR"));

        assertNotNull(created);
    }

    @Test
    public void addedCollIsReturned( ) {
        final ColleagueService service = new ColleagueService();

        final Colleague created = service.addColleague(
                new NewColleague("Irasiad", "555-555-551", "HR"));

        final List<Colleague> all = service.getColleagues();

        assertEquals("Irasiad", all.head().nick);
    }

    @Test
    public void addedCollHasNewId( ) {
        final ColleagueService service = new ColleagueService();
        final Colleague created1 = service.addColleague(
                new NewColleague("Irasiad", "555-555-551", "HR"));
        final Colleague created2 = service.addColleague(
                new NewColleague("Jurek", "555-555-552", "HR"));

        assertNotEquals(created1.id, created2.id);
        assertEquals(2, service.getColleagues().size());
    }

}