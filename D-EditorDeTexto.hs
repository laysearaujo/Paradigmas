data Cmd = Cursor Int
           | Backspace Int
           | Delete Int
           | Insert String
           deriving (Read)

delete :: Int -> Int -> String -> String
delete x n [] = []
delete x 0 str = str
delete x n (a:as)
  | x == 0    = delete x (n - 1) as
  | otherwise = a:(delete (x - 1) n as)

insert :: Int -> String -> String -> String
insert x s [] = s
insert x s (a:as)
  | x == 0    = (s++(a:as))
  | otherwise = a:(insert (x-1) s as) 
  
edit :: Int -> String -> [Cmd] -> String
edit x a [] = a
edit x a ((Cursor n):as) = edit (x+n) a as
edit x a ((Delete n):as) = edit x (delete x n a) as
edit x a ((Insert s):as) = edit x (insert x s a) as
edit x a ((Backspace n):as)
  | (x - n) >= 0 = edit (x - n) (delete (x - n) n a) as
  | otherwise    = edit 0 (delete 0 n a) as
                              
editText :: String -> [Cmd] -> String
editText s c = edit 0 s c 

main = do
       a <- getLine
       b <- getLine
       let result = editText a (read b)
       print result