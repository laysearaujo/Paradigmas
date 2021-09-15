converte :: String -> [String]
converte str = words [if c == ';' then ' ' else c|c <- str]

converteAux :: [String] -> Int -> [String]
converteAux [] _ = []
converteAux (a:as) x
 | x == 1    = [a] ++ converteAux as 0
 | otherwise = converteAux as (x+1)
 
logMesAux :: String -> [String] -> [Double]
logMesAux _ [] = []
logMesAux x (a:as)
 | x == a    = [read (head as)] ++ logMesAux x (tail as)
 | otherwise = logMesAux x (tail as)

logMes :: String -> String -> Double
logMes x str = sum (logMesAux x (converteAux (converte str) 0))

main = do
    a <- getLine
    b <- getLine
    let result = logMes a b
    print result