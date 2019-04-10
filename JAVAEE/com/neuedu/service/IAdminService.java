package com.neuedu.service;

import com.neudeu.Admin.Admin;
import com.neudeu.common.ServerResponse;

public interface IAdminService {
	public ServerResponse<Admin> login(String username,String password);
	public boolean isusernameexists(String username);
	public ServerResponse<Admin> reginser(String username,String password1,String password2);
}
