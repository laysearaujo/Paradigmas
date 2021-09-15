data Tree t = Nilt |
               Node t (Tree t) (Tree t)
               deriving (Read)

isBSTAux :: Ord t => Tree t -> t -> Char -> Bool
isBSTAux Nilt _ _= True
isBSTAux (Node x e d) y c
  | c == 'L' = if x < y then isBSTAux e y 'L' && isBSTAux d y 'L' else False
  | c == 'G' = if x > y then isBSTAux e y 'G' && isBSTAux d y 'G' else False

isBST :: Ord t => Tree t -> Bool
isBST Nilt = True
isBST (Node x Nilt Nilt) = True
isBST (Node x e Nilt) = isBSTAux e x 'L' && isBST e 
isBST (Node x Nilt d) = isBSTAux d x 'G' && isBST d
isBST (Node x e d) = isBSTAux e x 'L' && isBSTAux d x 'G' && isBST d && isBST e

main = do
       s <- getLine
       let result = isBST (read s::Tree Int)
       print result