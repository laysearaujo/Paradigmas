-- RUNTIME ERROR

data Tree t = Nilt |
               Node t (Tree t) (Tree t)
               deriving (Read, Show)

isBSTAux :: Tree t -> t
isBSTAux (Node x _ _) = x

isBST :: Ord t => Tree t -> Bool
isBST Nilt = True
isBST (Node x Nilt Nilt) = True
isBST (Node x e d) = x < (isBSTAux d) && x > (isBSTAux e) && isBST e && isBST d

main = do
       s <- getLine
       let result = isBST (read s::Tree Int)
       print result