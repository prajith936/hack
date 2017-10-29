class Dog{
    String name;
    Dog(String name){
        this.name = name;
    }
    String getName(){
        return name;
    }
public static void main( String[] args ) {
    Dog aDog = new Dog("Max");
    System.out.println(aDog.getName());
    // we pass the object to foo

    foo(aDog);
    // aDog variable is still pointing to the "Max" dog when foo(...) returns
    if (aDog.getName().equals("Max")) {  // true, java passes by value
       System.out.println(aDog.getName());
    }
    if (aDog.getName().equals("Fifi")) {System.out.println(aDog.getName());} // false 
    System.out.println(aDog.getName()+" last");
}

public static void foo(Dog d) {
    d.getName().equals("Max"); // true
    // change d inside of foo() to point to a new Dog instance "Fifi"
    d = new Dog("Fifi");
    System.out.println(d.getName());
    if (d.getName().equals("Fifi")) { } // true
}

}