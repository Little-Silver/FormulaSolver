package model;
public class OperationHelpEntry
{
    private String operation;
    private String description;
    private String example;

    public OperationHelpEntry(String operation, String description, String example){
        this.operation = operation;
        this.description = description;
        this.example = example;
    }

    public String getOperation()
    {
        return operation;
    }

    public String getDescription()
    {
        return description;
    }

    public String getExample()
    {
        return example;
    }

    public void setOperation(String operation)
    {
        this.operation = operation;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setExample(String example)
    {
        this.example = example;
    }
}
