package com.train.wrapper;

public class catTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QQ qq = new QQ();
		
		/*qq.run();
		
		qq.stop();*/
		
		carWrapper carWrapper = new carWrapper(qq);
		
		carWrapper.run();
		carWrapper.stop();

	}

}
