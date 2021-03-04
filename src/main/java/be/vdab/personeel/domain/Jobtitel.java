package be.vdab.personeel.domain;


import javax.persistence.*;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "jobtitels")
public class Jobtitel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String naam;
    @Version
    private long versie;
    @OneToMany(mappedBy = "jobtitel")
    @OrderBy("voornaam, familienaam")
    private Set<Werknemer> werknemers;


    public Jobtitel(String naam) {
        this.naam = naam;
        this.werknemers = new LinkedHashSet<>();
    }

    public boolean add(Werknemer werknemer) {
        var toegevoegd = werknemers.add(werknemer);
        var oudeJobtitel = werknemer.getJobtitel();
        if (oudeJobtitel != null && oudeJobtitel != this) {
            oudeJobtitel.werknemers.remove(werknemer);
        }
        if (this != oudeJobtitel) {
            werknemer.setJobtitel(this);
        }
        return toegevoegd;
    }

    public Set<Werknemer> getWerknemers() {
        return Collections.unmodifiableSet(werknemers);
    }

    protected Jobtitel() {}

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jobtitel)) return false;
        Jobtitel jobtitel = (Jobtitel) o;
        return Objects.equals(naam, jobtitel.naam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam);
    }

    @Override
    public String toString() {
        return getNaam();
    }
}
