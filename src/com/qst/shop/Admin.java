package com.qst.shop;

import java.math.BigDecimal;

public class Admin extends User{
	Shop shop = new Shop();
	public void adminLogin() {
		System.out.println("欢迎管理员登录：");
		System.out.print("请输入管理员用户名:");
		String username = Shop.sc.next();
		while(true){
			System.out.print("请输入管理员密码:");
			String password = Shop.sc.next();
			if (username.equals("admin")&&password.equals("admin")){
				System.out.println("******管理员登录成功******");
				this.showAdminMenu();
				break;
			}else{
				System.out.println("登录失败，请重新登录");
			}
		}

	}
	private void showAdminMenu() {
		// TODO Auto-generated method stub
		System.out.println("*****管理员菜单*****");
		System.out.println("\t1.添加商品");
		System.out.println("\t2.修改商品");
		System.out.println("\t3.删除商品");
		System.out.println("\t4.查看商品列表");
		System.out.println("\t5.查询商品");
		System.out.println("\t6.退出");
		System.out.println("************************");
		System.out.print("请选择菜单：");
		int choice = Shop.sc.nextInt();
		this.chooseAdminMenu(choice);
	}
	private void chooseAdminMenu(int choice) {
		// TODO Auto-generated method stub
		boolean result = true;
		String go_on = "Y";
		switch(choice){
		case 1:
			System.out.println("您选择的是：添加商品");
			while(go_on.equals("Y")){
			this.addGood();
			System.out.println("您是否继续？Y/N");
			go_on = Shop.sc.next();
			go_on = go_on.toUpperCase();
			}
			this.showAdminMenu();
			break;
		case 2:
			System.out.println("您选择的是：修改商品");
			while(go_on.equals("Y")){
			this.updateGood();
			System.out.println("您是否继续？Y/N");
			go_on = Shop.sc.next();
			go_on = go_on.toUpperCase();
			}
			this.showAdminMenu();
			break;
		case 3:
			System.out.println("您选择的是：删除商品");
			while(go_on.equals("Y")){
			this.deleteGood();
			System.out.println("您是否继续？Y/N");
			go_on = Shop.sc.next();
			go_on = go_on.toUpperCase();
			}
			this.showAdminMenu();
			break;
		case 4:
			System.out.println("您选择的是：查看商品列表");
			super.showGoodList();
			this.showAdminMenu();
			break;
		case 5:
			System.out.println("您选择的是：查询商品");
			while(go_on.equals("Y")){
			this.find();
			System.out.println("您是否继续？Y/N");
			go_on = Shop.sc.next();
			go_on = go_on.toUpperCase();
			}
			this.showAdminMenu();
			break;
		case 6:
			System.out.println("*****管理员登出******");
			break;
		}

	}
	private void find() {
		// TODO Auto-generated method stub
		System.out.println("******查询商品*****");
		System.out.print("请输入要查询的商品编号：");
		int id = Shop.sc.nextInt();
		Good good = this.findGoodById(id);
		if(good == null){
			System.out.println("未找到该商品");

		}else{
			System.out.println("该商品信息如下：");
			System.out.println("商品id\t商品名称\t商品价格\t商品数量");
			System.out.println(good.getId()+"\t"+good.getName()+"\t"+good.getPrice()+"\t"+good.getNum());
		}
	}
	
	private void addGood() {
		// TODO Auto-generated method stub
		System.out.println("开始添加商品");
		System.out.println("*****添加商品*******");
		System.out.print("请输入商品编号：");
		int id = Shop.sc.nextInt();
		System.out.print("请输入商品名称：");
		String name = Shop.sc.next();
		System.out.print("请输入商品价格：");
		String price = Shop.sc.next();
		System.out.print("请输入商品数量：");
		int num = Shop.sc.nextInt();

		Good good = new Good();
		good.setId(id);
		good.setName(name);
		good.setPrice(new BigDecimal(price));
		good.setNum(num);
		Shop.goodList.add(good);
		System.out.println("添加成功");
	}
	private void updateGood() {
		// TODO Auto-generated method stub
		System.out.println("******修改商品*****");
		System.out.print("请输入要修改的商品编号：");
		int id = Shop.sc.nextInt();
		Good good = this.findGoodById(id);
		if(good == null){
			System.out.println("未找到该商品");

		}else{
			System.out.println("该商品信息如下：");
			System.out.println("商品id\t商品名称\t商品价格\t商品数量");
			System.out.println(good.getId()+"\t"+good.getName()+"\t"+good.getPrice()+"\t"+good.getNum());

			System.out.print("请输入修改后的商品名称：");
			String name = Shop.sc.next();
			good.setName(name);
			System.out.print("请输入修改后的商品价格：");
			Double price = Shop.sc.nextDouble();
			good.setPrice(new BigDecimal(price));
			System.out.print("请输入修改后的商品数量：");
			int num = Shop.sc.nextInt();
			good.setNum(num);
			System.out.println("修改成功！");
		}
	}
	

	
	private void deleteGood() {
		// TODO Auto-generated method stub
		System.out.println("*******删除商品*******");
		System.out.print("请输入需要删除商品的编号：");
		int id = Shop.sc.nextInt();
		Good good = this.findGoodById(id);
		Shop.goodList.remove(good);
		System.out.println("删除成功！");
	}
}
