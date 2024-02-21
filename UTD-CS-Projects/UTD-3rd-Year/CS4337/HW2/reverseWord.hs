reverseWord :: [a] -> [a]
reverseWord [] = []
reverseWord [x] = [x]
reverseWord (x:xs) = reverseWord xs ++ [x]

main :: IO()
main = print (reverseWord "Hello World!")