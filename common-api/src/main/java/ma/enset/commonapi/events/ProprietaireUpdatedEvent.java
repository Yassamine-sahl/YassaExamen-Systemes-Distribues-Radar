package ma.enset.commonapi.events;

import lombok.Getter;

import java.util.Date;

@Getter
public class ProprietaireUpdatedEvent extends BaseEvent<String> {
    private String nom;
    private String prenom;
    private Date ddn;
    private String email;
    private String numTel;

    public ProprietaireUpdatedEvent(String id, String nom, String prenom, Date ddn, String email, String numTel) {
        super(id);
        this.nom = nom;
        this.prenom = prenom;
        this.ddn = ddn;
        this.email = email;
        this.numTel = numTel;
    }
}
