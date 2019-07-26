import java.util.Scanner;

public class Answer {
    //question2
    //消息加密的办法是：对消息原文中的每个字母，分别用该字母之后的第5个字母替换（例如：消息原文中的每个字母A 都分别替换成字母F），其他字符不 变，并且消息原文的所有字母都是大写的。密码中的字母与原文中的字母对应关系如下。
    //密码字母：A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
    //原文字母：V W X Y Z A B C D E F G H I J K L M N O P Q R S T U
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            char[] ch = s.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                char c = ch[i];
                if ('A' <= c) {
                    c = (char) ('E' < c ? c - 5 : c + 21);
                    ch[i] = c;
                }
            }
            System.out.println(new String(ch));
        }
    }

    //question1:
    //统计兔子总数
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int monthCount = scanner.nextInt();
            getTotalCount(monthCount);
            System.out.println(getTotalCount(monthCount));
        }
    }

    //需要使用递归 先写递归出口
    //要有一定的规律
    //Month小于等于2只有1只兔子
    public static int getTotalCount(int monthCount) {
        if (monthCount <= 2) {
            return 1;
        }
        return getTotalCount(monthCount - 1) + getTotalCount(monthCount - 2);
    }
}
