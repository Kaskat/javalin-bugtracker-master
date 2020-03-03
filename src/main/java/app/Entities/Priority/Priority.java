package app.Entities.Priority;

/**
 * Class of issue's priorities
 */
public class Priority {

    String priorityId;
    String priorityName;

    /**
     * Default constructor
     */
    public Priority() {

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
     * @param priority_id issue's priorityId
     */
    public void setPriorityId(String priority_id) {
        this.priorityId = priority_id;
    }

    /**
     * Issue's priorityName getter
     * @return issue's priorityName
     */
    public String getPriorityName() {
        return priorityName;
    }

    /**
     * Issue's priorityName setter
     * @param priorityName issue's priorityName
     */
    public void setPriorityName(String priorityName) {
        this.priorityName = priorityName;
    }

    @Override
    public String toString() {
        return "Priority{" +
                "priority_id='" + priorityId + '\'' +
                ", priorityName='" + priorityName + '\'' +
                '}';
    }
}
