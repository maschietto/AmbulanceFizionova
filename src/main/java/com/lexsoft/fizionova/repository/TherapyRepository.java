package com.lexsoft.fizionova.repository;

import com.lexsoft.fizionova.repository.mapper.TherapyMapper;
import com.lexsoft.fizionova.repository.model.Therapy;
import com.lexsoft.fizionova.repository.model.complexmodel.TherapyComplex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Repository
public class TherapyRepository {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    TherapyMapper therapyMapper;

    public Therapy findLastInsertedIdTherapy(Integer idPatient){
        return therapyMapper.findLastInsertedIdTherapy(idPatient);
    }

    public int insertTherapy(Therapy therapy) throws ParseException {
        Date therapyTime;
        String convertedTherapyTime = null;
        if (therapy.getStartTherapyTime() != null) {
            therapyTime = sdf.parse(therapy.getStartTherapyTime());
            convertedTherapyTime = sdf.format(therapyTime);
        }

        return therapyMapper.insert(therapy.getDocumentId(), convertedTherapyTime,therapy.getCreateEmployeeId(),
                                    therapy.getVerifiedEmployeeId(),therapy.getTherapyTypeIds(), therapy.getIdPatient(), therapy.getVerified());

    }

    public void updateTherapy(Therapy therapy) throws ParseException  {
        Date therapyTime;
        String convertedTherapyTime = null;
        if (therapy.getStartTherapyTime() != null) {
            therapyTime = sdf.parse(therapy.getStartTherapyTime());
            convertedTherapyTime = sdf.format(therapyTime);
        }
        therapyMapper.update(convertedTherapyTime,therapy.getVerifiedEmployeeId(),
                             therapy.getIdTherapy(),therapy.getTherapyTypeIds(), therapy.getIdPatient(), therapy.getVerified());
    }
    public List<Therapy> findTherapiesByPatientId (Integer idPatient){
        return therapyMapper.findTherapiesByPatientId(idPatient);
    }

    public Therapy findTherapyById(Integer therapyId){
        return therapyMapper.findTherapyById(therapyId);
    }

    public List<Therapy> findTherapyByParams(Integer documentId) throws ParseException {

         return therapyMapper.findTherapyByParams(documentId);
    }

    public void deleteTherapy(Integer id){
        therapyMapper.deleteTherapy(id);
    }

    public void deleteTherapyByDocId(Integer documentId){
        therapyMapper.deleteTherapyByDocumentId(documentId);
    }

    public List<TherapyComplex> findTherapiesBeewteenTwoDates(Date dateFrom, Date dateTo){
        return therapyMapper.findTherapyByDate(dateFrom,dateTo);
    }


    public Therapy findLastNotModifiedTherapyFromDoc(Integer docId){
      return therapyMapper.findLastNotVerifiedTherapy(docId);
    }


}
