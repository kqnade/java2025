class Kadai01 {
  static double calcArea(double width, double height){
    double ans;
    ans = (width * height)/2;
    return ans;
  }
  public static void main(String[] args){
    double arg0 = Double.parseDouble(args[0]);
    double arg1 = Double.parseDouble(args[1]);

    double answer = calcArea(arg0, arg1);

    System.out.println(answer);
  }
}
