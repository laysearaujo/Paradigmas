data Tree t = Nilt |
               Node t (Tree t) (Tree t)
               deriving (Read, Show)

insertListAux :: Ord t => Tree t -> t -> Tree t
insertListAux Nilt a = (Node a Nilt Nilt)
insertListAux (Node x e d) a 
  | x < a = Node x e (insertListAux d a)
  | x > a = Node x (insertListAux e a) d

insertList :: Ord t => Tree t -> [t] -> Tree t
insertList x [] = x
insertList x (a:as) = insertList (insertListAux x a) as

main = do
       a <- getLine
       b <- getLine
       let result = insertList (read a::Tree Int) (read b)
       print result