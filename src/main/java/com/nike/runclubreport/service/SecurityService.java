package com.nike.runclubreport.service;

import com.google.inject.Inject;
import com.nike.runclubreport.dao.IUserDAO;
import com.nike.runclubreport.model.LoginErrorCode;
import com.nike.runclubreport.model.LoginResult;
import com.nike.runclubreport.model.ReportUser;
import com.nike.runclubreport.persistence.User;

/**
 * Created by andrew.bao on 4/24/14.
 */
public class SecurityService implements ISecurityService {

    private final IUserDAO userDAO;

    @Inject
    public SecurityService(final IUserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    public LoginResult validateUser(String userName, String password) {
        LoginResult loginResult;

        try{
            User user = userDAO.getUserByName(userName);

            if(user == null){
                loginResult = new LoginResult(false, LoginErrorCode.InvalidUsername, null);
            }
            else if(!user.getPassword().equalsIgnoreCase(password)){
                loginResult = new LoginResult(false, LoginErrorCode.InvalidPassword, null);
            }
            else{
                loginResult = new LoginResult(true, LoginErrorCode.None, user);
            }
        }
        catch(Exception ex){
            loginResult = new LoginResult(false, LoginErrorCode.Unknown, null);
        }

        return loginResult;
    }
}
