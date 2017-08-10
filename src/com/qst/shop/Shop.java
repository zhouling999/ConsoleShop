package com.qst.shop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {
	static Scanner sc = new Scanner(System.in);
	static List<Good> goodList = new ArrayList();
	static List<Good> myGoodList = new ArrayList();
	static List<User> userList = new ArrayList();
    static File userFile = new File(
    		"G:\\Users\\Administrator\\workspace\\Shop\\src\\com\\qst\\shop\\UserFile");
	User user = new User();
	
	public static void saveListToFile(){
		try {
			FileOutputStream fos = new FileOutputStream(userFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
		    oos.writeObject(userList);
		    oos.close();
		    fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readListFromFile(){
		try {
			FileInputStream fis = new FileInputStream(userFile);
		    ObjectInputStream ois = new ObjectInputStream(fis);
		    Object object = ois.readObject();
		    userList = (List) object;
		    ois.close();
		    fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
        Shop shop = new Shop();
        shop.run();
	}


	
	private void run(){
		this.initGoodList();
		this.readListFromFile();
		boolean go_on = true;
		while(go_on){
		int choice = this.showMainMenu();
        go_on = this.chooseMenu(choice);
		}
	}
	
	public void initGoodList(){
		Good good1 = new Good(1,"海尔冰箱",new BigDecimal("1999"),100);
		Good good2 = new Good(2,"海信电视",new BigDecimal("2999"),200);
		Good good3 = new Good(3,"小米手机",new BigDecimal("999"),200);
	    goodList.add(good1);
	    goodList.add(good2);
	    goodList.add(good3);
	}
	
	public int showMainMenu() {
		// TODO Auto-generated method stub
		System.out.println("*****欢迎进入电子商城*****");
		System.out.println("\t1.注册");
		System.out.println("\t2.登录");
		System.out.println("\t3.查看商城");
		System.out.println("\t4.查看我购买的商品");
		System.out.println("\t5.管理员登录");
		System.out.println("\t6.退出系统");
		System.out.println("************************");
		System.out.print("请选择菜单：");
		int choice = sc.nextInt();
		return choice;
	}
	private boolean chooseMenu(int choice){
		boolean result =true;
		switch(choice){
		case 1:	
			System.out.println("您选择的是:注册");
			user.reg();
			break;
		case 2:
			System.out.println("您选择的是:登录");
			user.login();
			break;
		case 3:
			System.out.println("您选择的是:查看商城");
            user.showGoodList();
            if(user.isIs_login() == true){
            	user.buy();
            }else{
            	System.out.println("未登陆，请先登陆");
            }
			break;
		case 4:
			System.out.println("您选择的是:查看我购买的产品");
			break;
		case 5:
			System.out.println("您选择的是:管理员登录");
			Admin admin = new Admin();
			admin.adminLogin();
			break;
		case 6:
			System.out.println("谢谢使用！");
			result = false;
			break;
		default:
			System.out.println("您的输入有误！");
			break;
		}
		return result;
	}

}
