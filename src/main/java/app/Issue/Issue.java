package app.Issue;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;

public class Issue {
    @JsonInclude(NON_DEFAULT)
    int statusId;
    @JsonInclude(NON_DEFAULT)
    int priorityId;
    @JsonInclude(NON_NULL)
    String issueId;
    @JsonInclude(NON_NULL)
    String number;
    @JsonInclude(NON_NULL)
    String name;
    @JsonInclude(NON_NULL)
    String summary;
    @JsonInclude(NON_NULL)
    String description;
    @JsonInclude(NON_NULL)
    String assigneId;
    @JsonInclude(NON_NULL)
    String projectId;

    public Issue() {

    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(int priorityId) {
        this.priorityId = priorityId;
    }

    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssigneId() {
        return assigneId;
    }

    public void setAssigneId(String assigneId) {
        this.assigneId = assigneId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    //constructor
    public Issue (
        int statusId,
        int priorityId,
        String issueId,
        String name,
        String summary,
        String description,
        String assigneId,
        String projectId
    ) {
        this.statusId = statusId;
        this.priorityId = priorityId;
        this.issueId = issueId;
        this.name = name;
        this.summary = summary;
        this.description = description;
        this.assigneId = assigneId;
        this.projectId = projectId;
    }

    public Issue (ResultSet resultSet) {
        try {
            this.statusId = resultSet.getInt("status_id");
            this.priorityId = resultSet.getInt("priority_id");
            this.issueId = resultSet.getString("issue_id");
            this.name = resultSet.getString("name");
            this.summary = resultSet.getString("summary");
            this.description = resultSet.getString("description");
            this.assigneId = resultSet.getString("assigne_id");
            this.projectId = resultSet.getString("project_id");
        } catch (SQLException e) {
            System.out.println("SQL error occurred: " + e.getMessage());
        }
    }

    public Issue (int projectId) {
        this.projectId = String.valueOf(projectId);
    }

    @Override
    public String toString() {
        return "{ \"statusId\": \"" + statusId +
                "\", \"priorityId\": \"" + priorityId +
                "\", \"issueId\": \"" + issueId +
                "\", \"number\": \"" + number +
                "\", \"name\": \"" + name +
                "\", \"summary\": \"" + summary +
                "\", \"description\": \"" + description +
                "\", \"assigneeId\": \"" + assigneId +
                "\", \"projectId\": \"" + projectId +
                " }";
    }
}
