package org.example.hashing;

public class Main {
    public static void main(String[] args) {
        DirectChaining directChaining = new DirectChaining(15);
        directChaining.insert("The");
        directChaining.insert("quick");
        directChaining.insert("brown");
        directChaining.insert("Earth");
        directChaining.insert("fox");
        directChaining.insert("over");
        directChaining.display();
        System.out.println(directChaining.search("over"));
        System.out.println(directChaining.search("ovr"));
        System.out.println(directChaining.delete("brown"));
        System.out.println(directChaining.delete("bron"));
        directChaining.display();

        System.out.println("=================Linear============");
        LinearProbing linearProbing = new LinearProbing(13);
        linearProbing.insert("The");
        linearProbing.insert("quick");
        linearProbing.insert("brown");
        linearProbing.insert("fox");
        linearProbing.insert("over");
        linearProbing.display();
        System.out.println(linearProbing.search("os"));
        System.out.println(linearProbing.search("The"));
        System.out.println(linearProbing.search("fox"));
        System.out.println(linearProbing.delete("fox"));
        System.out.println(linearProbing.delete("os"));
        linearProbing.display();

        System.out.println("=================Quadratic============");
        QuadraticProbing quadraticProbing = new QuadraticProbing(13);
        quadraticProbing.insert("The");
        quadraticProbing.insert("quick");
        quadraticProbing.insert("brown");
        quadraticProbing.insert("fox");
        quadraticProbing.insert("over");
        quadraticProbing.display();


        System.out.println("=================Double Hashing============");
        DoubleHashing dH = new DoubleHashing(13);
        dH.insert("The");
        dH.insert("quick");
        dH.insert("brown");
        dH.insert("fox");
        dH.insert("over");
        dH.display();
    }
}
