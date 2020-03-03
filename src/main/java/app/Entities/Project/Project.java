package app.Entities.Project;

/**
 * Class of issue's project
 */
public class Project {

    String projectId;
    String projectName;

    /**
     * Constructor with parameters to create Project object
     * @param projectId issue's projectId
     * @param projectName project name
     */
    public Project(String projectId, String projectName) {
        this.projectId = projectId;
        this.projectName = projectName;
    }

    /**
     * Default constructor
     */
    public Project() {

    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId='" + projectId + '\'' +
                ", projectName='" + projectName + '\'' +
                '}';
    }

    /**
     * Project ID getter
     * @return project ID
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * Project ID setter
     * @param projectId project ID
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * Project name getter
     * @return project name
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * Project name setter
     * @param projectName project name
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
