/**
 * @program JavaBooks
 * @description: 报数
 * @author: mf
 * @create: 2019/05/08 21:46
 */

public class CountAndSay {
    public static void main(String[] args) {
        SolutionCountAndSay solutionCountAndSay = new SolutionCountAndSay();
//        String res = solutionCountAndSay.countAndSay(4);
        String res = solutionCountAndSay.countAndSay1(4);
        System.out.println(res);
    }
}



class  SolutionCountAndSay {
    public String countAndSay(int n) {
        if (n < 1 || n > 30) return null;
        if (n == 1) return "1";
        if (n == 2) return "11";
        String res = "11";
        String temp = "";
        for (int i = 2; i < n; i++) {
            int count = 1;
            char pre = res.charAt(0);
            for (int j = 1; j < res.length(); j++) {
                if(res.charAt(j) == pre) {
                    count++;
                    if (j == res.length() - 1) {
                        temp = temp + count + pre;
                        break;
                    } else {
                        pre = res.charAt(j);
                        continue;
                    }
                } else {
                    if (count != 1) {
                        temp = temp + count + pre;
                        count = 1;
                    } else {
                        temp = temp + "1" + pre;
                    }

                    if (j == res.length() - 1) {
                        temp = temp + "1" + res.charAt(j);
                        break;
                    }
                }
                pre = res.charAt(j);
            }
            res = temp;
            temp = "";
        }
        return res;

    }


    public String countAndSay1(int n) {
        if (n == 1) {
            return "1";
        }
        String str = "1";

        for (int i = 0; i < n - 1; i++) {
            StringBuffer sb = new StringBuffer();
            int count = 0;
            char code = str.charAt(0);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) != code) {
                    sb.append(count);
                    sb.append(code);
                    code = str.charAt(j);
                    count = 1;
                } else {
                    count++;

                }

            }

            sb.append(count);
            sb.append(str.charAt(str.length() - 1));
            str = sb.toString();
        }
        return str;
    }
}