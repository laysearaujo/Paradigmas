data Command = Forward Int | Backward Int | TurnLeft | TurnRight 
               deriving (Eq, Show, Read)

left :: Char -> Char
left x
  | x == 'N'  = 'O'
  | x == 'S'  = 'L'
  | x == 'L'  = 'N'
  | otherwise = 'S'

right :: Char -> Char
right x
  | x == 'N'  = 'L'
  | x == 'S'  = 'O'
  | x == 'L'  = 'S'
  | otherwise = 'N'

destinationAux :: (Int, Int) -> [Command] -> Char -> (Int,Int)
destinationAux (x, y) [] _ = (x, y) 
destinationAux (x, y) (Forward a:as) c
  | c == 'N'  = destinationAux (x, y+a) as c
  | c == 'S'  = destinationAux (x, y-a) as c
  | c == 'L'  = destinationAux (x+a, y) as c
  | otherwise = destinationAux (x-a, y) as c
destinationAux (x, y) (Backward a:as) c
  | c == 'N'  = destinationAux (x, y-a) as c
  | c == 'S'  = destinationAux (x, y+a) as c
  | c == 'L'  = destinationAux (x-a, y) as c
  | otherwise = destinationAux (x+a, y) as c
destinationAux (x, y) (TurnLeft:as) c  = destinationAux (x, y) as (left c)  
destinationAux (x, y) (TurnRight:as) c = destinationAux (x, y) as (right c)

destination :: (Int,Int) -> [Command] -> (Int,Int) 
destination (x, y) c = destinationAux (x, y) c 'N'  


main = do
       a <- getLine
       b <- getLine
       let result = destination (read a) (read b)
       print result
