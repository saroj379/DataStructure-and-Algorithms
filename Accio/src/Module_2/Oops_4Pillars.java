package Module_2;

public class Oops_4Pillars {

        String color;
        String breed;
        String name;
        int age;

        //normal constructor
        public Oops_4Pillars(){
            System.out.println("I am a normal constructor");
        }

        //parameterized constructor
        public Oops_4Pillars(String name, String breed, int age, String color){
            this.name = name;
            this.breed = breed;
            this.age = age;
            this.color = color;
        }

        //    method 1
        public String getName(){
            return name;
        }
        //    method 1
        public String getBreed(){
            return breed;
        }
        //    method 1
        public String getColor(){
            return color;
        }
        //     method 4
        public int getAge(){
            return age;
        }

        public String toString(){
            return ("Hi my name is "+this.getName()+
                    ".\nMy breed , age and color are "+
                    this.getBreed()+" ,"+ this.getAge()+" ,"+this.getColor());
        }


        //Main class to create obj for classes
        public static void main(String[] args) {
//        Oops_4Pillars m1 = new Oops_4Pillars();
//        System.out.println(m1);
//        System.out.println("I am not a parameterized constructor storing values "+m1.name+" ,"+m1.age);
        Oops_4Pillars m2 = new Oops_4Pillars("tuffy", "papillon",5,"white");
//        System.out.println(m2);
//        System.out.println(m2.toString());
//        System.out.println(m2);

            //Obj creation for Shape class(Abstraction)
            Shape s1 = new Circle("Red", 3);
            Shape s2 = new Rectangle("Orange", 3,7);
        System.out.println(s1);
        System.out.println(s2);

            //Obj creation for Area
            Area a1 = new Area(2,12);
            a1.getArea();
            System.out.println("Class anme: "+a1.getClass());

            //obj created for Encapsulation
            Encapsulate e1 = new Encapsulate();
            e1.setAge(18);
            e1.setName("HariName");
            e1.setRoll(10151);
            System.out.println("Geek's name: "+e1.getName()+
                    ".\nGeek's age: "+e1.getAge()+".\nGeek's roll: "+
                    e1.getRoll());

            //Getter And Setter
            Name n1 = new Name();
            n1.setAge(24);
            System.out.println("The age of the person which is present in " +
                    "name_class: "+n1.getAge());//getClassName is also a function here

            //Bank Account details
            Account ac1 = new Account();
            ac1.setAcc_no(1234567);
            ac1.setName("Supreme");
            ac1.setEmail("supreme@lord.com");
            ac1.setAmount(9999999);
            System.out.println(ac1.getAcc_no()+"\n"+ac1.getName()+"\n"+ac1.getEmail()+"\n"+ac1.getAmount());

            //Inheritance
            MountainBike mb = new MountainBike(3,1,5);
//        mb.setHeight(50);
            System.out.println(mb.toString());

            //single inheritance
            System.out.println("\n~***Single inheritance***~\n");
            Parent p1 = new Parent();
            p1.print_geek();
            Child c1 = new Child();
            c1.print_for();
            c1.print_geek();
            Parent pc = new Child();
            pc.print_geek();
//        pc.print_for();//give error as this is not present in parent

            //multilevel inheritance
            System.out.println("\n~***Multilevel inheritance***~\n");
            C abc = new C();
            abc.PrintC();
            abc.printB();
            abc.printA();

            //Hierarchical inheritance
            System.out.println("\n~***Hierarchical inheritance***~\n");
            Car c = new Car();
            c.color();
            BMW b = new BMW();
            b.colorB();
            Audi a = new Audi();
            a.colorA();

            //multiple inheritance using interface
            System.out.println("\n~***Multiple inheritance***~\n");
            Human h = new Human();
            h.print_one();
            h.print_two();
            h.print_three();

            //hybrid inheritance
            System.out.println("\n~***Hybrid inheritance***~\n");
            SolarSystem ss = new SolarSystem();
            ss.solar();
            System.out.println(ss.hashCode());
            Earth e = new Earth();
            e.solar();
            Mars ms = new Mars();
            ms.solar();
            Moon mo = new Moon();
            mo.solar();

            //Method overloading
            Sum sum = new Sum();
            System.out.println(sum.sum(3,4)+" - "+sum.sum(4,6,8)+" - "+ sum.sum(33.4,45.7));

            //Method overriding

        }
    }
    //Java has it's 4 pillor
