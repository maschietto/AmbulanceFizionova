package com.lexsoft.fizionova.controller;

import com.lexsoft.fizionova.exception.BussinesException;
import com.lexsoft.fizionova.repository.model.EnumDiagnoseType;
import com.lexsoft.fizionova.service.EnumDiagnoseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Maschietto on 2/14/17.
 */
@Controller
@RequestMapping("/diagnoses")
public class EnumDiagnoseTypeController {

    @Autowired
    EnumDiagnoseTypeService enumDiagnoseTypeService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getEnumDiagnoseTypeByParam(@RequestParam(value = "name", required = false) String name,
                                       @RequestParam(value = "id", required = false) Integer id) throws BussinesException {
        return enumDiagnoseTypeService.findDiagnoseByParam(id, name);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity saveEnumDiagnoseType(@RequestBody EnumDiagnoseType enumDiagnoseType) throws BussinesException {
        return enumDiagnoseTypeService.insertEnumDiagnoseType(enumDiagnoseType);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateEnumDiagnoseType(@RequestBody EnumDiagnoseType enumDiagnoseType) throws BussinesException {
        return enumDiagnoseTypeService.updateDiagnoseType(enumDiagnoseType);
    }

    @RequestMapping(method = RequestMethod.DELETE, value ="/{id}")
    public ResponseEntity deleteEnumDiagnoseType(@PathVariable(value = "id") Integer id) throws BussinesException {
        return enumDiagnoseTypeService.deleteEnumDiagnoseType(id);
    }

    @ExceptionHandler({BussinesException.class})
    void handleBadRequests(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

}
