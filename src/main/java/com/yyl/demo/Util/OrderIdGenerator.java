/**
 * 
 */
package com.yyl.demo.Util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author hepeichang
 * 订单号生成  ，根据无界线程安全队列
 * maxPerMSECSize  每秒生成订单号的最大值
 */
public class OrderIdGenerator {
	
	private static final ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
    private static final CountDownLatch latch = new CountDownLatch(1);
    public  static final int maxPerSize =1000;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int j=0;j<10;j++)
		{
			System.out.println(getOrderId());
		}
		
	}

	
	
	 private static void init() {
	        for (int i = 1; i < maxPerSize; i++) {
	            queue.offer(i);
	        }
	        latch.countDown();
	    }

	    public static Integer poll() {
	        try {
	            if (latch.getCount() > 0) {
	                init();
	                latch.await(1, TimeUnit.SECONDS);
	            }
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        Integer i = queue.poll();
	        queue.offer(i);
	        return i;
	    }
	    
	    public static String getOrderId() {
	        long nowLong = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
	        String number = maxPerSize + poll() + "";
	        return nowLong + number.substring(1);
	    }
}
