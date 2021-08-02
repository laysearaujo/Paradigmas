-- RUNTIME ERROR
import Prelude hiding (Maybe (..))

auxSep :: String -> String -> Int
auxSep (a:as) x 
  | a == 's' && head as == '0'
    || head as == '1' || head as == '2'
    || head as == '3' || head as == '4'
    || head as == '5' || head as == '6'
    || head as == '7' || head as == '8'
    || head as == '9' = (read x) + (read as) 
  | head as == 'b'    = (read x) - (read (tail as)) 
  | head as == 'l'    = (read x) * (read (tail as)) 
  | head as == 'v'    = div (read x) (read (tail as)) 
  | otherwise         = auxSep as (x++[a]) 

safeCalcAux :: String -> String -> String
safeCalcAux x [] = x
safeCalcAux x (a:as)
  | a == 's'   = safeCalcAux x as
  | a == 'm'   = safeCalcAux x as
  | a == 'd'   = safeCalcAux x as
  | otherwise = safeCalcAux (x++[a]) as

safeCalc :: String -> IO ()
safeCalc x = print (Just (auxSep (safeCalcAux "" x) ""))
--safeCalc x = print (safeCalcAux "" x)

data Maybe a = Just a |
               Nothing
               deriving(Show)

main = do
       a <- getLine
       safeCalc a