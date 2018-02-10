package com.News.Entity;

public class Catalogue {
    private String catalogueid;
    private String catalogueName;
    private String catalogueDes;
    private int catalogueNumber;
    private int getCatalogueViewcount;

    public Catalogue() {
    }

    public Catalogue(String catalogueid) {
        this.catalogueid = catalogueid;
    }
    public Catalogue(String catalogueid,String catalogueName) {
        this.catalogueid = catalogueid;
        this.catalogueName = catalogueName;
    }

    public Catalogue(String catalogueid, String catalogueName, String catalogueDes, int catalogueNumber, int getCatalogueViewcount) {
        this.catalogueid = catalogueid;
        this.catalogueName = catalogueName;
        this.catalogueDes = catalogueDes;
        this.catalogueNumber = catalogueNumber;
        this.getCatalogueViewcount = getCatalogueViewcount;
    }

    public String getCatalogueid() {
        return catalogueid;
    }

    public void setCatalogueid(String catalogueid) {
        this.catalogueid = catalogueid;
    }

    public String getCatalogueName() {
        return catalogueName;
    }

    public void setCatalogueName(String catalogueName) {
        this.catalogueName = catalogueName;
    }

    public String getCatalogueDes() {
        return catalogueDes;
    }

    public void setCatalogueDes(String catalogueDes) {
        this.catalogueDes = catalogueDes;
    }

    public int getCatalogueNumber() {
        return catalogueNumber;
    }

    public void setCatalogueNumber(int catalogueNumber) {
        this.catalogueNumber = catalogueNumber;
    }

    public int getGetCatalogueViewcount() {
        return getCatalogueViewcount;
    }

    public void setGetCatalogueViewcount(int getCatalogueViewcount) {
        this.getCatalogueViewcount = getCatalogueViewcount;
    }

    @Override
    public String toString() {
        return "Catalogue{" +
                "catalogueid='" + catalogueid + '\'' +
                ", catalogueName='" + catalogueName + '\'' +
                ", catalogueDes='" + catalogueDes + '\'' +
                ", catalogueNumber=" + catalogueNumber +
                ", getCatalogueViewcount=" + getCatalogueViewcount +
                '}';
    }
}
