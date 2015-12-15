/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * 
 * @author oland <roland at gmail.com>
 */
public class ApplicantBean {
    
    private Integer applicantId;
    private String firstname;
    private String middlename;
    private String lastname;
    private String email;
    private String contactNumber;
    private String workHistory; 
    private String applicantName;
    private ArrayList<CompanyBean> companyBeans;
    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getWorkHistory() {
        return workHistory;
    }

    public void setWorkHistory(String workHistory) {
        this.workHistory = workHistory;
    }

    public String getApplicantName() {
        return this.firstname + " " + this.middlename + " " + this.lastname;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public ArrayList<CompanyBean> getCompanyBeans() {
        return companyBeans;
    }

    public void setCompanyBeans(ArrayList<CompanyBean> companyBeans) {
        this.companyBeans = companyBeans;
    }
   
    
    

}
