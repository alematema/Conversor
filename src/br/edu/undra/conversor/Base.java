package br.edu.undra.conversor;

import java.util.HashMap;
import java.util.Map;

/**
 * Uma abstracao de uma base numérica.
 *
 * @author alexandre
 */
public class Base {
    
    public static final int BINARIA = 2;
    public static final int TERNARIA = 3;
    public static final int QUATERNARIA = 4;
    public static final int CINCO = 5;
    public static final int SEIS = 6;
    public static final int SETE = 7;
    public static final int OCTAL = 8;
    public static final int DECIMAL = 10;
    public static final int HEXA_DECIMAL = 16;

    private final int base;
    private Map<Integer, String> algarismosEspeciais = null;

    Base(int base) {

        this.base = base;

        if (base == 16) {

            algarismosEspeciais = new HashMap<>();

            algarismosEspeciais.put(10, "A");
            algarismosEspeciais.put(11, "B");
            algarismosEspeciais.put(12, "C");
            algarismosEspeciais.put(13, "D");
            algarismosEspeciais.put(14, "E");
            algarismosEspeciais.put(15, "F");

        }

    }

    public Base(int base, Map<Integer, String> algarismosEspeciais) {

        this(base);
        this.algarismosEspeciais = algarismosEspeciais;

    }

    /**
     * Recupera, quando houver, o algarismo especial associado à chave {@code}i.
     * <br>
     * <blockquote><pre>
     * Exemplo : Na BASE16(HEXADECIMAL) mapeia-se 10 <-> A, 11 <-> B, ... , 15
     * <-> F<br>
     * Entao, o get de 10 é A; o get de 11 é B ... o get de 15 é F.
     *</pre></blockquote>
     * @param i {@code} i é uma chave associada, possivelmente, a um algarismo especial.
     * @return {@code o valor especial} associado à chave {@chave}i, caso haja.<br>
     * ou a propria chave {@code}i, caso nao estejam mapeados algarismos especiais.
     * @exception IndexOutOfBoundsException se {@code i < 0 ou i > base-1} 
     */
    public String get(int i) throws IndexOutOfBoundsException {

        //checa in bounds : i deve ser tal que : 0 <= i <= (base-1) 
        if (!(0 <= i && i <= base - 1)) {
            throw new IndexOutOfBoundsException(i + " é argumento inválido.\nVálidos são \n\t >= 0 e \n\t <= " + (base - 1));
        }

        String algarismo = Integer.toString(i);

        if (algarismosEspeciais != null) {

            if (algarismosEspeciais.containsKey(i)) {
                algarismo = algarismosEspeciais.get(i);
            }

        }

        return algarismo;
    }

    /**
     * Recupera, quando houver, a chave associada a um algarismo especial.
     * <br>
     * <blockquote><pre>
     * Exemplo : Na BASE16(HEXADECIMAL) mapeia-se 10 <-> A, 11 <-> B, ... , 15
     * <-> F
     * Entao, o reverso de A é 10; o reverso de B é 11 ... o reverso de F é 15.
     *</pre></blockquote>
     * @param algarismo um possivel algarismo especial.
     * @return a chave associada ao possível {@code algarismo} especial, caso haja.<br>
     * ou o proprio {@code}algarismo, caso nao estejam mapeados algarismos especiais.
     * {@link #algarismosEspeciais}
     */
    public String reverter(String algarismo) {
        
        if (algarismosEspeciais != null) {

            for (Map.Entry<Integer, String> entry : algarismosEspeciais.entrySet()) {

                if (entry.getValue().equals(algarismo)) {
                    algarismo = Integer.toString(entry.getKey());
                    break;
                }

            }

        }

        return algarismo;
    }

    public int getBase() {
        return base;
    }

    @Override
    public String toString() {
        return "BASE" + getBase();
    }

    /**
     * Recupera os algarismos desta base.
     * @return os algarismos no formato csv(Comma Separeted Values)<br>
     * Exemplos:
     * <br>
     * se BASE16, retorna 0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F<br>
     * se BASE10, retorna 0,1,2,3,4,5,6,7,8,9<br>
     * se BASE3, retorna 0,1,2<br>
     * se BASE2, retorna 0,1<br>
     * 
     */
    public String getAlgarismos(){
        
        String csvAlgarismos="";
        
        for( int i = 0; i < base; i++ ){
            
            String value=Integer.toString(i);
            
            if( algarismosEspeciais != null ){
                
                if( algarismosEspeciais.containsKey(i) ) value = algarismosEspeciais.get(i);
                
            }
            
            csvAlgarismos+=value;
            csvAlgarismos+=",";
            
        }
        
        return csvAlgarismos.substring(0, csvAlgarismos.length() - 1 );
        
    }
    
}
