auxDecEnigma :: Char -> [(Char, Char)] -> String
auxDecEnigma _ [] = ""
auxDecEnigma c (a:as)
  | (c == fst a)  = [snd a]
  | otherwise = auxDecEnigma c as

decEnigma :: String -> [(Char, Char)] -> String
decEnigma [] _ = ""
decEnigma (a:as) tup = (auxDecEnigma a tup) ++ (decEnigma as tup) 

main = do
    a <- getLine
    b <- getLine
    let result = decEnigma a (read b)
    print result