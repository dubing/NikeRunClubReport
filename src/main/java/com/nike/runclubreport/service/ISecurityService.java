package com.nike.runclubreport.service;

import com.nike.runclubreport.model.LoginResult;
import com.nike.runclubreport.model.ReportUser;

/**
 * Created by andrew.bao on 4/24/14.
 */
public interface ISecurityService {
    LoginResult validateUser(final String username, final String password);
}
