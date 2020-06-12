package com.lexsoft.fizionova.repository.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee {

    private Integer idEmployee;
    private String username;
    private String password;
    private String name;
    private String lastname;
    private String middlename;
    private String personalId;
    private String email;
    private Integer adressId;
    private Boolean admin;
    private Boolean verifyTherapy;
    private Boolean createDoc;
    private Boolean viewDoc;
    private String phone1;
    private String phone2;
    private String pathToEmployeeImage;
    private Boolean isForeigner;
    private String roleName;
    private String jobTitle;

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    public Boolean getForeigner() {
        return isForeigner;
    }

    public void setForeigner(Boolean foreigner) {
        isForeigner = foreigner;
    }

    public String getPathToEmployeeImage() {
        return pathToEmployeeImage;
    }

    public void setPathToEmployeeImage(String pathToEmployeeImage) {
        this.pathToEmployeeImage = pathToEmployeeImage;
    }



    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAdressId() {
        return adressId;
    }

    public void setAdressId(Integer adressId) {
        this.adressId = adressId;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Boolean getVerifyTherapy() {
        return verifyTherapy;
    }

    public void setVerifyTherapy(Boolean verifyTherapy) {
        this.verifyTherapy = verifyTherapy;
    }

    public Boolean getCreateDoc() {
        return createDoc;
    }

    public void setCreateDoc(Boolean createDoc) {
        this.createDoc = createDoc;
    }

    public Boolean getViewDoc() {
        return viewDoc;
    }

    public void setViewDoc(Boolean viewDoc) {
        this.viewDoc = viewDoc;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }
}
