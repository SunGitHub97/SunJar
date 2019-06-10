package com.filldream.sun.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 摩斯密码工具
 * @author Rick.Sun
 * @see 2019-06-10
 * @see --/---/.../-/---/.../..-/-./.---/.-/.-.
 */
public final class MorseUtil {

    private static final Map<Integer, String> alphabets = new HashMap<>();    // code point -> morse
    private static final Map<String, Integer> dictionaries = new HashMap<>(); // morse -> code point

    private static void defalutMorse(Character abc, String dict) {
        alphabets.put(Integer.valueOf(abc), dict);
        dictionaries.put(dict, Integer.valueOf(abc));
    }

    /**
     * 常用字符串的摩斯密码
     */
    static {
        // Letters
        defalutMorse('A', "01");
        defalutMorse('B', "1000");
        defalutMorse('C', "1010");
        defalutMorse('D', "100");
        defalutMorse('E', "0");
        defalutMorse('F', "0010");
        defalutMorse('G', "110");
        defalutMorse('H', "0000");
        defalutMorse('I', "00");
        defalutMorse('J', "0111");
        defalutMorse('K', "101");
        defalutMorse('L', "0100");
        defalutMorse('M', "11");
        defalutMorse('N', "10");
        defalutMorse('O', "111");
        defalutMorse('P', "0110");
        defalutMorse('Q', "1101");
        defalutMorse('R', "010");
        defalutMorse('S', "000");
        defalutMorse('T', "1");
        defalutMorse('U', "001");
        defalutMorse('V', "0001");
        defalutMorse('W', "011");
        defalutMorse('X', "1001");
        defalutMorse('Y', "1011");
        defalutMorse('Z', "1100");
        // Numbers
        defalutMorse('0', "11111");
        defalutMorse('1', "01111");
        defalutMorse('2', "00111");
        defalutMorse('3', "00011");
        defalutMorse('4', "00001");
        defalutMorse('5', "00000");
        defalutMorse('6', "10000");
        defalutMorse('7', "11000");
        defalutMorse('8', "11100");
        defalutMorse('9', "11110");
        // Punctuation
        defalutMorse('.', "010101");
        defalutMorse(',', "110011");
        defalutMorse('?', "001100");
        defalutMorse('\'', "011110");
        defalutMorse('!', "101011");
        defalutMorse('/', "10010");
        defalutMorse('(', "10110");
        defalutMorse(')', "101101");
        defalutMorse('&', "01000");
        defalutMorse(':', "111000");
        defalutMorse(';', "101010");
        defalutMorse('=', "10001");
        defalutMorse('+', "01010");
        defalutMorse('-', "100001");
        defalutMorse('_', "001101");
        defalutMorse('"', "010010");
        defalutMorse('$', "0001001");
        defalutMorse('@', "011010");
    }

    private final char dit; // short mark or dot  嘀
    private final char dah; // longer mark or dash 嗒
    private final char split; //split /

    public MorseCoder() {
        this('.', '-', '/');
    }

    public MorseCoder(char dit, char dah, char split) {
        this.dit = dit;
        this.dah = dah;
        this.split = split;
    }

    /**
     * 编码
     * 中文转换为Unicode后变成二进制默认用01表示
     * @param text
     * @return
     */
    public String encode(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text should not be null.");
        }
        StringBuilder morseBuilder = new StringBuilder();
        text = text.toUpperCase();
        for (int i = 0; i < text.codePointCount(0, text.length()); i++) {
            int codePoint = text.codePointAt(text.offsetByCodePoints(0, i));
            String word = alphabets.get(codePoint);
            if (word == null) {
                word = Integer.toBinaryString(codePoint);
            }
            morseBuilder.append(word.replace('0', dit).replace('1', dah)).append(split);
        }
        return morseBuilder.toString();
    }

    public String decode(String morse) {
        if (morse == null) {
            throw new IllegalArgumentException("Morse should not be null.");
        }
        StringBuilder textBuilder = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(morse, String.valueOf(split));
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken().replace(dit, '0').replace(dah, '1');
            Integer codePoint = dictionaries.get(word);
            if (codePoint == null) {
                codePoint = Integer.valueOf(word, 2);
            }
            textBuilder.appendCodePoint(codePoint);
        }
        return textBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MorseUtil().encode("SOS"));
    }

}
