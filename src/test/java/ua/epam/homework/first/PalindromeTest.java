package ua.epam.homework.first;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeTest {

    @Test
    public void reverse() {
        byte input = 0b0000001;
        byte result = Palindrome.reverse(input);
        Assert.assertEquals(-0b10000000,result);
    }

    @Test
    public void reverse1() {
        short input = 22;
        short result = Palindrome.reverse(input);
        Assert.assertEquals(26624,result);
    }

    @Test
    public void reverse2() {
        int input = 35;
        int result = Palindrome.reverse(input);
        Assert.assertEquals(-1006632960,result);
    }


    @Test
    public void asString() {
        byte input = 0b00100001;
        String result = Palindrome.asString(input);
        Assert.assertEquals("00100001",result);
    }

    @Test
    public void asString1() {
        short input = 0b0010000100100001;
        String result = Palindrome.asString(input);
        Assert.assertEquals("0010000100100001",result);
    }

    @Test
    public void asString2() {
        int input = 0b00100001001000010010000100100001;
        String result = Palindrome.asString(input);
        Assert.assertEquals("00100001001000010010000100100001",result);
    }

    @Test
    public void findFirstBit() {
        int input = 0b00100001001000010010000100100001;
        int input2 = 0b00100001001000010010000100100000;
        int result = Palindrome.findFirstBit(input);
        int result2 = Palindrome.findFirstBit(input2);
        Assert.assertEquals(0,result);
        Assert.assertEquals(5,result2);
    }

    @Test
    public void createPalindromes() {
        int[] palindromes = Palindrome.createPalindromes(5);
        for(int palindrome:palindromes){
            Assert.assertEquals(true,checkPalindrome(palindrome));
        }
    }

    private boolean checkPalindrome(int palindrome){
        String binaryFormat = String.format("%s", Integer.toBinaryString(palindrome));
        String reverse = new StringBuilder(binaryFormat).reverse().toString();
        return binaryFormat.equals(reverse);
    }
}