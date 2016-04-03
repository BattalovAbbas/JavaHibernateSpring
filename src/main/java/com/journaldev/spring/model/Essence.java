/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.journaldev.spring.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.Table;

/**
 *
 * @author Abbas
 */
@Entity
@Table(name="essence")
public class Essence implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "Login")
    private String login; 
    @Column(name = "Value1")
    private String value1;
    @Column(name = "Value2")
    private String value2;
    @Column(name = "Operation")
    private String operation;
    @Column(name = "Result")
    private String result;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setValue1(String value1) {
        this.value1 = value1;
    }
    
    public String getValue1() {
        return value1;
    }
    
    public void setValue2(String value2) {
        this.value2 = value2;
    }
    
    public String getValue2() {
        return value2;
    }
    public void setOperation(String operation) {
        this.operation = operation;
    }
    
    public String getOperation() {
        return operation;
    }
    
    public void setResult(String result) {
        this.result = result;
    }
    
    public String getResult() {
        return result;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Essence)) {
            return false;
        }
        Essence other = (Essence) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //"id="+id+", login="+login +" "+ value1+ " "+operation+" "+ value2+" = " + result;
        return "com.journaldev.spring.model.Essence[ id=" + id + " ]";
    }

    public Query createQuery(String select__from_Essence) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
