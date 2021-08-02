data Command = Forward Int | Backward Int | TurnLeft | TurnRight 
               deriving (Eq, Show, Read)

data Direction = North | South | West | East
                 deriving (Read, Show)

left :: Direction -> Direction
left North = West
left South =  East
left West = South
left East = North

right :: Direction -> Direction
right North = East
right South = West
right West = North
right East = South

facesAux :: [Command] -> Direction -> Direction
facesAux (x:xs) d
 | x == TurnLeft  = faces (left d) xs
 | x == TurnRight = faces (right d) xs
 | otherwise      = faces d xs

faces :: Direction -> [Command] -> Direction
faces d [] = d 
faces d x = facesAux x d

main = do
       a <- getLine
       b <- getLine
       let result = faces (read a) (read b)
       print result