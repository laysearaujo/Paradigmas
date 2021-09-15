halve :: [String] -> ([String], [String])
halve [] = ([], [])
halve (a:[]) = ([a], [])
halve (a:as:ds) = ([a] ++ fst (halve ds), [as] ++ snd (halve ds))

main = do
  x <- getLine
  print $ halve (words x)