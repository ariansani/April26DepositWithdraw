package vttp2022.nusiss.April26tx.repositories;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository {
    //deposit/withdraw
    @Autowired
    private JdbcTemplate template;

    public boolean deposit(String accountNo, Float amount){
        int count = template.update(Queries.SQL_INCREASE_BALANCE_OF_ACCOUNT,amount ,accountNo);
        
        return 1 == count;

    }
    public boolean withdraw(String accountNo, Float amount){
        int count = template.update(Queries.SQL__DECREASE_BALANCE_OF_ACCOUNT, amount, accountNo);
        return 1 == count;
    }

    public Float getBalance(String accountNo){
        final SqlRowSet rs = template.queryForRowSet(Queries.SQL_GET_BALANCE,accountNo);
        
        Float balance = 0f;
        while (rs.next()) {
           balance = rs.getFloat("balance");
        }
        
        return balance;

    }

}
