package br.edu.undra.conversor;

import java.util.HashMap;
import java.util.Map;

/**
 * Converte um numero escrito em uma base qualquer, X , <br>
 * para seu equivalente escrito noutra base qualquer, Y.<br>
 * A entrada deve ser uma string csv (Comma Separated Values) representando o
 * numero na base X.<br>
 * A saida sera outra csv (Comma Separeted Values) representando o numero na
 * base Y.<br>
 * O INPUT DEVE SER EQUIVALENTEMENTE MENOR OU IGUAL QUE
 * <strong>Integer.MAX_VALUE</strong>.<br>
 * Exemplos de uso:<br>
 * <strong>Conversor.converter("1,1,1,1,1").naBase(2).paraBase(16) = "1,F"<br>
 * Conversor.converter("1,1,1,1,1").naBase(2).paraBase(10) = "3,1"<br>
 * Conversor.converter("1,1,1,1,1").naBase(3).paraBase(16) = "7,9"<br>
 * Conversor.converter("1,1,1").naBase(8).paraBase(10) = "7,3"<br>
 * Conversor.converter("1,F").naBase(16).paraBase(2) = "1,1,1,1,1"</strong><br>
 * Ou <strong>qualquer</strong> outra combinacao.
 *
 * @author alexandre
 */
public class Conversor {

    private static Map<Integer, Base> cache = null;

    static {
        cache = new HashMap<>();
    }

    public int numBASE10;
    private String convertendoAsString;
    private Base base;
    public static Base baseCorrente;
    public static Base baseOrigem;
    public static Base baseDestino;
    public static Base daBase;
    public static Base paraBase;

    public static Conversor converter(int inteiro) {

        Conversor c = new Conversor();
        c.numBASE10 = inteiro;
        return c;

    }

    /**
     * O numero deve ser passado na forma csv(Comma Separated Value), na base
     * desejada. <br>
     * Exemplos:
     * <br>
     * <strong>O binário "1,1,1"<br>
     * O hexadecimal "1,A,9,9"</strong>
     *
     * @param numero
     * @return instacia de conversor, para fazer Fluiding.
     */
    public static Conversor converter(String numero) {

        Conversor c = new Conversor();
        c.convertendoAsString = numero;
        return c;

    }

    /**
     * REVERTE uma String CSV(comma separated value).
     * <br>
     *
     * @param csvString a string a se reverter.
     * @return uma String CSV ( comma separated value )<br>
     * Exemplo : Exemplo : RECEBE A,1,0,9,9,1 RETORNA 1,9,9,0,1,A
     */
    public static String reverter(String csvString) {
        return reverter(csvString, ",");
    }

    /**
     * REVERTE uma String RegSV(Regex separated value).
     * <br>
     *
     * @param csvString a string a se reverter.
     * @param regex a expressao separadora dos valores
     * @return uma String RegSV ( Reg separated value )<br>
     * Exemplo : Exemplo : recebe A,1,0,9,9,1 RETORNA 1,9,9,0,1,A
     */
    public static String reverter(String csvString, String regex) {

        String csvRevertida = "";

        String[] values = csvString.split(regex);

        for (int i = 0; i < values.length; i++) {

            String value = values[values.length - 1 - i];
            csvRevertida = csvRevertida.concat(value).concat(regex);

        }

        if (!regex.equals("")) {
            //retira lá da ponta da string csv a ultima concatenacao de regex. 
            csvRevertida = csvRevertida.substring(0, csvRevertida.length() - 1);
        }

        return csvRevertida;

    }

    /**
     * Remove virgulas da csv(Comma Separated Values) string recebida<br>
     * e retorna uma string plana.<br>
     * Exemplo : RECEBE A,1,0,9,9,1 RETORNA A10991
     *
     * @param csvString uma String cujos valores estao separados por virgula.
     * @return Uma string sem virgulas separadoras de valores.
     * <br> Exemplo : RECEBE A,1,0,9,9,1 -> RETORNA A10991
     */
    public static String toString(String csvString) {
        return csvString.replaceAll(",", "");
    }

    /**
     * Converte um numeral DECIMAL em uma csv(Comma Separated Values)
     * string.<br>
     * Esta string csv representa os algarismos do numeral escrito na base=base.
     * <br>
     *
     * @param baseNumerica a base para a qual sera convertido o numero DECIMAL.
     * @return Uma String CSV ( Comma Separated Value )<br>
     * que representa os algarismos do numeral decimal escrito na base=base.<br>
     * Exemplo : RECEBE 7 e RETORNA 1,1,1
     * @throws IllegalArgumentException, caso base seja menor ou igual que 1.
     */
    public String paraBase(Base baseNumerica) {
        cache.put(baseNumerica.getBase(), baseNumerica);
        return this.paraBase(baseNumerica.getBase());
    }

