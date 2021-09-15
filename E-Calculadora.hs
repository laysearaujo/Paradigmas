type Comando = String
type Valor = Int

inverte :: [(Comando, Valor)] -> [(Comando, Valor)]
inverte [] = []
inverte (a:as) = (inverte as) ++ [a]

executaAux :: [(Comando, Valor)] -> Int
executaAux [] = 0
executaAux (a:as)
  | fst a == "Multiplica" = snd a * executaAux as
  | fst a == "Soma" = snd a + executaAux as
  | fst a == "Subtrai" = ((snd a) * (-1)) + executaAux as
  | fst a == "Divide" = if snd a == 0 then -666 else div (executaAux as) (snd a) 

executa :: [(Comando, Valor)] -> Int
executa (a:as) = executaAux (inverte (a:as))
 
main = do
    a <- getLine
    let result = executa (read a)
    print result