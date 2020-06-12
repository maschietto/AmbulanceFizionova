
  CREATE TABLE Adress
(
    adress_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    street_name VARCHAR(50) NOT NULL,
    street_number INT(11) NOT NULL,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    update_date TIMESTAMP DEFAULT '0000-00-00 00:00:00' NOT NULL
);
CREATE TABLE Document
(
    document_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    diagnose VARCHAR(5000),
    functional_diagnose VARCHAR(5000),
    description VARCHAR(5000),
    skelet_image_path VARCHAR(20000),
    therapy_details VARCHAR(5000),
    therapy_purpose VARCHAR(5000),
    therapy_plan VARCHAR(5000),
    therapy_marks VARCHAR(5000),
    therapy_conclusion VARCHAR(5000),
    date_create TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    date_update TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    patient_id INT(11),
    employee_id INT(11),
    register_number VARCHAR(50)
);
CREATE TABLE Employee
(
    employee_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    name VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    middlename VARCHAR(50) NOT NULL,
    personal_id VARCHAR(50) NOT NULL,
    email VARCHAR(50),
    adress_id INT(11),
    is_admin TINYINT(1),
    verify_therapy TINYINT(1),
    create_doc TINYINT(1),
    view_doc TINYINT(1),
    phone_1 VARCHAR(50) NOT NULL,
    phone_2 VARCHAR(50),
    path_to_employee_image VARCHAR(200),
    is_foreigner TINYINT(1),
    date_create TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    date_update TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    role_name VARCHAR(50)
);
CREATE TABLE Enum_Therapy_Type
(
    enum_therapy_type_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    therapy_name VARCHAR(100)
);
CREATE TABLE First_Exam
(
    first_exam_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    phone_number VARCHAR(50) NOT NULL,
    exam_start_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    update_date TIMESTAMP DEFAULT '0000-00-00 00:00:00' NOT NULL
);
CREATE TABLE Patient
(
    patient_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    middlename VARCHAR(50) NOT NULL,
    personal_id VARCHAR(50) NOT NULL,
    gender VARCHAR(50),
    age VARCHAR(50),
    email VARCHAR(50),
    adress_id INT(11),
    job_title VARCHAR(50),
    phone_1 VARCHAR(50) NOT NULL,
    phone_2 VARCHAR(50),
    path_to_patient_image VARCHAR(200),
    is_foreigner TINYINT(1),
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    update_date TIMESTAMP DEFAULT '0000-00-00 00:00:00' NOT NULL,
    employee_id INT(11)
);
CREATE TABLE Therapy
(
    therapy_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    document_id INT(11),
    start_therapy_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    create_employee_id INT(11),
    verified_employee_id INT(11),
    therapy_type_ids VARCHAR(1500),
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    update_date TIMESTAMP DEFAULT '0000-00-00 00:00:00' NOT NULL
);