import Prelude hiding (Maybe (..))

auxSep :: String -> String -> Int
auxSep (a:as) x 
  | head as == 'b'    = (read x::Int) - (read (tail as)::Int)
  | head as == 'l'    = (read x::Int) * (read (tail as)::Int)
  | a == 'u'          = (read x::Int) + (read as::Int)
  | head as == 'v' && read (tail as) == 0 = -6578
  | head as == 'v'    = div (read x::Int) (read (tail as)::Int) 
  | otherwise         = auxSep as (x++[a]) 

safeCalcAux :: String -> String -> String
safeCalcAux x [] = x
safeCalcAux x (a:as)
  | a == 's'  = safeCalcAux x as
  | a == 'm'  = safeCalcAux x as
  | a == 'd'  = safeCalcAux x as
  | otherwise = safeCalcAux (x++[a]) as

safeCalc :: String -> IO ()
--safeCalc x = print (safeCalcAux "" x)
safeCalc x = print (if resp x == -6578 then Nothing else Just (resp x))
  where resp y = auxSep (safeCalcAux "" y) ""

data Maybe a = Just a |
               Nothing
               deriving(Show)

main = do
       a <- getLine
       safeCalc a
