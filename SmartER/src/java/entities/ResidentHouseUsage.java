/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sanya
 */
@XmlRootElement
public class ResidentHouseUsage {

    private Integer residentid;
     private BigDecimal airconusage;
     private int usagehour;
     
    public Integer getResidentid() {
        return residentid;
    }

    public void setResidentid(Integer residentid) {
        this.residentid = residentid;
    }

    public BigDecimal getAirconusage() {
        return airconusage;
    }

    public void setAirconusage(BigDecimal airconusage) {
        this.airconusage = airconusage;
    }

    public int getUsagehour() {
        return usagehour;
    }

    public void setUsagehour(int usagehour) {
        this.usagehour = usagehour;
    }
    
    public ResidentHouseUsage()
    {}

    public ResidentHouseUsage(Integer residentid, BigDecimal airconusage, int usagehour) {
        this.residentid = residentid;
        this.airconusage = airconusage;
        this.usagehour = usagehour;
    }
    
     
     
     
}
