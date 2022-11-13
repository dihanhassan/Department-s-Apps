package com.example.imageslide;

public class dataHolderForBugReport {

    String id,bugText;

    public dataHolderForBugReport(String id, String bugText) {
        this.id = id;
        this.bugText = bugText;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBugText() {
        return bugText;
    }

    public void setBugText(String bugText) {
        this.bugText = bugText;
    }
}
