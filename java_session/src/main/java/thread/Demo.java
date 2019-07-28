package thread;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            String strC = in.next();
          String[] strings = str.split("\\.");
            StringBuffer strB = new StringBuffer();
            strB.append(calculate(strings[0])).append(calculate(strings[1]))
                    .append(calculate(strings[2])).append(calculate(strings[3]));
            System.out.println(strB.toString());
             long b = calculateA(strB.reverse().toString());
             String c = compute(computeA(strC));
            System.out.println(b);
            System.out.println(c);
        }

    }
    private  static String  computeA(String str){
        int a = Integer.parseInt(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (a !=0 ){
            stringBuffer.append(a%2);
            a = a>>1;
        }
        String ss = "";
        for (int i = 0; i < (32-stringBuffer.length()); i++) {

           ss+="0";
        }
        stringBuffer.append(ss);
        return  stringBuffer.reverse().toString();
    }
    //计算四位
    private static String compute(String str){
        StringBuffer stringBuffer = new StringBuffer();
        String a = "";
        int sum ;
        int mult;
        for (int i = 0; i < str.length(); i=i+8) {
            a = str.substring(i,i+8);
           // System.out.println(a);
             sum = 0;
             mult = 128;
            for (int j = 0; j < a.length(); j++) {
                sum += Integer.parseInt(a.substring(j,j+1))*mult;
                mult /= 2;
            }
           // System.out.println(sum);
            stringBuffer.append(sum);
            if (i<24){
                stringBuffer.append(".");
            }
        }
        return stringBuffer.toString();
    }
    private static long calculateA(String str){
        long sum = 0;
        int mult = 1;
        for (int i = 0; i < str.length(); i++) {
            sum += Integer.parseInt(str.substring(i,i+1))*mult;
            System.out.println(sum);
            mult *= 2;
        }
        return sum;
    }
    private static String calculate(String str){
        StringBuffer string = new StringBuffer();
        int flag = Integer.parseInt(str);
        while (flag!=0){
            string.append(flag%2);
            flag = flag>>1;
        }

        String string1 = string.reverse().toString();
        String s = "" ;
        if (string1.length()<8){
            for (int i = 0; i < 8-string1.length(); i++) {
                s +="0";
            }
        }
        s += string1;
        return s;
    }
}
