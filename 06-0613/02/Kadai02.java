class Kadai02 {
  public static double calcAverage(int a, int b, int c, int d, int e){
    double average = (a+b+c+d+e)/5;
    return average;
  }
  public static void main(String[] args){
    int arg0 = Integer.parseInt(args[0]);
    int arg1 = Integer.parseInt(args[1]);
    int arg2 = Integer.parseInt(args[2]);
    int arg3 = Integer.parseInt(args[3]);
    int arg4 = Integer.parseInt(args[4]);

    double average = calcAverage(arg0,arg1,arg2,arg3,arg4);

    System.out.println(average);
  }
}


