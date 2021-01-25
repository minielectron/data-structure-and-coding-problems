package day1;

import java.util.Scanner;

public class Codeforce785A {

    /*
    * Anton's favourite geometric figures are regular polyhedrons. Note that there are five kinds of regular polyhedrons:

Tetrahedron. Tetrahedron has 4 triangular faces.
Cube. Cube has 6 square faces.
Octahedron. Octahedron has 8 triangular faces.
Dodecahedron. Dodecahedron has 12 pentagonal faces.
Icosahedron. Icosahedron has 20 triangular faces.
All five kinds of polyhedrons are shown on the picture below:*/

    public static void main(String[] args) {
        int n = 0 , sum = 0;
         Scanner in = new Scanner(System.in);
         n = in.nextInt();
         while (n-- > 0){
             String polyhedron = in.next();
             if (polyhedron.equals("Tetrahedron")){
                 sum+=4;
                 continue;
             }
             if (polyhedron.equals("Cube")){
                 sum+=6;
                 continue;
             }
             if (polyhedron.equals("Octahedron")){
                 sum+=8;
                 continue;
             }
             if (polyhedron.equals("Dodecahedron")){
                 sum+=12;
                 continue;
             }
             if (polyhedron.equals("Icosahedron")){
                 sum+=20;
             }
         }

         System.out.println(sum);
    }
}


