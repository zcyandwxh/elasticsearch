package com.config;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/4/15 
 * @since V1.0
 *  
 */
public class Test {
   static   class O{
        public String str = "anc";
    }

    public static void main(String[] args) throws InterruptedException {

        O o1 = new O();
        System.out.println(o1.str);
        Thread.sleep(Integer.MAX_VALUE);
    }

}
class B{

}

