package com.levilee.store.interface1;

import java.util.List;
import com.levilee.store.entity.Account;

public interface AccountServiceInter {
	// 登陆验证，参数为用户名和密码，返回true或false
	public boolean login(String username, String password);
	// 注册账号(注意:一般情况下还需要添加账号信息)
	public boolean register(String username, String password);
	// 获得所有账号信息,返回包含Account对象的List
	public List<Account> getAccounts();
	// 获得指定账号信息
	public Account getAccount(String username);
	// 更新账号信息（一般先获取账号信息，然后对信息更改，最后再更新信息即可）
	public boolean update(Account account);
	// 更改密码
	public boolean setPassword(String username, String oldPassword,
			String newPassword);
	// 更改状态
	public boolean setStatus(String username, int status);
	// 删除账号（ps:会删掉账户信息和用户信息）
	public boolean delete(String username);
}
