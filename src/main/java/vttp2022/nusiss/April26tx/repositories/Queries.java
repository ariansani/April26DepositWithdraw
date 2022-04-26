package vttp2022.nusiss.April26tx.repositories;

public interface Queries {

    public static final String SQL_INCREASE_BALANCE_OF_ACCOUNT = "UPDATE account SET balance = balance + ? WHERE acct_no like '?'";
    public static final String SQL__DECREASE_BALANCE_OF_ACCOUNT = "UPDATE account SET balance = balance - ? WHERE acct_no like '?'";
    public static final String SQL_GET_BALANCE = "SELECT balance FROM account WHERE acct_no = ?";
    
}
