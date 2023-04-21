package com.example;

import java.util.Objects;

public class Main {

    static class CustomKey
    {
        private String str;
        private Integer number;

        public int hashCode()
        {
            return str.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CustomKey customKey = (CustomKey) o;
            return Objects.equals(str, customKey.str);
        }
        public CustomKey(String str, Integer number) {
            this.str = str;
            this.number = number;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }
    }

    public static void main(String[] args) {


//        IWHashMap<Integer, String> hashMap = new WHashMap<>();
//        hashMap.put(10, "sarang");
//        System.out.println(hashMap.get(10));
//        hashMap.put(10, "sarang");
//        hashMap.put(11, "walllmart");
//        System.out.println("for 11 : " + hashMap.get(11));
//        System.out.println(hashMap.get(10));
//        System.out.println("size=" + hashMap.getSize());
//        hashMap.delete(10);
//        System.out.println(hashMap.get(10));
//        System.out.println("size=" + hashMap.getSize());

        IMyHashMap<String, String> hashMap2 = new MyHashMap<>();
        hashMap2.put("sarang", "bagade");
        hashMap2.put("sarang", "bagade2");
        System.out.println(hashMap2.get("sarang"));
        hashMap2.remove("sarang");
        System.out.println(hashMap2.get("sarang"));



        IMyHashMap<CustomKey, String> hashMap3 = new MyHashMap<>();
        CustomKey key1 = new CustomKey("sarang", 100);
        hashMap3.put(key1, "bagade");

        System.out.println(hashMap3.get(key1));
    }
}
