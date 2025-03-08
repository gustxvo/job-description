package br.com.gustavoalmeidacarvalho.jobdescription.domain.report;

public enum CompanyAffiliation {

    ACME_LLC("LLC"),
    ACME_LATAM("LATAM"),
    ACME_EU("EU"),
    ACME_US("NA"),
    ACME_AS("AS"),
    ACME_AF("AF"),
    ACME_OC("OC");

    private final String affiliation;

    CompanyAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getAffilite() {
        return "ACME " + affiliation;
    }

}
