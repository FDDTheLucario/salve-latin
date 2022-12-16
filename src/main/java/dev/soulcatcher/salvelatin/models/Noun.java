package dev.soulcatcher.salvelatin.models;

import jakarta.persistence.*;

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

    public Noun(UUID nounId, Declension declension, String nominativeSingular, String genitiveSingular, String dativeSingular, String accusativeSingular, String ablativeSingular, String vocativeSingular, String nominativePlural, String genitivePlural, String accusativePlural, String ablativePlural, String vocativePlural) {
        this(declension, nominativeSingular, genitiveSingular, dativeSingular, accusativeSingular, ablativeSingular, nominativePlural, genitivePlural, accusativePlural, ablativePlural);
        this.vocativeSingular = vocativeSingular;
        this.vocativePlural = vocativePlural;
    }
}
