converte :: String -> [String]
converte str = words [if c == ' ' then '_' else if c == ';' then ' ' else c|c <- str]

converteAux :: [String] -> Int -> [Double]
converteAux [] _ = []
converteAux ((a:ls):as) x
 | a == '0' && x == 2 = [read (a:ls)] ++ converteAux as 0
 | a == '1' && x == 2 = [read (a:ls)] ++ converteAux as 0
 | a == '2' && x == 2 = [read (a:ls)] ++ converteAux as 0
 | a == '3' && x == 2 = [read (a:ls)] ++ converteAux as 0
 | a == '4' && x == 2 = [read (a:ls)] ++ converteAux as 0
 | a == '5' && x == 2 = [read (a:ls)] ++ converteAux as 0
 | a == '6' && x == 2 = [read (a:ls)] ++ converteAux as 0
 | a == '7' && x == 2 = [read (a:ls)] ++ converteAux as 0
 | a == '8' && x == 2 = [read (a:ls)] ++ converteAux as 0
 | a == '9' && x == 2 = [read (a:ls)] ++ converteAux as 0
 | otherwise          = converteAux as (x+1)
 
minMaxCartao :: String -> (Double, Double)
minMaxCartao str = (minimum x,maximum x)
 where
 x = (converteAux (converte str) 0)
--minMaxCartao str = maximum [1.0,2.5,3.4]

main = do
    a <- getLine
    let result = minMaxCartao a
    print result