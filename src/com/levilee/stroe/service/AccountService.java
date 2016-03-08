package com.levilee.stroe.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.levilee.store.dao.AccountDao;
import com.levilee.store.entity.Account;
import com.levilee.store.interface1.AccountServiceInter;

public class AccountService implements AccountServiceInter {
	private AccountDao accountDao = new AccountDao();
	private Logger log = Logger.getLogger("levilog");
	/**
	 * 登陆验证功能
	 */
	@Override
	public boolean login(String username, String password) {
		Account account;
		account = (Account) accountDao.get(username);
		if (account != null) {
			if (account.getPassword().equals(password)) {
				log.info("登陆验证成功");
				return true;
			} else {
				log.info("密码:" + password + "错误");
			}
		} else {
			log.info("用户名:" + username + "  不存在");
		}
		log.info("登陆验证失败");
		return false;
	}

	/**
	 * 实现注册账号功能
	 */
	@Override
	public boolean register(String username, String password) {
		//1.判断用户名是否存在
		Account a = (Account) accountDao.get(username);
		if(a!=null){
			log.warn("用户名"+username+"已存在");
			return false;
		}
		Account account = new Account();
		account.setUsername(username);
		account.setPassword(password);
		account.setStatus(0);
		try {
			accountDao.add(account);
		} catch (Exception e) {
			log.error("注册失败");
			return false;
		}
		log.info("注册账号:" + username + "成功");
		return true;
	}

	/**
	 * 获取所有账号信息
	 */
	@Override
	public List<Account> getAccounts() {
		List<Account> list = null;
		try {
			list = accountDao.get();
		} catch (Exception e) {
			log.error("获取账户信息失败");
		}
		return list;
	}

	/**
	 * 获取指定账号信息
	 */
	@Override
	public Account getAccount(String username) {
		Account account = null ;
		account = (Account) accountDao.get(username);
		if(account==null){
			log.info("获取账号信息失败");
			return null;
		}
		log.info("获取账号信息成功");
		return account;
	}

	/**
	 * 删除账户
	 */
	@Override
	public boolean delete(String username) {
		try {
			Account account = (Account) accountDao.get(username);
			accountDao.delete(account);
			new UserinfoService().deleteByUsername(username);
			log.info("用户  " + username + "  删除成功");
		} catch (Exception e) {
			log.error("删除用户" + username + "失败");
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean update(Account account) {
		try {
			accountDao.update(account);
			log.info("用户 " + account.getUsername() + " 更新成功");
		} catch (Exception e) {
			log.error("更新失败，可能是用户名不存在");
			return false;
		}
		return true;
	}

	/**
	 * 更改密码
	 */
	@Override
	public boolean setPassword(String username,String oldPassword,String newPassword) {
		//1.验证账号密码是否合法
		if(login(username,oldPassword)){
			log.info("账号密码合法");
			Account a = (Account) accountDao.get(username);
			a.setPassword(newPassword);
			accountDao.update(a);
			log.info("账号 "+username+"的密码更改成功");
			return true;
		}
		log.error("账号 "+username+"的密码更改失败");
		return false;
	}

	@Override
	public boolean setStatus(String username,int status) {
		try{
		Account a = (Account) accountDao.get(username);
		a.setStatus(status);
		accountDao.update(a);
		log.info("账号 "+username+"的密码更改成功");
		}catch(Exception e){
			log.error("状态更改失败");
			return false;
		}
		return true;
	}

}
