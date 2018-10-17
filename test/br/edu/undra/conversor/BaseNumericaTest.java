package br.edu.undra.conversor;

import br.edu.undra.conversor.Base;
import java.util.HashMap;
import java.util.Map;
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
public class BaseNumericaTest {

    public BaseNumericaTest() {
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
     * Teste para o metodo get(long) da classe Base
     */
    @Test
    public void testGet_int() {

        System.err.println("get(int) test");

        Base baseNumerica = new Base(2);

        assertEquals("0", baseNumerica.get(0));
        assertEquals("1", baseNumerica.get(1));

        Map<Integer, String> algarismosEspeciais = new HashMap<>();

        algarismosEspeciais.put(10, "A");
        algarismosEspeciais.put(11, "B");
        algarismosEspeciais.put(12, "C");
        algarismosEspeciais.put(13, "C");
        algarismosEspeciais.put(14, "E");
        algarismosEspeciais.put(15, "F");

        Base baseHexaDecimal = new Base(16, algarismosEspeciais);

        assertEquals("0", baseHexaDecimal.get(0));
        assertEquals("1", baseHexaDecimal.get(1));
        assertEquals("9", baseHexaDecimal.get(9));
        assertEquals("A", baseHexaDecimal.get(10));
        assertEquals("B", baseHexaDecimal.get(11));
        assertEquals("F", baseHexaDecimal.get(15));
        
        
        baseHexaDecimal = new Base(16);

        assertEquals("0", baseHexaDecimal.get(0));
        assertEquals("1", baseHexaDecimal.get(1));
        assertEquals("9", baseHexaDecimal.get(9));
        assertEquals("A", baseHexaDecimal.get(10));
        assertEquals("B", baseHexaDecimal.get(11));
        assertEquals("F", baseHexaDecimal.get(15));
        

    }

    /**
     * Teste para o metodo get(int) da classe Base
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testLancaIndexOutOfBoundsException() {

        System.err.println("get(int) lancaIndexOutOfBoundsException test");

        Base baseNumerica = new Base(2);

        baseNumerica.get(2);

    }
    
    
    /**
     * Teste para o metodo reverter(String) da classe Base
     */
    @Test
    public void testReverter_String() {

        System.err.println("reverter(String) test");

        Base baseNumerica = new Base(2);

        assertEquals("1",baseNumerica.reverter("1"));
        
        baseNumerica = new Base(16);

        assertEquals("10",baseNumerica.reverter("A"));
        assertEquals("11",baseNumerica.reverter("B"));
        assertEquals("15",baseNumerica.reverter("F"));

    }
    

}
