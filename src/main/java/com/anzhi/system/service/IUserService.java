package com.anzhi.system.service;



import java.util.List;
import com.anzhi.system.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Andy
 */
public interface IUserService extends IService<User> {

	
	public User getUser(String username);
	
	public void updateUser(User user);
	
	public void addUser(User user);
	
	public void deleteUser();
	
	public List<User> getAllUser();
	
		
}
