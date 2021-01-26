import java.util.Date;
import java.util.Scanner;

public class test_java_class {
//    ＜エントリポイントの条件＞
//    ・公開されていること（publicであること）
//    ・インスタンスを生成しなくても実行できること（staticであること)
//    ・戻り値は戻せない（戻り値がvoidであること)
//    ・メソッド名は「main」であること
//    ・引数はString配列型を１つ受け取ること
//    ↓メインメソッドいわゆるエントリポイント
    public static void main(String[] args){
        //標準出力の例
        System.out.println("テストで標準出力");

        //標準入力の例(Scannerを使用する場合はimportが必要)
        //Scannerクラスのオブジェクトを作成し「System.in」でKey入力を渡してあげる必要がある。
        Scanner scan = new Scanner(System.in);
        //Scanner型のscan変数を定義しインスタンス化、
        String scanInputKey = scan.nextLine();
        System.out.println(scanInputKey);
        //scan.nextLine()でターミナルの入力を待機し、入力されたKeyをprintで出力。

        //変数の種類と定義
        //データ型には「プリミティブ型」と「参照型」が存在する
        //◇プリミティブ型
        //|--①整数型
            byte bt = -128; //-128~127
            short st = 32767; // -32768~32767
            int i = 2100000000; // -2147483648 ~ 2147483647
            long lg = 9200000000000000000L; // -9223372036854775808 ~ 9223372036854775807 とにかくでかい値を扱える

        //|--②浮動小数点型
            float ft = 0.40000345f; //32ビット符号付き浮動小数点
            double db = 3.4; //64ビット符号付き浮動小数点　小数点を扱うなら基本doubleで問題ない。

        //|--③文字型
            char c = 97; //16ビットUnicode

        //|--④真偽値
            boolean bl = true; //true/falseの2値

        //◇参照型
        //|--①オブジェクト型
            Date date = new Date(); //一例としてDate型のオブジェクトをインスタンス

        //|--②配列型
            String str[] = {"star","moon","earth"};
            int it[] = {1,2,3,4,5};

        //|--③列挙型
            enum animal{ //この場合の「animal」が「列挙型名」,DogやCatなどが「列挙定数」,犬や猫はフィールド変数
                Dog("犬"),
                Cat("猫"),
                Mouse("鼠"),
                Monkey("猿");

                private String label;

                //↓()内の列挙定数が持つ値の名前を「label」に指定している。
                animal(String label){
                    this.label = label;
                }
            }
        //列挙型は決まっている値を参照する場合にとても有効。値を持たせることもできる。
        //列挙型名はユニークである必要がある。


    }
}
