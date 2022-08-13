package com.softserve.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompanyDTO {
    @JsonProperty(value = "name")
    private String companyName;
    private String catchPhrase;
    private String bs;


    public String getCompanyName() {
        return companyName;
    }

    public CompanyDTO setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public CompanyDTO setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
        return this;
    }

    public String getBs() {
        return bs;
    }

    public CompanyDTO setBs(String bs) {
        this.bs = bs;
        return this;
    }
}
