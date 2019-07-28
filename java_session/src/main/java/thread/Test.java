package thread;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.*;

public class Test {
    static String[] map = {"壹","贰","叁","肆","伍","陆","柒","捌","玖"};
    public static void main1(String[] args) throws InterruptedException{
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String number = in.next();
            resolve(number);
        }
        in.close();
    }
    private static void resolve(String str){
        String[] strArr = str.split("\\.");
        //整数部分
        int number = Integer.valueOf(str.split("\\.")[0]);

        StringBuffer res = new StringBuffer("人名币");
        int yi = (int)(number/100000000);
        if (yi != 0){
            res.append(resolveQian(yi)).append("亿");
            number = number - yi*100000000;
        }
        int wan = (int)(number/10000);
        if (wan != 0){
            res.append(resolveQian(wan)).append("万");
            number = number - wan*10000;
        }
        //一次性处理千百十个位
        String beforePointString = resolveQian(number);
        if (beforePointString.length()>0){
            res.append(beforePointString).append("元");
        }
        //若有小数点,处理小数点后面位数
        //小数点后面处理
        //System.out.println(strArr.length);
        if (strArr.length>1){
            String afterString = strArr[1];
            res.append(handleNumberAfterPoint(afterString));
        }

        String string = res.toString();
        //在resolveQian()方法里可能会返回 零xxx
        //但在最高位不能有"零";
        if (string.length()>4&&string.charAt(3)=='零'&&string.charAt(4)!='零'){
            string = string.substring(0,3)+string.substring(4);
        }
        System.out.println(string);
    }
    //处理四位数 千百十个位
    public static String resolveQian(double temp){
        StringBuffer stringBuffer = new StringBuffer();

        //千位
        int qian = (int) (temp/1000);
        if (qian != 0){
            stringBuffer.append(map[qian-1]).append("仟");
            temp = temp - qian*1000;
        }
        //百位
        int bai = (int) (temp/100);
        if (bai != 0){
            stringBuffer.append(map[bai-1]).append("佰");
            temp = temp - bai*100;
        }
        if (qian!=0&&bai==0){
            stringBuffer.append("零");
        }
        //十位
        int shi = (int) (temp/10);
        if (shi != 0){
            stringBuffer.append(map[shi-1]).append("拾");
            temp = temp - shi*10;
        }
        if (bai!=0&&shi==0){
            stringBuffer.append("零");
        }
        //个位
        int ge = (int) (temp%10);
        if (ge != 0){
            //5 0001 这种情况 千百十位均为0;
            if (qian == 0&&bai==0&&shi==0){
                stringBuffer.append("零");
            }
            stringBuffer.append(map[ge-1]);
        }
        String res = stringBuffer.toString();
        return res;
    }
    //处理小数点后面的数
    public static String handleNumberAfterPoint(String str){
        String res = "";
        if(str.equals("00") ||str.equals("0")){ res = "整"; }else{if(str.charAt(0)!='0'){ res += map[Integer.valueOf(str.charAt(0)+"")-1]+"角"; }if(str.length()>1 && str.charAt(1)!='0'){

            res += map[Integer.valueOf(str.charAt(1)+"")-1]+"分"; } }
        return res;
    }
}

