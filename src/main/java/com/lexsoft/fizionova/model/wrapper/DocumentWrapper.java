package com.lexsoft.fizionova.model.wrapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.lexsoft.fizionova.repository.model.Document;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocumentWrapper {

    Document document;
    private List<TherapyWrapperDoc> therapyWrappers;

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public List<TherapyWrapperDoc> getTherapyWrappers() {
        return therapyWrappers;
    }

    public void setTherapyWrappers(List<TherapyWrapperDoc> therapyWrappers) {
        this.therapyWrappers = therapyWrappers;
    }
}
