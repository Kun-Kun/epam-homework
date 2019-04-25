package ua.epam.homework;

import java.util.HashMap;
import java.util.Map;

public class Palindrome {
	private static Map<Byte,Byte> reverseByteMap = new HashMap<>();

	static {
		for (byte i= Byte.MIN_VALUE;i<Byte.MAX_VALUE;i++){
			byte result=0;
			for(int bit = 0; bit < 8; bit++) {
				byte bitAt = (byte)((i >> bit) & 0x01 ) ;
				result |= (byte)(bitAt<<7-bit);
			}
			reverseByteMap.put(i,result);
		}
	}

	public static byte reverseByte(byte bytee){
		return reverseByteMap.get(bytee);
	}

	public static short reverseShort(short shortt){
		short mask = 0x00ff;
		byte juniorByte = (byte)(shortt&mask);
		byte elderByte =(byte)((shortt>>8 )&mask);

		short result = 0;
		result |= reverseByte(juniorByte);
		result = (short)(result&mask);
		result=(short)(result<<8);
		result|=((short)reverseByte(elderByte))&mask;
		return result;
	}

	public static int reverseInt(int integer){
		int mask = 0xffff;
		short juniorShort = (short)(integer&mask);
		short elderShort =(short)((integer>>16 )&mask);

		int result = 0;
		result |= reverseShort(juniorShort);
		result=result<<16;
		result|=((int)reverseShort(elderShort))&mask;
		return result;
	}

	/*public static int[][] findPalindromes(){
		int[][] data = new int[65535][];
		for (int i=1;i<65535;i++){
			int[] palindromes = createPalindromes(i);
			data[i] = palindromes;
		}
		return data;
	}*/

	static String asString(byte in){
		return String.format("%8s", Integer.toBinaryString(in & 0xFF)).replace(' ', '0');
	}
	static String asString(short in){
		return String.format("%16s", Integer.toBinaryString(in&0xFFFF)).replace(' ', '0');
	}
	static String asString(int in){
		return String.format("%32s", Integer.toBinaryString(in)).replace(' ', '0');
	}

	/*public static void main(String[] args) {
		int[][] data = findPalindromes();
	}*/
	public static int findFirstBit(int in){
		for (int bit = 0; bit <32 ; bit++) {
			if (((in>>bit)&0x01) == 1){
				return bit;
			}
		}
		return 32;
	}

	public static int[] createPalindromes(int input){
		int[] result = new int[32];
		if(input<65536){
			int reverseInt = reverseInt(input);
			int firstBitPosition = findFirstBit(reverseInt);

			for (int i = 0; i <firstBitPosition ; i++) {
				int resultInt = 0;
				resultInt |= reverseInt;
				resultInt = resultInt>>i;
				resultInt|= input;
				result[i]=resultInt;
			}
			return result;

		}
		return result;
	}

}
