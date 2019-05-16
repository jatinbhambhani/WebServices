/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restws;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sanya
 */
@Entity
@Table(name = "RESIDENTCREDENTIAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Residentcredential.findAll", query = "SELECT r FROM Residentcredential r")
    , @NamedQuery(name = "Residentcredential.findByUsername", query = "SELECT r FROM Residentcredential r WHERE r.username = :username")
    , @NamedQuery(name = "Residentcredential.findByResidentid", query = "SELECT r FROM Residentcredential r WHERE r.residentid.residentid = :residentid")
    , @NamedQuery(name = "Residentcredential.findByPasswordhash", query = "SELECT r FROM Residentcredential r WHERE r.passwordhash = :passwordhash")
    , @NamedQuery(name = "Residentcredential.findByRegistrationdate", query = "SELECT r FROM Residentcredential r WHERE r.registrationdate = :registrationdate")})
public class Residentcredential implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PASSWORDHASH")
    private String passwordhash;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REGISTRATIONDATE")
    @Temporal(TemporalType.DATE)
    private Date registrationdate;
    @JoinColumn(name = "RESIDENTID", referencedColumnName = "RESIDENTID")
    @ManyToOne(optional = false)
    private Resident residentid;

    public Residentcredential() {
    }

    public Residentcredential(String username) {
        this.username = username;
    }

    public Residentcredential(String username, String passwordhash, Date registrationdate) {
        this.username = username;
        this.passwordhash = passwordhash;
        this.registrationdate = registrationdate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordhash() {
        return passwordhash;
    }

    public void setPasswordhash(String passwordhash) {
        this.passwordhash = passwordhash;
    }

    public Date getRegistrationdate() {
        return registrationdate;
    }

    public void setRegistrationdate(Date registrationdate) {
        this.registrationdate = registrationdate;
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
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Residentcredential)) {
            return false;
        }
        Residentcredential other = (Residentcredential) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restws.Residentcredential[ username=" + username + " ]";
    }
    
}
