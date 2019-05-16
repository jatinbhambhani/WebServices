package restws;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import restws.Resident;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-24T15:23:17")
@StaticMetamodel(Houseusage.class)
public class Houseusage_ { 

    public static volatile SingularAttribute<Houseusage, BigDecimal> fridgeusage;
    public static volatile SingularAttribute<Houseusage, Integer> usageid;
    public static volatile SingularAttribute<Houseusage, Date> usagedate;
    public static volatile SingularAttribute<Houseusage, Integer> usagehour;
    public static volatile SingularAttribute<Houseusage, BigDecimal> washingmachineusage;
    public static volatile SingularAttribute<Houseusage, BigDecimal> temperature;
    public static volatile SingularAttribute<Houseusage, Resident> residentid;
    public static volatile SingularAttribute<Houseusage, BigDecimal> airconusage;

}