package be.vdab.personeel.domain;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "werknemers")
public class Werknemer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String voornaam;
    private String familienaam;
    private String email;
    @DecimalMin(value = "1.0", inclusive = false)
    private BigDecimal salaris;
private String paswoord;
    private Date geboorte;
    @Version
    private long versie;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "jobtitelid")
    private Jobtitel jobtitel;
    @OneToMany(mappedBy = "werknemers")
    @OrderBy("voornaam, familienaam")
    private Set<Werknemer> werknemers;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chefid")
    private Werknemer chef;

    public Werknemer(String voornaam, String familienaam, String email, BigDecimal salaris,
                     String paswoord, Date geboorte) {
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.email = email;
        this.salaris = salaris;
        this.paswoord = paswoord;
        this.geboorte = geboorte;
        setJobtitel(jobtitel);
        this.werknemers = new LinkedHashSet<>();
        setWerknemer(chef);
    }

    protected Werknemer() {}

    public Jobtitel getJobtitel() {
        return jobtitel;
    }

    public void setJobtitel(Jobtitel jobtitel) {
        if (!jobtitel.getWerknemers().contains(this)) {
            jobtitel.add(this);
        }
        this.jobtitel = jobtitel;
    }

    public boolean add(Werknemer werknemer) {
        var toegevoegd = werknemers.add(werknemer);
        var oudeWerknemer = werknemer.getWerknemer();
        if (oudeWerknemer != null && oudeWerknemer != this) {
            oudeWerknemer.werknemers.remove(werknemer);
        }
        if (this != oudeWerknemer) {
            werknemer.setWerknemer(this);
        }
        return toegevoegd;
    }

    public Set<Werknemer> getWerknemers() {
        return Collections.unmodifiableSet(werknemers);
    }

    public Werknemer getWerknemer() {
        return chef;
    }

    public void setWerknemer(Werknemer chef) {
        if (!chef.getWerknemers().contains(this)) {
            chef.add(this);
        }
        this.chef = chef;
    }



    public long getId() {
        return id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public String getEmail() {
        return email;
    }

    public BigDecimal getSalaris() {
        return salaris;
    }

    public String getPaswoord() {
        return paswoord;
    }

    public Date getGeboorte() {
        return geboorte;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Werknemer)) return false;
        Werknemer werknemer = (Werknemer) o;
        return Objects.equals(email, werknemer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return getVoornaam();
    }

}
