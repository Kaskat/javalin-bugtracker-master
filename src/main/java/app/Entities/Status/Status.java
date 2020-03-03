package app.Entities.Status;

/**
 * Class of issue's status
 */
public class Status {

    String statusId;
    String statusName;

    /**
     * Constructor with parameters to create Status object
     * @param statusId issue's status ID
     * @param statusName status name
     */
    public Status(String statusId, String statusName) {
        this.statusId = statusId;
        this.statusName = statusName;
    }

    /**
     * Default constructor
     */
    public Status() {

    }

    /**
     * Status ID getter
     * @return status ID
     */
    public String getStatusId() {
        return statusId;
    }

    /**
     * Status ID setter
     * @param statusId status ID
     */
    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    /**
     * Status name getter
     * @return status name
     */
    public String getStatusName() {
        return statusName;
    }

    /**
     * Status name setter
     * @param statusName status name
     */
    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "Status{" +
                "statusId='" + statusId + '\'' +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}
