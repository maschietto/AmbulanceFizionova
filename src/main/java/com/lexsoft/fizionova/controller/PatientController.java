package com.lexsoft.fizionova.controller;

import com.lexsoft.fizionova.exception.BussinesException;
import com.lexsoft.fizionova.propertyBean.MyBean;
import com.lexsoft.fizionova.repository.PatientRepository;
import com.lexsoft.fizionova.repository.model.Patient;
import com.lexsoft.fizionova.service.PatientService;
import com.lexsoft.fizionova.validator.AdressValidator;
import com.lexsoft.fizionova.validator.PatientValidator;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by Maschietto on 2/14/17.
 */
@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    PatientService patientService;
    @Autowired
    PatientValidator patientValidator;
    @Autowired
    AdressValidator adressValidator;
    @Autowired
    MyBean myBean;

    //  GET PATIENT BY NAME, LASTNAME AND PHONE OR ALL PATIENTS
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getPatients(@RequestParam(value = "name", required = false) String name,
                                      @RequestParam(value = "lastname", required = false) String lastname,
                                      @RequestParam(value = "phone", required = false) String phone) throws BussinesException {
        patientValidator.validateAlphaParam(name, "name");
        patientValidator.validateAlphaParam(lastname, "lastname");
        patientValidator.validateNumericParam(phone, "phone");

        return patientService.getPatients(name, lastname, phone);
    }

    //GET PATIENT BY ID
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity getPatientById(@PathVariable(value = "id") Integer id) throws BussinesException {
        patientValidator.validateNumericParam(String.valueOf(id), "id");

        return patientService.getPatientById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity savePatient(@RequestBody(required = true) Patient patient) throws BussinesException {
        System.out.println("jesam usao");
        patientValidator.validatePatientRequestBody(patient);
        adressValidator.validateAdressRequestBody(patient.getAdress());

        return patientService.savePatient(patient);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updatePatient(@RequestBody Patient patient) throws BussinesException {
        patientValidator.validatePatientRequestBody(patient);
        adressValidator.validateAdressRequestBody(patient.getAdress());
        return patientService.updatePatient(patient);

    }

    @RequestMapping(value = "/downloadPatientPicture", method = RequestMethod.GET)
    public void getFileTest(HttpServletResponse response, @RequestParam("name") String name) {

        try {
            File f = new File(myBean.getSystemPathRoot() + File.separator +
                    "AmbulanceFizionova/patientsImages" + File.separator + name);
            InputStream inputStream = new FileInputStream(f);
            IOUtils.copy(inputStream, response.getOutputStream());
            inputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();

        }
    }


    @RequestMapping(value = "/uploadPatientPicture", method = RequestMethod.POST)
    @ResponseBody
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                String root = myBean.getSystemPathRoot() + File.separator + "AmbulanceFizionova/patientsImages";
                File f = new File(root);
                if (!f.exists()) {
                    f.mkdirs();
                }
                File newFile = new File(root + File.separator + "test.jpg");
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(newFile));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + file.getName() + " into " + root;
            } catch (Exception e) {
                e.printStackTrace();
                return "You failed to upload " + file.getName() + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + file.getName() + " because the file was empty.";
        }

    }


    @ExceptionHandler({BussinesException.class})
    void handleBadRequests(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

}
