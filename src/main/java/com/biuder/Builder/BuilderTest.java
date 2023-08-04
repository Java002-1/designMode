package com.biuder.Builder;

public class BuilderTest {

    public static void main(String[] args) {
        Product xxx = new Product.Builder().productName("xxx").part1("111").build();
        System.out.println(xxx);
    }
}




class Product {

    private String productName;

    private String  part1;
    private String  part2;
    private String  part3;
    private String  part4;
    private String  part5;
    // ...

    static class Builder{
        private String productName;

        private String  part1;
        private String  part2;
        private String  part3;
        private String  part4;
        private String  part5;

        public Builder productName(String productName) {
            this.productName = productName;
            return this;
        }
        public Builder part1(String part1) {
            this.part1 = part1;
            return this;
        }
        public Builder part2(String part2) {
            this.part2 = part2;
            return this;
        } public Builder part3(String part3) {
            this.part3 = part3;
            return this;
        } public Builder part4(String part4) {
            this.part4 = part4;
            return this;
        } public Builder part5(String part5) {
            this.part5 = part5;
            return this;
        }
        public Product build(){
            return new Product(this.part1,this.part2,this.part3,this.part4,this.part5);
        }
    }

    public Product() {
    }

    public Product(String part1, String part2, String part3, String part4, String part5) {
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
        this.part5 = part5;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    public String getPart3() {
        return part3;
    }

    public void setPart3(String part3) {
        this.part3 = part3;
    }

    public String getPart4() {
        return part4;
    }

    public void setPart4(String part4) {
        this.part4 = part4;
    }

    public String getPart5() {
        return part5;
    }

    public void setPart5(String part5) {
        this.part5 = part5;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", part3='" + part3 + '\'' +
                ", part4='" + part4 + '\'' +
                ", part5='" + part5 + '\'' +
                '}';
    }
}