package app.Entities.Issue;

import java.util.ArrayList;

/**
 * Class of collection with issue object
 */
public class IssueList {
    public ArrayList<Issue> issues = new ArrayList<>();

    /**
     * Function to add issue into ArrayList of issues
     * @param issue Issue object to add into ArrayList
     */
    public void addToIssues (Issue issue) {
        issues.add(issue);
    }

    /**
     * Function to delete issue object from ArrayList of issues
     * @param issue Issue object to remove from ArrayList
     */
    public void deleteIssue (Issue issue) {
        issues.remove(issue);
    }

    @Override
    public String toString() {
        return "{ \"Issues\": [ " + issues + " ] }";
    }
}
