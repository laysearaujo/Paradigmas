charmander :: Float -> Bool
charmander x = round ab + cd == round (sqrt x)
  where
  ab = x / 100
  cd = round x - (round ab * 100)

main :: IO()
main = do
    a <- getLine
    let result = charmander (read a)
    if result then putStr "Charmander vitorioso" else putStr "Charmander derrotado"
