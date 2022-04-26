package vttp2022.nusiss.April26tx.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp2022.nusiss.April26tx.services.AccountService;

@Controller
@RequestMapping("/")
public class AccountController {
    
    @Autowired
    private AccountService accSvc;

    
}
