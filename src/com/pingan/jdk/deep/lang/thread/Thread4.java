/*
 * Copyright © PING AN INSURANCE (GROUP) COMPANY OF CHINA ，LTD. All Rights Reserved
 */
package com.pingan.jdk.deep.lang.thread;

/**
 * @author dongdaiming911@pingan.com
 * @date 2017年6月14日
 */
public class Thread4 implements Runnable {
	
	private Num n;
	
	public Thread4(Num n) {
		this.n = n;
	}
	
	@Override
	public void run() {
		synchronized (n) {
			try {
			while(n.getN() < 30) {
				if(n.getN() % 2 == 0) {
					System.out.println(Thread.currentThread().getName() +"---" + n.getN());
					n.setN(n.getN() + 1);
					n.notify();
				} else {
						n.wait();
				}
			}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}