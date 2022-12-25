package ma.enset.commonapi.events;

import lombok.Getter;

import java.util.Date;

public class OwnerCreatedEvent extends BaseEvent<String> {
    @Getter public String name;
    @Getter public Date dateOfBirth;
    @Getter public String email;

    public OwnerCreatedEvent(String id, String name, Date dateOfBirth, String email) {
        super(id);
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }
}
