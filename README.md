interpretador-codigo-de-barras
==============================

Interpretador de códigos de barras de boletos, para leitura dos campos individuais.

Exemplo de uso:
```
Interpretador interpretador = new InterpretadorFactory().getInterpretador("39995567200001119002843306779912340123456001");
interpretador.getAgencia();
interpretador.getBanco();
interpretador.getValor();
```