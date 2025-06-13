class Kadai03 {
  public static int isOdd(int num){
    int modulo = num%2;
    return modulo==0?0:1;
  }
  public static void main(String[] args){
    int arg = Integer.parseInt(args[0]);

    int isOdd = isOdd(arg);

    System.out.println(isOdd);
  }
}
