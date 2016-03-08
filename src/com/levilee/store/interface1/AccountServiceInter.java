package com.levilee.store.interface1;

import java.util.List;
import com.levilee.store.entity.Account;

public interface AccountServiceInter {
	// ��½��֤������Ϊ�û��������룬����true��false
	public boolean login(String username, String password);
	// ע���˺�(ע��:һ������»���Ҫ����˺���Ϣ)
	public boolean register(String username, String password);
	// ��������˺���Ϣ,���ذ���Account�����List
	public List<Account> getAccounts();
	// ���ָ���˺���Ϣ
	public Account getAccount(String username);
	// �����˺���Ϣ��һ���Ȼ�ȡ�˺���Ϣ��Ȼ�����Ϣ���ģ�����ٸ�����Ϣ���ɣ�
	public boolean update(Account account);
	// ��������
	public boolean setPassword(String username, String oldPassword,
			String newPassword);
	// ����״̬
	public boolean setStatus(String username, int status);
	// ɾ���˺ţ�ps:��ɾ���˻���Ϣ���û���Ϣ��
	public boolean delete(String username);
}
