package hexlet.code;

public final class DifferValue {
    private final String status;
    private final Object valueOne;
    private Object valueTwo;

    public DifferValue(String statusOther, Object valueOneOther, Object valueTwoOther) {
        this.status = statusOther;
        this.valueOne = valueOneOther;
        this.valueTwo = valueTwoOther;
    }
    public DifferValue(String statusOther, Object valueOneOther) {
        this.status = statusOther;
        this.valueOne = valueOneOther;
    }

    public String getStatus() {
        return status;
    }

    public Object getValueOne() {
        return valueOne;
    }

    public Object getValueTwo() {
        return valueTwo;
    }
}
