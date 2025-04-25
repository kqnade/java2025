package org.kqnade;

class Koza {
    double _riritsu;
    int _gankin;

    Koza() {
        _riritsu = 0.01;
    }
    double Risoku(int month){
        for (int i = 0; i < month; i++) {
            _gankin = (int) (_gankin * (1 + _riritsu));
        }
        return _gankin;
    }

    public static void main(String[] args) {
        double kotae;
        Koza my_koza;
        int month = 0;
        my_koza = new Koza();
        if (args.length == 2) {
            try {
                month = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.out.println("2引数は整数で指定してください");
                System.exit(1);
            }
        } else if (args.length != 1) {
            System.out.println("引数は1つか2つ指定してください");
            System.exit(1);
        } else {
            month = 12;
        }
        try {
            my_koza._gankin = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("1引数は整数で指定してください");
            System.exit(1);
        }

        System.out.println("my_kozaの値は" + my_koza);
        kotae = my_koza.Risoku(month);
        System.out.println(month + "ヶ月後の利息は" + kotae);

        // exit
        System.exit(0);
    }
}