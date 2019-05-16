package restws;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import restws.Houseusage;
import restws.Residentcredential;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-24T15:23:17")
@StaticMetamodel(Resident.class)
public class Resident_ { 

    public static volatile CollectionAttribute<Resident, Residentcredential> residentcredentialCollection;
    public static volatile SingularAttribute<Resident, Integer> noofresidents;
    public static volatile SingularAttribute<Resident, String> nameofenergyprovider;
    public static volatile SingularAttribute<Resident, String> firstname;
    public static volatile SingularAttribute<Resident, String> address;
    public static volatile SingularAttribute<Resident, Date> dob;
    public static volatile SingularAttribute<Resident, Short> postcode;
    public static volatile SingularAttribute<Resident, Long> mobile;
    public static volatile SingularAttribute<Resident, Integer> residentid;
    public static volatile CollectionAttribute<Resident, Houseusage> houseusageCollection;
    public static volatile SingularAttribute<Resident, String> email;
    public static volatile SingularAttribute<Resident, String> lastname;

}