package com.lexsoft.fizionova.repository.model.joinDomain;

import java.util.Date;

/**
 * Created by Maschietto on 2/15/17.
 */

public class DocumentCollection {
//document
    private Integer documentId;
    private String diagnose;
    private String functionalDiagnose;
    private String description;
    private String skeletImagePath;
    private String therapyDetails;
    private String therapyPurpose;
    private String therapyPlan;
    private String therapyMarks;
    private String therapyConclusion;
    private String registerNumber;
    private Date dateCreate;

    //employee
    private Integer idEmployee;
    private String employee_name;
    private String employe_lastname;
    private String employee_jobTitle;
//patient
    private Integer idPatient;
    private String name;
    private String lastname;
    private String middlename;
    private String personalId;
    private String gender;
    private String age;
    private String email;
    private String jobTitle;
    private String phone1;
    private String phone2;
    private String pathToPatientImage;
    private Boolean isForeigner;
//adress of patient
    private Integer adressId;
    private String city;
    private String state;
    private String streetName;

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public String getFunctionalDiagnose() {
        return functionalDiagnose;
    }

    public void setFunctionalDiagnose(String functionalDiagnose) {
        this.functionalDiagnose = functionalDiagnose;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSkeletImagePath() {
        return skeletImagePath;
    }

    public void setSkeletImagePath(String skeletImagePath) {
        this.skeletImagePath = skeletImagePath;
    }

    public String getTherapyDetails() {
        return therapyDetails;
    }

    public void setTherapyDetails(String therapyDetails) {
        this.therapyDetails = therapyDetails;
    }

    public String getTherapyPurpose() {
        return therapyPurpose;
    }

    public void setTherapyPurpose(String therapyPurpose) {
        this.therapyPurpose = therapyPurpose;
    }

    public String getTherapyPlan() {
        return therapyPlan;
    }

    public void setTherapyPlan(String therapyPlan) {
        this.therapyPlan = therapyPlan;
    }

    public String getTherapyMarks() {
        return therapyMarks;
    }

    public void setTherapyMarks(String therapyMarks) {
        this.therapyMarks = therapyMarks;
    }

    public String getTherapyConclusion() {
        return therapyConclusion;
    }

    public void setTherapyConclusion(String therapyConclusion) {
        this.therapyConclusion = therapyConclusion;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmploye_lastname() {
        return employe_lastname;
    }

    public void setEmploye_lastname(String employe_lastname) {
        this.employe_lastname = employe_lastname;
    }

    public String getEmployee_jobTitle() {
        return employee_jobTitle;
    }

    public void setEmployee_jobTitle(String employee_jobTitle) {
        this.employee_jobTitle = employee_jobTitle;
    }

    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
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

    public String getPathToPatientImage() {
        return pathToPatientImage;
    }

    public void setPathToPatientImage(String pathToPatientImage) {
        this.pathToPatientImage = pathToPatientImage;
    }

    public Boolean getForeigner() {
        return isForeigner;
    }

    public void setForeigner(Boolean foreigner) {
        isForeigner = foreigner;
    }

    public Integer getAdressId() {
        return adressId;
    }

    public void setAdressId(Integer adressId) {
        this.adressId = adressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
}
