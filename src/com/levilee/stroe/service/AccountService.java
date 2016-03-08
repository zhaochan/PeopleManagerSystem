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
	 * ��½��֤����
	 */
	@Override
	public boolean login(String username, String password) {
		Account account;
		account = (Account) accountDao.get(username);
		if (account != null) {
			if (account.getPassword().equals(password)) {
				log.info("��½��֤�ɹ�");
				return true;
			} else {
				log.info("����:" + password + "����");
			}
		} else {
			log.info("�û���:" + username + "  ������");
		}
		log.info("��½��֤ʧ��");
		return false;
	}

	/**
	 * ʵ��ע���˺Ź���
	 */
	@Override
	public boolean register(String username, String password) {
		//1.�ж��û����Ƿ����
		Account a = (Account) accountDao.get(username);
		if(a!=null){
			log.warn("�û���"+username+"�Ѵ���");
			return false;
		}
		Account account = new Account();
		account.setUsername(username);
		account.setPassword(password);
		account.setStatus(0);
		try {
			accountDao.add(account);
		} catch (Exception e) {
			log.error("ע��ʧ��");
			return false;
		}
		log.info("ע���˺�:" + username + "�ɹ�");
		return true;
	}

	/**
	 * ��ȡ�����˺���Ϣ
	 */
	@Override
	public List<Account> getAccounts() {
		List<Account> list = null;
		try {
			list = accountDao.get();
		} catch (Exception e) {
			log.error("��ȡ�˻���Ϣʧ��");
		}
		return list;
	}

	/**
	 * ��ȡָ���˺���Ϣ
	 */
	@Override
	public Account getAccount(String username) {
		Account account = null ;
		account = (Account) accountDao.get(username);
		if(account==null){
			log.info("��ȡ�˺���Ϣʧ��");
			return null;
		}
		log.info("��ȡ�˺���Ϣ�ɹ�");
		return account;
	}

	/**
	 * ɾ���˻�
	 */
	@Override
	public boolean delete(String username) {
		try {
			Account account = (Account) accountDao.get(username);
			accountDao.delete(account);
			new UserinfoService().deleteByUsername(username);
			log.info("�û�  " + username + "  ɾ���ɹ�");
		} catch (Exception e) {
			log.error("ɾ���û�" + username + "ʧ��");
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean update(Account account) {
		try {
			accountDao.update(account);
			log.info("�û� " + account.getUsername() + " ���³ɹ�");
		} catch (Exception e) {
			log.error("����ʧ�ܣ��������û���������");
			return false;
		}
		return true;
	}

	/**
	 * ��������
	 */
	@Override
	public boolean setPassword(String username,String oldPassword,String newPassword) {
		//1.��֤�˺������Ƿ�Ϸ�
		if(login(username,oldPassword)){
			log.info("�˺�����Ϸ�");
			Account a = (Account) accountDao.get(username);
			a.setPassword(newPassword);
			accountDao.update(a);
			log.info("�˺� "+username+"��������ĳɹ�");
			return true;
		}
		log.error("�˺� "+username+"���������ʧ��");
		return false;
	}

	@Override
	public boolean setStatus(String username,int status) {
		try{
		Account a = (Account) accountDao.get(username);
		a.setStatus(status);
		accountDao.update(a);
		log.info("�˺� "+username+"��������ĳɹ�");
		}catch(Exception e){
			log.error("״̬����ʧ��");
			return false;
		}
		return true;
	}

}
