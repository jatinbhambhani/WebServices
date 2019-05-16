/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restws;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sanya
 */
@Entity
@Table(name = "HOUSEUSAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Houseusage.findAll", query = "SELECT h FROM Houseusage h")
    , @NamedQuery(name = "Houseusage.findByUsageid", query = "SELECT h FROM Houseusage h WHERE h.usageid = :usageid")
    , @NamedQuery(name = "Houseusage.findByResidentid", query = "SELECT h FROM Houseusage h WHERE h.residentid.residentid = :residentid")
    , @NamedQuery(name = "Houseusage.findByUsagedate", query = "SELECT h FROM Houseusage h WHERE h.usagedate = :usagedate")
    , @NamedQuery(name = "Houseusage.findByUsagehour", query = "SELECT h FROM Houseusage h WHERE h.usagehour = :usagehour")
    , @NamedQuery(name = "Houseusage.findByFridgeusage", query = "SELECT h FROM Houseusage h WHERE h.fridgeusage = :fridgeusage")
    , @NamedQuery(name = "Houseusage.findByAirconusage", query = "SELECT h FROM Houseusage h WHERE h.airconusage = :airconusage")
    , @NamedQuery(name = "Houseusage.findByWashingmachineusage", query = "SELECT h FROM Houseusage h WHERE h.washingmachineusage = :washingmachineusage")
    , @NamedQuery(name = "Houseusage.findByTemperature", query = "SELECT h FROM Houseusage h WHERE h.temperature = :temperature")
    , @NamedQuery(name = "Houseusage.findByResidentidANDTemperature", query = "SELECT h FROM Houseusage h WHERE h.residentid.residentid = :residentid"
            + " AND h.temperature = :temperature")
    , @NamedQuery(name = "Houseusage.findHighestHourlyConsumption", query = "SELECT h FROM Houseusage h WHERE h.residentid.residentid = :residentid"
            + " AND h.temperature = :temperature")  
})

public class Houseusage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USAGEID")
    private Integer usageid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USAGEDATE")
    @Temporal(TemporalType.DATE)
    private Date usagedate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USAGEHOUR")
    private int usagehour;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "FRIDGEUSAGE")
    private BigDecimal fridgeusage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AIRCONUSAGE")
    private BigDecimal airconusage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WASHINGMACHINEUSAGE")
    private BigDecimal washingmachineusage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TEMPERATURE")
    private BigDecimal temperature;
    @JoinColumn(name = "RESIDENTID", referencedColumnName = "RESIDENTID")
    @ManyToOne(optional = false)
    private Resident residentid;

    public Houseusage() {
    }

    public Houseusage(Integer usageid) {
        this.usageid = usageid;
    }

    public Houseusage(Integer usageid, Date usagedate, int usagehour, BigDecimal fridgeusage, BigDecimal airconusage, BigDecimal washingmachineusage, BigDecimal temperature) {
        this.usageid = usageid;
        this.usagedate = usagedate;
        this.usagehour = usagehour;
        this.fridgeusage = fridgeusage;
        this.airconusage = airconusage;
        this.washingmachineusage = washingmachineusage;
        this.temperature = temperature;
    }

    public Integer getUsageid() {
        return usageid;
    }

    public void setUsageid(Integer usageid) {
        this.usageid = usageid;
    }

    public Date getUsagedate() {
        return usagedate;
    }

    public void setUsagedate(Date usagedate) {
        this.usagedate = usagedate;
    }

    public int getUsagehour() {
        return usagehour;
    }

    public void setUsagehour(int usagehour) {
        this.usagehour = usagehour;
    }

    public BigDecimal getFridgeusage() {
        return fridgeusage;
    }

    public void setFridgeusage(BigDecimal fridgeusage) {
        this.fridgeusage = fridgeusage;
    }

    public BigDecimal getAirconusage() {
        return airconusage;
    }

    public void setAirconusage(BigDecimal airconusage) {
        this.airconusage = airconusage;
    }

    public BigDecimal getWashingmachineusage() {
        return washingmachineusage;
    }

    public void setWashingmachineusage(BigDecimal washingmachineusage) {
        this.washingmachineusage = washingmachineusage;
    }

    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public Resident getResidentid() {
        return residentid;
    }

    public void setResidentid(Resident residentid) {
        this.residentid = residentid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usageid != null ? usageid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Houseusage)) {
            return false;
        }
        Houseusage other = (Houseusage) object;
        if ((this.usageid == null && other.usageid != null) || (this.usageid != null && !this.usageid.equals(other.usageid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restws.Houseusage[ usageid=" + usageid + " ]";
    }
    
}
