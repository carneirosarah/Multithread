import java.io.Serializable;

public class Message implements Serializable {

    private Integer number;
    private Boolean isPrimeNumber;

    public Message(Integer number, Boolean isPrimeNumber) {

        this.number = number;
        this.isPrimeNumber = isPrimeNumber;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getPrimeNumber() {
        return isPrimeNumber;
    }

    public void setPrimeNumber(Boolean primeNumber) {
        isPrimeNumber = primeNumber;
    }
}
