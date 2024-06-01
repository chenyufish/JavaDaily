//完整java代码
import java.util.*;

/**
 * 逆波兰表达式(后缀表达式）
 * 支持整数、浮点 + - * / ( )运算符，可自动过滤非法字符
 */
public class test3 {
    public static void main(String[] args) {
        String expression = "(2.1-1)* 3.1+  15/(2+4)";
        System.out.println("中缀表达式：" + expression);
        List<String> list = toInfixExpressionList(expression);
        System.out.println("中缀表达式List：" + list);
        List<String> suffixExpression = parseSuffixExpression(list);
        System.out.println("后缀表达式List：" + suffixExpression);
        float calculate = calculate(suffixExpression);
        System.out.println("计算结果：" + calculate);
    }

    public static List<String> parseSuffixExpression(List<String> ls) {
        Stack<String> s1 = new Stack<>();//运算符栈
        Queue<String> s2 = new ArrayDeque<>();//临时队列

        for (String item : ls) {
            if (item.matches(REGEX_FLOAT)) {
                //3.如果是数字，直接入队s2
                s2.offer(item);
            } else if (isOper(item)) {
                //4.如果是运算符
                while (true) {
                    if (s1.isEmpty() || "(".equals(s1.peek())) {
                        //4.1如果运算符栈s1是空的，或栈顶是左括号，则直接入栈
                        s1.push(item);
                        break;
                    } else if (priority(item) > priority(s1.peek())) {
                        //4.2否则，若运算符优先级比栈顶的高，也入栈
                        s1.push(item);
                        break;
                    } else {
                        //4.3 否则，直接把栈顶的元素入队，继续转到4.1与新的栈顶元素比较
                        s2.offer(s1.pop());
                    }
                }
            } else if ("(".equals(item)) {
                //5.1如果遇到左括号( ，直接压入s1
                s1.push(item);
            } else if (")".equals(item)) {
                //5.2如果是右括号
                while (true) {
                    String top = s1.pop();//弹出栈顶元素
                    if ("(".equals(top)) {
                        //碰到左括号，丢弃这对括号
                        break;
                    } else {
                        //否则入队
                        s2.offer(top);
                    }
                }
            } else {
                throw new RuntimeException("无法识别的字符" + item + ",表达式不正确");
            }
        }
        while (!s1.isEmpty()) {
            //7.将s1剩余的表达式依次弹出并入队
            s2.offer(s1.pop());
        }

        List<String> res = new ArrayList<>();
        while (!s2.isEmpty()) {
            res.add(s2.poll());
        }
        return res;
    }

    public static boolean isOper(String val) {
        return "+".equals(val) || "-".equals(val) || "*".equals(val) || "/".equals(val);
    }

    public static List<String> toInfixExpressionList(String s) {
        List<String> ls = new ArrayList<>();
        int i = 0;//指针，用于遍历中缀表达式字符串
        String str;//对多位数的拼接工作
        char c;//每遍历到一个字符，放入c
        do {
            c = s.charAt(i);//获取元素
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')') {
                //如果元素是运算符直接添加到List
                ls.add(c + "");
                i++;
            } else if (Character.isDigit(c) || c == '.') {
                //如果元素是数字和小数点
                str = "";
                while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '.')) {//直至下个不是小数点或数字的位置
                    str += "" + s.charAt(i++);
                }
                ls.add(str);
            } else {
                i++;
            }
        } while (i < s.length());

        return ls;
    }


    public static int priority(String operString) {
        if ("*".equals(operString) || "/".equals(operString)) {
            return 1;
        } else if ("+".equals(operString) || "-".equals(operString)) {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 数字正则
     */
    private final static String REGEX_FLOAT = "\\d+||\\d*\\.\\d+||\\d*\\.?\\d+?e[+-]\\d*\\.?\\d+?||e[+-]\\d*\\.?\\d+?";

    public static float calculate(List<String> ls) {
        Stack<String> stack = new Stack<>();
        for (String item : ls) {
            if (item.matches(REGEX_FLOAT)) {
                stack.push(item);//如果是数字则入栈
            } else {
                //如果不是数字，则弹出栈顶和次栈顶元素进行计算
                Float num2 = Float.parseFloat(stack.pop());
                Float num1 = Float.parseFloat(stack.pop());
                Float res = 0f;
                if ("+".equals(item)) {
                    res = num1 + num2;
                } else if ("-".equals(item)) {
                    res = num1 - num2;
                } else if ("*".equals(item)) {
                    res = num1 * num2;
                } else if ("/".equals(item)) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //计算过的结果再次入栈
                stack.push("" + res);
            }
        }
        //栈中的结果就是表达是的结果，直接返回
        return Float.parseFloat(stack.pop());
    }

}
