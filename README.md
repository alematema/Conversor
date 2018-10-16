# ConversorEntreBasesNumericas

 Converte um numero escrito em uma base qualquer, X , para seu equivalente escrito noutra base qualquer, Y.<br>
 A entrada deve ser uma string csv (Comma Separated Values) representando o
 numero na base X.<br>
 A saida sera outra csv (Comma Separeted Values) representando o numero na
 base Y.<br>
 O INPUT DEVE SER EQUIVALENTEMENTE MENOR OU IGUAL QUE
 <strong>Integer.MAX_VALUE</strong>.<br>
 <br>Exemplos de uso:<br>
 <div style="margin-left:30px;">
 <strong>Conversor.converter("1,1,1,1,1").naBase(2).paraBase(16) = "1,F"<br>
 Conversor.converter("1,1,1,1,1").naBase(2).paraBase(10) = "3,1"<br>
 Conversor.converter("1,1,1,1,1").naBase(3).paraBase(16) = "7,9"<br>
 Conversor.converter("1,1,1").naBase(8).paraBase(10) = "7,3"<br>
 Conversor.converter("1,F").naBase(16).paraBase(2) = "1,1,1,1,1"</strong><br>
 </div><br>
 Ou <strong>qualquer</strong> outra combinacao.
