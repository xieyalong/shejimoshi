package com.xyl.test;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;

public class RsaUtil {
	private static String PRIVATE_KEY = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKBggh1"+
			"nkMdpudUPQL0kQaRbeWLpRbbLv94XcjZWHSfQySFEfjk+42/YWn4NjPZ3mVGemKiY1mjYmGT4oH+Ks+fp2u"+
			"WPQ25Y06fegViZhaZ4nbcTPvKWfMLE0DCmena/IhEInHfuZFj6iY0hemc4/lJ5cnZ86QyO1jhAN0Y3I6GvA"+
			"gMBAAECgYBPZ3kElgJYuUAI/URQYWMevSucjWK23qpgi7tAq+JDlFwA3KiiL0DsX3JudscUQKLohl2PHB0M"+
			"TDEnzPGqNEJeA6gVAxep+gsJzm/GGL/BNg3+j4GDoRmcKD6pp+tjF9pCCRR6nJpelV71/FBtJSXzz3JSu4X"+
			"KYtd3Wa25G6+YAQJBAPmJJ828dOPJJ5/MM8KAP9rNEmnij1Ie+y1lf0AHKeLxgW5iXPEzH4c6YB4Y1JiHkLJ"+
			"QcMojzd2WDOcAr2atqnECQQCkiBRDcmvv027gVg4NAKbStnoDvjGCv0DCoRWTumibExIZzABYa1RXDXH5O2A"+
			"3SZ8FcYgdHhDtk0a7Yd1uLt4fAkBFUA+6Wgqt6wYSoQoPkMgr4qKmvsPIr8pdRcAe7N55p1OocbIXXXf4fAK"+
			"O2Z7T73QF08pAm8lnL3LOB6axArRBAkBwytkZY9ebEddw842uXEQBMBd1eW13tKUwyD2CiMgth2VhSfjypKG"+
			"tDAqWUZ4kSNQ7Zxlo3LO+KrjSvMSQRJEBAkByBC3HpWyMC+d+4gOtz5Z2cyXSgU/3GW0F+f4D13iJVppBn6gX"+
			"3fJ2X1ypNkp1DNtO5YnGU0OLbvx6AJOsVey0";
	private static String PUBLIC_KEY ="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCgYIIdZ5DH"+
			"abnVD0C9JEGkW3li6UW2y7/eF3I2Vh0n0MkhRH45PuNv2Fp+DYz2d5lRnpiomNZo2Jhk+KB/irPn6"+
			"drlj0NuWNOn3oFYmYWmeJ23Ez7ylnzCxNAwpnp2vyIRCJx37mRY+omNIXpnOP5SeXJ2fOkMjtY4QDdGNyOhrwIDAQAB";
	//公钥写入的前端文件里。
	private static RSA rsa = new RSA(PRIVATE_KEY, PUBLIC_KEY);
	/**
	 * 加密字符串
	 * <p>Description: </p>  
	 * @author wzs
	 * @date 2019年8月9日
	 * @param str   普通字符串
	 * @param keyType 用公钥 还是私钥
	 * @return base64编码的加密字符串。
	 */
	public static String encrypt(String str, KeyType keyType) {
		byte[] bytes = str.getBytes();
		byte[] encrypt = rsa.encrypt(bytes, keyType);
		return Base64.encode(encrypt);
	}

	/**
	 * 公钥加密字符串
	 * <p>Description: </p>  
	 * @author wzs
	 * @date 2019年8月9日
	 * @param str
	 * @return base64编码的加密字符串。
	 */
	public static String pubEncrypt(String str) {
		return encrypt(str,KeyType.PublicKey);
	}

	/**
	 * 私钥加密字符串
	 * <p>Description: </p>  
	 * @author wzs
	 * @date 2019年8月9日
	 * @param str
	 * @return base64编码的加密字符串。
	 */
	public static String priEncrypt(String str) {
		return encrypt(str,KeyType.PrivateKey);
	}

	/**
	 * 解密字符串
	 * <p>Description: 解密密文</p>  
	 * @author wzs
	 * @date 2019年8月9日
	 * @param str   base64编码的密文
	 * @param keyType 用公钥 还是私钥
	 * @return utf-8编码的字符串。
	 */
	public static String decrypt(String str, KeyType keyType) {
		byte[] bytes = Base64.decode(str);
		byte[] decrypt = rsa.decrypt(bytes, keyType);
		return StrUtil.str(decrypt, CharsetUtil.CHARSET_UTF_8);
	}

	/**
	 * 公钥解密字符串
	 * <p>Description: 解密密文</p>  
	 * @author wzs
	 * @date 2019年8月9日
	 * @param str   base64编码的密文
	 * @return utf-8编码的字符串。
	 */
	public static String pubDecrypt(String str) {
		return decrypt(str, KeyType.PublicKey);
	}
	/**
	 * 私钥解密字符串
	 * <p>Description: 解密密文</p>  
	 * @author wzs
	 * @date 2019年8月9日
	 * @param str   base64编码的密文
	 * @return utf-8编码的字符串。
	 */
	public static String priDecrypt(String str) {
		return decrypt(str, KeyType.PrivateKey);
	}





	public static void main(String[] args) throws Exception {
		KeyPair keyPair = SecureUtil.generateKeyPair("RSA");
//		RSAPublicKey public1 = (RSAPublicKey)keyPair.getPublic();
//		RSAPrivateKey private1 =(RSAPrivateKey) keyPair.getPrivate();
//		System.out.println("公钥："+Base64.encode(public1.getEncoded()) );
//		System.out.println("私钥："+Base64.encode(private1.getEncoded()) );

		//公钥加
		String str=RsaUtil.pubEncrypt("1qaz@WSX");
		System.out.println(str);
		//私钥解
		str=RsaUtil.priDecrypt(str);
		System.out.println(str);


	}
}
