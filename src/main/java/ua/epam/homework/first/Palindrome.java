package ua.epam.homework.first;

import java.util.HashMap;
import java.util.Map;

public class Palindrome {
	private static Map<Byte,Byte> reverseByteMap = new HashMap<>();

	static {
		for (byte i= Byte.MIN_VALUE;i<=Byte.MAX_VALUE;i++){
			byte result=0;
			for(int bit = 0; bit < 8; bit++) {
				byte bitAt = (byte)((i >> bit) & 0x01 ) ;
				result |= (byte)(bitAt<<7-bit);
			}
			reverseByteMap.put(i,result);
			if(i==Byte.MAX_VALUE){
				break;
			}
		}
	}

	public static byte reverse(byte bytee){
		return reverseByteMap.get(bytee);
	}

	public static short reverse(short shortt){
		short mask = 0x00ff;
		byte juniorByte = (byte)(shortt&mask);
		byte elderByte =(byte)(shortt>>>8 );

		short result = 0;
		result |= reverse(juniorByte);
		result = (short)(result&mask);
		result=(short)(result<<8);
		result|=((short) reverse(elderByte))&mask;
		return result;
	}

	public static int reverse(int integer){
		int mask = 0xffff;
		short juniorShort = (short)(integer&mask);
		short elderShort =(short)(integer>>>16 );

		int result = 0;
		result |= reverse(juniorShort);
		result=result<<16;
		result|=((int) reverse(elderShort))&mask;
		return result;
	}

	public static int[][] findPalindromes(){
		int[][] data = new int[65536][];
		for (int i=0;i<65536;i++){
			int[] palindromes = createPalindromes(i);
			data[i] = palindromes;
		}
		return data;
	}

	static String asString(byte in){
		return String.format("%8s", Integer.toBinaryString(in & 0xFF)).replace(' ', '0');
	}
	static String asString(short in){
		return String.format("%16s", Integer.toBinaryString(in&0xFFFF)).replace(' ', '0');
	}
	static String asString(int in){
		return String.format("%32s", Integer.toBinaryString(in)).replace(' ', '0');
	}

	public static void main(String[] args) {
		/*int[][] data = findPalindromes();
		for (int[] row:data){
			for (int cell: row){
				System.out.println(asString(cell));
			}
		}*/
		int[] data = createPalindromes(691);

			for (int cell: data){
				System.out.println(asString(cell));
			}

	}
	public static int findFirstBit(int in){
		for (int bit = 0; bit <32 ; bit++) {
			if (((in>>bit)&0x01) == 1){
				return bit;
			}
		}
		return 32;
	}

	public static int[] createPalindromes(int input){
		int[] result = {};
		if(input<65536){
			int reverseInt = reverse(input);
			int firstBitPosition = findFirstBit(reverseInt);
			int avaliblePalindromes = firstBitPosition - (31 - firstBitPosition);
			result = new int[avaliblePalindromes];
			for (int i = 0; i <avaliblePalindromes ; i++) {
				int resultInt = 0;
				resultInt |= reverseInt;
				resultInt = resultInt>>>i;
				resultInt|= input;
				result[i]=resultInt;
			}
			return result;

		}
		return result;
	}

}
