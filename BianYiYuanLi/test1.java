import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class test1 {
	private static int code;
	private static String word = "";
	private static ArrayList<String> list = new ArrayList<String>();
	private static String sourceFileName = "G:\\code\\java\\JavaDaily\\BianYiYuanLi\\input.txt";
	private static String keyWordsFileName = "G:\\code\\java\\JavaDaily\\BianYiYuanLi\\KeyWords.txt";
	private static String sourceFileTxt = "";
	private static int IDCODE;
	private static int NUMCODE;

	public static void main(String[] args) {
		sourceFileTxt = readFile(sourceFileName);
		list = getKeys(keyWordsFileName);
	
		IDCODE = list.size() + 1;
		NUMCODE = IDCODE + 1;
		getToken((sourceFileTxt.replaceAll("\r|\n|\t", " "))); // 去除换行
	}
	
	private static void getToken(String contents) {
		int index = 0;
		boolean isFind = false; 
		boolean mayBeNum = false; 
		boolean mayBeID = false; 
	
		while (index < contents.length()) {
			char character = contents.charAt(index);
	
			if (!isFind) {
				// 当前token也许是关键字
				if (list.contains(word)) {
					// 像这种可以凑个=号的要特殊关照
					if (isEquals(word, "<", ">", "=", "+", "-", "*", "/") && character == '=') {
						// 像<=还要考虑其后面是数字或字母才能确定，但像main则不适用此规则，所以我特地这样
						word += character;
						index++;
						isFind = true;
						continue;
					} else if ((word.equals("-") && character == '-') || (word.equals("+") && character == '+')) {
						word += character;
						index++;
						isFind = true;
						continue;
					} else if (word.length() == 1) { // 不是上面那些字符的话，一个字的关键字必然是
						isFind = true;
					} else {
						// main、if...后面要接这些字符才能确定
						if (isEquals(character + "", "(", "{", ":", " ")) {
							isFind = true;
						}
					}
				}
			}
	
			if (!isFind) {
				if (word.length() >= 1) {
					if (mayBeNum) {
						// 在可能是数字的情况下下一个字符不是数字字符，则确定当前token是数字常量
						if (!isNum(character)) {
							isFind = true;
							code = NUMCODE;
						}
					}
					if (mayBeID) { // 这也一样
						if (!isLetter(character)) {
							isFind = true;
							code = IDCODE;
						}
					}
				} else if (word.equals("")) { // 空串时遇到字母或数字必须考虑其可能性
					if (isNum(character)) {
						mayBeNum = true;
					} else if (isLetter(character)) {
						mayBeID = true;
					}
				}
			}
	
			if (isFind) {
				if (code > 0) {
					if (code == IDCODE) {
						word = "ID";
					} else if (code == NUMCODE) {
						word = "NUM";
					}
				} else {
					code = list.indexOf(word) + 1;
				}
	
				System.out.println("(" + code + " ," + word + ")");
	
				isFind = false;
				mayBeNum = false;
				mayBeID = false;
	
				word = "";
				code = 0;
			}
	
			if (!mayBeNum && word.length() == 0 && isNum(character)) {
				continue;
			}
			if (!mayBeID && word.length() == 0 && isLetter(character)) {
				continue;
			}
	
			// 字符肯定要加在一起
			if (character != ' ') {
				word += character;
			}
			index++;
		}
	}
	
	private static boolean isNum(char character) {
		if (character >= '0' && character <= '9') {
			return true;
		}
		return false;
	}
	
	private static boolean isLetter(char character) {
		if ((character <= 'Z' && character >= 'A') || (character <= 'z' && character >= 'a')) {
			return true;
		}
		return false;
	}
	
	private static boolean isEquals(String word, String... agrs) {
		for (String value : agrs) {
			if (value.equals(word)) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * 获取关键字数组
	 */
	private static ArrayList<String> getKeys(String fileName) {
		String txt = readFile(fileName);
		String[] keys = txt.replaceAll("\\s*", "").split(",");
		ArrayList<String> list = new ArrayList<>();
		for (String key : keys) {
			list.add(key);
		}
		return list;
	}
	
	/*
	 * 读取指定文件，将整个文件内容以字符串返回
	 */
	private static String readFile(String fileName) {
		String encoding = "UTF-8";
		File file = new File(fileName);
		Long filelength = file.length();
		byte[] filecontent = new byte[filelength.intValue()];
		try {
			FileInputStream in = new FileInputStream(file);
			in.read(filecontent);
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			return new String(filecontent, encoding);
		} catch (UnsupportedEncodingException e) {
			System.err.println("The OS does not support " + encoding);
			e.printStackTrace();
			return null;
		}
	}
}
