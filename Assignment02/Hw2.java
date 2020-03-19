//package Hw2;

public class Hw2 {

    public static void main(String[] args) {
 
		Ratl a = new Ratl(3, 5);
		Ratl b = new Ratl(7, 11);
		Ratl c = new Ratl(6, 10);
		Ratl d = new Ratl(3, 5);
		Boolean x;
		System.out.printf("%n");

		x = (a == a);
		System.out.printf("3/5 == the same 3/5 is %b%n", x);

		x = (a == d);
		System.out.printf("3/5 == a different 3/5 is %b%n", x);
      
		x = a.equals(a);
		System.out.printf("3/5 .equals the same 3/5 is %b%n", x);

		x = a.equals(d);
		System.out.printf("3/5 .equals a different 3/5 is %b%n", x);
		System.out.printf("%n");

		System.out.printf("static:%n");
		x = Ratl.ident(a, a);
		System.out.printf("3/5 is ident to the same 3/5: %b%n", x);

		x = Ratl.ident(a, d);
		System.out.printf("3/5 is ident to a different 3/5: %b%n", x);

		x = Ratl.ident(a, c);
		System.out.printf("3/5 is ident to 6/10: %b%n%n", x);

		x = Ratl.equiv(a, a);
		System.out.printf("3/5 is equiv to the same 3/5: %b%n", x);

		x = Ratl.equiv(a, d);
		System.out.printf("3/5 is equiv to a different 3/5: %b%n", x);

		x = Ratl.equiv(a, c);
		System.out.printf("3/5 is equiv to 6/10: %b%n%n", x);

 
		System.out.printf("member:%n");
		x = a.ident(a);
		System.out.printf("3/5 is ident to the same 3/5: %b%n", x);

		x = a.ident(d);
		System.out.printf("3/5 is ident to a different 3/5: %b%n", x);

		x = a.ident(a, c);
		System.out.printf("3/5 is ident to 6/10: %b%n%n", x);

		x = a.equiv(a);
		System.out.printf("3/5 is equiv to the same 3/5: %b%n", x);

		x = a.equiv(d);
		System.out.printf("3/5 is equiv to a different 3/5: %b%n", x);

		x = a.equiv(c);
		System.out.printf("3/5 is equiv to 6/10: %b%n%n", x);  
      
		Ratl c;
      
		c = Ratl.add(a, b);
		System.out.printf("static: %s + %s = %s%n", a, b, c);
      
		Ratl d = new Ratl(a);    
      
		d.add(b);
		System.out.printf("member: %s + %s = %s%n%n", a, b, d);

		a = new Ratl(3, 6);
		b = new Ratl(14, 14);
		c = Ratl.add(a, b);

		System.out.printf("static: %s + %s = %s%n", a, b, c);
      
		d = new Ratl(a);
		d.add(b);
		System.out.printf("member: %s + %s = %s%n%n", a, b, d);


		c = Ratl.sub(new Ratl(3, 5), new Ratl(7, 11));
		System.out.printf("static: 3/5 - 7/11 = %s%n", c);
      
		Ratl z = new Ratl(3,5);
		z.sub(new Ratl(7, 11));
		System.out.printf("member: 3/5 - 7/11 = %s%n%n", z);
      

		c = Ratl.mult(new Ratl(3, 6), new Ratl(7, 11));
		System.out.printf(" static 3/6 * 7/11 = %s%n", c);
      
		Ratl m = new Ratl(3,6);
		Ratl m1 = new Ratl(7,11);
      
		m.mutl(m1);
		System.out.printf(" member 3/6 * 7/11 = %s%n%n", m);

		c = Ratl.div(new Ratl(7, 11), new Ratl(3, 6));
		System.out.printf("static: 7/11 / 3/6 = %s%n%n", c);
      
		Ratl poop = new Ratl(7, 11);
		Ratl more = new Ratl(3,6);
		poop.div(more);
		System.out.printf("member: 7/11 / 3/6 = %s%n%n", poop);

		c = Ratl.div(new Ratl(7, 11), new Ratl(7, 11));
		System.out.printf(" static: 7/11 / 7/11 = %s%n", c);

		c = Ratl.div(new Ratl(14, 11), new Ratl(7, 11));
		System.out.printf(" static: 14/11 / 7/11 = %s%n", c);
      
		Ratl foo = new Ratl(14,11);
		Ratl bar = new Ratl(7,11);
		foo.div(bar);
		System.out.printf(" member: 7/11 / 3/6 = %s%n", foo);   

		Ratl gcd1 = new Ratl(5, 10); 
		Ratl gcd2 = Ratl.negate(gcd1);
		System.out.printf(" static: negation of 5/10 %s%n", gcd2);

		System.out.printf("%n");
		testGCD(6, 10);
		testGCD(6, 6);
		testGCD(10, 6);
		testGCD(6, 12);
		testGCD(6, 16);
		testGCD(3, 5);
		System.out.printf("%n");    
    }
    
	public static void testGCD(int a, int b)
    {
		System.out.printf("gcd of %d and %d is %d%n", a, b, Ratl.gcd(a, b));
		return;
    }   
}
