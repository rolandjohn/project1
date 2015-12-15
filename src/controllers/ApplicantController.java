/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.ApplicantBean;
import models.CompanyBean;

/**
 *
 *
 *
 * REQUIRES db2jcc4.jar library
 *
 *
 *
 * @author developer
 */
public class ApplicantController {

    private static final String server = "localhost";
    private static final String database = "RGASPAR";
    private static final int port = 50001;
    private static final String username = "db2admin";
    private static final String password = "web001";
    private static final String url = "jdbc:db2://" + server + ":" + port + "/" + database;

    private static final String table = "APPLICANT";
    private static final String tableColumns = "applicant_id, firstname, middlename, lastname, email, contact_number";

    public static void addData(ApplicantBean model) throws SQLException {
        String query = "INSERT INTO " + table + " (" + tableColumns + ", work_history) VALUES(?,?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(url, username, password); PreparedStatement pstm = conn.prepareStatement(query)) {
            pstm.setInt(1, model.getApplicantId());
            pstm.setString(2, model.getFirstname());
            pstm.setString(3, model.getMiddlename());
            pstm.setString(4, model.getLastname());
            pstm.setString(5, model.getEmail());
            pstm.setString(6, model.getContactNumber());
            pstm.setString(7, model.getWorkHistory());

            pstm.executeUpdate();
        }
    }

    public static void insertCompanyXMLData(String xml, int id) throws SQLException {
        String query = "UPDATE " + table + " SET work_history = xmlquery('copy $new := $WORK_HISTORY\n"
                + " modify do insert " + xml + " as last into $new/companies\n"
                + " return  $new' ) where applicant_id=?";

        try (Connection conn = DriverManager.getConnection(url, username, password); PreparedStatement pstm = conn.prepareStatement(query)) {
            pstm.setInt(1, id);
            pstm.executeUpdate();
        }
    }

    public static void updateCompanyXMLData(String xml, int companyId, int id) throws SQLException {
        String query = "UPDATE " + table + " SET work_history = xmlquery('copy $new := $WORK_HISTORY\n"
                + " modify for $c in $new/companies/company[@id=\"" + companyId + "\"] return do replace $c with " + xml
                + " return  $new' ) where applicant_id=?";
        System.out.println("update query: " + query);
        try (Connection conn = DriverManager.getConnection(url, username, password); PreparedStatement pstm = conn.prepareStatement(query)) {
            pstm.setInt(1, id);
            pstm.executeUpdate();
        }
    }

    public static void deleteCompanyXMLData(int companyId, int id) throws SQLException {
        String query = "UPDATE " + table + " SET work_history = xmlquery('copy $new := $WORK_HISTORY\n"
                + " modify do delete $new/companies/company[@id=\"" + companyId + "\"] \n"
                + " return  $new' ) where applicant_id=?";
        System.out.println("delete query: " + query);
        try (Connection conn = DriverManager.getConnection(url, username, password); PreparedStatement pstm = conn.prepareStatement(query)) {
            pstm.setInt(1, id);
            pstm.executeUpdate();
        }
    }

    public static void updateData(ApplicantBean model, int pk) throws SQLException {
        String query = "UPDATE " + table + " SET applicant_id = ?, firstname = ?, middlename = ?, lastname = ?, email = ?, contact_number=?, work_history=? WHERE applicant_id = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password); PreparedStatement pstm = conn.prepareStatement(query)) {
            pstm.setInt(1, model.getApplicantId());
            pstm.setString(2, model.getFirstname());
            pstm.setString(3, model.getMiddlename());
            pstm.setString(4, model.getLastname());
            pstm.setString(5, model.getEmail());
            pstm.setString(6, model.getContactNumber());
            pstm.setString(7, model.getWorkHistory());
            pstm.setString(7, model.getWorkHistory());
            pstm.setInt(8, pk);
            pstm.executeUpdate();
        }
    }

    public static void removeData(int pk) throws SQLException {
        String query = "DELETE FROM " + table + " WHERE applicant_id = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password); PreparedStatement pstm = conn.prepareStatement(query)) {
            pstm.setInt(1, pk);
            pstm.executeUpdate();
        }
    }

    public static ArrayList<ApplicantBean> getAllData() throws SQLException {
        String query = "SELECT " + tableColumns + " FROM " + table + " order by applicant_id";
        ArrayList<ApplicantBean> al = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, username, password); PreparedStatement pstm = conn.prepareStatement(query); ResultSet rs = pstm.executeQuery()) {
            while (rs.next()) {
                ApplicantBean mymodel = new ApplicantBean();
                mymodel.setApplicantId(rs.getInt("applicant_id"));
                mymodel.setFirstname(rs.getString("firstname"));
                mymodel.setMiddlename(rs.getString("middlename"));
                mymodel.setLastname(rs.getString("lastname"));
                mymodel.setEmail(rs.getString("email"));
                mymodel.setContactNumber(rs.getString("contact_number") + "");

                al.add(mymodel);
            }
        }

        return al;
    }

    public static ApplicantBean getData(int id) throws SQLException {
        String query = "SELECT " + tableColumns + ",work_history FROM " + table + " WHERE applicant_id = ?";
        ApplicantBean mymodel = new ApplicantBean();

        try (Connection conn = DriverManager.getConnection(url, username, password); PreparedStatement pstm = conn.prepareStatement(query)) {
            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {

                    mymodel.setApplicantId(rs.getInt("applicant_id"));
                    mymodel.setFirstname(rs.getString("firstname"));
                    mymodel.setMiddlename(rs.getString("middlename"));
                    mymodel.setLastname(rs.getString("lastname"));
                    mymodel.setEmail(rs.getString("email"));
                    mymodel.setContactNumber(rs.getString("contact_number"));
                    mymodel.setWorkHistory(rs.getString("work_history"));

                }
            }
        }

        String companiesQuery = "SELECT wh.companyID, wh.company_name, wh.street, wh.city, wh.zipcode, wh.phone from " + table + " a, \n"
                + "xmltable('$w/companies/company' passing a.work_history as \"w\"\n"
                + "columns companyID integer path '@id',\n"
                + "     company_name varchar(100) path 'name',\n"
                + "	street varchar(100) path 'address/street',\n"
                + "	city varchar(100) path 'address/city',\n"
                + "	zipcode varchar(50) path 'address/zipcode',\n"
                + "	phone varchar(25) path 'phone') as wh WHERE a.applicant_id = ?";
        ArrayList<CompanyBean> al = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, username, password); PreparedStatement pstm = conn.prepareStatement(companiesQuery)) {
            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    CompanyBean companyModel = new CompanyBean();
                    companyModel.setCompanyId(rs.getInt("companyID"));
                    companyModel.setCompanyName(rs.getString("company_name"));
                    companyModel.setStreet(rs.getString("street"));
                    companyModel.setCity(rs.getString("city"));
                    companyModel.setZipCode(rs.getString("zipcode"));
                    companyModel.setPhone(rs.getString("phone"));
                    al.add(companyModel);
                }
            }
        }
        mymodel.setCompanyBeans(al);
        return mymodel;
    }

    public static ArrayList<CompanyBean> getWorkHistoryAllData(int id) throws SQLException {
        String query = "SELECT wh.companyID, wh.company_name, wh.street, wh.city, wh.zipcode, wh.phone from " + table + " a, \n"
                + "xmltable('$w/companies/company' passing a.work_history as \"w\"\n"
                + "columns companyID integer path '@id',\n"
                + "     company_name varchar(100) path 'name',\n"
                + "	street varchar(100) path 'address/street',\n"
                + "	city varchar(100) path 'address/city',\n"
                + "	zipcode varchar(50) path 'address/zipcode',\n"
                + "	phone varchar(25) path 'phone') as wh WHERE a.applicant_id = ?";
        //System.out.println(query);
        ArrayList<CompanyBean> al = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, username, password); PreparedStatement pstm = conn.prepareStatement(query)) {
            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    CompanyBean mymodel = new CompanyBean();
                    mymodel.setCompanyId(rs.getInt("companyID"));
                    mymodel.setCompanyName(rs.getString("company_name"));
                    mymodel.setStreet(rs.getString("street"));
                    mymodel.setCity(rs.getString("city"));
                    mymodel.setZipCode(rs.getString("zipcode"));
                    mymodel.setPhone(rs.getString("phone"));
                    al.add(mymodel);
                }
            }
        }

        return al;
    }

    public static CompanyBean getWorkHistoryData(int companyId, int id) throws SQLException {
        String query = "SELECT wh.companyID, wh.company_name, wh.street, wh.city, wh.zipcode, wh.phone from " + table + " a, \n"
                + "xmltable('$w/companies/company[@id=\"" + companyId + "\"]' passing a.work_history as \"w\"\n"
                + "columns companyID integer path '@id',\n"
                + "     company_name varchar(100) path 'name',\n"
                + "	street varchar(100) path 'address/street',\n"
                + "	city varchar(100) path 'address/city',\n"
                + "	zipcode varchar(50) path 'address/zipcode',\n"
                + "	phone varchar(25) path 'phone') as wh WHERE a.applicant_id = ?";
        System.out.println(query);
        CompanyBean mymodel = new CompanyBean();

        try (Connection conn = DriverManager.getConnection(url, username, password); PreparedStatement pstm = conn.prepareStatement(query)) {
            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {

                    mymodel.setCompanyId(rs.getInt("companyID"));
                    mymodel.setCompanyName(rs.getString("company_name"));
                    mymodel.setStreet(rs.getString("street"));
                    mymodel.setCity(rs.getString("city"));
                    mymodel.setZipCode(rs.getString("zipcode"));
                    mymodel.setPhone(rs.getString("phone"));
                }
            }
        }

        return mymodel;
    }
}