    /**
     * Converte um numeral DECIMAL em uma csv(Comma Separated Values)
     * string.<br>
     * Esta string csv representa os algarismos do numeral escrito na base=base.
     * <br>
     *
     * @param base a base para a qual sera convertido o numero DECIMAL.
     * @return Uma String CSV ( Comma Separated Value )<br>
     * que representa os algarismos do numeral decimal escrito na base=base.<br>
     * Exemplo : RECEBE 7 e RETORNA 1,1,1
     * @throws IllegalArgumentException, caso base seja menor ou igual que 1.
     */
    public String paraBase(int base) {

        if (base <= 1) {
            throw new IllegalArgumentException("A base não pode ser menor ou igual a 1. Base passada " + base);
        }

        Base baseNumerica = getBase(base);

        setUpParaBase(baseNumerica);

        // o numBASE10 que sera convertido na base=base.
        int numBase10 = this.numBASE10;

        //Cria uma csv (Comma Separated Values) string,por exemplo "F,F", equivalente ao numBASE10 = 255
        String algarismosCsvEscritosNaBase = paraAlgarismosCSV(baseNumerica, numBase10);

        return algarismosCsvEscritosNaBase;

    }

    /**
     * Converte o numBase10 em uma csv(Comma Separated Values) string.<br>
     * Esta string csv representa os algarismos do numBase10 escrito na
     * base=base.
     * <br>
     *
     * @param baseNumerica a base para a qual sera convertido o numBase10.
     * @param numBase10 o decimal que será convertido.
     * @return Uma String CSV ( Comma Separated Value )<br>
     * que representa os algarismos do numBase10 escrito na base=base.<br>
     * Exemplo : RECEBE 7 e RETORNA 1,1,1
     */
    private String paraAlgarismosCSV(Base baseNumerica, int numBase10) {

        int _base = baseNumerica.getBase();

        //csv(Comma Separeted Values) string, cujos valores representarao os algarismos na base=base
        String csvValues = "";
        while (numBase10 / _base >= 1) {
            int algarismo = numBase10 % _base;
            csvValues = csvValues.concat(baseNumerica.get(algarismo)).concat(",");
            numBase10 = numBase10 / _base;
        }
        csvValues = csvValues.concat(baseNumerica.get(numBase10));
        return Conversor.reverter(csvValues);

    }

    /**
     * Settings para converter BASE10 -> baseNumerica
     *
     * @param baseNumerica
     */
    private void setUpParaBase(Base baseNumerica) {
        this.base = baseNumerica;
        baseCorrente = this.base;
        baseOrigem = getBase(Base.DECIMAL);
        baseDestino = baseCorrente;
        paraBase = baseDestino;
    }

    /**
     * Converte uma csv(Comma Separated Value) string em um numBASE10.<br>
     * Esta csv string foi previamente setada e representa um numeral escrito
     * numa base=base.<br>
     * Exemplo : recebe 1,1,1 escrito na BASE2 e converte em 7 BASE10 e armazena
     * em this.numBASE10.
     * <br>
     *
     * @param baseNumerica a base na qual foi escrito o numeral que sera
     * convertido na base DECIMAL.
     * @return uma instancia de conversor.<br>
     * @throws IllegalArgumentException, caso base seja menor ou igual que 1.
     */
    public Conversor daBase(Base baseNumerica) {
        cache.put(baseNumerica.getBase(), baseNumerica);
        return this.daBase(baseNumerica.getBase());
    }

    /**
     * Converte uma csv(Comma Separated Value) string em um numBASE10.<br>
     * Esta csv string foi previamente setada e representa um numeral escrito
     * numa base=base.<br>
     * Exemplo : recebe 1,1,1 escrito na BASE2 e converte em 7 BASE10 e armazena
     * em this.numBASE10.
     * <br>
     *
     * @param base a base na qual foi escrito o numeral que sera convertido na
     * base DECIMAL.
     * @return uma instancia de conversor.<br>
     * @throws IllegalArgumentException, caso base seja menor ou igual que 1.
     */
    public Conversor daBase(int base) {

        if (base <= 1) {
            throw new IllegalArgumentException("A base não pode ser menor ou igual a 1. Base passada " + base);
        }

        Base baseNumerica = getBase(base);

        setUpDaBase(baseNumerica);

        checarSeAlgarismosSaoCoerentesComABase();

        //Uma csv (Comma Separated Values) string, como 1,A,B,1,F
        String algarismosCSVEscritosNumaBase = convertendoAsString;

        this.numBASE10 = deAlgarismosCSV(baseNumerica, algarismosCSVEscritosNumaBase);

        return this;

    }

