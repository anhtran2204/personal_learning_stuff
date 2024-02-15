range x y
    | x > y = []
    | x == y = [y]
    | otherwise = x : range (x + 1) y

main :: IO ()
main = putStrLn "Hello World!"