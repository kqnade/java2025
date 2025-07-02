class MyPointApp {
  public static void main(String[] args){
    int x = Integer.parseInt(args[0]);
    int y = Integer.parseInt(args[1]);
    int z = Integer.parseInt(args[2]);

    MyPoint mp = new MyPoint(x, y, z);

    mp.print();
  }
}


