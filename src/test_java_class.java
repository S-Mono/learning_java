import java.util.*;

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
        //|--(1)整数型
            byte bt = -128; //-128~127
            short st = 32767; // -32768~32767
            int i = 2100000000; // -2147483648 ~ 2147483647
            long lg = 9200000000000000000L; // -9223372036854775808 ~ 9223372036854775807 とにかくでかい値を扱える

        //|--(2)浮動小数点型
            float ft = 0.40000345f; //32ビット符号付き浮動小数点
            double db = 3.4; //64ビット符号付き浮動小数点　小数点を扱うなら基本doubleで問題ない。扱える値は最も多く、とても大きい(小さい）値を扱える。

        //|--(3)文字型
            char c = 97; //16ビットUnicodeを整数で指定したり
            char c2 = '\u1F1C'; //16進数で指定したり
            char c3 = 'U'; //''シングルクォーテーションで1文字を指定したりできる

        //|--(4)真偽値
            boolean bl = true; //true/falseの2値

        //◇参照型
        //|--(1)オブジェクト型
            Date date = new Date(); //一例としてDate型のオブジェクトをインスタンス

        //|--(2)配列型
            String str[] = {"star","moon","earth"};
            int it[] = {1,2,3,4,5};

        //|--(3)列挙型
//           enum animal{ //この場合の「animal」が「列挙型名」,DogやCatなどが「列挙定数」,犬や猫はフィールド変数
//                Dog("犬"),
//                Cat("猫"),
//                Mouse("鼠"),
//                Monkey("猿");
//
//                private String label;
//
//                //↓()内の列挙定数が持つ値の名前を「label」に指定している。
//                animal(String label){
//                    this.label = label;
//                }
//            }
        //列挙型は決まっている値を参照する場合にとても有効。値を持たせることもできる。
        //列挙型名はユニークである必要がある。


        //if文の例
        int counter = 3;

        if(counter >= 0){
            System.out.println("counterは0以上です。");
        }else if (counter == 0) {
            System.out.println("counterは0です。");
        }else{
            System.out.println("counterは0以下です。");
        }

        //switch文の例
        switch (counter){
            case 0:
                System.out.println("counterは0と判定しています。");
                break;
                //breakがない場合は処理を継続してしまうので注意。
            default:
                //defaultはcaseの条件に当てはまらない場合の処理をどうするか定義することができる。
                System.out.println("counterは0以外と判定しています。");
                break;
        }

        int a = 2;
        int b = 5;
        for(int j = 0; j < 5; j++){
            //if文における簡潔な構文
            //      ↓(条件式)? 値または式 : 値または式;
            a += (a > b)?1:3;
            //上記はbよりaが大きい場合は1を足し、それ以外は3を足すという意味
            //if文だと4行程になるが、上記だと1行で済むので簡潔に記載できる。
            System.out.println("a:::" + a);
        }

        System.out.println("----------------------------------");
        System.out.println("----------------------------------");
        System.out.println("------------九九の計算表------------");
        //for文の例(九九の表作成)
        for(int k = 1; k < 10; k++){
            for(int l = 1; l < 10; l++){
                System.out.print(k*l + "\t");
            }
            System.out.println("");
            //System.out.print("\r\n") でも可。
        }

        System.out.println("----------------------------------");
        System.out.println("----------------------------------");
        System.out.println("----------引っ越しの料金表-----------");
        //for文の例(引っ越しの料金表作成)
        System.out.print("\t" + "\t");
        int weight = 0;
        for(weight = 20; weight <= 200; weight += 20){
            System.out.print(weight + "kg" + "\t");
        }
        System.out.println("");
        for(int distance = 10; distance <= 100; distance += 10){
            System.out.print(distance + "km");
            for(weight = 20; weight <= 200; weight += 20){
                System.out.print("\t" + distance * weight * 50);
            }
            System.out.println("");
        }
        System.out.println("----------------------------------");

        //-----配列-----
        //一次元配列の例
        int cArr[] = {1,2,3,4,5};
        for (int m = 0; m < cArr.length; m++){
            System.out.println("cArr:::::" + cArr[m]);
        }

        //多次元配列の例
        //int test[][];
        //↓このように初期化もできるけど、実用性はあまりない。
        int[][] arrNum;
        arrNum = new int[3][5];
        arrNum[0][0] = 20;
        arrNum[0][1] = 28;
        //どっちかというと↓の方が実用的。
        int score[][] = {
                {20,28,40,19,50},{30,29,58,37,45},{50,39,29,48,58}
        };

        //可変長配列(コレクション）クラス　ArrayListクラス
        //import java.util.ArrayList のインポート文が必要（今回は*で包括する)
        ArrayList arrList = new ArrayList();
        //ArrayList型のオブジェクトを作成してから使用すること。

        //.isEmpty は　要素が空かどうかを判定する。空ならtureが返る。
        System.out.println(arrList.isEmpty());

        for(i = 0; i <=100; i++){
            if(i % 5 == 0){
                //.add は　要素を追加するメソッド
                arrList.add(i);
            }else if(i % 50 == 0){
                //.size は　要素数を取得するメソッド。
                System.out.println(arrList.size());
            }
        }

        for(int j = 0; j < arrList.size(); j++){
            //.get は　指定した位置の要素を取得するメソッド。
            System.out.print(arrList.get(j) + "\t");
        }

        //ArrayListクラスで使用できるメソッド
//        (void).add     :リストの指定インデックス位置に指定された要素を追加する。
//        (boolean).add  :リストの末尾に要素を追加する。
//        .clear    :リストからすべての要素を削除する。
//        .get      :リストの指定された位置の要素を取得する。
//        .indexOf  :(equals()メソッドを使って)引数と同じ指定要素を先頭から検索する。
//        .isEmpty  :リストが空かどうかを調べる。空の場合trueが返る。
//        .remove   :リストの指定された位置から要素を削除する。
//        .set      :リストの指定された位置の要素を指定された要素の置き換える。
//        .size     :リストの要素数を取得する。

        int arrIndex;
        for(int arr = 0; arr < arrList.size(); arr++){
            //          ↓↓↓　ArrayList型を変数に代入する場合は、変数の型にキャストする必要がある。
            arrIndex = (int) arrList.get(arr);
            System.out.println("arrIndex:::::" + arrIndex);
        }


    }
}
