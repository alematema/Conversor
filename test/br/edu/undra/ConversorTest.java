package br.edu.undra;

import static br.edu.undra.Base.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexandre
 */
public class ConversorTest {

    public ConversorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of converter method, of class Conversor.
     */
    //@Test
    public void testConverter() {
        System.out.println("converter");
        int inteiro = 0;
        Conversor expResult = null;
        Conversor result = Conversor.converter(inteiro);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    /**
     * Test of reverter(String,String) method, of class Conversor.
     */
    @Test
    public void testReverter_String_String() {
        
        System.out.println("reverter(String,String) teste");
        
        String csvString = "12ABA";
        String csvRevertida = "ABA21";
        
        assertEquals(csvRevertida,Conversor.reverter(csvString,""));
        
        assertEquals(csvString,Conversor.reverter(csvRevertida,""));
        
        
    }
    
    /**
     * Test of reverter method, of class Conversor.
     */
    @Test
    public void testReverter_String() {
        
        System.out.println("reverter(String) teste");
        
        String csvString = "1,2,A,B,A";
        String csvRevertida = "A,B,A,2,1";
        
        assertEquals(csvRevertida,Conversor.reverter(csvString));
        
        assertEquals(csvString,Conversor.reverter(csvRevertida));
        
        
    }

      /**
     * Test of paraBase(Base) method, of class Conversor.
     */
    @Test
    public void testparaBase_BaseNumerica() {
        
        System.out.println("paraBase(BaseNumerica) test");
        
        Base baseBinaria = new Base(BINARIA);
        
        int numero = 7;
        String convertido = Conversor.converter(numero).paraBase(baseBinaria);
        convertido = Conversor.toString(convertido);
        System.out.println(numero + " BASE10 -> " + convertido + " " + Conversor.baseCorrente);

        assertEquals("111", convertido);
        
        numero = 31;
        convertido = Conversor.converter(numero).paraBase(new Base(HEXA_DECIMAL));
        convertido = Conversor.toString(convertido);
        System.out.println(numero + " BASE10 -> " + convertido + " " + Conversor.baseCorrente);

        assertEquals(Conversor.baseCorrente.toString(),"BASE16");
        assertEquals("1F", convertido);
        
        
    }
    
     /**
     * Test of daBase(int) method, of class Conversor.
     */
    @Test
    public void testDaBase_int() {
        
        System.out.println("daBase(int) test");
        
        Base baseBinaria = new Base(BINARIA);
        
        String numero = "1,1,1";
        int decimal = Conversor.converter(numero).daBase(BINARIA).numBASE10;
        String convertido = Integer.toString(decimal);
        System.out.println(numero + " BASE2 -> " + convertido + " " + Conversor.baseDestino);

        assertEquals("7", convertido);
        
        numero = "1,F";
        decimal = Conversor.converter(numero).daBase(HEXA_DECIMAL).numBASE10;
        convertido = Integer.toString(decimal);
        System.out.println(numero + " BASE16 -> " + convertido + " " + Conversor.baseDestino);

        assertEquals("31", convertido);

        int argDecimal = 367896;
        numero = Conversor.converter(argDecimal).paraBase(TERNARIA);
        decimal = Conversor.converter(numero).daBase(TERNARIA).numBASE10;
        convertido = Integer.toString(decimal);
        System.out.println(numero + " " + Conversor.baseOrigem + " -> " + convertido + " " + Conversor.baseDestino);
        
        assertEquals(Integer.toString(argDecimal), convertido);
        
        
        argDecimal = 1000000000;
        numero = Conversor.converter(argDecimal).paraBase(HEXA_DECIMAL);
        decimal = Conversor.converter(numero).daBase(HEXA_DECIMAL).numBASE10;
        convertido = Integer.toString(decimal);
        System.out.println(numero + " " + Conversor.baseOrigem + " -> " + convertido + " " + Conversor.baseDestino);
        
        assertEquals(Integer.toString(argDecimal), convertido);
        
    }
    
    /**
     * Test of paraBase method, of class Conversor.
     */
   @Test
    public void testParaBase() {

        System.out.println("paraBase");

        int numero = 7;
        String convertido = Conversor.converter(numero).paraBase(BINARIA);
        convertido = Conversor.toString(convertido);
        System.out.println(numero + " BASE10 -> " + convertido + " " + Conversor.baseCorrente);

        assertEquals("111", convertido);
        
        numero = 10;
        convertido = Conversor.converter(numero).paraBase(BINARIA);
        convertido = Conversor.toString(convertido);
        System.out.println(numero + " BASE10 -> " + convertido + " " + Conversor.baseCorrente);

        assertEquals("1010", convertido);
        
        numero = 10;
        convertido = Conversor.converter(numero).paraBase(HEXA_DECIMAL);
        convertido = Conversor.toString(convertido);
        System.out.println(numero + " BASE10 -> " + convertido + " " + Conversor.baseCorrente);

        assertEquals(Conversor.baseCorrente.toString(),"BASE16");
        assertEquals("A", convertido);
        
        numero = 31;
        convertido = Conversor.converter(numero).paraBase(HEXA_DECIMAL);
        convertido = Conversor.toString(convertido);
        System.out.println(numero + " BASE10 -> " + convertido + " " + Conversor.baseCorrente);

        assertEquals(Conversor.baseCorrente.toString(),"BASE16");
        assertEquals("1F", convertido);
        
        numero = 255;
        convertido = Conversor.converter(numero).paraBase(HEXA_DECIMAL);
        convertido = Conversor.toString(convertido);
        System.out.println(numero + " BASE10 -> " + convertido + " " + Conversor.baseCorrente);

        assertEquals(Conversor.baseCorrente.toString(),"BASE16");
        assertEquals("FF", convertido);
        
        numero = 256;
        convertido = Conversor.converter(numero).paraBase(HEXA_DECIMAL);
        convertido = Conversor.toString(convertido);
        System.out.println(numero + " BASE10 -> " + convertido + " " + Conversor.baseCorrente);

        assertEquals(Conversor.baseCorrente.toString(),"BASE16");
        assertEquals("100", convertido);
        
        numero = 256;
        convertido = Conversor.converter(numero).paraBase(DECIMAL);
        convertido = Conversor.toString(convertido);
        System.out.println(numero + " BASE10 -> " + convertido + " " + Conversor.baseCorrente);

        assertEquals(Conversor.baseCorrente.toString(),"BASE10");
        assertEquals("256", convertido);
        
        

    }
    
    /**
     * Test of daBase(int)method union paraBase(int) method, of class Conversor.
     */
    @Test
    public void testDaBase_int_paraBase_int() {
        
        System.out.println("daBase(int) paraBase(int) test");
        
        String numero = "1,1,1";
        
        String convertido = Conversor.converter(numero).daBase(BINARIA).paraBase(TERNARIA);
        
        System.out.println(numero + " " + Conversor.daBase + " -> " + convertido + " " + Conversor.paraBase);
        
        assertEquals("2,1", convertido);
        
        
        numero = "1,1,1";
        
        convertido = Conversor.converter(numero).daBase(BINARIA).paraBase(BINARIA);
        
        System.out.println(numero + " " + Conversor.daBase + " -> " + convertido + " " + Conversor.paraBase);
        
        assertEquals("1,1,1", convertido);
        
        
        numero = "1,1,1";
        
        convertido = Conversor.converter(numero).daBase(BINARIA).paraBase(DECIMAL);
        
        System.out.println(numero + " " + Conversor.daBase + " -> " + convertido + " " + Conversor.paraBase);
        
        assertEquals("7", convertido);
        
        
        numero = "1,1,1,1";
        
        convertido = Conversor.converter(numero).daBase(BINARIA).paraBase(HEXA_DECIMAL);
        
        System.out.println(numero + " " + Conversor.daBase + " -> " + convertido + " " + Conversor.paraBase);
        
        assertEquals("F", convertido);
        
        
        numero = "F";
        
        convertido = Conversor.converter(numero).daBase(HEXA_DECIMAL).paraBase(BINARIA);
        
        System.out.println(numero + " " + Conversor.daBase + " -> " + convertido + " " + Conversor.paraBase);
        
        assertEquals("1,1,1,1", convertido);
        
        
        numero = "F";
        
        convertido = Conversor.converter(numero).daBase(HEXA_DECIMAL).paraBase(DECIMAL);
        
        System.out.println(numero + " " + Conversor.daBase + " -> " + convertido + " " + Conversor.paraBase);
        
        assertEquals("1,5", convertido);
        
        
        numero = "1,0";
        
        convertido = Conversor.converter(numero).daBase(HEXA_DECIMAL).paraBase(DECIMAL);
        
        System.out.println(numero + " " + Conversor.daBase + " -> " + convertido + " " + Conversor.paraBase);
        
        assertEquals("1,6", convertido);
        
        
        numero = "1,6";
        
        convertido = Conversor.converter(numero).daBase(DECIMAL).paraBase(HEXA_DECIMAL);
        
        System.out.println(numero + " " + Conversor.daBase + " -> " + convertido + " " + Conversor.paraBase);
        
        assertEquals("1,0", convertido);
        
        
        numero = "1,0,0,0";
        
        convertido = Conversor.converter(numero).daBase(DECIMAL).paraBase(HEXA_DECIMAL);
        
        System.out.println(numero + " " + Conversor.daBase + " -> " + convertido + " " + Conversor.paraBase);
        
        assertEquals("3,E,8", convertido);
        
        
        numero = "1,0,0,0,0";
        
        convertido = Conversor.converter(numero).daBase(DECIMAL).paraBase(HEXA_DECIMAL);
        
        System.out.println(Conversor.toString(numero) + " " + Conversor.daBase + " -> " + Conversor.toString(convertido) + " " + Conversor.paraBase);
        
        assertEquals("2,7,1,0", convertido);
        
        
        numero = "1,0,0,0,0";
        
        convertido = Conversor.converter(numero).daBase(DECIMAL).paraBase(DECIMAL);
        
        System.out.println(Conversor.toString(numero) + " " + Conversor.daBase + " -> " + Conversor.toString(convertido) + " " + Conversor.paraBase);
        
        assertEquals(numero, convertido);
        
        
        numero = "1,0,0,0,0";
        
        convertido = Conversor.converter(numero).daBase(OCTAL).paraBase(DECIMAL);
        
        System.out.println(Conversor.toString(numero) + " " + Conversor.daBase + " -> " + Conversor.toString(convertido) + " " + Conversor.paraBase);
        
        assertEquals("4,0,9,6", convertido);
        
        
        numero = "1,0,0,0,0";
        
        convertido = Conversor.converter(numero).daBase(DECIMAL).paraBase(OCTAL);
        
        System.out.println(Conversor.toString(numero) + " " + Conversor.daBase + " -> " + Conversor.toString(convertido) + " " + Conversor.paraBase);
        
        assertEquals("2,3,4,2,0", convertido);
        
        
        numero = "1,0";
        
        convertido = Conversor.converter(numero).daBase(10).paraBase(100);
        
        System.out.println(Conversor.toString(numero) + " " + Conversor.daBase + " -> " + Conversor.toString(convertido) + " " + Conversor.paraBase);
        System.out.println(numero + " " + Conversor.daBase + " -> " + convertido + " " + Conversor.paraBase);
        System.out.println(Conversor.paraBase.getAlgarismos());
        
        assertEquals("10", convertido);
        
    }
}
