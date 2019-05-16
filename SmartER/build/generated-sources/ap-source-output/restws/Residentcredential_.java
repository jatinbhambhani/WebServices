package restws;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import restws.Resident;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-24T15:23:17")
@StaticMetamodel(Residentcredential.class)
public class Residentcredential_ { 

    public static volatile SingularAttribute<Residentcredential, Date> registrationdate;
    public static volatile SingularAttribute<Residentcredential, Resident> residentid;
    public static volatile SingularAttribute<Residentcredential, String> passwordhash;
    public static volatile SingularAttribute<Residentcredential, String> username;

}