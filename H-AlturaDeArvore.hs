data Tree t = Node t (Tree t) (Tree t) 
              | Nilt
              deriving (Read)

alturaArvore :: Tree t -> Int
alturaArvore Nilt         = 0                                 
alturaArvore (Node x e d) = 1 + max (alturaArvore e) (alturaArvore d)

main = do
       a <- getLine
       let result = alturaArvore (read a::Tree Int)
       print result