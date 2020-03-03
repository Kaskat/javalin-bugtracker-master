package app.Entities.Type;

/**
 * Class of issue's type
 */
public class Type {
    String typeId;
    String typeName;

    /**
     * Default constructor
     */
    public Type() {
    }

    /**
     * Type ID getter
     * @return type ID
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     * Type ID setter
     * @param typeId type ID
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    /**
     * Type name getter
     * @return type name
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * Type name setter
     * @param typeName type name
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "Type{" +
                "typeId='" + typeId + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
