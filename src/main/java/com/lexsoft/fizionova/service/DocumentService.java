package com.lexsoft.fizionova.service;

import com.lexsoft.fizionova.exception.BussinesException;
import com.lexsoft.fizionova.model.wrapper.DocumentWrapper;
import com.lexsoft.fizionova.model.wrapper.TherapyWrapperDoc;
import com.lexsoft.fizionova.repository.DocumentRepository;
import com.lexsoft.fizionova.repository.EnumTherapyTypeRepository;
import com.lexsoft.fizionova.repository.TherapyRepository;
import com.lexsoft.fizionova.repository.model.Document;
import com.lexsoft.fizionova.repository.model.EnumTherapyType;
import com.lexsoft.fizionova.repository.model.Therapy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentService {

    @Autowired
    DocumentRepository documentRepository;
    @Autowired
    TherapyRepository therapyRepository;
    @Autowired
    EnumTherapyTypeRepository enumTherapyTypeRepository;


    @Transactional
    public ResponseEntity saveDocument(Document document) throws BussinesException {
        documentRepository.insertDocument(document);
        Document doc = documentRepository.getLastCreateDocByPatientId(document.getIdPatient());
        return ResponseEntity.status(HttpStatus.CREATED).body(doc);
    }

    public ResponseEntity findDocumentsByParam(String patientId, String documentId, String registerNumber) throws ParseException {
        Integer patientIdNum = null;
        Integer documentIdNum = null;
        if (patientId != null) patientIdNum = Integer.valueOf(patientId);
        if (documentId != null) documentIdNum = Integer.valueOf(documentId);
        List<Document> documents = documentRepository.findDocumentsByParam(patientIdNum, documentIdNum, registerNumber);
        if (!documents.isEmpty()) {
            if (documents.size() == 1) {
                List<Therapy> documentTherapies = therapyRepository.findTherapyByParams(documents.get(0).getDocumentId());
                documents.get(0).setTerapies(documentTherapies);
                return ResponseEntity.ok(documents);
            } else {
                return ResponseEntity.ok(documents);
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Transactional
    public ResponseEntity updateDocument(Document document) {
        Document document1 = documentRepository.getDocumentById(document.getDocumentId());
        if (document1 != null) {
            documentRepository.updateDocument(document);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    public ResponseEntity findDocumentByRegisterNumber(String registerNumber) throws ParseException {
        Document document = documentRepository.getDocumentByRegisterNumber(registerNumber);
        if (document != null) {
            List<Therapy> documentTherapies = therapyRepository.findTherapyByParams(document.getDocumentId());
            document.setTerapies(documentTherapies);
            return ResponseEntity.ok(document);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Transactional
    public ResponseEntity findDocumentById(Integer documentId) throws ParseException {
        Document document = documentRepository.getDocumentById(documentId);
        if (document != null) {
            List<Therapy> documentTherapies = therapyRepository.findTherapyByParams(document.getDocumentId());
            document.setTerapies(documentTherapies);
            return ResponseEntity.ok(document);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @Transactional
    public ResponseEntity findDocumentWrapperById(Integer documentId) throws ParseException {
        Document document = documentRepository.getDocumentById(documentId);
        if (document != null) {
            DocumentWrapper documentWrapper = new DocumentWrapper();
            documentWrapper.setDocument(document);

            List<Therapy> therapyList = therapyRepository.findTherapyByParams(documentId);
            if (therapyList != null && !therapyList.isEmpty()) {
                List<TherapyWrapperDoc> therapyWrapper = new ArrayList<>();
                for (Therapy t : therapyList) {
                    TherapyWrapperDoc therapyWrapperDoc = new TherapyWrapperDoc();
                    therapyWrapperDoc.setTherapy(t);
                    String therapyTypeIds = t.getTherapyTypeIds();
                    String[] therapyTypesIdsSplit = therapyTypeIds.split(",");
                    List<EnumTherapyType> therapyTypes = new ArrayList<>();
                    for (String s : therapyTypesIdsSplit) {
                        List<EnumTherapyType> enumTherapyTypes = enumTherapyTypeRepository.findEnumTherapyTypeByParam(Integer.valueOf(s), null);
                        therapyTypes.add(enumTherapyTypes.get(0));
                    }
                    therapyWrapperDoc.setEnumTherapyTypeList(therapyTypes);
                    therapyWrapper.add(therapyWrapperDoc);
                }
                documentWrapper.setTherapyWrappers(therapyWrapper);

            }

            return ResponseEntity.ok(documentWrapper);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


    }

    @Transactional
    public ResponseEntity deleteDocumentById(Integer documentId) throws ParseException {
        Document document = documentRepository.getDocumentById(documentId);
        if (document != null) {
            List<Therapy> therapyList = therapyRepository.findTherapyByParams(documentId);
            if (therapyList != null && !therapyList.isEmpty()) {
                therapyRepository.deleteTherapyByDocId(documentId);
                documentRepository.deleteDocument(documentId);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
