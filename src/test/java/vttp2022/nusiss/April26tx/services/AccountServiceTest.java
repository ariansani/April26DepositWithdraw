package vttp2022.nusiss.April26tx.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import vttp2022.nusiss.April26tx.exceptions.BalanceException;
import vttp2022.nusiss.April26tx.repositories.AccountRepository;

@SpringBootTest
public class AccountServiceTest {

    @Autowired
    private AccountService accSvc;

    @MockBean
    private AccountRepository accRepo;

    @Test
    void testDeposit() throws BalanceException {

        Boolean inserted = true;

        Mockito.when(accRepo.deposit("arian", 50.0f))
            .thenReturn(inserted);
        accSvc.deposit("arian",50.0f);
        assertTrue(inserted,"success");

    }

    @Test
    void testWithdraw() throws BalanceException {
        Boolean withdrawn = true;

        Mockito.when(accRepo.withdraw("arian", 50.0f))
            .thenReturn(withdrawn);
        assertTrue(withdrawn,"success");


    }

    @Test
    void testWithdrawMoreShouldFail() throws BalanceException {
        Boolean withdrawn = true;
        Boolean exceed = false;

        Mockito.when(accRepo.withdraw("arian", 5000000.0f))
            .thenReturn(withdrawn);
        assertFalse(exceed,"success");

    }

}
