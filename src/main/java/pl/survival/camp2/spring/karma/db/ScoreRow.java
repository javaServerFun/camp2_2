package pl.survival.camp2.spring.karma.db;

import javax.persistence.*;

@Entity
public class ScoreRow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int scores;

    private String comment;

    public ScoreRow(int scores, String comment, ColleagueRow colleague) {
        this.scores = scores;
        this.comment = comment;
        this.colleague = colleague;
    }

    protected ScoreRow() {

    }

    @ManyToOne
    private ColleagueRow colleague;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public ColleagueRow getColleague() {
        return colleague;
    }

    public void setColleague(ColleagueRow colleague) {
        this.colleague = colleague;
    }
}
