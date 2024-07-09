package net.raeen.aetheriusmod.recruitment;

import java.util.List;

public class RecruitmentListing {
    private String recruiter;
    private String criteria;
    private List<String> candidates;

    public RecruitmentListing(String recruiter, String criteria) {
        this.recruiter = recruiter;
        this.criteria = criteria;
    }

    public String getRecruiter() {
        return recruiter;
    }

    public String getCriteria() {
        return criteria;
    }

    public List<String> getCandidates() {
        return candidates;
    }

    public void updateListing(String criteria, List<String> candidates) {
        this.criteria = criteria;
        this.candidates = candidates;
    }

    public void displayListing() {
        // Display recruitment listing
    }
}
