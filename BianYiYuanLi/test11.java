import java.util.*;
public class test11 {
    static String k[]={"do","end","then","if","printf","scanf","then","while","auto","break","case","char",
            "const","continue","default","double","else","enum","extern","float","goto","int","long","register",
            "return","short","signed","sizeof","static","struct","switch",
            "typedef","union","unsigned","void","volatile","inline"};//1 关键字
    static char s[]={',',';','(',')','[',']','{','}'};//2 分界符
    static char m[]={'+','-','*','/'};//3 算术运算符
    static String r []={"<","<=","=",">",">=","<>"};//4 关系运算符
    ArrayList<String> ci= new ArrayList<>();//5 常数
    ArrayList<String> id= new ArrayList<>();//6 标识符
    int pint;
    String strtoken="";
    int row;
    int line;
    char ch;
    String instring;
    
    test11(){//简简单单初始化
        instring="if i=0 then n++;\na<= 3b %);";
        row=1;
        line=1;
        pint=-1;
    }


    public static void main(String args[]) throws Exception{
    	test11 one = new test11();
        one.handle();
    }
    
    boolean isdigit( char c){// 判断字符 c是否是数字
        if (c>=48&&c<=57) return true ;
        return false ;
    }

    boolean isletter( char c){// 判断字符 c是否是字母
        if ((c>64&&c<91)||(c>96&&c<123)) return true ;
        return false ;
    }

    boolean isline( char c){// 判断字符 c是否是下划线
        if (c=='_') return true ;
        return false ;
    }

    boolean remove(){// 用于在判断关系运算符时，判断是否是要再读一个字符
        char b=instring.charAt(pint+1);
        if (b=='='||b=='>'){// 当其后的字符是 =或>时, 要再读一个字符。否则不要再读。
            return true ;
        }
        return false ;
    }


    boolean sremove(){//用于判断算数运算符时，是否需要再读一个字符
        char b = instring.charAt(pint);
        char bn=instring.charAt(pint+1);
        String s = Character.toString(b)+Character.toString(bn);
        if ("++".equals(s)||"--".equals(s)){
            return true;
        }
        return false;
    }


    void getbc(){// 检查空白直到读入字符非空白
        while (ch==' '){
            getchar();
        }
    }


    void getchar(){// 读入下一个字符
        pint++;
        if (pint<=instring.length()-1){// 当指针没有越界时， 可读字符
            ch=instring.charAt(pint);
            if (ch=='\n'){
                change_r_l();
                getchar();
            }
        }
        else ch=' ';// 当指针越界时，置 ch为空白符
    }


    void retract(){// 读入前一个字符
        pint--;
        ch=instring.charAt(pint);
    }

    void words(){// 识别字符串
        strtoken="";// 先将strtoken 置空
        while (isletter(ch)||isdigit(ch)||isline(ch)){// 当是字母，数字，下划线时继续识别字符串
            strtoken=strtoken+ch;// 将新识别的字符加到 strtoken后
            getchar();
        }
    }

    void num(){// 识别数字串
        strtoken="";
        while (isdigit(ch)){
            strtoken=strtoken+ch;
            getchar();
        }
        if (isletter(ch)||isline(ch)){// 识别完数字串而其后是字母，下划线时出错处理
            while (isletter(ch)||isline(ch)||isdigit(ch)){// 当是字母，数字，下划线时继续识别错误数字串
                strtoken=strtoken+ch;// 将 新 识 别 的 字 符 加 到strtoken 后
                getchar();
            }
            show(0,strtoken,' ');// 输出错误数字串
            strtoken="";// 将strtoken 置空返回
        }
    }


    void show( int i,String s, char a){// 各种输出处理
        switch (i){
            case -1:System. out .println(a+" "+"        Error"+"        Error       "+"     ("+row+","+line+")");
                break ;
            case 0:System. out .println(s+" "+"         Error"+"        Error       "+"     ("+row+","+line+")");
                break ;
            case 1:System. out .println(s+" "+"     (1,"+s+")       "+" 关 键 字"+"     ("+row+","+line+")");
                break ;
            case 2:System. out .println(a+" "+"     (2,"+a+")       "+" 分 界 符"+"     ("+row+","+line+")");
                break ;
            case 3:System. out .println(a+" "+"     (3,"+a+")       "+" 算 术 运 算 符"+"       ("+row+","+line+")");
                break ;
            case 4:System. out .println(s+" "+"     (4,"+s+")       "+" 关 系 运 算 符"+"       ("+row+","+line+")");
                break ;
            case 5:System. out .println(s+" "+"     (5,"+s+")       "+" 常 数"+"        ("+row+","+line+")");
                break ;
            case 6:System. out .println(s+" "+"     (6,"+s+")       "+" 标 识 符"+"     ("+row+","+line+")");
                break ;
        }
        line++;// 列数加一
    }

