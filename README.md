[![Build Status](https://api.travis-ci.org/devmonsters/interpretador-codigo-de-barras.png)](http://travis-ci.org/#!/devmonsters/interpretador-codigo-de-barras)

# interpretador-codigo-de-barras

Interpretador de códigos de barras de boletos, para leitura dos campos individuais.

## Exemplo de uso:
```java
Interpretador interpretador = new InterpretadorFactory().getInterpretador("39995567200001119002843306779912340123456001");
interpretador.getAgencia();
interpretador.getBanco();
interpretador.getValor();
```
