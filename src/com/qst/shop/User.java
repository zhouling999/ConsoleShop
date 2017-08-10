package com.qst.shop;

import java.io.Serializable;
import java.math.BigDecimal;

public class User implements Serializable{
	private String username;
	private String password;


	private boolean is_login;
	public boolean isIs_login() {
		return is_login;
	}

	public void setIs_login(boolean is_login) {
		this.is_login = is_login;
	}

	public void reg(){
		// TODO Auto-generated method stub
		System.out.println("��ӭע��");
		System.out.print("�������û�����");
		String username = Shop.sc.next();
		while(true){
			System.out.print("���������룺");
			String password = Shop.sc.next();
			System.out.print("���ٴ��������룺");
			String repassword = Shop.sc.next();
			if(password.equals(repassword)){
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				Shop.userList.add(user);
                Shop.saveListToFile();
				break;
			}
			else{
				System.out.println("�������벻һ�£����ٴ�ȷ������");
			}
		}
		System.out.println("ע��ɹ���");
	}

	public void login(){
		// TODO Auto-generated method stub
		System.out.println("��ӭ��¼");
		System.out.print("�������û�����");
		String login_username = Shop.sc.next();
		boolean loginResult = false;
		while(true){
			System.out.print("���������룺");
			String login_password = Shop.sc.next();

			for(User user:Shop.userList){
				if(login_username.equals(user.getUsername())
						&&login_password.equals(user.getPassword())){
					System.out.println("��¼�ɹ���");
					this.setIs_login(true);
					loginResult = true;
					break;
				}
			}
			if(loginResult == true){
				break;
			}else{
				System.out.println("��½ʧ�ܣ�");
			}
		}
	}
	public void showGoodList() {
		// TODO Auto-generated method stub
		System.out.println("*******��Ʒ�б�******");
		for(Good good:Shop.goodList){
			System.out.println(good);
		}
	}
	public void buy(){
		System.out.println("*******������Ʒ******");
		while(true){
			System.out.print("�����빺�����Ʒ��ţ�");
			int id = Shop.sc.nextInt();
			System.out.println("����Ҫ�������Ʒ��Ϣ���£�");
			Good shopGood = this.findGoodById(id);
			System.out.println(shopGood);
			System.out.print("�����빺�����Ʒ������");
			int num = Shop.sc.nextInt();
			//�������Ʒ��Ϣ��ʾ
			Good myGood = new Good();
//			myGood.setId(shopGood.getId());
//			myGood.setName(shopGood.getName());
//			myGood.setPrice(shopGood.getPrice());
			myGood = shopGood.clone();
			myGood.setNum(num);
			Shop.myGoodList.add(myGood);
			
			System.out.println("�Ƿ������Y/N");
			String choice = Shop.sc.next();
			choice = choice.toUpperCase();
			if(choice.equals("N")){
				break;
			}
		}
		this.showMyGoodList();
	}
	public void showMyGoodList() {
		// TODO Auto-generated method stub
		System.out.println("*******���������Ʒ�б�******");
		BigDecimal total = new BigDecimal("0");
		for(Good good:Shop.myGoodList){
			System.out.println(good);
			BigDecimal price = good.getPrice();
			int num = good.getNum();
			total = total.add(price).multiply(new BigDecimal(num));
			//total = total.add(good.getPrice().multiply(new BigDecimal(good.getNum())));
		}
		System.out.println("�ܼ۸�Ϊ"+total);
	}
	public Good findGoodById(int id) {
		// TODO Auto-generated method stub
		Good returnGood = null;
		for(Good good :Shop.goodList){
			if(good.getId()==id){
				returnGood = good;
				break;
			}
		}
		return returnGood;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