//Abstraction
//  We cann't cracte an object of a Abstract class
    abstract class Cat{
        int a;
        Cat(){
            System.out.println("Hey im in Abstract Class");
        };
        Cat(int a){
            this.a = a;
            System.out.println(this.a+" here is a value");
        }
    }

    //Example of Abstraction
    abstract class Shape{
        String color;

        //abstract methods
        abstract double area();
        public abstract String toString();

        //    abstract class have constructor
        public Shape(String color1){
            System.out.println("Shape constructor called");
            this.color = color1;
        }
        public String getColor(){
            return color;
        }
    }
    //Chile class / derived class
    class Circle extends Shape {
        double radius;
        public Circle(String color, double rad){
            //calling shape constructor
            super(color);
            System.out.println("Circle constructor called");
            this.radius = rad;
        }

        //overriding the abstract (area) method to remove error
        double area(){
            return Math.PI*Math.pow(radius,2);
        }
        public String toString(){
            return "Circle color is "+super.getColor()+" and area is :"+area();
        }
    }

    //Another class from Parent class(Hierarcal Inheritance)
    class Rectangle extends Shape {
        double length;
        double width;
        public Rectangle(String color, double len, double wid){
            super(color);
            System.out.println("Rectangle constructor called");
            this.length = len;
            this.width = wid;
        }
        double area(){
            return length*width;
        }
        public String toString(){
            return "Rectangle color is "+this.color+" and area is :"+ area();
        }
    }

    //Encapsulation
    class Area{
        int length;
        int breadth;

        Area(int len, int bred){
            this.length = len;
            this.breadth = bred;
        }

        public void getArea(){
            int area = length * breadth;
            System.out.println("Area: "+area);
        }
    }

    //java program to demonstrate encapsulation
    class Encapsulate{
        //private variables declared
        //these can only be accessed by public methods of class
        private String geekName;
        private int geekRoll;
        private int geekAge;

        //get method for age to access private variable geekAge
        public int getAge(){
            return geekAge;
        }

        //get method for name to access private variable geekName
        public String getName(){
            return geekName;
        }

        //get method for roll to access private variable geekRoll
        public int getRoll(){
            return geekRoll;
        }

        //set method for age to access private variable geekage
        public void setAge(int newAge){
            this.geekAge = newAge;
        }

        //set method for name to access private variable geekname
        public void setName(String newName){
            this.geekName = newName;
        }

        //set method for roll to access private variable geekroll
        public void setRoll(int newRoll){
            this.geekRoll = newRoll;
        }
    }

    class Name{
        private int age;//Private is  using to hide the data(age)
        public void setAge(int age){//setter
            this.age = age;
        }
        public int getAge(){//getter
            return age;
        }
    }

    //Bank Account details
    class Account{
        //private datamembers hide the data
        private long acc_no;
        private String name,email;
        private float amount;

        //now getter and setter methods
        public void setAcc_no(long acc){
            this.acc_no = acc;
        }
        public long getAcc_no(){
            return acc_no;
        }
        public void setName(String name){
            this.name = name;
        }
        public String getName(){
            return name;
        }
        public void setEmail(String email){
            this.email = email;
        }
        public String getEmail(){
            return email;
        }
        public void setAmount(float amount){
            this.amount = amount;
        }
        public float getAmount(){
            return amount;
        }
    }

    //Inheritance
    //parent class
    class Bicycle{
        public int gear;
        public int speed;

        public Bicycle(int gr,  int spd){
            this.gear = gr;
            this.speed = spd;
        }
        public void applyBrake(int decrement){
            speed -= decrement;
        }
        public void speedUp(int increment){
            speed +=increment;
        }

        public String toString(){
            return "No of gears are "+gear+"\n" +
                    "Speed of bicycle is: "+speed;
        }
    }

    //chile class
    class MountainBike extends Bicycle {
        //this subclass has added 1 more variable
        public int seatHeight;
        //this add another constructor in adding parent class constructor
        public MountainBike(int gear, int speed, int seathigh){
            super(gear,speed);
            this.seatHeight = seathigh;
        }
        public void setHeight(int newValue){
            this.seatHeight = newValue;
        }
        public int getHeight(){
            return seatHeight;
        }
        //override the toString() method of parent class
        public String toString(){
            return super.toString()+"\nSeat heights are: "+seatHeight;
        }
    }

    //Types of Inheritance
// single inheritance
    class Parent{
        public void print_geek(){
            System.out.println("Geeks");
        }
    }
    class Child extends Parent {
        public void print_for(){
            System.out.println("for");
        }
    }

    //multilevel inheritance
    class A{
        public void printA(){
            System.out.println("A");
        }
    }
    class B extends A {
        public void printB(){
            System.out.println("B");
        }
    }
    class C extends B {
        public void PrintC(){
            System.out.println("C");
        }
    }

    //Hierarchical inheritance
    class Car{
        public void color(){
            System.out.println("Color");
        }
    }
    class BMW extends Car {
        BMW(){
            super();
        }
        public void colorB(){
            System.out.println("Blue");
        }
    }
    class Audi extends Car {
        public void colorA(){
            System.out.println("White");
        }
    }

    //multiple inheritance(using interface)
    interface one{
        public void print_one();
    }
    interface two{
        public void print_two();
    }
    interface three extends one, two {
        public void print_three();
    }
    class Human implements three {
        public void print_one(){
            System.out.println("1 inside human class");
        }

        @Override
        public void print_two() {
            System.out.println("2 inside human class");
        }

        @Override
        public void print_three() {
            System.out.println("3 inside human class");
        }
    }

    //Hybrid inheritance
    class SolarSystem{
        public void solar(){
            System.out.println("inside solarsystem");
        }
    }
    class Earth extends SolarSystem {
        @Override
        public void solar() {
            System.out.println("inside earth");
        }
    }
    class Mars extends SolarSystem {
        @Override
        public void solar() {
            System.out.println("inside mars");
        }
    }
    class Moon extends Earth {
        public void solar(){
            System.out.println("inside moon revolving around earth");
        }
    }

    //Method Overloading(Compile time polymorphism)
    class Sum{
        public int sum(int x, int y){
            return x+y;
        }
        public int sum(int x, int y, int z){
            return x+y+z;
        }
        public double sum(double x,double y){
            return x+y;
        }
    }


    //Method Overriding(Run time polymorphism)


// Access Modifiers

