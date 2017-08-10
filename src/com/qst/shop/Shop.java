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
		Good good1 = new Good(1,"��������",new BigDecimal("1999"),100);
		Good good2 = new Good(2,"���ŵ���",new BigDecimal("2999"),200);
		Good good3 = new Good(3,"С���ֻ�",new BigDecimal("999"),200);
	    goodList.add(good1);
	    goodList.add(good2);
	    goodList.add(good3);
	}
	
	public int showMainMenu() {
		// TODO Auto-generated method stub
		System.out.println("*****��ӭ��������̳�*****");
		System.out.println("\t1.ע��");
		System.out.println("\t2.��¼");
		System.out.println("\t3.�鿴�̳�");
		System.out.println("\t4.�鿴�ҹ������Ʒ");
		System.out.println("\t5.����Ա��¼");
		System.out.println("\t6.�˳�ϵͳ");
		System.out.println("************************");
		System.out.print("��ѡ��˵���");
		int choice = sc.nextInt();
		return choice;
	}
	private boolean chooseMenu(int choice){
		boolean result =true;
		switch(choice){
		case 1:	
			System.out.println("��ѡ�����:ע��");
			user.reg();
			break;
		case 2:
			System.out.println("��ѡ�����:��¼");
			user.login();
			break;
		case 3:
			System.out.println("��ѡ�����:�鿴�̳�");
            user.showGoodList();
            if(user.isIs_login() == true){
            	user.buy();
            }else{
            	System.out.println("δ��½�����ȵ�½");
            }
			break;
		case 4:
			System.out.println("��ѡ�����:�鿴�ҹ���Ĳ�Ʒ");
			break;
		case 5:
			System.out.println("��ѡ�����:����Ա��¼");
			Admin admin = new Admin();
			admin.adminLogin();
			break;
		case 6:
			System.out.println("ллʹ�ã�");
			result = false;
			break;
		default:
			System.out.println("������������");
			break;
		}
		return result;
	}

}
