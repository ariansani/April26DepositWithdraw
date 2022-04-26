package vttp2022.nusiss.April26tx.exceptions;

public class BalanceException extends Exception{
    private String reason;

    public BalanceException(String reason) {
        super();
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    
}
