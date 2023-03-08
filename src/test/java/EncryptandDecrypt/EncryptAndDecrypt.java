package EncryptandDecrypt;

import java.util.Base64;

public class EncryptAndDecrypt {

	public static void main(String[] args) {
		String encryptData = "dGVzdEBkZW1vLmNvbQo=";
		byte[] bytes = encryptData.getBytes();
		byte[] bytes1 = Base64.getDecoder().decode(bytes);
		String s = new String(bytes1);
		System.out.println(s);
	}

}
