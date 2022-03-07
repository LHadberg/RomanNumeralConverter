package com.example.romannumeralconverter;

public class RomanConverter {
    public String ArabicToRoman(int input) {
        String result = "";
        while (input >= 1000) {
            result += "M";
            input -= 1000;
        }
        while (input >= 900) {
            result += "CM";
            input -= 900;
        }
        while (input >= 500) {
            result += "D";
            input -= 500;
        }
        while (input > 400) {
            result += "CD";
            input -= 400;
        }
        while (input >= 100) {
            result += "C";
            input -= 100;
        }
        while (input >= 90) {
            result += "XC";
            input -= 90;
        }
        while (input >= 50) {
            result += "L";
            input -= 50;
        }
        while (input >= 40) {
            result += "XL";
            input -= 40;
        }
        while (input >= 10) {
            result += "X";
            input -= 10;
        }
        while (input >= 9) {
            result += "IX";
            input -= 9;
        }
        while (input >= 5) {
            result += "V";
            input -= 5;
        }
        while (input >= 4) {
            result += "IV";
            input -= 4;
        }
        while (input >= 1) {
            result += "I";
            input -= 1;
        }
        return result;
    }

    public int RomanToArabic(String input) {
        int result = 0;
        if (input.startsWith("M")) {
            result += 1000 + RomanToArabic(input.substring(1));
        }
        if (input.startsWith("CM")) {
            result += 900 + RomanToArabic(input.substring(2));
        }
        if (input.startsWith("D")) {
            result += 500 + RomanToArabic(input.substring(1));
        }
        if (input.startsWith("C")) {
            result += 400 + RomanToArabic(input.substring(2));
        }
        if (input.startsWith("C")) {
            result += 100 + RomanToArabic(input.substring(1));
        }
        if (input.startsWith("XC")) {
            result += 90 + RomanToArabic(input.substring(2));
        }
        if (input.startsWith("L")) {
            result += 50 + RomanToArabic(input.substring(1));
        }
        if (input.startsWith("XL")) {
            result += 40 + RomanToArabic(input.substring(2));
        }
        if (input.startsWith("X")) {
            result += 10 + RomanToArabic(input.substring(1));
        }
        if (input.startsWith("IX")) {
            result += 9 + RomanToArabic(input.substring(2));
        }
        if (input.startsWith("V")) {
            result += 5 + RomanToArabic(input.substring(1));
        }
        if (input.startsWith("IV")) {
            result += 4 + RomanToArabic(input.substring(2));
        }
        if (input.startsWith("I")) {
            result += 1 + RomanToArabic(input.substring(1));
        }
        return result;
    }
}
