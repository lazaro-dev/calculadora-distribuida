=> O cliente terá que informar três entradas: 
    -A primeira contendo o primeiro número
    -A segunda a operação que deverá ser o simbolo referente a operação desejada variando de 
            (+ => (soma) - => (subtração) * => (multiplicação) / => (divisão) r => raiz ^ => pontencia s => sair)
    -A terceira contendo o segundo número    

=> Portas
    -Servidor básico (classe ServerA): 5056
    -Servidor especial (classe ServerB): 5057

=> Após a obtenção das 3 entradas, elas são concatenadas para virar uma expressão e ser enviada ao servidor referente a sua operação

=>Funcionamento dos servidores básico e especial consiste em receber a expressão separar em três variaveis, uma contendo a operação
    e outras duas para os valores