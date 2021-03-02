package be.vdab.personeel.domain;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.*;

@Entity
public class Werknemer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String voornaam;
    private String familienaam;
    private String emailAdres;
    private int chefId;
    private int jobTitelId;
    @DecimalMin(value = "1.0", inclusive = false)
    private BigDecimal salaris;
private String paswoord;
    private Date geboorte;
    @Version
    private long versie;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "jobtitelid")
    private Jobtitel jobtitel;
    @OneToMany(mappedBy = "werknemer")
    @OrderBy("voornaam, familienaam")
    private Set<Werknemer> werknemers;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chefid")
    private Werknemer werknemer;

    public Werknemer(String voornaam, String familienaam, String emailAdres, BigDecimal salaris,
                     String paswoord, Date geboorte,int chefId,int jobTitelId) {
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.emailAdres = emailAdres;
        this.salaris = salaris;
        this.paswoord = paswoord;
        this.geboorte = geboorte;
        this.chefId = chefId;
        this.jobTitelId = jobTitelId;
        setJobtitel(jobtitel);
        this.werknemers = new LinkedHashSet<>();
        setWerknemer(werknemer);
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
        return werknemer;
    }

    public void setWerknemer(Werknemer werknemer) {
        if (!werknemer.getWerknemers().contains(this)) {
            werknemer.add(this);
        }
        this.werknemer = werknemer;
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

    public String getEmailAdres() {
        return emailAdres;
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

    public int getChefId() {
        return chefId;
    }

    public int getJobTitelId() {
        return jobTitelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Werknemer)) return false;
        Werknemer werknemer = (Werknemer) o;
        return Objects.equals(emailAdres, werknemer.emailAdres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailAdres);
    }
}
