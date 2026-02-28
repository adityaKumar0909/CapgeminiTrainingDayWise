package com.ak;

class StringAlgo {
    String funct(String str) throws Exception {
            if (str == null) {
                Exception e = new Exception();
                throw e;
            }
        if(str.length() <=2) return str;
        return str.substring(2)+str.substring(0,2);
    }

    public static void main(String[] args) throws Exception {
            String str = null;
            StringAlgo obj = new StringAlgo();
            try {
                System.out.println(obj.funct(str));
            }
            catch (Exception e){
                System.out.println(e);
            }
    }


}
