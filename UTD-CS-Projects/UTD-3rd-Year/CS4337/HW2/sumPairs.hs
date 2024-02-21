sumPairs :: [Int] -> [Int]
sumPairs [] = []
sumPairs [x] = [x]
sumPairs (k:v:t) = (k + v) : sumPairs t

main :: IO()
main = print (sumPairs [1,2,3,4,5])