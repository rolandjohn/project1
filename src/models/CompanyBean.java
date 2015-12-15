/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class CompanyBean {
    
    private Integer companyId;
    private String companyName;
    private String Street;
    private String city;
    private String zipCode;
    private String phone;
    private String address;
    private String xmlValue;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.Street + " " + this.city + ", " + this.zipCode;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getXmlValue() {
        return xmlValue;
    }

    public void setXmlValue(String xmlValue) {
        this.xmlValue = xmlValue;
    }
    
    
    

}
