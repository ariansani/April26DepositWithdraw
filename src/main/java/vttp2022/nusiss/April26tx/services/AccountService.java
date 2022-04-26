package vttp2022.nusiss.April26tx.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2022.nusiss.April26tx.exceptions.BalanceException;
import vttp2022.nusiss.April26tx.repositories.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accRepo;

    public void deposit(String accountNo, Float amount) throws BalanceException {
        if (!accRepo.deposit(accountNo, amount))
            throw new BalanceException("Cannot deposit into your account");
    }


    public void withdraw(String accountNo, Float amount) throws BalanceException {
        Float balance = accRepo.getBalance(accountNo);
        if (amount > balance){
            throw new BalanceException("Cannot withdraw, u broke");
            
        }

        accRepo.withdraw(accountNo, amount);
            
    }
}
