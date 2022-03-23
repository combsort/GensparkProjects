public class Counter {
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private int value;

    public void incrementValue(){
        this.value++;
    }

}
