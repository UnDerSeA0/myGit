/*    */ package com.util;
/*    */ 
/*    */ import java.security.MessageDigest;
/*    */ 
/*    */ public final class MD5
/*    */ {
/*    */   public static final String MD5(String s)
/*    */   {
/* 13 */     char[] hexDigits = { 
/* 14 */       '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 
/* 15 */       'e', 'f' };
/*    */     try {
/* 17 */       byte[] strTemp = s.getBytes();
/* 18 */       MessageDigest mdTemp = MessageDigest.getInstance("MD5");
/* 19 */       mdTemp.update(strTemp);
/* 20 */       byte[] md = mdTemp.digest();
/* 21 */       int j = md.length;
/* 22 */       char[] str = new char[j * 2];
/* 23 */       int k = 0;
/* 24 */       for (int i = 0; i < j; ++i) {
/* 25 */         byte byte0 = md[i];
/* 26 */         str[(k++)] = hexDigits[(byte0 >>> 4 & 0xF)];
/* 27 */         str[(k++)] = hexDigits[(byte0 & 0xF)];
/*    */       }
/* 29 */       return new String(str);
/*    */     } catch (Exception e) {
/*    */     }
/* 32 */     return null;
/*    */   }
/*    */ }

/* Location:           C:\Documents and Settings\Administrator\桌面\飞机订票\WebRoot\WEB-INF\classes\
 * Qualified Name:     com.util.MD5
 * JD-Core Version:    0.5.3
 */