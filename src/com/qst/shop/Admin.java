package com.qst.shop;

import java.math.BigDecimal;

public class Admin extends User{
	Shop shop = new Shop();
	public void adminLogin() {
		System.out.println("��ӭ����Ա��¼��");
		System.out.print("���������Ա�û���:");
		String username = Shop.sc.next();
		while(true){
			System.out.print("���������Ա����:");
			String password = Shop.sc.next();
			if (username.equals("admin")&&password.equals("admin")){
				System.out.println("******����Ա��¼�ɹ�******");
				this.showAdminMenu();
				break;
			}else{
				System.out.println("��¼ʧ�ܣ������µ�¼");
			}
		}

	}
	private void showAdminMenu() {
		// TODO Auto-generated method stub
		System.out.println("*****����Ա�˵�*****");
		System.out.println("\t1.�����Ʒ");
		System.out.println("\t2.�޸���Ʒ");
		System.out.println("\t3.ɾ����Ʒ");
		System.out.println("\t4.�鿴��Ʒ�б�");
		System.out.println("\t5.��ѯ��Ʒ");
		System.out.println("\t6.�˳�");
		System.out.println("************************");
		System.out.print("��ѡ��˵���");
		int choice = Shop.sc.nextInt();
		this.chooseAdminMenu(choice);
	}
	private void chooseAdminMenu(int choice) {
		// TODO Auto-generated method stub
		boolean result = true;
		String go_on = "Y";
		switch(choice){
		case 1:
			System.out.println("��ѡ����ǣ������Ʒ");
			while(go_on.equals("Y")){
			this.addGood();
			System.out.println("���Ƿ������Y/N");
			go_on = Shop.sc.next();
			go_on = go_on.toUpperCase();
			}
			this.showAdminMenu();
			break;
		case 2:
			System.out.println("��ѡ����ǣ��޸���Ʒ");
			while(go_on.equals("Y")){
			this.updateGood();
			System.out.println("���Ƿ������Y/N");
			go_on = Shop.sc.next();
			go_on = go_on.toUpperCase();
			}
			this.showAdminMenu();
			break;
		case 3:
			System.out.println("��ѡ����ǣ�ɾ����Ʒ");
			while(go_on.equals("Y")){
			this.deleteGood();
			System.out.println("���Ƿ������Y/N");
			go_on = Shop.sc.next();
			go_on = go_on.toUpperCase();
			}
			this.showAdminMenu();
			break;
		case 4:
			System.out.println("��ѡ����ǣ��鿴��Ʒ�б�");
			super.showGoodList();
			this.showAdminMenu();
			break;
		case 5:
			System.out.println("��ѡ����ǣ���ѯ��Ʒ");
			while(go_on.equals("Y")){
			this.find();
			System.out.println("���Ƿ������Y/N");
			go_on = Shop.sc.next();
			go_on = go_on.toUpperCase();
			}
			this.showAdminMenu();
			break;
		case 6:
			System.out.println("*****����Ա�ǳ�******");
			break;
		}

	}
	private void find() {
		// TODO Auto-generated method stub
		System.out.println("******��ѯ��Ʒ*****");
		System.out.print("������Ҫ��ѯ����Ʒ��ţ�");
		int id = Shop.sc.nextInt();
		Good good = this.findGoodById(id);
		if(good == null){
			System.out.println("δ�ҵ�����Ʒ");

		}else{
			System.out.println("����Ʒ��Ϣ���£�");
			System.out.println("��Ʒid\t��Ʒ����\t��Ʒ�۸�\t��Ʒ����");
			System.out.println(good.getId()+"\t"+good.getName()+"\t"+good.getPrice()+"\t"+good.getNum());
		}
	}
	
	private void addGood() {
		// TODO Auto-generated method stub
		System.out.println("��ʼ�����Ʒ");
		System.out.println("*****�����Ʒ*******");
		System.out.print("��������Ʒ��ţ�");
		int id = Shop.sc.nextInt();
		System.out.print("��������Ʒ���ƣ�");
		String name = Shop.sc.next();
		System.out.print("��������Ʒ�۸�");
		String price = Shop.sc.next();
		System.out.print("��������Ʒ������");
		int num = Shop.sc.nextInt();

		Good good = new Good();
		good.setId(id);
		good.setName(name);
		good.setPrice(new BigDecimal(price));
		good.setNum(num);
		Shop.goodList.add(good);
		System.out.println("��ӳɹ�");
	}
	private void updateGood() {
		// TODO Auto-generated method stub
		System.out.println("******�޸���Ʒ*****");
		System.out.print("������Ҫ�޸ĵ���Ʒ��ţ�");
		int id = Shop.sc.nextInt();
		Good good = this.findGoodById(id);
		if(good == null){
			System.out.println("δ�ҵ�����Ʒ");

		}else{
			System.out.println("����Ʒ��Ϣ���£�");
			System.out.println("��Ʒid\t��Ʒ����\t��Ʒ�۸�\t��Ʒ����");
			System.out.println(good.getId()+"\t"+good.getName()+"\t"+good.getPrice()+"\t"+good.getNum());

			System.out.print("�������޸ĺ����Ʒ���ƣ�");
			String name = Shop.sc.next();
			good.setName(name);
			System.out.print("�������޸ĺ����Ʒ�۸�");
			Double price = Shop.sc.nextDouble();
			good.setPrice(new BigDecimal(price));
			System.out.print("�������޸ĺ����Ʒ������");
			int num = Shop.sc.nextInt();
			good.setNum(num);
			System.out.println("�޸ĳɹ���");
		}
	}
	

	
	private void deleteGood() {
		// TODO Auto-generated method stub
		System.out.println("*******ɾ����Ʒ*******");
		System.out.print("��������Ҫɾ����Ʒ�ı�ţ�");
		int id = Shop.sc.nextInt();
		Good good = this.findGoodById(id);
		Shop.goodList.remove(good);
		System.out.println("ɾ���ɹ���");
	}
}