    /**
     * Converte uma csv(Comma Separated Value) string em um numBASE10.<br>
     * Exemplo : recebe 1,1,1, escrita na BASE2, e converte em 7 BASE10.
     * <br>
     *
     * @param baseNumerica a base na qual foi escrito o numeral que sera
     * convertido na base DECIMAL.
     * @param algarismosCSVEscritosNumaBase a csv string, cujos valores sao os
     * algarismos do numeral escrito na base=base.
     * @return um numero na base 10, um numBASE10
     */
    private int deAlgarismosCSV(Base baseNumerica, String algarismosCSVEscritosNumaBase) {

        String[] convertiveis = Conversor.reverter(algarismosCSVEscritosNumaBase).split(",");

        for (int i = 0; i < convertiveis.length; i++) {//aplica possiveis reversoes dos algarismos especiais das bases
            convertiveis[i] = baseNumerica.reverter(convertiveis[i]);
        }

        int decimal = 0;
        for (int i = 0; i < convertiveis.length; i++) {//Converte em BASE10(DECIMAL)
            int value = Integer.parseInt(convertiveis[i]);
            decimal += value * Math.pow(baseNumerica.getBase(), i);
        }

        return decimal;

    }

    /**
     * Settings para converter baseNumerica -> BASE10
     *
     * @param baseNumerica
     */
    private void setUpDaBase(Base baseNumerica) {
        this.base = baseNumerica;
        baseCorrente = this.base;
        baseOrigem = baseCorrente;
        baseDestino = getBase(10);
        daBase = baseOrigem;
    }

    private Base getBase(int base) {

        if (!cache.containsKey(base)) {

            Base baseNumerica = new Base(base);

            cache.put(base, baseNumerica);

        }

        return cache.get(base);

    }

    private void checarSeAlgarismosSaoCoerentesComABase() {

        String[] algarismosAsString = convertendoAsString.split(",");

        for (int i = 0; i < algarismosAsString.length; i++) {

            try {
                baseCorrente.get(Integer.parseInt(baseCorrente.reverter(algarismosAsString[i])));
            } catch (IndexOutOfBoundsException e) {
                throw new IllegalArgumentException("Erro ao converter algarismos da " + baseCorrente + "\nValor " + algarismosAsString[i] + " é invalido na posicao " + i + " da csv String " + convertendoAsString + "\nOs algarismos válidos na BASE " + baseCorrente.getBase() + " sao " + baseCorrente.getAlgarismos());
            }

        }

    }

    public static void main(String[] args) {

//        String convertido = Conversor.converter("F,E,D,C,B,A").daBase(16).paraBase(16);
//
//        System.err.println(convertido);
//
//        convertido = Conversor.converter("F,F,F,F,F,F").daBase(16).paraBase(10);
//
//        System.err.println(convertido);
//
//        convertido = Conversor.converter("A,A,A,A,A,A").daBase(16).paraBase(10);
//
//        System.err.println(convertido);
//        String semanas = Conversor.converter("7,7").daBase(10).paraBase(7);
//        System.err.println("semanas " + semanas);
//
//        String meses = Conversor.converter(semanas).daBase(10).paraBase(30);
//        System.err.println("meses " + meses);
//
//        String anos = Conversor.converter(meses).daBase(30).paraBase(360);
//        System.err.println("anos " + anos);


//        String semanas = Conversor.converter("5,6").daBase(10).paraBase(7);
//        System.err.println("semanas " + semanas);
//        
//        String dias = Conversor.converter(semanas).daBase(7).paraBase(10);
//        System.err.println("dias " + dias);

        // dias -> semanas : Conversor.agrupar("5,7").naBase(7) -> "8,1" 
        // dias -> meses : Conversor.agrupar("5,7").naBase(30) -> "1,27" 
        // dias -> anos : : Conversor.agrupar("3,7,0").naBase(360) -> "1,10" 

        // dias.agrupar.emSemanas.agruparEmMeses
        
        System.out.println(Conversor.converter("9,9,8,6,6,6").daBase(10).paraBase(60));
        System.out.println(18666/3600);
    }

}
