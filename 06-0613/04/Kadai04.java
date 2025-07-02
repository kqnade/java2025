class Kadai04 {
  public static int isUnder18(int num){
    return num>=10?0:1;
  }
  public static void main(String[] args){
    int arg = Integer.parseInt(args[0]);

    int result = isUnder18(arg);

    System.out.println(result);
  }
}
