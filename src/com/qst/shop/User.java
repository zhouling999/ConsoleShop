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
		System.out.println("欢迎注册");
		System.out.print("请输入用户名：");
		String username = Shop.sc.next();
		while(true){
			System.out.print("请输入密码：");
			String password = Shop.sc.next();
			System.out.print("请再次输入密码：");
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
				System.out.println("两次密码不一致，请再次确认密码");
			}
		}
		System.out.println("注册成功！");
	}

	public void login(){
		// TODO Auto-generated method stub
		System.out.println("欢迎登录");
		System.out.print("请输入用户名：");
		String login_username = Shop.sc.next();
		boolean loginResult = false;
		while(true){
			System.out.print("请输入密码：");
			String login_password = Shop.sc.next();

			for(User user:Shop.userList){
				if(login_username.equals(user.getUsername())
						&&login_password.equals(user.getPassword())){
					System.out.println("登录成功！");
					this.setIs_login(true);
					loginResult = true;
					break;
				}
			}
			if(loginResult == true){
				break;
			}else{
				System.out.println("登陆失败！");
			}
		}
	}
	public void showGoodList() {
		// TODO Auto-generated method stub
		System.out.println("*******商品列表******");
		for(Good good:Shop.goodList){
			System.out.println(good);
		}
	}
	public void buy(){
		System.out.println("*******购买商品******");
		while(true){
			System.out.print("请输入购买的商品编号：");
			int id = Shop.sc.nextInt();
			System.out.println("您需要购买的商品信息如下：");
			Good shopGood = this.findGoodById(id);
			System.out.println(shopGood);
			System.out.print("请输入购买的商品数量：");
			int num = Shop.sc.nextInt();
			//购买的商品信息显示
			Good myGood = new Good();
//			myGood.setId(shopGood.getId());
//			myGood.setName(shopGood.getName());
//			myGood.setPrice(shopGood.getPrice());
			myGood = shopGood.clone();
			myGood.setNum(num);
			Shop.myGoodList.add(myGood);
			
			System.out.println("是否继续？Y/N");
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
		System.out.println("*******您购买的商品列表******");
		BigDecimal total = new BigDecimal("0");
		for(Good good:Shop.myGoodList){
			System.out.println(good);
			BigDecimal price = good.getPrice();
			int num = good.getNum();
			total = total.add(price).multiply(new BigDecimal(num));
			//total = total.add(good.getPrice().multiply(new BigDecimal(good.getNum())));
		}
		System.out.println("总价格为"+total);
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
