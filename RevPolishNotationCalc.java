// 課題1のプログラムRevPolishNotationCalcクラスを作成する
import java.util.Scanner;
import java.util.Stack;

public class RevPolishNotationCalc {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("逆ポーランド記法の式を入力してください：");
        System.out.println("計算開始！");
        System.out.println("がんばれ！");
        String input = scanner.nextLine();
        scanner.close();

        String[] tokens = input.split(" ");
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperator(a, b, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        if (stack.size()==1) {
            System.out.println("答え：" +stack.pop());
            System.out.println("計算終了");
        } else {
            System.out.println("エラー：式が正しくありません。");
        }
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static int applyOperator(int a, int b, String operator) {
        switch (operator) {
            case "+": return a+b;
            case "-": return a-b;
            case "*": return a*b;
            case "/": return a/b;
            default:
            throw new IllegalArgumentException("未知の演算子です：" +operator);
        }
    }
}