    void change_r_l(){// 改变行列数
        row++;
        line=1;
    }


    void handle(){
        pint=-1;
        System.out .println(" 要处理的语句为 ： ");
        System.out .println(instring);
        System.out .println("单词      "+"二元序列     "+"类型     "+"位置");
        getchar();

        while (pint<instring.length()){
            getbc();

            if (isdigit(ch)){// 当ch为数字          
                num();
                if (strtoken.length()!=0){
                    if (reseverci(strtoken)==-1){// 如果 strtoken 不在 ci 中，将 strtoken 加入ci 表中
                        ci.add(strtoken);// 将strtoken 加入ci 表中
                        show(5,strtoken,' ');
                    }
                    else {// 如果 strtoken 在ci 表中，仅输出//System.out.println(one.strtoken+" 是 第"+one.reseverci(one.strtoken)+" 个已经识别的常数 ");
                        show(5,strtoken,' ');
                    }
                }
            } else if (isletter(ch)){// 当ch为字母时进行字符串识别
                words();
                if (reserve(strtoken)==-1){// 如果 strtoken 不在 k表中
                    if (reseverid(strtoken)==-1){// 如果 strtoken 不 在id 表中
                        id.add(strtoken);// 将strtoken 加入id 表中
                        show(6,strtoken,' ');// 输出标识串
                    }
                    else {// 如果strtoken 在id 表中
                        show(6,strtoken,' ');// 输出标识串
                    }
                } else {// 如果strtoken 在k表中
                    show(1,strtoken,' ');// 输出关键字
                }

            } else if (in_s(ch)!=-1){
            } else if (in_m(ch)!=-1){
            } else if (in_k(ch)!=-1){
            } else {
                show(-1, "",ch);//error
                getchar();// 读下一位
            }
        }
    }

    int reserve(String s){// 判断识别的关键字是否在 k 表中
        int i;
        for (i=0;i< k.length;i++){
            if (s.equals( k[i])){
                return i;// 是保留字，就返回编码
            }
        }
        return -1;
    }
    int reseverid(String s){// 判断识别的标志符是否已经在 id 表 中
        int i;
        for (i=0;i<id.size();i++){
            if (s.equals(id.get(i)))
                return i;// 识别的标志符已经在 id 表中，返回位置
        }
        return -1;
    }

    int reseverci(String s){// 判断识别的数字串是否已经在 ci 表 中
        int i;
        for (i=0;i<ci.size();i++){
            if (s.equals(ci.get(i)))
                return i;// 识别的数字串已经在 ci 表中，返回位置
        }
        return -1;
    }
    int in_s( char c){// 查找分界符
        int i;
        for (i=0;i< s.length;i++) {
            if (c == s[i]) {// 与某个分界符配备时
                show(2, "", c);// 输出分界符
                getchar();// 读下一位
                return i;// 返回所在位置
            }
        }
        return -1;
    }
    int in_m( char c){// 查找算术运算符
        int i;
        if ( sremove() == false) {
            for (i = 0; i < m.length; i++)
                if (c == m[i]) {// 与某个算术运算符配备时
                    show(3, "", c);// 输出算术运算符
                    getchar();// 读下一位
                    return i;// 返回所在位置
                }
        }else{
            char a[]= new char [2];// 将两位字符放入 a中
            a[0]=c;
            getchar();
            a[1] = ch;
            show(0,String.valueOf(a),' ');
            getchar();
            return 0;
        }
        return -1;
    }

    int in_k( char b){// 查找关系运算符
        int i;
        if (remove()== false ){// 读下一位为假时， 进行一位关系运算符识别
            for (i=0;i< r .length;i++)
                if (r [i].length()==1){// 当关系运算符为一位时，尝试匹配
                    if ( r [i].equals(Character. toString (b))){
                        show(4, r [i],' ');// 输出关系运算符
                        getchar();
                        return i;
                    }
                }
        } else {// 读下一位为假时，进行两位关系运算符识别
            char a[]= new char [2];// 将两位字符放入 a中
            a[0]=b;
            getchar();
            a[1]=ch;
            for (i=0;i< r.length;i++)
                if ( r[i].length()==2){// 当关系运算符为两位时， 尝试匹配
                    if ( r [i].equals(String. copyValueOf(a))){
                        show(4, r [i],' ');// 输出关系运算符
                        getchar();// 读下一位
                        return i;// 返回所在位置
                    }
                }
            retract();// 两位关系运算符匹配失败，读入前一个字符
        }
        return -1;// 不在关系运算表中
    }
}
 