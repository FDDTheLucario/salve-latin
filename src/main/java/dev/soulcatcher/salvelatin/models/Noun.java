package dev.soulcatcher.salvelatin.models;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "nouns")
public class Noun {
    @Id
    private UUID nounId = UUID.randomUUID();

    @Enumerated(EnumType.STRING)
    private Declension declension;
    @Column(nullable = false)
    private String nominativeSingular;
    @Column(nullable = false)
    private String genitiveSingular;
    @Column(nullable = false)
    private String dativeSingular;
    @Column(nullable = false)
    private String accusativeSingular;
    @Column(nullable = false)
    private String ablativeSingular;
    private String vocativeSingular = null;
    @Column(nullable = false)
    private String nominativePlural;
    @Column(nullable = false)
    private String genitivePlural;
    @Column(nullable = false)
    private String accusativePlural;
    @Column(nullable = false)
    private String ablativePlural;
    private String vocativePlural = null;

    public Noun() {
        super();
    }

    public Noun(Declension declension, String nominativeSingular, String genitiveSingular, String dativeSingular,
            String accusativeSingular, String ablativeSingular, String nominativePlural, String genitivePlural,
            String accusativePlural, String ablativePlural) {
        this.declension = declension;
        this.nominativeSingular = nominativeSingular;
        this.genitiveSingular = genitiveSingular;
        this.dativeSingular = dativeSingular;
        this.accusativeSingular = accusativeSingular;
        this.ablativeSingular = ablativeSingular;
        this.nominativePlural = nominativePlural;
        this.genitivePlural = genitivePlural;
        this.accusativePlural = accusativePlural;
        this.ablativePlural = ablativePlural;
    }

    public Noun(UUID nounId, Declension declension, String nominativeSingular, String genitiveSingular,
            String dativeSingular, String accusativeSingular, String ablativeSingular, String vocativeSingular,
            String nominativePlural, String genitivePlural, String accusativePlural, String ablativePlural,
            String vocativePlural) {
        this(declension, nominativeSingular, genitiveSingular, dativeSingular, accusativeSingular, ablativeSingular,
                nominativePlural, genitivePlural, accusativePlural, ablativePlural);
        this.vocativeSingular = vocativeSingular;
        this.vocativePlural = vocativePlural;
    }

    public UUID getNounId() {
        return nounId;
    }

    public void setNounId(UUID nounId) {
        this.nounId = nounId;
    }

    public Declension getDeclension() {
        return declension;
    }

    public void setDeclension(Declension declension) {
        this.declension = declension;
    }

    public String getNominativeSingular() {
        return nominativeSingular;
    }

    public void setNominativeSingular(String nominativeSingular) {
        this.nominativeSingular = nominativeSingular;
    }

    public String getGenitiveSingular() {
        return genitiveSingular;
    }

    public void setGenitiveSingular(String genitiveSingular) {
        this.genitiveSingular = genitiveSingular;
    }

    public String getDativeSingular() {
        return dativeSingular;
    }

    public void setDativeSingular(String dativeSingular) {
        this.dativeSingular = dativeSingular;
    }

    public String getAccusativeSingular() {
        return accusativeSingular;
    }

    public void setAccusativeSingular(String accusativeSingular) {
        this.accusativeSingular = accusativeSingular;
    }

    public String getAblativeSingular() {
        return ablativeSingular;
    }

    public void setAblativeSingular(String ablativeSingular) {
        this.ablativeSingular = ablativeSingular;
    }

    public String getVocativeSingular() {
        return vocativeSingular;
    }

    public void setVocativeSingular(String vocativeSingular) {
        this.vocativeSingular = vocativeSingular;
    }

    public String getNominativePlural() {
        return nominativePlural;
    }

    public void setNominativePlural(String nominativePlural) {
        this.nominativePlural = nominativePlural;
    }

    public String getGenitivePlural() {
        return genitivePlural;
    }

    public void setGenitivePlural(String genitivePlural) {
        this.genitivePlural = genitivePlural;
    }

    public String getAccusativePlural() {
        return accusativePlural;
    }

    public void setAccusativePlural(String accusativePlural) {
        this.accusativePlural = accusativePlural;
    }

    public String getAblativePlural() {
        return ablativePlural;
    }

    public void setAblativePlural(String ablativePlural) {
        this.ablativePlural = ablativePlural;
    }

    public String getVocativePlural() {
        return vocativePlural;
    }

    public void setVocativePlural(String vocativePlural) {
        this.vocativePlural = vocativePlural;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Noun noun = (Noun) o;
        return nounId.equals(noun.nounId) && declension == noun.declension
                && nominativeSingular.equals(noun.nominativeSingular) && genitiveSingular.equals(noun.genitiveSingular)
                && dativeSingular.equals(noun.dativeSingular) && accusativeSingular.equals(noun.accusativeSingular)
                && ablativeSingular.equals(noun.ablativeSingular)
                && Objects.equals(vocativeSingular, noun.vocativeSingular)
                && nominativePlural.equals(noun.nominativePlural) && genitivePlural.equals(noun.genitivePlural)
                && accusativePlural.equals(noun.accusativePlural) && ablativePlural.equals(noun.ablativePlural)
                && vocativePlural.equals(noun.vocativePlural);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nounId, declension, nominativeSingular, genitiveSingular, dativeSingular,
                accusativeSingular, ablativeSingular, vocativeSingular, nominativePlural, genitivePlural,
                accusativePlural, ablativePlural, vocativePlural);
    }

    @Override
    public String toString() {
        return "Noun{" + "nounId=" + nounId + ", declension=" + declension + ", nominativeSingular='"
                + nominativeSingular + '\'' + ", genitiveSingular='" + genitiveSingular + '\'' + ", dativeSingular='"
                + dativeSingular + '\'' + ", accusativeSingular='" + accusativeSingular + '\'' + ", ablativeSingular='"
                + ablativeSingular + '\'' + ", vocativeSingular='" + vocativeSingular + '\'' + ", nominativePlural='"
                + nominativePlural + '\'' + ", genitivePlural='" + genitivePlural + '\'' + ", accusativePlural='"
                + accusativePlural + '\'' + ", ablativePlural='" + ablativePlural + '\'' + ", vocativePlural='"
                + vocativePlural + '\'' + '}';
    }
}
