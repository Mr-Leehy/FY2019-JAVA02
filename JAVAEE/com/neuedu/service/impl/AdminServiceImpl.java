package com.neuedu.service.impl;
import java.util.HashMap;
import java.util.Map;
import com.neudeu.Admin.Admin;
import com.neudeu.Admin.Const;
import com.neudeu.common.ServerResponse;
import com.neuedu.service.IAdminService;
public class AdminServiceImpl implements IAdminService {
	private static AdminServiceImpl instance;
	//List<Admin> list=new ArrayList<Admin>();
	Map<String,Admin> map=new HashMap<String,Admin>();
	private AdminServiceImpl() {

		Admin user1=new Admin("admin","admin");
		
		//list.add(user1);
		map.put(user1.getUsername(),user1);
		
	}

	public static synchronized AdminServiceImpl getInstance() {
		if(instance==null) {
			instance=new AdminServiceImpl();
		}
		return instance;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public ServerResponse<Admin> login(String username, String password) {
		
		//�жϲ����Ƿ����
		if(username==null||username.equals("")) {
			return ServerResponse.CreateServerResponseByFile(Const.USERNAME_NOT_NULL,"�û�������Ϊ��");
		}
		if(password==null||password.equals("")) {
			return ServerResponse.CreateServerResponseByFile(Const.PASSWORD_NOT_NULL,"�û�������Ϊ��");
		}
		//����û����Ƿ����
		boolean isexistsusername=isusernameexists(username);
		if(isexistsusername) {
			Admin admin=map.get(username);
			String _username=admin.getUsername();
			String _password=admin.getPassword();
			if(_username.equals(username)&&_password.equals(password)) {
				return ServerResponse.CreateServerResponseBySucess();
			}else {
				return ServerResponse.CreateServerResponseByFile(Const. PASSWORD_ERROR, "�������");
			}
			/*for(int i=0;i<list.size();i++) {
				Admin user=list.get(i);
				if(user==null) {
					continue;
				}
				String _username=user.getUsername();
				String _password=user.getPassword();
				if(_username.equals(username)&&_password.equals(password)) {
					return ServerResponse.CreateServerResponseBySucess();
				}else {
					return ServerResponse.CreateServerResponseByFile(Const. PASSWORD_ERROR, "�������");
				}
			}*/
			
		}else {
			return ServerResponse.CreateServerResponseByFile(Const.USERNAME_NOT_EXISTS, "�û���������");
		}
		
	//return null;
	}
	@Override
	public boolean isusernameexists(String username)  {
		// TODO Auto-generated method stub
		
		
	/*for(int i=0;i<list.size();i++) {
			
			Admin user=list.get(i);
			if(user==null) {
				continue;
			}
			
			String _username=user.getUsername();
			
			if(_username.equals(username)) {//�û�������
				
			   return true;
			}
			
		}*/
		
		return map.containsKey(username);
		//return false;
		
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public ServerResponse<Admin> reginser(String username, String password1, String password2) {
		// TODO Auto-generated method stubu
		
		Admin admin=new Admin(username, password1);
				Admin admin1=map.put(admin.getUsername(),admin);
		
		if(username!=admin1.username) {
			return ServerResponse.CreateServerResponseBySucess(admin1);
		}
		/*Admin user3=new Admin(username,password1);
		for(int i=0;i<list.size();i++) {
			if(username!=list.get(i).username) {
				return ServerResponse.CreateServerResponseBySucess(user3);
			}
		}*/
 	
		return null;
	}

	

	
}
