sumTo :: Int -> Int
sumTo 0 = 0
sumTo a = sumTo (a-1) + a

main :: IO()
main = interact $ show . sumTo . read