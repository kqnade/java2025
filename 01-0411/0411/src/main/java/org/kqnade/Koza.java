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
        my_koza = new Koza();
        System.out.println("my_kozaの値は" + my_koza);

        my_koza._gankin = 10000;
        kotae = my_koza.Risoku(6);
        System.out.println("利息は" + kotae);

        System.exit(0);
    }
}