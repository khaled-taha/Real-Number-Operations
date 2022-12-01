# Real-Number-Operations

Write a class called FloatNumber to implement the floating point number:

The class has two integer data members val and ndp. Where val represents the whole number
and ndp represents the number of decimal places. For example the number 235478.67 will be represented as val=23547867 and ndp=2

The class has two constructors:

a) A constructor the takes two integers one of them for val and the other of ndp

b) A constructor that takes a float and deduce val and ndp from it

The class has the following methods:

a) Setters and getters for val and ndp

b) Add that takes a FloatNumber(as an object) and adds it to its object and returns the result object

c) Addinteger that takes an integer and adds it to its object and returns the result object

d) Mul that takes a FloatNumber(as an object) and multipliess it to its object and returns the result object

e) Mulinteger that takes an integer and multiplies it to its object and returns the result object

f) Round that rounds the object to the nearest integer and return the result as integer

g) Show that displays the object as a float number

======================================================================================================================

Representing currency values with BigDecimal

        double number = .012;
        System.out.println(number + number + number);
 
 output:  0.036000000000000004

 That's because the way they're stored in memory doesn't map exactly to the value.
 
 For example, a double value is supposed to take 64 bits but Java doesn't use all 64 bits, it only stores what it considers the important parts of the number.
 
 So you can see some pretty odd things when you start adding values together and then outputting the result.



To fix this, Java provides a class called BigDecimal. There are actually two of these classes.

There's one called BigInteger and one called BigDecimal, but BigDecimal is specifically designed to take care of this precision problem.

To use BigDecimal on a number, first, you need to convert the number to a string.

        BigDecimal bd = new BigDecimal(String.valueOf(number));
        
Now, I've wrapped the number in a complex object


        BigDecimal bd1 = bd.add(bd).add(bd);
        
        System.out.println(bd1); // 0.036 
        
************************************************************

        BigDecimal bd = BigDecimal.valueOf(number);
        
        BigDecimal bd1 = bd.add(bd).add(bd);
        
        System.out.println(bd1); // 0.036


Now, the result is accurate. This is especially important when you're dealing with currency values where precision is absolutely critical.

When dealing with money, you can't afford to have extra little bits of values because eventually they'll all get added together and your results will be incorrect.

But using BigDecimal to wrap those numbers in your Java code can make sure that your calculations come out right every time.

