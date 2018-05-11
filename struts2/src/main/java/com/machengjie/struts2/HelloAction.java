package com.machengjie.struts2;

/**
 * @author 马成杰
 */
public class HelloAction {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String execute(){
		System.out.println("hello world");
		message = "welcome Hi!!";
		return "success";
	}

}
