package com.div.basic.mediator;

import java.util.ArrayList;
import java.util.List;

public class MediatorApp {
	public static void main(String[] args) {

		TextChat chat = new TextChat();
		
		User admin = new Admin(chat, "Р�РІР°РЅ Р�РІР°РЅС‹С‡");
		User u1 = new SimpleUser(chat,"Р’Р°РЅСЏ");
		User u2 = new SimpleUser(chat, "Р’РѕРІР°");
		User u3 = new SimpleUser(chat, "РЎР°С€Р°");
		u2.setEnable(false);
		
		chat.setAdmin(admin);
		chat.addUser(u1);
		chat.addUser(u2);
		chat.addUser(u3);
		
		admin.sendMessage("РџСЂРёРІРµС‚");
	}
}

abstract class User{
	Chat chat;
	String name;
	boolean isEnable = true;
	
	public boolean isEnable() {return isEnable;}

	public void setEnable(boolean isEnable) {this.isEnable = isEnable;}

	public User(Chat chat, String name) {this.chat = chat;this.name=name;}
	
	public String getName() {return name;}

	public void sendMessage(String message) {
		chat.sendMessage(message, this);
	}
	abstract void getMessage(String message);

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}
}

class Admin extends User{
	
	public Admin(Chat chat, String name) {super(chat,name);}
	
	public void getMessage(String message) {
		System.out.println("РђРґРјРёРЅРёСЃС‚СЂР°С‚РѕСЂ " + getName()+" РїРѕР»СѓС‡Р°РµС‚ СЃРѕРѕР±С‰РµРЅРёРµ '"+ message + "'");
	}
}
class SimpleUser extends User{
	public SimpleUser(Chat chat, String name) {super(chat, name);}
	
	public void getMessage(String message) {
		System.out.println("РџРѕР»СЊР·РѕРІР°С‚РµР»СЊ " + getName()+" РїРѕР»СѓС‡Р°РµС‚ СЃРѕРѕР±С‰РµРЅРёРµ '"+ message + "'");
	}
}
interface Chat{
	void sendMessage(String message, User user);
}

class TextChat implements Chat{
	User admin;
	List<User> users = new ArrayList<>();
	
	public void setAdmin(User admin) {
		if(admin!=null && admin instanceof Admin){
			this.admin = admin;
		}
		else{
			throw new RuntimeException("РќРµ С…РІР°С‚Р°РµС‚ РїСЂР°РІ");
		}
	}
	public void addUser(User u){
		if(admin==null){
			throw new RuntimeException("Р’ С‡Р°С‚Рµ РЅРµС‚ Р°РґРјРёРЅР°!");
		}
		
		if(u instanceof SimpleUser){
			users.add(u);
		}
		else{
			throw new RuntimeException("РђРґРјРёРЅ РЅРµ РјРѕР¶РµС‚ РІС…РѕРґРёС‚СЊ РІ РґСЂСѓРіРѕР№ С‡Р°С‚!");
		}		
	}
	
	public void sendMessage(String message, User user) {
		if(user instanceof Admin){
			for(User u :  users){
				u.getMessage(user.getName()+": "+message);
			}			
		}
		if(user instanceof SimpleUser){
			for(User u :  users){
				if(u!=user && u.isEnable())
					u.getMessage(user.getName()+": "+message);
			}
			if(admin.isEnable())
				admin.getMessage(user.getName()+": "+message);
		}
	}
	
}