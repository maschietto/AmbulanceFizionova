package com.lexsoft.fizionova.repository;

import com.lexsoft.fizionova.repository.mapper.DocumentMapper;
import com.lexsoft.fizionova.repository.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Maschietto on 2/17/17.
 */
@Repository
public class DocumentRepository {

    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @Autowired
    DocumentMapper documentMapper;


    public int insertDocument(Document document) {
        return documentMapper.insertDocument(document.getDiagnose(), document.getFunctionalDiagnose(), document.getDescription(), document.getSkeletImagePath(),
                document.getTherapyDetails(), document.getTherapyPurpose(), document.getTherapyPlan(), document.getTherapyMarks(),
                document.getTherapyConclusion(), document.getIdPatient(), document.getRegisterNumber(), document.getIdEmployee());
    }

    public Document getDocumentById(Integer documentId) {
        Document document = documentMapper.findDocumentById(documentId);
        return document;
    }


    public void updateDocument(Document document) {
        documentMapper.updateDocument(document.getDiagnose(), document.getFunctionalDiagnose(), document.getDescription(), document.getSkeletImagePath(),
                document.getTherapyDetails(), document.getTherapyPurpose(), document.getTherapyPlan(), document.getTherapyMarks(),
                document.getTherapyConclusion(), document.getDocumentId());

    }

    public List<Document> findDocumentsByParam(Integer patientId, Integer documentId, String registerNumber) {
        List<Document> documents = documentMapper.findOnlyDocsByParams(patientId, documentId, registerNumber);
        for (Document doc : documents) {
            String result = doc.getCreateDate().toString();
            doc.setCreatedDate(result);
            doc.setCreateDate(null);
        }
        return documents;
    }

    public Document getDocumentByRegisterNumber(String registerNumber) {
        Document document = documentMapper.findDocByRegisterNumber(registerNumber);
        return document;
    }

    public Document getLastCreateDocByPatientId(Integer patientId) {
        return documentMapper.getLastCreateDocByPatientId(patientId);
     }

    public void deleteDocument(Integer documentId) {
        documentMapper.deleteDocument(documentId);
    }

}