package app.Entities.Issue;

import app.Entities.Project.Project;
import app.Entities.User.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;


@JsonDeserialize(using = IssueDeserializer.class)

/**
 * Class of issue entity
 */
public class Issue {
    @JsonInclude(NON_NULL)
    String id;
    @JsonInclude(NON_NULL)
    String statusId;
    @JsonInclude(NON_NULL)
    String priorityId;
//    @JsonInclude(NON_NULL)
//    String number;
    @JsonInclude(NON_NULL)
    String summary;
    @JsonInclude(NON_NULL)
    String description;
    @JsonInclude(NON_NULL)
    String assigneeId;
    @JsonInclude(NON_NULL)
    String projectId;
    @JsonInclude(NON_NULL)
    Project project;
    @JsonInclude(NON_NULL)
    User assignee;

    /**
     * Default constructor
     */
    public Issue() {

    }

    /**
     * Issue constructor with parameter
     * @param project issue's project
     */
    public Issue(Project project) {
        this.project = project;
    }

    /**
     * Issue constructor with parameters
     * @param summary issue's summary
     * @param description issue's description
     * @param priorityId issue's priorityId
     * @param statusId issue's statusId
     * @param project issue's project
     * @param assignee issue's assignee
     */
    public Issue(String summary, String description, String priorityId, String statusId, Project project, User assignee) {
        this.summary = summary;
        this.description = description;
        this.priorityId = priorityId;
        this.statusId = statusId;
        this.project = project;
        this.assignee = assignee;
    }

    /**
     * Issue's assignee getter
     * @return issue's assignee
     */
    public User getAssignee() {
        return assignee;
    }

    /**
     * Issue's assignee setter
     * @param assignee issue's assignee
     */
    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    /**
     * Issue's ID getter
     * @return issue's ID
     */
    public String getId() {
        return id;
    }

    /**
     * Issue's ID setter
     * @param id issue's ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Issues statusId getter
     * @return issue's statusId
     */
    public String getStatusId() {
        return statusId;
    }

    /**
     * Issue's statusId setter
     * @param statusId issue's statusId
     */
    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    /**
     * Issue's priorityId getter
     * @return issue's priorityId
     */
    public String getPriorityId() {
        return priorityId;
    }

    /**
     * Issue's priorityId setter
     * @param priorityId issue's priorityId
     */
    public void setPriorityId(String priorityId) {
        this.priorityId = priorityId;
    }

    /**
     * Issue's summary getter
     * @return issue's summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * Issue's summary setter
     * @param summary issue's summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * Issue's description getter
     * @return issue's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Issue's description setter
     * @param description issue's description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Issue's assigneeId getter
     * @return issue's assigneeId
     */
    public String getAssigneeId() {
        return assigneeId;
    }

    /**
     * Issue's assigneeId setter
     * @param assigneeId issue's assigneeId
     */
    public void setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
    }

    /**
     * Issue's projectId getter
     * @return issue's projectId
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * Issue's projectId setter
     * @param projectId issue's projectId
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

<<<<<<< HEAD
//    public String getNumber() {
//        return number;
//    }
//
//    public void setNumber(String number) {
//        this.number = number;
//    }
=======
    /**
     * Issue's number getter
     * @return issue's number
     */
    public String getNumber() {
        return number;
    }

    /**
     * Issue's number setter
     * @param number issue's number
     */
    public void setNumber(String number) {
        this.number = number;
    }
>>>>>>> 2df19134e9b8ecea23a77e00b79c1708be042c41

    /**
     * Issue's project getter
     * @return issue's project
     */
    public Project getProject() {
        return project;
    }

    /**
     * Issue's project setter
     * @param project issue's project
     */
    public void setProject(Project project) {
        this.project = project;
    }

    /**
     * Issue constructor with parameters to create issue object
     * @param statusId issue's statusId
     * @param priorityId issue's priorityId
     * @param issueId issue's issueId
     * @param summary issue's summary
     * @param description issue's description
     * @param assigneeId issue's assigneeId
     * @param projectId issue's projectId
     */
    public Issue (
            String statusId,
            String priorityId,
            String issueId,
            String summary,
            String description,
            String assigneeId,
            String projectId
    ) {
        this.statusId = statusId;
        this.priorityId = priorityId;
        this.summary = summary;
        this.description = description;
        this.assigneeId = assigneeId;
        this.projectId = projectId;
    }

    /**
     * Issue constructor to create issue object from resultSet
     * @param resultSet resultSet object to transform into issue object
     */
    public Issue (ResultSet resultSet) {
        try {
            this.statusId = resultSet.getString("status_id");
            this.priorityId = resultSet.getString("priority_id");
            this.id = resultSet.getString("issue_id");
            this.summary = resultSet.getString("summary");
            this.description = resultSet.getString("description");
            this.assigneeId = resultSet.getString("assigne_id");
            this.projectId = resultSet.getString("project_id");
        } catch (SQLException e) {
            System.out.println("SQL error occurred: " + e.getMessage());
        }
    }

    /**
     * Issue constructor with parameter to create issue object
     * @param projectId parameter to create issue object
     */
    public Issue (int projectId) {
        this.projectId = String.valueOf(projectId);
    }

<<<<<<< HEAD
//    @Override
//    public String toString() {
//        return "Issue{" +
//                "id='" + id + '\'' +
//                ", statusId='" + statusId + '\'' +
//                ", priorityId='" + priorityId + '\'' +
//                ", number='" + number + '\'' +
//                ", summary='" + summary + '\'' +
//                ", description='" + description + '\'' +
//                ", assigneId='" + assigneId + '\'' +
//                ", projectId='" + projectId + '\'' +
//                '}';
//    }
=======
    @Override
    public String toString() {
        return "Issue{" +
                "id='" + id + '\'' +
                ", statusId='" + statusId + '\'' +
                ", priorityId='" + priorityId + '\'' +
                ", number='" + number + '\'' +
                ", summary='" + summary + '\'' +
                ", description='" + description + '\'' +
                ", assigneId='" + assigneeId + '\'' +
                ", projectId='" + projectId + '\'' +
                '}';
    }
>>>>>>> 2df19134e9b8ecea23a77e00b79c1708be042c41
}
