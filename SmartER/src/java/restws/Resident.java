/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restws;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sanya
 */
@Entity
@Table(name = "RESIDENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resident.findAll", query = "SELECT r FROM Resident r")
    , @NamedQuery(name = "Resident.findByResidentid", query = "SELECT r FROM Resident r WHERE r.residentid = :residentid")
    , @NamedQuery(name = "Resident.findByFirstname", query = "SELECT r FROM Resident r WHERE r.firstname = :firstname")
    , @NamedQuery(name = "Resident.findByLastname", query = "SELECT r FROM Resident r WHERE r.lastname = :lastname")
    , @NamedQuery(name = "Resident.findByDob", query = "SELECT r FROM Resident r WHERE r.dob = :dob")
    , @NamedQuery(name = "Resident.findByAddress", query = "SELECT r FROM Resident r WHERE r.address = :address")
    , @NamedQuery(name = "Resident.findByPostcode", query = "SELECT r FROM Resident r WHERE r.postcode = :postcode")
    , @NamedQuery(name = "Resident.findByEmail", query = "SELECT r FROM Resident r WHERE r.email = :email")
    , @NamedQuery(name = "Resident.findByMobile", query = "SELECT r FROM Resident r WHERE r.mobile = :mobile")
    , @NamedQuery(name = "Resident.findByNoofresidents", query = "SELECT r FROM Resident r WHERE r.noofresidents = :noofresidents")
    , @NamedQuery(name = "Resident.findByNameofenergyprovider", query = "SELECT r FROM Resident r WHERE r.nameofenergyprovider = :nameofenergyprovider")})
public class Resident implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RESIDENTID")
    private Integer residentid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ADDRESS")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "POSTCODE")
    private short postcode;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOBILE")
    private long mobile;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOOFRESIDENTS")
    private int noofresidents;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NAMEOFENERGYPROVIDER")
    private String nameofenergyprovider;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "residentid")
    private Collection<Houseusage> houseusageCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "residentid")
    private Collection<Residentcredential> residentcredentialCollection;

    public Resident() {
    }

    public Resident(Integer residentid) {
        this.residentid = residentid;
    }

    public Resident(Integer residentid, String firstname, String lastname, String address, short postcode, String email, long mobile, int noofresidents, String nameofenergyprovider) {
        this.residentid = residentid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.postcode = postcode;
        this.email = email;
        this.mobile = mobile;
        this.noofresidents = noofresidents;
        this.nameofenergyprovider = nameofenergyprovider;
    }

    public Integer getResidentid() {
        return residentid;
    }

    public void setResidentid(Integer residentid) {
        this.residentid = residentid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public short getPostcode() {
        return postcode;
    }

    public void setPostcode(short postcode) {
        this.postcode = postcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public int getNoofresidents() {
        return noofresidents;
    }

    public void setNoofresidents(int noofresidents) {
        this.noofresidents = noofresidents;
    }

    public String getNameofenergyprovider() {
        return nameofenergyprovider;
    }

    public void setNameofenergyprovider(String nameofenergyprovider) {
        this.nameofenergyprovider = nameofenergyprovider;
    }

    @XmlTransient
    public Collection<Houseusage> getHouseusageCollection() {
        return houseusageCollection;
    }

    public void setHouseusageCollection(Collection<Houseusage> houseusageCollection) {
        this.houseusageCollection = houseusageCollection;
    }

    @XmlTransient
    public Collection<Residentcredential> getResidentcredentialCollection() {
        return residentcredentialCollection;
    }

    public void setResidentcredentialCollection(Collection<Residentcredential> residentcredentialCollection) {
        this.residentcredentialCollection = residentcredentialCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (residentid != null ? residentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resident)) {
            return false;
        }
        Resident other = (Resident) object;
        if ((this.residentid == null && other.residentid != null) || (this.residentid != null && !this.residentid.equals(other.residentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restws.Resident[ residentid=" + residentid + " ]";
    }
    
}
